<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<title>Add New Material</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #f8f9fa;
	padding: 20px;
}

.form-container {
	background: #ffffff;
	border-radius: 10px;
	padding: 15px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	max-width: 600px;
	margin: 0 auto;
}

.form-container h1 {
	margin-bottom: 20px;
	font-size: 24px;
	color: #343a40;
}

.form-container fieldset {
	margin-bottom: 10px;
}

.form-container label {
	font-weight: bold;
	margin-bottom: 5px;
}

.form-container input[type="text"], .form-container select {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
	border: 1px solid #ced4da;
	border-radius: 5px;
}

.form-container input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #28a745;
	border: none;
	color: #ffffff;
	font-size: 16px;
	border-radius: 5px;
	cursor: pointer;
}

.form-container input[type="submit"]:hover {
	background-color: #218838;
}

/* CSS để tùy chỉnh checkbox */
.form-container input[type="checkbox"] {
	margin-right: 10px; /* Khoảng cách giữa checkbox và label */
	margin-left:5px;
	transform: scale(1.5); /* Phóng to checkbox */
}

.form-container label.checkbox-label {
	display: inline-block;
	margin-bottom: 10px; /* Khoảng cách giữa các checkbox và các fieldset */
}

</style>
</head>

<body>
	<div class="container">
		<div class="form-container">
			<h1>Enter Material Details</h1>
			<form:form method="post" modelAttribute="formWrapper">
				<fieldset>
					<form:label path="material.typeId">Type</form:label>
					<form:select path="material.typeId" class="form-select">
						<%-- <form:option value="1">Type 1</form:option>
						<form:option value="2">Type 2</form:option>
						<form:option value="3">Type 3</form:option>
						<form:option value="4">Type 4</form:option>
						<form:option value="5">Type 5</form:option> --%>
						
						<c:forEach items = "${materialTypes}" var = "materialType">
							 <form:option value="${materialType.typeId}">${materialType.type}</form:option>
						
						</c:forEach>
					</form:select>
				</fieldset>
				<fieldset>
					<form:label path="selectedCategory" class="checkbox-label">Category</form:label>
					<br>
					<form:checkboxes path="selectedCategory" class = "check"
						items="${category}" delimiter=" " />
				</fieldset>
				<fieldset>
					<form:label path="material.name">Name</form:label>
					<form:input type="text" path="material.name" required="required"
						class="form-control" />
				</fieldset>
				<fieldset>
					<form:label path="material.author">Author</form:label>
					<form:input type="text" path="material.author" required="required"
						class="form-control" />
				</fieldset>
				<fieldset>
					<form:label path="material.description">Description</form:label>
					<form:input type="text" path="material.description"
						required="required" class="form-control" />
				</fieldset>
				<input type="submit" class="btn btn-success">
			</form:form>
		</div>
	</div>
</body>

</html>
