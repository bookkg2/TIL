<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					
						<h4 class="mtext-105 cl2 txt-center p-b-30">
							회원 정보 수정
						</h4>
					<form action="customerupdateimpl.mc" method="GET">
						<!--챦쩔쩍챙혬혻챌혬짹챦쩔쩍, 챦쩔쩍챙혺쩐챦쩔쩍챙혛혮챔쨍째챘혥혡챙혘혝, 채쨘혣챙혝짹챘혘쩌,email-->
						<div class="col-sm-6 p-b-5 m-lr-auto ">
							<label class="stext-102 cl3" for="id">ID</label>
							<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="id" type="text" name="CUSTOMER_ID" value="${customerupdate.CUSTOMER_ID }">
						</div>

						<div class="col-sm-6 p-b-5 m-lr-auto ">
							<label class="stext-102 cl3" for="pwd">PASSWORD</label>
							<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="pwd" type="text" name="CUSTOMER_PWD" value="${customerupdate.CUSTOMER_PWD }">
						</div> 

						<div class="col-sm-6 p-b-5 m-lr-auto ">
							<label class="stext-102 cl3" for="name">NAME</label>
							<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="name" type="text" name="CUSTOMER_NM" value="${customerupdate.CUSTOMER_NM }">
						</div>

						<div class="col-sm-6 p-b-5 m-lr-auto ">
							<label class="stext-102 cl3" for="name">PHONE</label>
							<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="phone" type="text" name="CUSTOMER_PHONE" value="${customerupdate.CUSTOMER_PHONE }">
						</div>

						<div class="col-sm-6 p-b-5 m-lr-auto ">
							<label class="stext-102 cl3" for="name">ADDRESS</label>
							<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="address" type="text" name="CUSTOMER_ADDR" value="${customerupdate.CUSTOMER_ADDR }">
						</div>
	
						<div class="col-sm-6 p-b-5 m-lr-auto ">
							<label class="stext-102 cl3" for="email">EMAIL</label>
							<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="email" type="text" name="CUSTOMER_EMAIL" value="${loginuser.CUSTOMER_EMAIL }">
						</div>
						
						<label class="stext-102 cl3"></label>
						<input type="submit" class="flex-c-m m-lr-auto stext-101 cl0 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer" style="width : 300px; height : 50px" value="UPDATE">
							
						
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
				wheelPropagation: false,
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