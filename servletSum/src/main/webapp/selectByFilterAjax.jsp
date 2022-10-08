<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>异步条件查询</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://fastly.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script src="js/jquery-3.6.0.js"></script>

    <script>
        $(function () {
            update();
            $("#res_btn").click(function (event) {
                event.preventDefault();
                update();
            });
            $("#showPage").on("click", ".btn_page", function (event) {
                $("#pageIndex").val($(event.target).val());
                update();
            })
            $("#customer_tab").on("click", ".btn_del", function () {
                del(this.id);
                // $(this).parent().parent().remove();
                update();
            })

            function del(id) {
                $.ajax({
                    "url": "customerServlet",
                    "type": "get",
                    "data": `method=deleteCustomerAjax&delCid=\${id}`, //向服务器发送的数据
                    "dataType": "text",	//服务器返回的数据类型
                    "success": function (result) {  //result服务器返回的数据
                        // console.log("删除成功")
                    },
                     "error": function () {//服务器代码异常调用该函数
                        // console.log("删除失败")
                    }
                });
            }

            function update() {
                $("#customer_tab tr:not(:first)").remove();
                $("#showPage").empty()
                $.get("customerServlet",
                    $("#form_mes").serialize(),
                    // "method": "selectByFilterAjax",
                    // "cid": $(cid).val(),
                    // "cname": $(cname).val(),
                    // "gender": $(gender).val(),
                    // "email": $(email).val(),
                    // "profession": $(profession).val(),
                    // "pageIndex": $(e).val()
                    function (result) {
                        $(result.list).each(function () {
                            let newTr = `<tr>
                                        <td>\${this.cid}</td>
                                        <td>\${this.cname}</td>
                                        <td>\${this.gender}</th>
                                        <td>\${this.birthday}</th>
                                        <td>\${this.cellphone}</th>
                                        <td>\${this.email}</th>
                                        <td>\${this.profession}</th>
                                        <td><input type="button" class="btn btn-danger btn_del btn-sm" id="\${this.cid}" value="删除"></th>
                                    </tr>`
                            $("#customer_tab").append(newTr);
                        });
                        let newPage = ``;
                        for (let i = result.pageStart; i <= result.pageEnd; i++) {
                            if (result.pageIndex == i) {
                                newPage += `<input class="btn_page btn btn-sm btn-primary" type="button" value="\${i}">`
                            } else {
                                newPage += `<input class="btn_page btn btn-sm" type="button" value="\${i}">`;
                            }
                        }
                        newPage += `第\${result.pageIndex}页，共\${result.pageTotal}页`
                        $("#showPage").append(newPage);
                    }, "json")
            }
        })
    </script>
</head>
<body>
<div class="container">
    <jsp:include page="/header.jsp"/>
    <div class="row">
        <form action="#" id="form_mes">
            <input type="hidden" name="method" id="method" value="selectByFilterAjax">
            <input type="hidden" name="pageIndex" id="pageIndex" value="1">
            <div class="row">
                <div class="col-md-4">编号:<input type="text" name="cid" id="cid"></div>
                <div class="col-md-4">姓名:<input type="text" name="cname" id="cname"></div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    职业：
                    <select name="profession" id="profession">
                        <option value="">-------</option>
                        <option value="java">java</option>
                        <option value="c++">c++</option>
                        <option value="python">python</option>
                    </select>
                </div>
                <div class="col-md-4">
                    邮箱：
                    <select name="email" id="email">
                        <option value="">-------</option>
                        <option value="qq.com">QQ邮箱</option>
                        <option value="gmail.com">谷歌邮箱</option>
                        <option value="163.com">网易邮箱</option>
                    </select>
                </div>
                <div class="col-md-4">
                    性别：
                    <select name="gender" id="gender">
                        <option value="">-------</option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </div>

            </div>
            <div class="row">
                <div class="col-md-4">
                    <input class="btn btn-success " type="submit" name="res_btn" id="res_btn" value="查询">
                </div>
            </div>
        </form>
    </div>

    <div class="row">
        <table class="table table-striped table-hover table-primary" id="customer_tab">
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>性别</th>
                <th>生日</th>
                <th>电话</th>
                <th>邮箱</th>
                <th>职业</th>
                <th>操作</th>
            </tr>
        </table>
    </div>
    <div class="row text-center">
        <span id="showPage">

        </span>
    </div>
</div>
</body>
</html>
