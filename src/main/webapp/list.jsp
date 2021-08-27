<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>英雄列表页</title>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<div class="container">
    <div class="title">
        <h1>英雄列表</h1>
        <button onclick="location.href='add'">添加英雄</button>
    </div>
    <table>
        <tr>
            <th>英雄ID</th>
            <th>英雄头像</th>
            <th>英雄姓名</th>
            <th>英雄类型</th>
            <th>技能名称</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${heroes}" var="hero">
            <tr>
                <td>${hero.id}</td>
                <td>
                    <img src="${hero.avatar}">
                </td>
                <td>${hero.name}</td>
                <td>
                    <c:if test="${hero.type == 1}">坦克</c:if>
                    <c:if test="${hero.type == 2}">战士</c:if>
                    <c:if test="${hero.type == 3}">刺客</c:if>
                    <c:if test="${hero.type == 4}">法师</c:if>
                    <c:if test="${hero.type == 5}">射手</c:if>
                    <c:if test="${hero.type == 6}">辅助</c:if>
                </td>
                <td>${hero.skill}</td>
                <td>
                    <button onclick="location.href='edit?id=${hero.id}'">修改</button>
                    <button onclick="deleteHero(${hero.id})">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<%--点击按钮删除英雄--%>
<script>
    //向后端发请求
    function deleteHero(id) {
        $.ajax({
            url: 'delete',
            type: 'post',
            data: {id: id},
            success: function (res) {
                console.log(res);
                if (res === 0) {
                    alert("删除成功")
                    location.reload();
                }
                if (res === 1) {
                    alert("删除失败")
                }
            },
            error: function (e) {
                alert("1111")
            }
        })

    }


</script>
</html>