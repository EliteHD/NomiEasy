<div class="navcontainer">
    <nav class="nav">
        <div class="nav-upper-options">
            <div>
                <a class="nav-option option1"
                   href="<%=request.getContextPath()%>../panel/panel.jsp"> <img
                        src="<%=request.getContextPath()%>../images/dashboard.png"
                        class="nav-img" alt="panel">
                    <h3>Panel</h3>
                </a>
            </div>


            <div>
                <a class="nav-option option4"
                   href="<%=request.getContextPath()%>../UsuarioControlado/"> <img
                        src="<%=request.getContextPath()%>../images/usuarios.png"
                        class="nav-img" alt="usuarios">
                    <h3>Usuarios</h3>
                </a>
            </div>


            <div>
                <a class="nav-option option6" href="#"> <img
                        src="<%=request.getContextPath()%>../images/configuracion.png"
                        class="nav-img" alt="settings">
                    <h3>Mi Perfil</h3>
                </a>
            </div>

            <div>
                <a class="nav-option logout"
                   href="<%=request.getContextPath()%>../LoginControlador/logout"> <img
                        src="<%=request.getContextPath()%>../images/salir.png"
                        class="nav-img" alt="logout">
                    <h3>Salir</h3>
                </a>
            </div>

        </div>
    </nav>
</div>