<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        function search() {
            setInterval("getProgress()", 1000);
        }

        function getProgress() {
            $.ajax({
                type: "post",
                dataType: "json",
                url: "${pageContext.request.contextPath}/progress",
                success: function (data) {
                        console.log(data);
                },
                error: function () {
                    console.log("进入错误");
                }
            });
        }
    </script>
</head>
<body>

<form action="${pageContext.request.contextPath}/file/test" method="post" enctype="multipart/form-data">
    <a>上传 <input name="file" type="file"></a>
    <input onclick="search()" type="submit" value="提交">
</form>


</body>
</html>