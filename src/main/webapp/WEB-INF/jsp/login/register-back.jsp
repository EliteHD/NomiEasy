
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login y Registro</title>

    <link rel="stylesheet"
          href="css/panel.css">
    <link rel="stylesheet"
          href="css/responsive.css">
    <link rel="stylesheet"
          href="css/login.css">

</head>
<body>
<div class="my-container">

    <div id="register-form">


        <h1>Registra tus datos	</h1>
        <form:form action="/saveUser" method="post" modelAttribute="usuario">

            <div class="form-group">
                <label for="nombre">Nombre</label>
                <form:input type="text" path="nombre" id="nombre" required="required" />
            </div>
            <div class="form-group">
                <label for="apepat">Apellido paterno</label>
                <form:input type="text" path="apePaterno" id="apepat" required="required" />
            </div

            <div class="form-group">
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <form:input  path="email" type="email" id="email" required="required" />
            </div>

            <div class="form-group">
                <label for="password">Contraseña</label>
                <form:input type="password" path="password" id="password" required="required" />
            </div>

            <button class="btn-login" type="submit">Registrar</button>
            <p>
                Ya tienes una cuenta? <a href="/loginUser" id="switch-to-login">Inicia
                sesión</a>
            </p>
        </form:form>
    </div>
</div>

</body>
</html>