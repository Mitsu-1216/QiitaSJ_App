<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Todoアプリ</title>
<style>
h1 {
position: relative;
background: #dfefff;
box-shadow: 0px 0px 0px 5px #dfefff;
border: dashed 2px white;
padding: 0.2em 0.5em;
color: #454545;
display:inline-block;
}

h1:after {
position: absolute;
content: '';
left: -7px;
top: -7px;
border-width: 0 0 15px 15px;
border-style: solid;
border-color: #fff #fff #a8d4ff;
box-shadow: 1px 1px 1px rgba(0, 0, 0, 0.15);
}

.Button-style {
    position: relative;
    display: inline-block;
    text-align: center;
    text-decoration: none;
    outline: 0;
    overflow: hidden;
    color: #fff;/* 文字の色 */
    background: #f08080;/* ボタン背景色 */
    border-radius: 8px;/* 角丸サイズ */
    box-shadow: 0 0 0 5px #f08080, 0 2px 3px 5px rgba(0,0,0,0.5);/* 縁取り・影 */
    border: 2px dashed #fff;/* 点線の色・サイズ */
    padding: .5em 1em;/* 余白 */
}
</style>
</head>
<body>
<div class="container text-center">
<h1 class="my-5">Todoアプリへようこそ！</h1>
<form action="/sampleSJ/MainServlet" method="get">
お名前：<input type="text" name="name">
<input type="submit" class="Button-style mx-3" value="はじめる">
</form>
</div>
</body>
</html>