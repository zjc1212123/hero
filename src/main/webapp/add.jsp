<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>添加英雄</title>
    <link rel="icon" href="img/icon.ico">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
</head>
<body>
<div class="container">
    <div class="title">
        <h1>添加英雄</h1>
        <button type="button" onclick="location.href='list'">返回首页</button>
    </div>
    <form id="hero">
        <div class="form-control">
            <label>英雄姓名</label>
            <input class="form-item" type="text" name="name" placeholder="请输入英雄姓名">
        </div>
        <div class="form-control">
            <label>英雄头像</label>
            <input class="form-item" type="text" name="avatar" placeholder="请输入英雄头像文件地址">
        </div>
        <div class="form-control">
            <label>英雄职业</label>
            <select class="form-item" name="type">
                <option value="" selected>请选择英雄职业</option>
                <option value="1">坦克</option>
                <option value="2">战士</option>
                <option value="3">刺客</option>
                <option value="4">法师</option>
                <option value="5">射手</option>
                <option value="6">辅助</option>
            </select>
        </div>
        <div class="form-control">
            <label>英雄技能</label>
            <input class="form-item" type="text" name="skill" placeholder="请输入英雄技能名称">
        </div>
        <div class="form-control">
            <label>技能描述</label>
            <textarea class="form-item" name="skillDescribe" rows="5" placeholder="请输入英雄技能描述"></textarea>
        </div>
        <div class="form-control">
            <button type="button" class="btn-submit" id="submit">提交</button>
        </div>
    </form>
</div>
</body>
<script>
    //监听提交事件
    $("#submit").on('click', function () {
        //获取参数 将整个表单元素转化为json字符串
        var hero = $("#hero").serializeJSON();
        var heroJson = JSON.stringify(hero);
        //表单验证
        if (hero.name === "") {
            alert("英雄姓名不能为空")
        } else if (hero.avatar === "") {
            alert("英雄头像不能为空")
        } else if (hero.type === "") {
            alert("英雄职业不能为空")
        } else if (hero.skill === "") {
            alert("英雄技能不能为空")
        } else if (hero.skillDescribe === "") {
            alert("英雄技能描述不能为空")
        } else {
            //ajax请求后端
            $.post("add", {hero: heroJson}, function (res) {
                console.log(res);
                if (res === 0) {
                    alert("添加成功");
                    location.href = 'list';
                } else if (res === 1) {
                    alert("添加失败");
                }
            })
            // $.ajax({
            //     url: "add",
            //     type: "post",
            //     data: {
            //         hero: JSON.stringify(hero)
            //     },
            //     success: function (res) {
            //         console.log(res);
            //         if (res === 0) {
            //             alert("添加成功");
            //             location.href = 'list';
            //         } else if (res === 1) {
            //             alert("添加失败");
            //         }
            //     },
            //     error: function () {
            //         alert("请求失败")
            //     }
            // })
        }
    })
</script>
</html>