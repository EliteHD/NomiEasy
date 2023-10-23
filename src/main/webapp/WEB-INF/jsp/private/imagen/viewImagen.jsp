<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>IMAGE</title>
</head>

<body>


<h1>Cargar y mostrar imagen</h1>

<form method="post" action="/upload" enctype="multipart/form-data">
    <input type="file" name="file" class="btn btn-success"/>
    <br/><br/>
    <input type="submit" value="Upload" class="btn btn-primary"/>


</form>
<h2>Images guardadas</h2>
<ul>
    <c:forEach var="img" items="${images}">
        <li>
            <img src="<%=request.getContextPath()%>/images/${img.name}" width="50" height="50" />
        </li>
    </c:forEach>
</ul>
</body>
</html>