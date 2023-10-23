editUser:
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>Editar Usuario</title>

</head>
<body>
<jsp:include page="../header.jsp" />

<div class="container mt-5">
    <h2 class="mb-4">Editar Usuario</h2>

    <form:form action="/guardarCambiosUsuario" method="post" modelAttribute="usuario">

        <form:hidden  id="idUsuario" path="idUsuario" />
        <div class="form-group">
            <label for="nombre">Nombre Completo</label>
            <form:input type="text" class="form-control" path="nombre" name="nombre" id="nombre" aria-describedby="emailHelp" placeholder="Nombre"/>
        </div>
        <div class="form-group">
            <label for="correo">Correo Electr�nico</label>
            <form:input type="email" class="form-control" path="correo" name="correo" id="correo" aria-describedby="emailHelp" placeholder="Correo Electr�nico"/>
        </div>
        <div class="form-group">
            <label for="telefono">Tel�fono</label>
            <form:input type="tel" class="form-control" path="telefono" name="telefono" id="telefono" placeholder="Tel�fono"/>
        </div>
        <div class="form-group">
            <label for="direccion">Direcci�n</label>
            <form:input type="text" class="form-control" name="direccion" path="direccion" id="direccion" placeholder="Direcci�n"/>
        </div>
        <div class="form-group">
            <label for="contra">Contrase�a</label>
            <form:input type="password" class="form-control" path="contra" name="contra" id="contra" placeholder="Contrase�a"/>
        </div>

        <input type="submit" class="btn btn-primary">Guardar Cambios</input>
    </form:form>
</div>
</body>
</html>
