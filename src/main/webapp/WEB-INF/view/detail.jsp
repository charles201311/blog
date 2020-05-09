<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>博文详情</title>

<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resource/css/bootstrap.min.css">

</head>
<body>
 <div class="container">
   <h2  style="color: green" align="center">博文详情</h2>
   
   <br/>
    <span style="float: right;"><a href="toUpdate?id=${blog.id }">编辑</a></span>
       <hr/>
   <dl>
    <dt><h3>${blog.title}</h3>
    <br> 作者:${blog.author }  发布时间: <fmt:formatDate value="${blog.created }" pattern="yyyy-MM-dd HH:mm:ss"/>  </dt>
    <hr/>
    <dd>${blog.content }</dd>
   </dl>
 
 </div>

</body>
</html>