<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Деканат</title>

	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
	<link href="${contextPath}/resources/js/bootstrap.min.js" rel="script">
	<%--<script href="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>--%>
	<script href="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script href="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/font-awesome/css/font-awesome.min.css" />

	<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- you need to include the shieldui css and js assets in order for the grids to work -->
	<link rel="stylesheet" type="text/css" href="http://prepbootstrap.com/Content/shieldui-lite/dist/css/light/all.min.css" />
	<script type="text/javascript" src="${contextPath}/resources/js/shieldui-lite-all.min.js"></script>

	<script type="text/javascript" href="http://prepbootstrap.com/Content/data/shortGridData.js"></script>

	<!-- CSS Files -->
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/animate.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/main.css">

	<!-- Javascript Files -->
	<script type="text/javascript" src="${contextPath}/resources/js/jquery.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/slider.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/wow.js"></script>
	<%--<script type="text/javascript" src=${contextPath}/resources/js/main2.js"></script>--%>
</head>
<body>
	<!-- header Section -->
	<header>
		<jsp:include page="menu.jsp"></jsp:include>
	</header><!-- end header -->

	<!-- Slider Section -->
	<section class="slider_wrapper">
		
		<div id="slides">

			<div class="slide">
				<img src="${contextPath}/resources/img/slide1.jpg" alt=""/>
				<h3 class="caption">sed do eiusmod tempor incididunt.</h3>
			</div>

			<div class="slide">
				<img src="${contextPath}/resources/img/slide2.jpg" alt=""/>
				<h3 class="caption">officia deserunt mollit velit esse.</h3>
			</div>

			<div class="slide">
				<img src="${contextPath}/resources/img/slide3.jpg" alt=""/>
				<h3 class="caption">cillum dolore fugiat pariatur.</h3>
			</div>

		</div>

	</section><!-- end slider -->

	<!-- Services Section -->
	<section class="services container clearfix">
			
			<!-- Services Title  -->
			<div class="section_title animated wow fadeInUp">
				<h2>Декан.</h2>
			</div>

			<!-- Services List  -->
			<div class="services_list">
				<ul>
					<li class="animated wow fadeInRight" data-wow-delay=".2s">
						<h3>We Design.</h3>
						<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
						<a href="#">read more<span class="arrow">&rarr;</span></a>
					</li>
					<li class="animated wow fadeInRight" data-wow-delay=".3s">
						<h3>We Innovate.</h3>
						<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
						<a href="#">read more<span class="arrow">&rarr;</span></a>
					</li>
					<li class="animated wow fadeInRight" data-wow-delay=".4s">
						<h3>We Create.</h3>
						<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
						<a href="#">read more<span class="arrow">&rarr;</span></a>
					</li>
				</ul>
			</div>

	</section><!-- end services -->

	<!-- Projects Section -->
	<section class="projects container clearfix">
			
			<!-- Projects Title  -->
			<div class="section_title animated wow fadeInUp">
				<h2>Our Work.</h2>
				<a href="" class="details">More Projects<span class="arrow">&rarr;</span></a>
			</div>

			<!-- Projects List  -->
			<div class="projects_list clearfix">
				<ul>
					<li class="animated wow fadeInRight" data-wow-delay=".2s">
						<a href="#"> <span class="p_logo1"></span> </a>
					</li>
					<li class="animated wow fadeInRight" data-wow-delay=".3s">
						<a href="#"> <span class="p_logo2"></span> </a>
					</li>
				</ul>
			</div>

	</section><!-- end projects -->

	<!-- Clients Section -->
	<section class="clients container">

			<!-- Clients section Title  -->
			<div class="section_title animated wow fadeInUp">
				<h2>Our Happy Clients.</h2>
			</div>

			<!-- Clients List  -->
			<div class="client_list clearfix">
				<ul>
					<li class="animated wow fadeInRight" data-wow-delay=".2s">
						<img src="${contextPath}/resources/img/client_logo.jpg" alt="Client 1" />
					</li>
					<li class="animated wow fadeInRight" data-wow-delay=".3s">
						<img src="${contextPath}/resources/img/client_logo.jpg" alt="Client 1" />
					</li>
					<li class="animated wow fadeInRight" data-wow-delay=".4s">
						<img src="${contextPath}/resources/img/client_logo.jpg" alt="Client 1" />
					</li>
					<li class="animated wow fadeInRight" data-wow-delay=".5s">
						<img src="${contextPath}/resources/img/client_logo.jpg" alt="Client 1" />
					</li>
				</ul>
			</div>

	</section><!-- end clients -->

	<!-- Call To Action Section -->
	<section class="cta">
		<div class="container animated wow fadeInUp">

			<h3 class="cta_title">Ready To Start Your Project?</h3>
			<a href="#" class="cta_button">yes we are ready &rarr;</a>
		
		</div>
	</section><!-- end cta(call to action) -->

	<!-- Footer Section -->
	<footer class="clearfix">
		<div class="container">
			
			<!-- Copyrights  -->
			<div class="copyright animated wow fadeInUp">
				<img src="${contextPath}/resources/img/footer_logo.png" alt="Деканат." class="footer_logo">
				<p>© 2014 copyright pixelhint - All rights reserved</p>
				<p>More free templates @ <a href="http://pixelhint.com">Pixelhint.com</a></p>
			</div>
			
			<div class="footer_links">

				<!-- Social Media Links  -->
				<div class="sm columns animated wow fadeInRight" data-wow-delay=".2s">
					<h3 class="columns_title">Stay Tuned</h3>
					<ul>
						<li>
							<a class="facebook" href="#">Facebook</a>
						</li>
						<li>
							<a class="twitter" href="#">Twitter</a>
						</li>
						<li>
							<a class="google" href="#">Google Plus</a>
						</li>
					</ul>
				</div>

				<!-- About Links  -->
				<div class="about columns animated wow fadeInRight" data-wow-delay=".3s">
					<h3 class="columns_title">About</h3>
					<ul>
						<li>
							<a href="#">Our Company</a>
						</li>
						<li>
							<a href="#">Our Team</a>
						</li>
						<li>
							<a href="#">Blog</a>
						</li>
					</ul>
				</div>

				<!-- Address  -->
				<div class="address columns animated wow fadeInRight" data-wow-delay=".4s">
					<h3 class="columns_title">Address</h3>
					<p>1012 14th Street Northwest</p>
					<p>Washington, DC 20005</p>
					<p class="phone">(202) 737-1499</p>
				</div>

			</div>

		</div>

	</footer><!-- end footer -->

</body>