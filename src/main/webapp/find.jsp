<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/24 0024
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function (){
            $(":button").click(function (){
                $.ajax({url:"find.do",dataType:"json",type:"get",success:function (data){
                        $("#info").empty()
                    $.each(data,function (i,n){
                        $("#info")
                            .append("<tr>")
                            .append("<td>"+n.name+"</td>")
                        .append("<td>"+n.age+"</td>")
                        .append("<td>"+n.id+"</td>")
                        .append("</tr>")
                    })

                    }})
            })



        })
    </script>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>学生姓名</td>
        <td>学生年龄</td>
        <td>学生编号</td>
    </tr>
    </thead>
    <tbody id="info"></tbody>
</table>
<input type="button" value="点我查询">



</body>
</html>
