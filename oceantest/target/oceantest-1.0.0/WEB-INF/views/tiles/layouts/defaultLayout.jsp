<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ page isELIgnored="false" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib
uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<title>ocean store</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/static/css/demo-app.css' />" rel="stylesheet"></link>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/prototype/1.7.3.0/prototype.js"></script>
<script src="http://yui.yahooapis.com/3.18.1/build/yui/yui-min.js"></script>
</head>

<body>
	<div align="center">
		<div class="SITE_ROOT" id="SITE_ROOT"
			style="width: 980px; padding-bottom: 41px;">

			<div id="SITE_STRUCTURE"
				style="top: 100px; width: 1000px; position: relative; height: 1326px;">
				<div class="main-style">

					<div class="header-style">
						<tiles:insertAttribute name="header" />
					</div>

					<div class="body-style">
						<tiles:insertAttribute name="body" />
					</div>
					<div class="footer-style">
						<tiles:insertAttribute name="footer" />
					</div>

				</div>

			</div>
		</div>
	</div>

</body>

</html>