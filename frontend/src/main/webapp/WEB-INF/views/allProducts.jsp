<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
          <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
           <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
           

 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
          <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
           <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Elite Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
//tags
<link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/css/font-awesome.css" rel="stylesheet"> 
<link href="resources/css/easy-responsive-tabs.css" rel='stylesheet' type='text/css'/>
//for bootstrap working
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>
 --></head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<!-- /banner_bottom_agile_info -->
<div class="page-head_agile_info_w3l">
		<div class="container">
			
			<!--/w3_short-->
				 <div class="services-breadcrumb">
						<div class="agile_inner_breadcrumb">
						 </div>
				</div>
	   <!--//w3_short-->
	</div>
</div>

<!-- /new_arrivals --> 
	<div class="new_arrivals_agile_w3ls_info"> 
		<div class="container">
		    <h3 class="wthree_text_info">All<span>Products</span></h3>		
				<div id="horizontalTab">
						<!-- <ul class="resp-tabs-list">
							<li> Men's</li>
							<li> Women's</li>
							<li> Bags</li>
							<li> Footwear</li>
						</ul> -->
					<div class="resp-tabs-container">
					<!--/tab_one-->
						
					<c:forEach items="${prodList }" var="pro">
							
						<div class="tab1">
							<div class="col-md-3 product-men">
								<div class="men-pro-item simpleCart_shelfItem">
									<div class="men-thumb-item">
										<img src="${pageContext.request.contextPath }/resources/${pro.pro_imagename }" alt="" class="pro-image-front">
										<img src="${pageContext.request.contextPath }/resources/${pro.pro_imagename }" alt="" class="pro-image-back">
											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
													<a href="productDetails?pro_id=${pro.pro_id }" class="link-product-add-cart">Quick View</a>
												</div>
											</div>
									</div>
									<div class="item-info-product ">
										<h4><a href="single.html">${pro.pro_name }</a></h4>
										<div class="info-product-price">
											<span class="item_price">${pro.pro_price }</span>
											<del>${pro.pro_price }</del>
										</div>
										<div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
															<form action="addToCart" method="post">
																<fieldset>
																	<input type="hidden" name="pro_price" value="${pro.pro_price }" />
																	<input type="hidden" name="pro_imagename" value="${pro.pro_imagename }" />
																	<input type="hidden" name="pro_name" value="${pro.pro_name }" />
																	<input type="hidden" name="quantity" value="1" />
																	<input type="hidden" name="pro_id" value="${pro.pro_id }" />
																	<input type="hidden" name="discount_amount" value="1.00" />
																	<input type="hidden" name="currency_code" value="USD" />
																	<input type="hidden" name="return" value=" " />
																	<input type="hidden" name="cancel_return" value=" " />
																	<input type="submit" name="submit" value="Add to cart" class="button" />
																</fieldset>
															</form>
														</div>
																			
									</div>
								</div>
							</div>
						</div>
						
					</c:forEach>
						
					</div>
				</div>
			</div>
		</div>
<jsp:include page="footer.jsp"/>
</body>

</html>