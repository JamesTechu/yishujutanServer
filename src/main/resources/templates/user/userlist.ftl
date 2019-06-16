<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>用户id</th>
                            <th>用户密码</th>
                            <th>用户昵称</th>
                            <th>用户头像</th>
                            <th>注册时间</th>
                            <th>联系方式</th>
                            <th colspan="">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list userlist.getList() as user>
                            <tr>
                                <td>${user.user_id}</td>
                                <td>${user.password!""}</td>
                                <td>${user.nickname}</td>
                                <td><img height="100px" width="100px" src="${user.icon!""}"></td>
                                <td>${user.register_date!""}</td>
                                <td>${user.phone!""}</td>
                                <td><a href="#">删除</a></td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else >
                            <li><a href="/userlist?currentPage=${currentPage-1}">上一页</a></li></#if>

                        <#list 1..userlist.getPages() as index>
                            <#if currentPage==index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/userlist?currentPage=${index}">${index}</a></li>
                            </#if>
                        </#list>

                        <#if currentPage gte userlist.getPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li>
                                <a href="/userlist?currentPage=${currentPage+1}">下一页</a>
                            </li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</body>
</html>