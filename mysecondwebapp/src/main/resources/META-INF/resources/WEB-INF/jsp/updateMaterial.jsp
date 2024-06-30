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

/* CSS Äá» tÃ¹y chá»nh checkbox */
.form-container input[type="checkbox"] {
	margin-right: 10px; /* Khoáº£ng cÃ¡ch giá»¯a checkbox vÃ  label */
	margin-left: 5px;
	transform: scale(1.5); /* PhÃ³ng to checkbox */
}

.form-container label.checkbox-label {
	display: inline-block;
	margin-bottom: 10px;
	/* Khoáº£ng cÃ¡ch giá»¯a cÃ¡c checkbox vÃ  cÃ¡c fieldset */
}

.alert {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
        }

.alert-danger {
            color: #721c24;
            background-color: #f8d7da;
            border-color: #f5c6cb;
        }
</style>
</head>

<body>
	<div class="container">
		<div class="form-container">
			<h1>Update Material Details</h1>
			<div id="error-message" path = "error-message" class="alert alert-danger" style="display:none;"></div>
			<form:form method="post" modelAttribute="formWrapperUpdate">
				<fieldset>
					<form:label path="material.materialId">Material_Id</form:label>
					<form:input path="material.materialId" readonly="true" />
					<form:label path="material.typeId">Type</form:label>
					<form:select path="material.typeId" class="form-select">
						<%-- <form:option value="1">Type 1</form:option>
						<form:option value="2">Type 2</form:option>
						<form:option value="3">Type 3</form:option>
						<form:option value="4">Type 4</form:option>
						<form:option value="5">Type 5</form:option> --%>

						<c:forEach items="${materialTypes}" var="materialType">
							<form:option value="${materialType.typeId}">${materialType.type}</form:option>

						</c:forEach>
					</form:select>
				</fieldset>
				<fieldset>
					<form:label path="materialCategory.category" class="checkbox-label">Category</form:label>
					<br>
					<form:checkboxes path="materialCategory.category" class="check"
						name="checkboxes" items="${category}" delimiter=" " />
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
				<form:input type="hidden" path="material.createdDate" />
				<form:input type="hidden" path="material.deleteFlag" />
				<form:input type="hidden" path="material.firstPublishDate" />
				<form:input type="hidden" path="material.note" />
				<form:input type="hidden" path="material.publisher" />
				<form:input type="hidden" path="material.updatedDate" />
				<form:input type="hidden" path="material.updatedUserId" />
				<form:input type="hidden" path="relMaterialCat.relMaterialCatId" />
				<form:input type="hidden" path="relMaterialCat.materialId" />
				
				
			</form:form>
			
		</div>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.check').click(function() {
				$('.check').not(this).prop('checked', false);
			});
			
			 // Check if there is an error message
            var errorMessage = "${errorMessage}";
            if (errorMessage) {
                $('#error-message').text(errorMessage).show();
            }
		});
		
		
	</script>

</body>

</html>
