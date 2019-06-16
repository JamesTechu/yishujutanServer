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
                            <th>帖子id</th>
                            <th>帖子标题</th>
                            <th>发布者</th>
                            <th>发布时间</th>
                            <th>热度</th>
                            <th>审核状态</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list essayList.getList() as essay>
                            <tr>
                                <td>${essay.essay_id}</td>
                                <td>${essay.essay_title}</td>
                                <td>${essay.user_id}</td>
                                <td>${essay.issue_date!""}</td>
                                <td>${essay.hot_degree}</td>
                                <td>通过</td>
                                <td><a href="#">审核</a></td>
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
                            <li><a href="/essaylistessaylist?currentPage=${currentPage-1}">上一页</a></li></#if>

                        <#list 1..essayList.getPages() as index>
                            <#if currentPage==index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/essaylist?currentPage=${index}">${index}</a></li>
                            </#if>
                        </#list>

                        <#if currentPage gte essayList.getPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li>
                                <a href="/essaylist?currentPage=${currentPage+1}">下一页</a>
                            </li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</body>
</html>