<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang đăng ký </title>
	<link rel="stylesheet" href="Template/Backend/assets/css/bootstrap.min.css" />
		<!-- font -->
		<link rel="stylesheet" href="Template/Backend/assets/font-awesome/4.5.0/css/font-awesome.min.css" />
		<link rel="stylesheet" href="Template/Backend/font/font-awesome.min.css" />
		<!--link rel="stylesheet" href="Template/Backend/assets/css/fonts.googleapis.com.css" /-->
		
		<link rel="stylesheet" href="Template/Backend/assets/css/ace.min.css" />

		<link rel="stylesheet" href="Template/Backend/assets/css/ace-rtl.min.css" />
		<script type="text/javascript">
		function Validate()
		{
			var name = document.myform.name.value;
			var membername = document.myform.membername.value;
			var memberpass = document.myform.memberpass.value;
			
			if (name == "" || membername == "" || memberpass == "")
			{
				alert("Yêu cầu không bỏ trống bất kì thông tin nào");
				return false;
				
			}
			else 
			{
				if (memberpass.length < 6)
				{
					document.getElementById("errorpass").innerHTML = "Độ dài phải pass >= 6";
					return false;
				}
			}	
		}
		</script>
</head>
<body class="login-layout">
	<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="ace-icon fa fa-leaf green"></i>
									<span class="red">Toeic</span>
									<span class="white" id="id-text2">Đức</span>
								</h1>
								<h4 class="blue" id="id-company-text">&copy; Lê Đức</h4>
							</div>
					
							<div class="space-6"></div>

							<div class="position-relative">
								
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												Tạo tài khoản mới
											</h4>

											<div class="space-6"></div>

											<form name="myform" action="RegisterController" method="POST" onsubmit="return Validate()">
												<fieldset>
												<label class="block clearfix" style="color: red">
													<%=request.getAttribute("msgregister")!=null?request.getAttribute("msgregister"):""%>
												</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Nhập họ và tên" name="name"/>
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Nhập tài khoản" name="membername"/>
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Nhập mật khẩu" name="memberpass" onkeyup="return Validate()"/>
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
													<label class="block clearfix" id="errorpass" style="color: red"></label>
													<div class="space"></div>

													<div class="clearfix">
														

														<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">Đăng ký</span>
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

											<div class="social-or-login center">
												<span class="bigger-110"></span>
											</div>

											<div class="space-6"></div>

											
										</div><!-- /.widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="HomeForward" class="forgot-password-link">
													<i class="ace-icon fa fa-arrow-left"></i>
													Trở về trang chủ
												</a>
											</div>
											<div>
												<a href="LoginForward" class="user-signup-link">
													Đăng nhập
													<i class="ace-icon fa fa-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /.widget-body -->
								</div>
									
							</div><!-- /.position-relative -->

							<div class="navbar-fixed-top align-right">
								<br />
								&nbsp;
								<a id="btn-login-dark" href="#">Dark</a>
								&nbsp;
								<span class="blue">/</span>
								&nbsp;
								<a id="btn-login-blur" href="#">Blur</a>
								&nbsp;
								<span class="blue">/</span>
								&nbsp;
								<a id="btn-login-light" href="#">Light</a>
								&nbsp; &nbsp; &nbsp;
							</div>
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div>
</body>
</html>