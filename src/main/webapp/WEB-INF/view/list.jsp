<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的博客</title>

<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css">
<script type="text/javascript">
	function deleteByid(id) {
		var ret = confirm("删除后不能恢复?")
		if (ret) {
			$.ajax({
				type : "post",
				data : {
					id : id
				},
				url : "deleteByid",
				success : function(obj) {
					if (obj) {
						alert("删除成功!")
						location.href = "list";
					}

				}

			})
		}

	}

	$(function() {
		//为分页动态的加click
		$(".page-link").click(function() {
			var url = $(this).attr("data");

			location.href = url;
		})

	})

	function toAdd() {
		location.href = "toAdd"
	}

	function query(month) {

		location.href = "list?month=" + month
	}
</script>
</head>
<body>
	<div class="container">

		<span style="float: right;">
			<button type="button" class="btn btn-outline-info"
				onclick="location.href='toManager'">登录</button>
			<button type="button" class="btn btn-success" onclick="toAdd()">发博文</button>
		</span>
		<h2 style="color: green" align="center">博文列表</h2>
		<div class="form-group form-inline">
			标题内容： <input class="form-control" type="text" name="title">
			&nbsp; 博文类型：
				<select class=" form-control form-control-sm" id="select" name="tid">
				</select>
			<button type="button" class="btn btn-info ml-3">搜索</button>

		</div>
		
		<div class="float-right">
			<button type="button" class="btn btn-outline-info" onclick="query()">显示所有</button>
			<button type="button" class="btn btn-outline-info" onclick="query(1)">显示1个月</button>
			<button type="button" class="btn btn-outline-info" onclick="query(3)">显示3个月</button>
		</div>
		<hr />
		<dl>
			<c:forEach items="${list}" var="l">
				<dt>
					<img alt="" src="/pic/${l.picture }"
						style="width: 80px; height: 60px"> <span class="ml-4">${l.title}</span>
				</dt>
				<dd class="mt-4">
					${l.author } · ${l.created } · ${l.hits } ·${l.tname } <span style="float: right;"><a
						href="toDetail?id=${l.id }">查看</a> | <a
						href="javascript:deleteByid(${l.id })">删除</a></span>
				</dd>
				<hr />

			</c:forEach>
		</dl>

		${pageInfo }
	</div>

</body>
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
	</script>
</html>