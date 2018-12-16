$(function () {
    console.log("我执行了")
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/log/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', width: 30, key: true },
			{ label: '用户名', name: 'username', width: 50 }, 			
			{ label: '用户操作', name: 'operation', width: 70 }, 			
			{ label: '请求方法', name: 'method', width: 150 }, 			
			{ label: '请求参数', name: 'params', width: 80 },
            { label: '执行时长(毫秒)', name: 'time', width: 80 },
			{ label: 'IP地址', name: 'ip', width: 70 }, 			
			{ label: '创建时间', name: 'createDate', width: 90 }			
        ],
		viewrecords: true, //在浏览导航栏显示记录总数
        height: 385,
        rowNum: 10, //每页显示记录数
		rowList : [10,30,50], //用于改变显示行数的下拉列表框的元素数组。
        rownumbers: true, //添加左侧行号
        rownumWidth: 25, 
        autowidth:true,
        multiselect: false,
        pager: "#jqGridPager",
        // 读取服务器返回的json数据并解析
        jsonReader : {
            root: "page.list",//返回的数组集合
            page: "page.currPage",//当前页数
            total: "page.totalPage",// 总页数
            records: "page.totalCount" //总行数
        },
        // 设置jqGrid将要向Server传递的参数名称
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
			key: null
		},
	},
	methods: {
		query: function () {
			vm.reload();
		},
		reload: function (event) {
		    // 请求数据，并刷新jqGrid表格
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			console.log(page);
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'key': vm.q.key},
                page:page
            }).trigger("reloadGrid");
		}
	}
});