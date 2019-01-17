$(function () {
    toastr.options = {
        closeButton: true,
        progressBar: true,
        positionClass: "toast-bottom-right",
        timeOut: "2000",
    };
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/config/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', width: 30, key: true },
			{ label: '参数名', name: 'paramKey', sortable: false, width: 60 },
			{ label: '参数值', name: 'paramValue', width: 100 },
			{label: '状态', name: 'status', width: 60, formatter: function (value, options, row) {
                    return value === 0 ?
                        '<span class="label label-danger">禁用</span>' :
                        '<span class="label label-success">正常</span>';
                }
            },
			{ label: '备注', name: 'remark', width: 80 },
            {label: '创建时间', name: 'createDate', index: "create_date", width: 85}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
            paramKey: null
		},
		showList: true,
		title: null,
		config: {

		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.config = {
				status : 1
			};
		},
		update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			
			$.get(baseURL + "sys/config/info/"+id, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.config = r.config;
            });
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}

            layer.confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/config/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
                        if (r.code == 200) {
                            toastr.success("删除成功!", function () {
                                layer.closeAll("dialog");
                                vm.reload();
                            });

                        } else {
                            layer.closeAll("dialog");
                            toastr.error(r.msg);

                        }
					}
				});
			});
		},
		saveOrUpdate: function (event) {
			if (vm.validator()) {
				return;
			}
			var url = vm.config.id == null ? "sys/config/save" : "sys/config/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.config),
			    success: function(r){
                    if (r.code === 200) {
                        toastr.success("操作成功!", function () {
                            vm.reload();
                        });
                    } else {
                        toastr.error(r.msg);
                    }
				}
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'paramKey': vm.q.paramKey},
                page:page
            }).trigger("reloadGrid");
		},
		validator: function(event) {
            // 部门
            if (isBlank(vm.config.paramKey)) {
                toastr.warning("参数名不能为空");
                return true;
            }

            if (isBlank(vm.config.paramValue)) {
                toastr.warning("参数值不能为空");
                return true;
            }
		}


	}
});