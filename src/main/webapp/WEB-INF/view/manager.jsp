<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理博文</title>

<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css">
<script type="text/javascript">
	

	function add() {
		//包含普通文本,也包含文件
		 var formData = new FormData($( "form" )[0]);
		$.ajax({
			type : "post",
			data : formData,
			processData : false,//让jquery不转为对象
			// 告诉jQuery不要去设置Content-Type请求头
			contentType : false,
			url : "importType",
			success : function(obj) {
				if (obj) {
					alert("导入成功");
					location.href = "/list";
				}
			}
		})
	}
</script>
</head>
<body>
	<div class="container">
		<h2 style="color: green" align="center">管理博文</h2>
		<br />
		<form>
			<div class="form-group">
				<label for="title">导入博文分类:</label>
				 <input type="file"
					class="form-control" name="file">
			</div>
			
			
			<button type="button" class="btn btn-success" onclick="add()">导入</button>
			
			<button type="button" class="btn btn-warning" onclick="history.go(-1)">返回</button>
		
	
		</form>
		<div>
		<br/>
		<mark>少年:要想成功导入,请把要导入的分类以 英文逗号分隔存在一个txt文件中.    否则 嘿嘿~~</mark>
		</div>
			
	</div>

</body>
</html>