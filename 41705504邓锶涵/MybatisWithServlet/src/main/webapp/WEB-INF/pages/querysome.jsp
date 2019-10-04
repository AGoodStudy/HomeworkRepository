<%--
  Created by IntelliJ IDEA.
  User: DSH
  Date: 2019/10/4
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">
        table {
            margin: auto;
            margin-top: 70px;
            width: 800px;
            font-size: 20px;
            text-align: center;
            color: white;
        }

        body {
            background-image: url(data:image/jpeg;base64,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);
            background-size: cover;
        }

        th,
        td {
            height: 60px;
        }

        tr {
            background: black;
        }

        tr:nth-of-type(2n) {
            background: #636363;
        }

        button {
            background: black;
            width: 190px;
            height: 50px;
            border: none;
            color: white;
            font-size: 20px;
            cursor: pointer;
        }
        a{
            text-decoration: none;
            color: white;
        }
        span{
            position: absolute;
            left: 46%;
            top: 40px;
            font-weight: bold;
            color: red;
            font-size: 20px;
        }
    </style>
</head>

<body>
<span>${prompt}</span>
<form action="<%=request.getContextPath()%>/querysome.do" method="post">
    <table border="1" cellspacing="0">
        <tr>
            <td colspan="4">请输入需要查询的条件(至少填一项)</td>
        </tr>
        <tr>
            <td>学号:</td>
            <td><input type="text" name="studynum" /></td>
            <td>姓名</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td><input type="text" name="sex" /></td>
            <td colspan="2">
                <button type="submit">查询</button>
                <button type="reset">清空</button>
            </td>
        </tr>
        <tr>
            <th>序号</th>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
        </tr>
        <c:forEach var="studnt" items="${students}">
            <tr>
                <td>${studnt.id}</td>
                <td>${studnt.studynum}</td>
                <td>${studnt.name}</td>
                <td>${studnt.sex}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4"><a href="index.jsp">返回</a></td>
        </tr>

    </table>
</form>
</body>

</html>
