<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>SideFlip - Página principal</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<%=request.getContextPath()%>/css/font-awesome.css"
	rel="stylesheet">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet">
</head>
<body>
	<div class="preloader-background">
		<div class="preloader-wrapper big active">
			<div class="spinner-layer spinner-blue">
				<div class="circle-clipper left">
					<div class="circle"></div>
				</div>
				<div class="gap-patch">
					<div class="circle"></div>
				</div>
				<div class="circle-clipper right">
					<div class="circle"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="background-1" id="home">
		<div class="fondo-1">
			<div class="container header">
				<div class="row">
					<div class="col s6 center-align" data-aos="fade-right">
						<h1 class="title-welcome">PAGINA SIMULANDO PERFIL DE UN USUARIO NORMAL</h1>
						<span class="center-align"></span>
						<h2 class="see-more"></h2>
						<a href="#what-is"><span class="center-align"><i
								class="fa fa-chevron-down"></i></span></a>
					</div>
					<div class="col s6">
						<img class="img-women to-center" data-aos="fade-down"
							src="<%=request.getContextPath()%>/images/sd-1.png" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<nav>
		<div class="nav-wrapper">
			<div class="container">
				<a href="#!" class="brand-logo">NomiEase</a> <a href="#"
					data-target="mobile-demo" class="sidenav-trigger"><i
					class="material-icons">menu</i></a>
				<ul class="right hide-on-med-and-down">
					<li class=""><a href="#what-is">Nómina</a></li>
					<li class=""><a href="#services">Pensiones</a></li>
					<li class=""><a href="#prices">ISR</a></li>
					<li class=""><a href="#clients" data-ancla="clients">Asalariados</a></li>
					<li class=""><a href="#contact-us">Formatos de Contrato</a></li>
					<li class=""><a href="/loginUser">Log
				In</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<ul class="sidenav" id="mobile-demo">
		<li class=""><a href="#what-is">Pensiones</a></li>
		<li class=""><a href="#services">Nómina</a></li>
		<li class=""><a href="#prices">ISR</a></li>
		<li class=""><a href="#clients">Asalariados</a></li>
		<li class=""><a href="#contact-us">Formatos</a></li>
		<li class=""><a
			href="/loginUser">Log
				In</a></li>
	</ul>
	<div class="background-2" id="what-is">
		<div class="container">
			<div class="row">
				<div class="col s12 center-align">
					<h2 class="title-what-is" data-aos="zoom-in">Power by: Josias
						Domiguez Hernandez</h2>
					<div class="line-shape"></div>
					<br>
					<p class="text-sideflip">NomiEase es una plataforma innovadora
						diseñada para simplificar y agilizar el proceso de cálculo de
						nóminas en tu empresa. NomiEase te proporciona las herramientas
						necesarias para garantizar que los cálculos de nómina se realicen
						sin problemas, permitiéndote concentrarte en lo que realmente
						importa: el bienestar financiero de tu equipo.</p>
					<br>
					<div class="main-center">
						<a class="btn see-more" href="#">Calcular</a>
					</div>
					<br> <br>
				</div>
			</div>
			<div class="row">
				<div class="col s12">
					<h2 class="center-align">
						Redes sociales <br> <br> <span
							class="fa fa-facebook-square hoverable"></span> <span
							class="fa fa-twitter-square hoverable"></span> <span
							class="fa fa-youtube-square hoverable"></span>
					</h2>
				</div>
			</div>
		</div>
	</div>


	<footer class="page-footer center-align">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h2>NomiEase</h2>
				</div>
				<div class="col l4 offset-l2 s12">
					<span class="fa fa-facebook-square"></span> <span
						class="fa fa-twitter-square"></span> <span
						class="fa fa-youtube-square"></span>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">&copy; 2018 Copyright | Todos los
				derechos reservados</div>
		</div>
	</footer>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/panel.js"></script>
</body>
</html>