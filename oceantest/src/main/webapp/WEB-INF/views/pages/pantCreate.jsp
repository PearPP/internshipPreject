<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div align="right" style="top: 70px; width: 275px; position: absolute;"
	class="s1">
	<h2 style="line-height: 0.98em;" class="font_2">
		<span style="letter-spacing: -0.01em;">Creating</span>
	</h2>

	<h2 style="line-height: 0.98em;" class="font_2">
		<span style="letter-spacing: -0.01em;">Bottom</span>
	</h2>
	<a href="${pageContext.request.contextPath}/web/store/bottoms"><button
			class="button">back to bottoms list</button></a><br>
	<!-- <a
		href="${pageContext.request.contextPath}/web/store/bottoms/create"><button
			class="button3">Create New Bottoms</button></a> -->
</div>

<div align="right">
	<div class="font_8" style="width: 60%" align="left">
		<form:form method="POST"
			action="${pageContext.request.contextPath}/web/store/bottoms/create">
			<div>
				Bottom Brand: <select name="pantBrand" class="button">
					<option value="FOREVER 21">FOREVER 21</option>
					<option value="MUJI">MUJI</option>
					<option value="UNIQLO">UNIQLO</option>
					<option value="ZARA">ZARA</option>
				</select>
			</div>
			<br>


			<div>
				Bottom Model: <input type="text" name="pantModel" value="" />
			</div>
			<br>

			<div>
				Bottom Price: <input type="text" name="pantPrice" value="" />
			</div>
			<br>

			<div>
				Bottom Rating: <select name="pantTest" class="button">
					<option value=1>1</option>
					<option value=2>2</option>
					<option value=3>3</option>
					<option value=4>4</option>
					<option value=5>5</option>
				</select>
			</div>
			<br>

			<div>
				Bottom Category: <select name="categoryId.id" class="button">
					<option value=1>Mens Bottom</option>
					<option value10px 10px=2>Women Bottom</option>
				</select>
			</div>
			<br>

			<div>
				<input type="submit" value="Save" class="button1" />
			</div>
		</form:form>

	</div>
</div>
