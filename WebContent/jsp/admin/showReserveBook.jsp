<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<%-- <form class="form-inline definewidth m20" action="<%=request.getContextPath()%>/user/show" method="get">    
    书籍名称：
    <input type="text" name="bname" id="username"class="abc input-default" placeholder="书籍关键字" value="">&nbsp;&nbsp;  
   书籍类别:<select class="form-control" name="sid">
   			<option selected="selected" ></option>
		  <option value="1">计算机类</option>
		  <option value="2">数学</option>
	</select>&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
</form> --%>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
    	<th>申请人</th>
        <th>申请预定书籍名称</th>
        <th>作者</th>
        <th>出版社</th>
        <th>版本</th>
        <th>申请时间</th>
       	<th>操作</th>
   <!--      <th>操作</th> -->
    </tr>
    </thead>
    <c:forEach items="${allReserves }" var="allReserve">
    	<tr>
    		<td>${allReserve.uname}</td>
            <td>${allReserve.bname}</td>
            <td>${allReserve.author}</td>
            <td>${allReserve.birth}</td>
            <td>${allReserve.edition}</td>
         <%--    <td>${allReserve.startTime }</td> --%>
             <td><fmt:formatDate  value="${allReserve.startTime}" type="time" pattern="yyyy-MM-dd HH:mm:ss"/></td>
          <%--   <td>
              <a type="button" class="btn btn-success" href="<%=request.getContextPath()%>/user/borrow">借阅</a>
            </td> --%>
            <td>
            	<c:if test="${allReserve.number>0}">
            		<a type="button" class="btn btn-success" href="<%=request.getContextPath()%>/admin/allowReserveBook?id=${allReserve.id}">同意预定</a>
            	</c:if>
            	<a type="button" class="btn btn-warning" href="<%=request.getContextPath()%>/admin/notAllowReserveBook?id=${allReserve.id}">不同意预定</a>
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