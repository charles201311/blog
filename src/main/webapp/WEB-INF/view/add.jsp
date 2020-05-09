<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发布博文</title>

<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css">
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "get",
			url : "getTypeList",
			success : function(list) {
				for ( var i in list) {
					$("#select").append(
							"<option value='"+list[i].tid+"'> " + list[i].tname
									+ "</option>")
				}

			}

		})

	})

	function add() {
		$.ajax({
			type : "post",
			data : $("form").serialize(),
			url : "/add",
			success : function(obj) {
				if (obj) {
					alert("发布成功");
					location.href = "/list";
				}
			}
		})
	}
</script>
</head>
<body>
	<div class="container">
		<h2 style="color: green" align="center">增加博文</h2>
		<br />
		<form>
			<div class="form-group">
				<label for="title">标题</label> <input type="text"
					class="form-control" name="title" id="title" placeholder="请输入标题">
			</div>
			<div class="form-group">
				<label for="content">内容</label>
				<textarea class="form-control" id="content" rows="10" name="content"></textarea>
			</div>
			<div class="form-group">
				标题图片：
				<input type="file" name="file">

			</div>

			<div  class="form-group form-inline	" >
			 博文类型：
				<select class="form-control form-control-sm" id="select" name="tid">
				</select>

			</div>
			<div  class="form-group">
			<button type="button" class="btn btn-success" onclick="add()">发布</button>
			
			<button type="button" class="btn btn-warning" onclick="history.go(-1)">返回</button>
			</div>
		</form>
	</div>

</body>
</html>