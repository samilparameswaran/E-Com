<body>
<!-- js -->
<script type="text/javascript" src="resources/js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<script src="resources/js/modernizr.custom.js"></script>
	<!-- Custom-JavaScript-File-Links --> 
	<!-- cart-js -->
	<script src="js/minicart.min.js"></script>
<script>
	// Mini Cart
	paypal.minicart.render({
		action: '#'
	});

	if (~window.location.search.indexOf('reset=true')) {
		paypal.minicart.reset();
	}
</script>

	<!-- //cart-js --> 
<!-- script for responsive tabs -->						
<!-- <script src="resources/js/easy-responsive-tabs.js"></script>
 --><!-- <!-- <script>
	$(document).ready(function () {
	$('#horizontalTab').easyResponsiveTabs({
	type: 'default', //Types: default, vertical, accordion           
	width: 'auto', //auto or any width like 600px
	fit: true,   // 100% fit in a container
	closed: 'accordion', // Start closed if in accordion view
	activate: function(event) { // Callback function if tab is switched
	var $tab = $(this);
	var $info = $('#tabInfo');
	var $name = $('span', $info);
	$name.text($tab.text());
	$info.show();
	}
	});
	$('#verticalTab').easyResponsiveTabs({
	type: 'vertical',
	width: 'auto',
	fit: true
	});
	});
</script> --> -->
<!-- //script for responsive tabs -->		
<!-- stats -->
	<script src="resources/js/jquery.waypoints.min.js"></script>
	<script src="resources/js/jquery.countup.js"></script>
	<script>
		$('.counter').countUp();
	</script>
<!-- //stats -->
<!-- start-smoth-scrolling -->
<!-- <script type="text/javascript" src="resources/js/move-top.js"></script>
<script type="text/javascript" src="resources/js/jquery.easing.min.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script> -->
<!-- here stars scrolling icon -->
	<!-- <script type="text/javascript">
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
	</script> -->
<!-- //here ends scrolling icon -->


<!-- for bootstrap working -->
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<!-- footer -->
<div class="footer">
	<div class="footer_agile_inner_info_w3l">
		<div class="col-md-3 footer-left">
			<h2><a href="index.html"><span>S</span>amsung Mobile </a></h2>
			<p>The Vision 2020 is at the core of our commitment to create a better world full of richer digital experiences, through innovative technology and products.
The goal of the vision is to become a beloved brand, an innovative company, and an admired company. 
For this, we dedicate our efforts to creativity and innovation, shared value with our partners, and our great people.</p>
			<ul class="social-nav model-3d-0 footer-social w3_agile_social two">
															<li><a href="https://www.facebook.com/" class="facebook">
																  <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div></a></li>
															<li><a href="https://twitter.com/login" class="twitter"> 
																  <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div></a></li>
															<li><a href="https://www.instagram.com" class="instagram">
																  <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div></a></li>
															<li><a href="https://www.linkedin.com/" class="linkedin">
																  <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div></a></li>
														</ul>
		</div>
		<div class="col-md-9 footer-right">
			<div class="sign-grds">
				<div class="col-md-4 sign-gd">
					<h4>Our <span>Information</span> </h4>
					<ul>
						<li><a href="index">Home</a></li>
						<li><a href="viewProducts?cat_id=66">Foldable Series</a></li>
						<li><a href="viewProducts?cat_id=72">Smart Phone</a></li>
						<li><a href="about">About</a></li>
						<li><a href="viewProducts?cat_id=69">Tablets</a></li>
						
					</ul>
				</div>
				
				<div class="col-md-5 sign-gd-two">
					<h4>Store <span>Information</span></h4>
					<div class="w3-address">
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-phone" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Phone Number</h6>
								<p>+91-9980945164</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-envelope" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Email Address</h6>
								<p>Email :<a href="mailto:example@email.com"> samilparameswaran@gmail.com</a></p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-map-marker" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Location</h6>
								<p>D-531, 11th Avenue, Gaur City -2, Greater Noida
								


<!--<script>
<div id="googleMap" style="width:100%;height:400px;"></div>

function myMap() {
var mapProp= {
  center:new google.maps.LatLng(28.6107,77.4250),
  zoom:5,
};
var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
</script>
-->

<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY&callback=myMap"></script>

</body>
</html>
								
								</p>
							</div>
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
				<div class="col-md-3 sign-gd flickr-post">
					<h4>Flickr <span>Posts</span></h4>
					<ul>
						<li><a href="single.html"><img src="resources/images/t1.jpg" alt=" " class="img-responsive" /></a></li>
						<li><a href="single.html"><img src="resources/images/t2.jpg" alt=" " class="img-responsive" /></a></li>
						<li><a href="single.html"><img src="resources/images/t3.jpg" alt=" " class="img-responsive" /></a></li>
						<li><a href="single.html"><img src="resources/images/t4.jpg" alt=" " class="img-responsive" /></a></li>
						<li><a href="single.html"><img src="resources/images/t1.jpg" alt=" " class="img-responsive" /></a></li>
						<li><a href="single.html"><img src="resources/images/t2.jpg" alt=" " class="img-responsive" /></a></li>
						<li><a href="single.html"><img src="resources/images/t3.jpg" alt=" " class="img-responsive" /></a></li>
						<li><a href="single.html"><img src="resources/images/t2.jpg" alt=" " class="img-responsive" /></a></li>
						<li><a href="single.html"><img src="resources/images/t4.jpg" alt=" " class="img-responsive" /></a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="clearfix"></div>
			<div class="agile_newsletter_footer">
					<div class="col-sm-6 newsleft">
				<h3>SIGN UP FOR NEWSLETTER !</h3>
			</div>
			<div class="col-sm-6 newsright">
				<form action="#" method="post">
					<input type="email" placeholder="Enter your email..." name="email" required="">
					<input type="submit" value="Submit">
				</form>
			</div>

		<div class="clearfix"></div>
	</div>
		<p class="copy-right">&copy 2019 Samsung mobile E-commerce site. All rights reserved | Powered by Samil Parameswaran
</div>
<!-- //footer -->
</body>
