<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Usuario</title>
    <link rel="stylesheet"
          href="css/panel.css">
    <link rel="stylesheet"
          href="css/responsive.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>../css/rol.css">

</head>
<body>

<jsp:include page="../componentes/panelHeader.jsp"></jsp:include>

<div class="main-container">
    <jsp:include page="../componentes/panelNav.jsp"></jsp:include>

    <div class="main">
        <h3>
            <%=request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : ""%>
        </h3>
        <c:if test="${message}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>${message}</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>


        <div class="table-container">
            <h1>Roles</h1>
            <form:form>
                <table>
                    <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apepat</th>
                        <th>Apemat</th>
                        <th>Email</th>
                        <th>Celular</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="usuario" items="${listUsuario}">

                        <tr>
                            <td><c:out value="${usuario.nombre}"/></td>
                            <td><c:out value="${usuario.apePaterno}"/></td>
                            <td><c:out value="${usuario.apeMaterno}"/></td>
                            <td><c:out value="${usuario.email}"/></td>
                            <td><c:out value="${usuario.celular}"/></td>
                            <td>
                                <button type="button">
                                    <a href="/editUsuario/${usuario.id}">Editar</a>
                                </button>
                            </td>
                            <td>
                                <button type="button">
                                    <a href="/eliminarUsuario/${usuario.id}">Eliminar</a>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form:form>
            <div class="btn-container">
                <a href="/addUsuarios"
                   class="btn create">Crear Usuario</a>
            </div>
        </div>
        <!-- end table-container -->
    </div>
    <!-- end main -->
</div>
<script src="<%=request.getContextPath()%>/js/panel.js"></script>
</body>
</html>