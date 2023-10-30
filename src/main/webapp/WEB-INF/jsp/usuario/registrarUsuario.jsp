<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>./css/panel.css">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>./css/responsive.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>../css/rol.css">

    <title>Registrar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<jsp:include page="../componentes/panelHeader.jsp"></jsp:include>

<div class="main-container">
    <jsp:include page="../componentes/panelNav.jsp"></jsp:include>

    <!-- <h3>
			<%=request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "No Existe Nada"%>
		</h3>
		 -->
    <br>
    <div class="form-container">
        <h1 class="p-3"> Registrarte </h1>

        <c:if test="${message}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>${message}</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>

        <form:form action="/saveUser" method="post" modelAttribute="usuario">
            <div class="form-group">
                <label for="nombre">Nombreeeeeeeeee</label>
                <form:input type="text" path="nombre" id="nombre" required="required"/>
            </div>
            <div>
                <label for="apepat">Apellido paterno</label>
                <form:input type="text" path="apePaterno" id="apepat" required="required"/>
            </div>
            <div>
                <label for="apemat">Apellido materno</label>
                <form:input type="text" path="apeMaterno" id="apemat"/>
            </div>
            <div>
                <label for="numero">Número de teléfono</label>
                <form:input type="tel" path="celular" id="numero" required="required" pattern="[0-9]+"
                            title="Ingrese un número de teléfono válido"/>
            </div>
            <div>
                <label for="genero">Género</label>
                <form:select path="genero" id="genero">
                    <form:option value="0">Seleccione un género</form:option>
                    <form:option value="1">Masculino</form:option>
                    <form:option value="2">Femenino</form:option>
                </form:select>
            </div>
            <div>
                <label for="email">Correo electrónico</label>
                <form:input type="email" path="email" id="email" required="required"/>
            </div>
            <div>
                <label for="password">Contraseña</label>
                <form:input type="password" path="password" id="password" required="required"/>
            </div>

        </form:form>


    </div>
</div>

<script src="/js/panel.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>