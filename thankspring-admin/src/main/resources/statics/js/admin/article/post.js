$(function () {
    toastr.options = {
        closeButton: true,
        progressBar: true,
        positionClass: "toast-bottom-right",
        timeOut: "2000",
    };
    $("#jqGrid").jqGrid({
        url: baseURL + 'article/post/list',
        datatype: "json",
        colModel: [
            {label: '文章ID', name: 'postId', index: "post_id", width: 45, key: true},
            {label: '文章标题', name: 'postTitle', width: 75},
            {label: '发布时间', name: 'postDate', index: "post_date", width: 75},
            {label: '浏览量', name: 'postViews', width: 90},
            {label: '所属分类', name: 'sortName', width: 100},
            {
                label: '发布状态', name: 'postStatus', width: 60, formatter: function (value, options, row) {
                    if(value === 0){
                        return '<span class="label label-success">已发布</span>';
                    }
                    if(value === 1){
                        return '<span class="label label-primary">草稿</span>';
                    }
                    if(value === 2){
                        return '<span class="label label-warning">回收站</span>';
                    }
                }
            },
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});
var mditor, htmlEditor;
var refreshIntervalId;
Vue.component('v-select', VueSelect.VueSelect);
Dropzone.autoDiscover = false;
var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            postTitle: null,
            postStatus: "",
            category: ""
        },
        showList: true,
        title: null,

        post: {
            customTpl: 'markdown',
            postStatus:1,
            allowComment: 1,
            allowPing: 1,
            allowFeed: 1,
            postContentMd:'',
            postContent:'',
            postStatus:'',

        },
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.post = {
                customTpl: 'markdown',
                allowComment: 1,
                allowPing: 1,
                allowFeed: 1,
                postContentMd:'',
                postContent:'',
                postStatus:'',
                };
            //获取分类信息
            this.getCategoryList();
        },
        update: function () {
            var postId = getSelectedRow();
            if (postId == null) {
                return;
            }

            vm.showList = false;
            vm.title = "修改";

            vm.getPost(postId);

        },
        getPost: function(postId) {
            console.log("")
            $.get(baseURL + "article/post/info/" + postId, function (r) {
                vm.post = r.post;
                if (vm.post.customTpl === 'markdown') {
                    mditor.value = vm.post.postContentMd;

                } else {
                    htmlEditor.summernote('code').value = vm.post.postContent;
                }

            });

        },
        del: function () {
            var postIds = getSelectedRows();
            if (postIds == null) {
                return;
            }

            layer.confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "article/post/delete",
                    contentType: "application/json",
                    data: JSON.stringify(postIds),
                    success: function (r) {
                        if (r.code === 200) {
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
        saveOrUpdate: function (status) {
            if (vm.validator()) {
                return;
            }
            var content = vm.post.customTpl === 'markdown' ? mditor.value : htmlEditor.summernote('code');
            if (vm.post.customTpl === 'markdown') {
                vm.post.postContentMd = content;

            } else {
                vm.post.postContent = content;
            }
            var url = vm.post.postId == null ? "article/post/save" : "article/post/update";
            vm.post.postStatus = status;
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.post),
                success: function (r) {
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
        getCategoryList: function () {
            $.get(baseURL + "article/category/select", function (r) {

                // vm.categoryIdList = r.list;
            });
        },
        deptTree: function () {
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择部门",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#deptLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级部门
                    vm.user.deptId = node[0].deptId;
                    vm.user.deptName = node[0].name;

                    layer.close(index);
                }
            });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'postTitle': vm.q.postTitle,'postStatus':vm.q.postStatus},
                page: page
            }).trigger("reloadGrid");
        },
        switchEditor : function(event) {
            var type = this.post.customTpl;
            var this_ = event.target;
            if (type === 'markdown') {
                // 切换为富文本编辑器
                if ($('#md-container .markdown-body').html().length > 0) {
                    $('#html-container .note-editable').empty().html($('#md-container .markdown-body').html());
                    $('#html-container .note-placeholder').hide();
                }
                mditor.value = '';
                $('#md-container').hide();
                $('#html-container').show();

                this_.customTpl = '切换为Markdown编辑器';

                this.post.customTpl = 'html';
            } else {
                // 切换为markdown编辑器
                if ($('#html-container .note-editable').html().length > 0) {
                    mditor.value = '';
                    mditor.value = toMarkdown($('#html-container .note-editable').html());
                }
                $('#html-container').hide();
                $('#md-container').show();

                this.post.customTpl = 'markdown';

                this_.innerHTML = '切换为富文本编辑器';
                htmlEditor.summernote("code", "");
            }

        },
        validator: function(event) {
            // 部门
            if (isBlank(vm.post.postTitle)) {
                toastr.warning("文章标题必须输入");
                return true;
            }
        }



    }
});

$(document).ready(function () {

    mditor = window.mditor = Mditor.fromTextarea(document.getElementById('md-editor'));
    // 富文本编辑器
    htmlEditor = $('.summernote').summernote({
        lang: 'zh-CN',
        height: 340,
        placeholder: '写点儿什么吧...',
        //上传图片的接口
        callbacks: {
            onImageUpload: function (files) {
                var data = new FormData();
                data.append('image_up', files[0]);
                tale.showLoading();
                $.ajax({
                    url: '/admin/api/attach/upload',
                    method: 'POST',
                    data: data,
                    processData: false,
                    dataType: 'json',
                    contentType: false,
                    success: function (result) {
                        tale.hideLoading();
                        if (result && result.success) {
                            var url = $('#attach_url').val() + result.payload[0].fkey;
                            console.log('url =>' + url);
                            htmlEditor.summernote('insertImage', url);
                        } else {
                            tale.alertError(result.msg || '图片上传失败');
                        }
                    }
                });
            }
        }
    });

    // Tags Input
    $('#tags').tagsInput({
        width: '100%',
        height: '35px',
        defaultText: '请输入文章标签'
    });

    $('#allowComment').toggles({
        on: 1,
        text: {
            on: '开启',
            off: '关闭'
        }
    });

    $('#allowPing').toggles({
        on: 1,
        text: {
            on: '开启',
            off: '关闭'
        }
    });

    $('#allowFeed').toggles({
        on: 1,
        text: {
            on: '开启',
            off: '关闭'
        }
    });

    $('#addThumb').toggles({
        on: 0,
        text: {
            on: '添加',
            off: '取消'
        }
    });

    $('#allowComment').on('toggle', function (e, active) {
        vm.post.allowComment = 1;
    });

    $('#allowPing').on('toggle', function (e, active) {
        vm.post.allowPing = 1;
    });

    $('#allowFeed').on('toggle', function (e, active) {
        vm.post.allowFeed = 1;
    });

    $('#addThumb').on('toggle', function (e, active) {
        if (active) {
            $('#dropzone-container').removeClass('hide');
            $('#dropzone-container').show();
            var thumbImage = $("#dropzone").css("backgroundImage");
            if(thumbImage && thumbImage.indexOf('url') !== -1){
                thumbImage = thumbImage.split("(")[1].split(")")[0];
                vm.post.postThumbnail = thumbImage.substring(1, thumbImage.length - 1);
            }
        } else {
            $('#dropzone-container').addClass('hide');
            vm.post.postThumbnail = '';
        }
    });

    var thumbdropzone = $('.dropzone');

    // 缩略图上传
    $("#dropzone").dropzone({
        url: "/123",
        filesizeBase: 1024,//定义字节算法 默认1000
        maxFilesize: '10', //MB
        fallback: function () {
            tale.alertError('暂不支持您的浏览器上传!');
        },
        acceptedFiles: 'image/*',
        dictFileTooBig: '您的文件超过10MB!',
        dictInvalidInputType: '不支持您上传的类型',
        init: function () {
            this.on('success', function (files, result) {
                console.log("upload success..");
                console.log(" result => " + result);
                if (result && result.success) {
                    var url = attach_url + result.payload[0].fkey;
                    console.log('url => ' + url);

                    vm.post.postThumbnail = url;
                    thumbdropzone.css('background-image', 'url(' + url + ')');
                    thumbdropzone.css('background-size', 'cover');
                    $('.dz-image').hide();
                }
            });
            this.on('error', function (a, errorMessage, result) {
                if (!result.success && result.msg) {
                    tale.alertError(result.msg || '缩略图上传失败');
                }
            });
        }
    });
});