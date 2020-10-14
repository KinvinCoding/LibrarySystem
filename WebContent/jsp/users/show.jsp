<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/jquery.pagination.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.pagination.min.js"></script>


<script>
			$(function() {
				var cp=<%= request.getAttribute("currentPage")%>;
				var tp=<%= request.getAttribute("totalPage")%>;
		/* 		alert(cp);
				alert(tp); */
				$("#pagination2").pagination({
					currentPage:cp,
					totalPage:tp,
					isShow: false,
					count: 6,
					prevPageText: "< 上一页",
					nextPageText: "下一页 >",
					callback: function(current) {
						/* 给后台传到了Cuttentpage */
						$("#CurrentPage").val(current);
						$("#form").submit();
					}
				});
			});
</script>

</head>
<body>

<!-- <div class="container"> -->
	<form id="form" class="form-inline definewidth m20" action="<%=request.getContextPath()%>/user/show" method="get">    
    书籍名称：
    <input type="text" name="bname" id="username"class="abc input-default" placeholder="书籍关键字" <c:if test="${bname!=null and bname!='' }">value="${bname }"</c:if> >&nbsp;&nbsp;  
   书籍类别:<select class="form-control" name="sid">
   			<option selected="selected" ></option>
		  <option value="1" <c:if test="${sid==1 and sid!=null }">selected="selected"</c:if> >计算机类</option>
		  <option value="2" <c:if test="${sid==2 and sid!=null }">selected="selected"</c:if> >数学类</option>
		  <option value="3" <c:if test="${sid==3 and sid!=null }">selected="selected"</c:if> >英语类</option>
		  <option value="4" <c:if test="${sid==4 and sid!=null }">selected="selected"</c:if> >语文类</option>
	</select>&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
<input id="CurrentPage" type="hidden" name="currentPage" value="1"/>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>书籍类别</th>
        <th>书籍名称</th>
        <th>作者</th>
        <th>出版社</th>
        <th>版本</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${books }" var="book">
    	<tr>
            <td>${book.sname}</td>
            <td>${book.bname}</td>
            <td>${book.author}</td>
            <td>${book.birth}</td>
            <td>${book.edition}</td>
            <td>
              <a type="button" class="btn btn-success" href="<%=request.getContextPath()%>/user/borrow?id=${book.id}">借阅</a>
            </td>
        </tr>	
    </c:forEach>
    
</table>

<center>
	<div class="box">
			<div id="pagination2" class="page fl"></div>
			<div class="info fl">
				<p>总记录数：<span id="current2" >${page.count}</span></p>
			</div>
		</div>
</center>
</form>
</body>

</html>
