<html>
<#include "common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>图书id</th>
                            <th>图书图片</th>
                            <th>图书名字</th>
                            <th>发布者</th>
                            <th>发布时间</th>
                            <th>审核状态</th>
                            <th colspan="2">审核</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list booklist.getList() as book>
                            <tr>
                                <td>${book.book_id}</td>
                                <td><img height="100px" width="100px" src="${book.book_picture}"></td>
                                <td>${book.book_name}</td>
                                <td>${book.user_id}</td>
                                <td>${book.issue_date}</td>
                                <td><a href="#">通过</a></td>
                                <td><a href="#">驳回</a></td>
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
                            <li><a href="/booklist?currentPage=${currentPage-1}">上一页</a></li></#if>

                        <#list 1..booklist.getPages() as index>
                            <#if currentPage==index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/booklist?currentPage=${index}">${index}</a></li>
                            </#if>
                        </#list>

                        <#if currentPage gte booklist.getPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li>
                                <a href="/booklist?currentPage=${currentPage+1}">下一页</a>
                            </li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</body>
</html>