<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ quản lý</title>
		<link rel="stylesheet" href="Template/Backend/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="Template/Backend/assets/font-awesome/4.5.0/css/font-awesome.min.css" />
		<link rel="stylesheet" href="Template/Backend/font/font-awesome.min.css" />
		<link rel="stylesheet" href="Template/Backend/assets/css/colorbox.min.css" />


		<link rel="stylesheet" href="Template/Backend/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<link rel="stylesheet" href="Template/Backend/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="Template/Backend/assets/css/ace-rtl.min.css" />

		<script src="Template/Backend/assets/js/ace-extra.min.js"></script>
		<style type="text/css">
			.image-padding {
				padding-top: 80px;
			}
		</style>
</head>
<body class="no-skin">
	<!-- Header -->
		<jsp:include page="Headeradmin.jsp"></jsp:include>
	<!-- End Header -->
	<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>
			<!-- Menu -->
				<jsp:include page="Menuadmin.jsp"></jsp:include>
			<!-- End Menu -->
			<div class="main-content">
					<div class="main-content-inner">
						<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="AdminForward">Trang chủ</a>
							</li>
						</ul><!-- /.breadcrumb -->

						</div>
						<div class="page-content">
							<!--div class="page-header">
								<h1>
									Gallery
									<small>
										<i class="ace-icon fa fa-angle-double-right"></i>
										responsive photo gallery using colorbox
									</small>
								</h1>
							</div-->
							<div class="row">
								<div class="col-xs-12">
									<center class="image-padding"><img width="500" height="250" alt="" src="Template/Backend/assets/images/homeadmin.jpg" /></center>
								</div>
							</div>
						</div>
					</div>
				</div><!-- /.main-content -->
				<!-- Footer -->
					<jsp:include page="Footeradmin.jsp"></jsp:include>
				<!-- End Footer -->
		
					<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
						<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
					</a>
			</div> <!-- /.main-container -->
	<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="Template/Backend/assets/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='Template/Backend/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="Template/Backend/assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="Template/Backend/assets/js/jquery.colorbox.min.js"></script>

		<!-- ace scripts -->
		<script src="Template/Backend/assets/js/ace-elements.min.js"></script>
		<script src="Template/Backend/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
	var $overflow = '';
	var colorbox_params = {
		rel: 'colorbox',
		reposition:true,
		scalePhotos:true,
		scrolling:false,
		previous:'<i class="ace-icon fa fa-arrow-left"></i>',
		next:'<i class="ace-icon fa fa-arrow-right"></i>',
		close:'&times;',
		current:'{current} of {total}',
		maxWidth:'100%',
		maxHeight:'100%',
		onOpen:function(){
			$overflow = document.body.style.overflow;
			document.body.style.overflow = 'hidden';
		},
		onClosed:function(){
			document.body.style.overflow = $overflow;
		},
		onComplete:function(){
			$.colorbox.resize();
		}
	};

	$('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
	$("#cboxLoadingGraphic").html("<i class='ace-icon fa fa-spinner orange fa-spin'></i>");//let's add a custom loading icon
	
	
	$(document).one('ajaxloadstart.page', function(e) {
		$('#colorbox, #cboxOverlay').remove();
   });
})
		</script>
</body>
</html>