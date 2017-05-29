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
<div align="right" style="top: 70px; width: 275px; position: absolute;"
	class="s1">

	<h2 style="line-height: 0.98em;" class="font_2">
		<span style="letter-spacing: -0.01em;">${brand}</span>
	</h2>

	<h2 style="line-height: 0.98em;" class="font_2">
		<span style="letter-spacing: -0.01em;">LIST</span>
	</h2>
	<a href="${pageContext.request.contextPath}/web/store/bottoms"><button
			class="button">back to bottoms list</button></a>
</div>

<div align="right">
	<table style="width: 70%" class="font_8">
		<tr>
			<th><center>Id</center></th>
			<th>Model</th>
			<th>Price</th>
			<th><center>Rating</center></th>
			<th>Category</th>

		</tr>
		<c:forEach items="${pants}" var="pant">
			<tr>
				<td><center>
						<c:out value="${pant.pantId}" />
					</center></td>
				<td><c:out value="${pant.pantModel}" /><br> <a
					href="${pageContext.request.contextPath}/web/store/bottoms/edit/${pant.pantId}">Edit</a>
					| <a
					href="${pageContext.request.contextPath}/web/store/bottoms/delete/${pant.pantId}">Delete</a></td>
				<td><c:out value="${pant.pantPrice}" /></td>
				<td><center>
						<c:out value="${pant.pantTest}" />
					</center></td>
				<td><c:out value="${pant.categoryId.name}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>