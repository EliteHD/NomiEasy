usuario.jsp:
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<body>

<jsp:include page="../header.jsp" />

<section id="top">
    <button type="button" data-toggle="modal" data-target="#exampleModal" class=" m-3 btn btn-primary ">Agregar Usuario</button>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Nombre</th>
            <th scope="col">Correo</th>
            <th scope="col">Telefono</th>
            <th scope="col">Direccion</th>
            <th scope="col">Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${usuarios}" var="usuario">
            <tr>
                <td>${usuario.nombre}</td>
                <td>${usuario.correo}</td>
                <td>${usuario.telefono}</td>
                <td>${usuario.direccion}</td>
                <td>
                    <a href="/eliminarUsuario/${usuario.idUsuario}" >Eliminar</a>
                    <a>|</a>
                    <a href="/editarUsuario/${usuario.idUsuario}">Editar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Crear Usuario</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <form:form action="/saveUsuario2" method="post" modelAttribute="usuario">
                        <div class="form-group">
                            <label for="nombre">Nombre Completo</label>
                            <input type="text" class="form-control" path="nombre" name="nombre" id="nombre" aria-describedby="emailHelp" placeholder="Nombre">
                        </div>
                        <div class="form-group">
                            <label for="correo">Correo Electrónico</label>
                            <input type="email" class="form-control" path="correo" name="correo" id="correo" aria-describedby="emailHelp" placeholder="Correo Electrónico">
                        </div>
                        <div class="form-group">
                            <label for="telefono">Teléfono</label>
                            <input type="tel" class="form-control" path="telefono" name="telefono" id="telefono" placeholder="Teléfono">
                        </div>
                        <div class="form-group">
                            <label for="direccion">Dirección</label>
                            <input type="text" class="form-control" name="direccion" path="direccion" id="direccion" placeholder="Dirección">
                        </div>
                        <div class="form-group">
                            <label for="contra">Contraseña</label>
                            <input type="password" class="form-control" path="contra" name="contra" id="contra" placeholder="Contraseña">
                        </div>
                        <input type="submit" class="btn btn-primary">Enviar</input>
                    </form:form>

                </div>

            </div>
        </div>
    </div>

</section>



</body>
