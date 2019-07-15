<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Contact</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.png"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/linearicons-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body class="animsition">
	<!-- Content page -->
	<section class="bg0 p-t-104 p-b-116">
		<div class="container">
			<div class="p-b-10">
				<h3 class="ltext-103 cl5">
				</h3>
			</div>
			<div class="flex-w flex-tr">
				<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
					<form>
						<h4 class="mtext-105 cl2 txt-center p-b-30">
							ORDER
						</h4>
	
						<div class="col-sm-6 p-b-5 m-lr-auto">
							<label class="stext-102 cl3" for="name">ORDER LIST</label>
							<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="orlist" type="text" name="orlist">
						</div>
						<div class="col-sm-6 p-b-5 m-lr-auto">
							<label class="stext-102 cl3" for="name">NAME</label>
							<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="name" type="text" name="name">
						</div>

						<div class="col-sm-6 p-b-5 m-lr-auto">
							<label class="stext-102 cl3" for="name">PHONE</label>
							<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="phone" type="number" name="phone">
						</div>

						<div class="col-sm-6 p-b-5 m-lr-auto">
							<label class="stext-102 cl3" for="name">ADDRESS</label>
							<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="address" type="text" name="address">
						</div>
	
						<div class="col-sm-6 p-b-5 m-lr-auto">
							<label class="stext-102 cl3" for="name">PAYMENT</label>
					
								<div class="size-204 respon6-next">
									<div class="rs1-select2 bor8 bg0">
										<select class="js-select2 size-111 bor8 stext-102 cl2 p-lr-20" name="payment">
											<option></option>
											<option>移대뱶</option>
											<option>臾댄넻�옣 �엯湲�</option>
										</select>
										<div class="dropDownSelect2"></div>
									</div>
								</div>
							</div>
						
						<label class="stext-102 cl3"></label>
					
						<input type="button" value="ORDER" onClick="location.href='orderdetail.html'"
 class="flex-c-m m-lr-auto stext-101 cl0 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer" style="width : 300px; height : 50px;">
						
						</input>
					</form>
				</div>
			</div>
		</div>
	</section>
	
	



<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			$(this).css('position','relative');
			$(this).css('overflow','hidden');
			var ps = new PerfectScrollbar(this, {
				wheelSpeed: 1,
				scrollingThreshold: 1000,
				wheelPropagation: false
			});

			$(window).on('resize', function(){
				ps.update();
			})
		});
	</script>
<!--===============================================================================================-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
	<script src="js/map-custom.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>