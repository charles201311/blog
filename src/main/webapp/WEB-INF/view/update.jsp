<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改博文</title>

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
				var tid ='${blog.tid}';
				//让下拉框选中
				$("#select").find("option[value='"+tid+"']").prop("selected",true);

			}

		})

	})

	function update() {
		$.ajax({
			type : "post",
			data : $("form").serialize(),
			url : "/update",
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
		<h2 style="color: green" align="center">修改博文</h2>
		<br />
		<form>
			<div class="form-group">
				<label for="title">标题</label> 
				<input type="hidden" value="${blog.id }" name="id">
				
				<input type="text"
					class="form-control" name="title" id="title" value="${blog.title }" placeholder="请输入标题">
			</div>
			<div class="form-group">
				<label for="content">内容</label>
				<textarea class="form-control" id="content" rows="10" name="content">
				 ${blog.content }
				</textarea>
			</div>
			
			<div class="form-group">
				标题图片：
				<input type="file" name="file">
                <img alt="" src="/pic/${blog.picture }">
			</div>

			<div>
				<select class="form-control form-control-sm" id="select" name="tid">
				</select>

			</div>
			<button type="button" class="btn btn-success" onclick="update()">发布</button>
		</form>
	</div>

</body>
</html>