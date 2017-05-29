<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}
</style>
<div align="right" style="top: 70px; width: 275px; position: absolute"
	class="s1">

	<h2 style="line-height: 0.98em;" class="font_2">
		<span style="letter-spacing: -0.01em;">TOPs</span>
	</h2>

	<h2 style="line-height: 0.98em;" class="font_2">
		<span style="letter-spacing: -0.01em;">LIST</span>
	</h2>
	<a href="${pageContext.request.contextPath}/web/store/bottoms/create"><button
			class="button3">Create New Bottoms</button></a>
</div>


<div align="right">
	<table style="width: 70%" class="font_8">
		<tr>
			<th></th>
			<th><p align="right">Price</p></th>
		</tr>
		<c:forEach items="${shirtTest}" var="shirt">
			<tr>
				<td><span
					style="text-decoration: none; font-weight: bold; font-size: 20px; font-family: helvetica-w01-bold, helvetica-w02-bold, helvetica-lt-w10-bold, sans-serif;">
						<c:out value="${shirt.brand}" />
				</span>:&nbsp; <c:out value="${shirt.name}" /><br> &emsp;
					Rating:&nbsp;<c:out value="${shirt.taste}" /><br> &emsp;
					Category:&nbsp;<c:out value="${shirt.catId.category}" /></td>
				<td><p align="right">
						<c:out value="${shirt.price}" />
					</p></td>
			</tr>
		</c:forEach>
	</table>
</div>
