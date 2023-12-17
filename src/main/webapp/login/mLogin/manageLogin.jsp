<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.manage.model.*"%>


<%
Object account = session.getAttribute("mUserName");
if (account == null) {
	System.out.println("�T�{�M��");
}
%>

<%
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
response.setHeader("Cache-Control", "post-check=0, pre-check=0");
response.setHeader("Pragma", "no-cache");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>�޲z���n�J</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/bootstrap.min.css" />
<!-- Vendor CSS-->
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/animsition/animsition.min.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/wow/animate.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/css-hamburgers/hamburgers.min.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/slick/slick.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/select2/select2.min.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all" />
<!-- Main CSS-->
<link href="<%=request.getContextPath()%>/backEnd-Website/css/login.css"
	rel="stylesheet" media="all" />
<style type="text/css">
button.au-btn {
	/* border: 2px solid red; */
	background-color: #207DCA;
	/* margin: 5px; */
}


.login-form {
	max-height: 360px;
	overflow-y: auto;
}

button.au-btn:hover {
	/* border: 2px solid red; */
	background-color: orange;
	/* margin: 5px; */
}

div.pwd-see {
	display: flex;
	align-items: center;
}

label.pwd-see2 {
	margin-left: 5px;
}
</style>
</head>
<body class="animsition">
	<div class="all">
		<!-- <img src="./pic/m_login.png" height="1000" width="1000"> -->
	</div>
	<div class="page-wrapper">
		<div class="page-content--bge5">
			<div class="container">
				<div class="login-wrap">
					<div class="login-content">
						<div class="login-logo">
							<a href="#"> <img
								src="<%=request.getContextPath()%>/backEnd-Website/pic/m_login_logo.png"
								alt="CoolAdmin" />
							</a>
						</div>
						<div class="login-form">
							<form action="<%=request.getContextPath()%>/mloginhandler"  id="loginForm"
								method="post">
								<div class="form-group">
									<label>�b��</label><font color=red>${requestScope.errorMsgs.mUserName}</font>
									<input class="au-input au-input--full" type="text"
										name="mUserName" placeholder="�п�J�b��"
										value="${param.mUserName}" />
								</div>
								<div class="form-group">
									<label>�K�X</label><font color=red>${requestScope.errorMsgs.mPassword}</font>
									<input class="au-input au-input--full" type="password"
										id="password" name="mPassword" placeholder="�п�J�K�X"
										value="${param.mPassword}" />
									<div class="pwd-see">
										<input type="checkbox" id="togglePwd"> <label
											class="pwd-see2" for="togglePwd">��ܱK�X</label>
									</div>
								</div>
								<div class="form-group">
									<label>���ҽX</label> <input class="au-input au-input--full"
										type="text" name="checkCode" placeholder="�п�J���ҽX" /> <img
										id="yzm_img" src="${pageContext.request.contextPath}/valistr"
										style="cursor: pointer" onclick="changeYZM(this)" /> <span
										id="valistr_msg"></span>
								</div>
								<button class="au-btn au-btn--block au-btn--green m-b-20"
									type="submit">�n�J</button>
								<div  class="error-message" style="color: red;">${requestScope.errorMsgs.mStatus}</div>
							</form>
						</div>
					</div>
					<div class="left-image">
						<img
							src="<%=request.getContextPath()%>/backEnd-Website/pic/Group 460.png" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		/**
		 * �������O�_����
		 */
		function checkNull(name, msg) {
			setMsg(name, "")
			var v = document.getElementsByName(name)[0].value;
			if (v == "") {
				setMsg(name, msg)
				return false;
			}
			return true;
		}
		/**
		 * ����J���]�w���ܰT��
		 */
		function setMsg(name, msg) {
			var span = document.getElementById(name + "_msg");
			span.innerHTML = "<font color='red'>" + msg + "</font>";
		}
		/**
		 * �I������ҽX
		 */
		function changeYZM(imgObj) {
			imgObj.src = "${pageContext.request.contextPath}/valistr?time="
					+ new Date().getTime();
		}
	</script>
	<script>
		$('form').submit(function(e) {
			e.preventDefault();

			// ���ҥN�X
		})

		var code = $('input[name=checkCode]').val();

		$.ajax({
			url : '/checkCode',
			data : {
				code : code
			},
			 success: function (res) {
		            if (res.success) {
		                // Validation passed, submit the form
		                $('#loginForm').submit();
		            } else {
		                // Validation failed, show an error message
		                alert('���ҽX���~!');
		            }
		        }
		});
	</script>
	<script>
		history.pushState(null, null, document.URL);
		window.addEventListener('popstate', function() {
			history.pushState(null, null, document.URL);
		});

		function ajaxLogoutCallback() {
			// �n�X�ާ@
			history.pushState(null, null, document.URL);
			window.addEventListener('popstate', function() {
				history.pushState(null, null, document.URL);
			});
		}
	</script>
	<script>
		const password = document.getElementById('password');
		const toggle = document.getElementById('togglePwd');

		toggle.addEventListener('change', function() {
			if (this.checked) {
				password.type = 'text';
			} else {
				password.type = 'password';
			}
		});
	</script>
	<!-- Jquery JS-->
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/jquery-3.2.1.min.js"></script>
	<!-- proper.min.js first, then bootstrap.min.js -->
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/popper.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/slick/slick.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/wow/wow.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/animsition/animsition.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/counter-up/jquery.waypoints.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/counter-up/jquery.counterup.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/circle-progress/circle-progress.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/chartjs/Chart.bundle.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/select2/select2.min.js"></script>
	<!-- Main JS-->
	<script src="<%=request.getContextPath()%>/backEnd-Website/js/main.js"></script>
</body>
</html>