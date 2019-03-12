<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>

<form action="${pageContext.request.contextPath}/chapter/add" method="post" enctype="multipart/form-data">
 上传文件:<input type="file"  name="curl" /><br/>
 <input type="submit" value="提交">
</form>


</body>

</html>
