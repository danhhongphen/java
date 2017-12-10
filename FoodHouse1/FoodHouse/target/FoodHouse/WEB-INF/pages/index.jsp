<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>Food Club a Hotels and Restaurants Category Bootstrap responsive Website Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="Food Club Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--// bootstrap-css -->
<!-- css -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!--// css -->
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<!-- font -->
<link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Great+Vibes&amp;subset=latin-ext" rel="stylesheet">
<!-- //font -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script> 

<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<![endif]-->
</head>
<body>
	<!-- banner -->
	<div class="banner jarallax">
		<!-- agileinfo-dot -->
		<div class="agileinfo-dot">
			<div class="w3layouts-header-top">
				<div class="w3-header-top-grids">
					<div class="w3-header-top-left">
						<p><i class="fa fa-volume-control-phone" aria-hidden="true"></i> +1 234 567 8901</p>
					</div>
					<div class="w3-header-top-right">
						<div class="agileinfo-social-grids">
							<ul>
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-rss"></i></a></li>
								<li><a href="#"><i class="fa fa-vk"></i></a></li>
							</ul>
						</div>
						<div class="w3-header-top-right-text">
							<p><i class="fa fa-home" aria-hidden="true"></i> 1st Street , mexico city</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="head">
				<div class="head-nav-grids">
					<div class="navbar-top">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
							  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							  </button>
								 <div class="navbar-brand logo ">
									<h1><a href="index.html">Food <span>Club</span></a></h1>
								</div>

							</div>

							<!-- Collect the nav links, forms, and other content for toggling -->
							<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							 <ul class="nav navbar-nav link-effect-4">
							<li class="active"><a href="index.html" data-hover="Home">Home</a> </li>
								<li><a href="about.html" data-hover="About">About </a> </li>
								<li><a href="gallery.html"  data-hover="Gallery">Gallery</a></li>
								<li class="dropdown">
									<a href="codes.html" class="dropdown-toggle" data-hover="Pages" data-toggle="dropdown">Pages <b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="icons.html">Icons</a></li>
										<li><a href="codes.html">Short Codes</a></li>
									</ul>
							  </li>
								<li><a href="contact.html" data-hover="Contact">Contact</a></li>
							  </ul>
							</div><!-- /.navbar-collapse -->
						</div>
			
					<div class="header-left">
						<ul>
							<li><i class="fa fa-envelope" aria-hidden="true"></i> <a href="mailto:info@example.com">@example.com</a></li>
							<li><i class="fa fa-fax" aria-hidden="true"></i> +1234 567 892</li>
						</ul>
					</div>
					<div class="clearfix"></div>	
				</div>
			</div>
			<div class="w3layouts-banner-slider">
				<div class="w3layouts-banner-top-slider">
					<div class="slider">
						<div class="callbacks_container">
							<ul class="rslides callbacks callbacks1" id="slider4">
								<li>
									<div class="agileits-banner-info">
										<h3>Lorem ipsum <span>dolor sit amet</span></h3>
										<div class="w3-button">
											<a href="single.html">More</a>
										</div>
									</div>
								</li>
								<li>
									<div class="agileits-banner-info">
										<h3>Donec posuere <span>cursus nibh</span></h3>
										<div class="w3-button">
											<a href="single.html">More</a>
										</div>
									</div>
								</li>
							</ul>
						</div>
						<div class="clearfix"> </div>
						<script src="js/responsiveslides.min.js"></script>
						<script>
							// You can also use "$(window).load(function() {"
							$(function () {
							  // Slideshow 4
							  $("#slider4").responsiveSlides({
								auto: true,
								pager:true,
								nav:true,
								speed: 500,
								namespace: "callbacks",
								before: function () {
								  $('.events').append("<li>before event fired.</li>");
								},
								after: function () {
								  $('.events').append("<li>after event fired.</li>");
								}
							  });
						
							});
						 </script>
						<!--banner Slider starts Here-->
					</div>
				</div>
			</div>
		</div>
		<!-- //agileinfo-dot -->
	</div>
	<!-- //banner -->
	<!-- welcome -->
	<div class="welcome">
		<div class="container">
			<div class="agileinfo-heading">
				<h3>Welcome</h3>
			</div>
			<div class="agileits-welcome-grids">
				<div class="col-md-5 agileits-welcome-left">
					<img src="images/2.jpg" alt="" />
				</div>
				<div class="col-md-7 agileits-welcome-left">
					<h2>Aenean et ultricies mi, ac ultricies ex. Cras iaculis lectus at orci dapibus efficitur.</h2>
					<div class="agile-border"> </div>
					<p>Vivamus placerat velit placerat elementum vestibulum. Suspendisse faucibus, dui id sagittis dignissim, tortor mauris maximus turpis, eu vehicula est leo nec metus. Donec pellentesque felis sit amet vehicula iaculis. Fusce sollicitudin leo ipsum, nec mollis quam dignissim eu. <span>Vivamus pellentesque porttitor hendrerit. In dui justo, egestas at aliquam quis, mollis dictum ex. Curabitur laoreet pretium enim eu hendrerit. Donec vel consectetur mauris, eu malesuada magna. Praesent nec ultricies purus. Phasellus maximus efficitur velit, vel blandit diam elementum sed.</span></p>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- //welcome -->
	<!-- special -->
	<div class="special">
		<div class="container">
			<div class="agileinfo-heading">
				<h3>Specialities</h3>
			</div>
			<div class="special-top-grids">
				<div class="w3-agile-special">
					<div class="col-md-3 special-grids">
						<div class="special-img">
							<img class="img-responsive" src="images/s1.jpg" alt="">
							<div class="captn">
								<div class="captn-top">
									<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
								</div>
								<div class="wthree-special-info">
									<h4>Phasellus</h4>
								</div>
							</div>
						</div>
					</div>					
					<div class="col-md-3 special-grids">
						<div class="special-img">
							<img class="img-responsive" src="images/s2.jpg" alt="">
							<div class="captn">
								<div class="captn-top">
									<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
								</div>
								<div class="wthree-special-info">
									<h4>Accumsan</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 special-grids">
						<div class="special-img">
							<img class="img-responsive" src="images/s3.jpg" alt="">
							<div class="captn">
								<div class="captn-top">
									<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
								</div>
								<div class="wthree-special-info">
									<h4>Sodales</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 special-grids">
						<div class="special-img">
							<img class="img-responsive" src="images/s4.jpg" alt="">
							<div class="captn">
								<div class="captn-top">
									<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
								</div>
								<div class="wthree-special-info">
									<h4>Placerat</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="w3-agile-special">
					<div class="col-md-3 special-grids">
						<div class="special-img">
							<img class="img-responsive" src="images/s5.jpg" alt="">
							<div class="captn">
								<div class="captn-top">
									<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
								</div>
								<div class="wthree-special-info">
									<h4>Phasellus</h4>
								</div>
							</div>
						</div>
					</div>					
					<div class="col-md-3 special-grids">
						<div class="special-img">
							<img class="img-responsive" src="images/s4.jpg" alt="">
							<div class="captn">
								<div class="captn-top">
									<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
								</div>
								<div class="wthree-special-info">
									<h4>Accumsan</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 special-grids">
						<div class="special-img">
							<img class="img-responsive" src="images/s1.jpg" alt="">
							<div class="captn">
								<div class="captn-top">
									<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
								</div>
								<div class="wthree-special-info">
									<h4>Sodales</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 special-grids">
						<div class="special-img">
							<img class="img-responsive" src="images/s2.jpg" alt="">
							<div class="captn">
								<div class="captn-top">
									<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
								</div>
								<div class="wthree-special-info">
									<h4>Placerat</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<!-- //special -->
	<!-- history -->
	<div class="history jarallax">
		<div class="history-dot">
			<div class="container">
				<div class="agileinfo-history-grids">
					<div class="slider">
						<div class="callbacks_container">
							<ul class="rslides" id="slider3">
								<li>
									<div class="wthree-history-info">
										<h4>Lorem ipsum dolor sit amet, consectetur</h4>
										<p>Mauris mollis, libero id ornare condimentum, erat mi iaculis libero, bibendum dictum leo tortor a magna. Aenean porta non nunc in semper. Fusce eget tempus metus, sit amet posuere lectus. Morbi cursus ante a felis ultrices scelerisque. Nullam cursus odio est, in pellentesque neque elementum nec. Pellentesque a egestas erat.</p>
										<a href="about.html">Read More</a>
									</div>
								</li>
								<li>
									<div class="wthree-history-info">
										<h4>Vivamus placerat velit placerat elementum</h4>
										<p>Nullam tristique faucibus pharetra. Ut ultricies, dui a tincidunt placerat, urna augue pellentesque leo, et posuere velit neque quis justo. Vivamus vel nulla vel tellus pretium maximus. Pellentesque auctor euismod lectus a pretium. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
										<a href="about.html">Read More</a>
									</div>
								</li>
								<li>
									<div class="wthree-history-info">
										<h4>Donec pellentesque felis sit amet vehicula</h4>
										<p>Donec viverra enim nunc, sit amet ultricies dolor placerat vestibulum. Donec id dapibus dolor. Praesent elementum ipsum fringilla ullamcorper facilisis. Morbi blandit tortor molestie ex dignissim, vitae blandit metus ullamcorper. Praesent eleifend risus quam, et aliquet eros tristique a. Duis rhoncus auctor urna, id tristique quam gravida in. </p>
										<a href="about.html">Read More</a>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<script>
									// You can also use "$(window).load(function() {"
									$(function () {
									  // Slideshow 4
									  $("#slider3").responsiveSlides({
										auto: true,
										pager:false,
										nav:false,
										speed: 500,
										namespace: "callbacks",
										before: function () {
										  $('.events').append("<li>before event fired.</li>");
										},
										after: function () {
										  $('.events').append("<li>after event fired.</li>");
										}
									  });
								
									});
								 </script>
								<!--banner Slider starts Here-->
				</div>
			</div>
		</div>
	</div>
	<!-- //history -->
	<!-- subscribe -->
	<div class="wthree-subscribe">
		<div class="container">
			<div class="agileinfo-heading">
				<h3>Newsletter</h3>
			</div>
			<div class="w3-agileits-subscribe-form">
				<form action="#" method="post">
					<input type="text" placeholder="Subscribe" name="Subscribe" required="">
					<button class="btn1">Subscribe</button>
				</form>
			</div>
		</div>
	</div>
	<!-- //subscribe -->
	<!-- footer -->
	<div class="w3-agile-footer">
		<div class="container">
			<div class="footer-grids">
				<div class="col-md-3 footer-grid">
					<div class="footer-grid-heading">
						<h3><a href="index.html">Food <span>Club</span></a></h3>
					</div>
					<div class="agile-footer-info">
						<p>Maecenas pharetra scelerisque sem quis commodo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Interdum et malesuada fames ac ante ipsum primis in faucibus.</p>
					</div>
					<div class="social">
						<ul>
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-rss"></i></a></li>
							<li><a href="#"><i class="fa fa-vk"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-3 footer-grid">
					<div class="footer-grid-heading">
						<h4>Address</h4>
					</div>
					<div class="footer-grid-info">
						<p>Eiusmod Tempor inc
							<span>St Dolore Place,Kingsport 56777.</span>
						</p>
						<p class="phone">Phone : +1 123 456 789
							<span>Email : <a href="mailto:example@email.com">mail@example.com</a></span>
							<span>FAX : 123 456 7890</span>
						</p>
					</div>
				</div>
				<div class="col-md-3 footer-grid">
					<div class="footer-grid-heading">
						<h4>Navigation</h4>
					</div>
					<div class="footer-grid-info">
						<ul>
							<li><a href="index.html">Home</a></li>
							<li><a href="about.html">About</a></li>
							<li><a href="gallery.html">Gallery</a></li>
							<li><a href="icons.html">Icons</a></li>
							<li><a href="codes.html">Short Codes</a></li>
							<li><a href="contact.html">Contact</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-3 footer-grid">
					<div class="footer-grid-heading">
						<h4>Twitter Posts</h4>
					</div>
					<div class="agile-footer-grid">
						<ul class="w3agile_footer_grid_list">
							<li>Ut aut reiciendis voluptatibus maiores <a href="#">http://example.com</a> alias, ut aut reiciendis.
								<span><i class="fa fa-twitter" aria-hidden="true"></i> 02 days ago</span></li>
							<li>Itaque earum rerum hic tenetur a sapiente delectus <a href="#">http://example.com</a><span><i class="fa fa-twitter" aria-hidden="true"></i> 03 days ago</span></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="agileits-w3layouts-copyright">
				<p>� 2017 Food Club . All Rights Reserved | Design by <a href="http://w3layouts.com/"> W3layouts</a> </p>
			</div>
		</div>
	</div>
	<!-- //footer -->
	<script src="js/jarallax.js"></script>
	<script src="js/SmoothScroll.min.js"></script>
	<script type="text/javascript">
		/* init Jarallax */
		$('.jarallax').jarallax({
			speed: 0.5,
			imgWidth: 1366,
			imgHeight: 768
		})
	</script>
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
	<!-- //here ends scrolling icon -->
</body>	
</html>