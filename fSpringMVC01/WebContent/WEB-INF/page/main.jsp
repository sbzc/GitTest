<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
   function check() {
	   //alert("sda")
	   $.ajax({
			"url":"ajax",
			"type":"get",
			"dataType":"json",
			"success":function(data){
				alert(data[1])
			}
		})
}
</script>
</head>
<body>
欢迎登录成功:${user}

<button onclick="check()">查找</button><br>

<hr>
<form action="getDate">
<input type="date" name="time">
<button>提交</button>
</form>
<a href="download?fileName=a.docx">下载</a><br>
<hr>
<form action="upload" enctype="multipart/form-data" method="post">
文件名：<input type="text" name="fileName"><br><br>
选择文件<input type="file" name="file">
<button>提交</button>
</form>
</body>
</html>