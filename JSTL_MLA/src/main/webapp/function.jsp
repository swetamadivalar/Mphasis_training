<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Functions</title>
</head>
<body>
<h1>Function Tags</h1>
<c:set value="Spring Framewrok is frameworks of framework and supports AI" var="datay"></c:set>
<c:out value="${data}"></c:out>
<c:if test="${fn:contains(data,'supports')}">
<p>In data variable contains <strong>supports</strong> keyword.</p>
</c:if>
</body>
</html>