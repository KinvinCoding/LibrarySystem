<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
    
</head>
<body>
	
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
    	<th>申请人</th>
        <th>申请归还书籍名称</th>
        <th>作者</th>
        <th>出版社</th>
        <th>版本</th>
       	<th>操作</th>
   <!--      <th>操作</th> -->
    </tr>
    </thead>
    <c:forEach items="${backBooks }" var="backBook">
    	<tr>
    		<td>${backBook.uname}</td>
            <td>${backBook.bname}</td>
            <td>${backBook.author}</td>
            <td>${backBook.birth}</td>
            <td>${backBook.edition}</td>

            <td>
            	<a type="button" class="btn btn-success" href="<%=request.getContextPath()%>/admin/allowBackBook?id=${backBook.id}">确认归还</a>
            </td>
        </tr>	
    </c:forEach>
</table>

</body>
</html>
<!-- <script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="add.html";
		 });

    });

	function del(id)
	{
		if(confirm("确定要删除吗？"))
		{
			var url = "index.html";
			window.location.href=url;		
		
		}
	
	}
</script> -->