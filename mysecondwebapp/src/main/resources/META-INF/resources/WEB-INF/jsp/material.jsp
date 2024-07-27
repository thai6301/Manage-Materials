
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Material List</title>
<!-- Bootstrap CSS -->
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="webjars/datatables/1.10.25/css/jquery.dataTables.min.css" rel="stylesheet">
<style>
/* CSS tùy chỉnh cho dropdown */
.dataTables_length select {
    margin-left: 5px;
    margin-right: 5px;
    width: auto;
}

.dataTables_length label {
    font-weight: bold;
    font-size: 14px;
}

.dataTables_wrapper .dataTables_filter {
    display: none;
}

/* CSS cho form tìm kiếm */
#searchForm {
    position: relative;
}

#searchForm .form-group {
    margin-bottom: 20px;
}

#searchForm .btn-search {
    position: absolute;
    bottom: -30px;
    right: 0;
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
<div id="error-message" path = "error-message" class="alert alert-danger" style="display:none;"></div>
<div class="container mt-5">
    <div class="card p-4">
        <h3 class="mb-4">Search Materials</h3>
        <form action="" id="searchForm">
            <div class="row">
                <div class="col-md-8 form-group">
                    <label for="search">Name</label>
                    <input type="text" name="name" id="name" class="form-control" placeholder="Enter name">
                </div>
                <div class="col-md-4 form-group">
                    <label for="category">Category</label>
                    <select name="category" id="category" class="form-control">
                    	<option value="0">Select category</option>
                    	<c:forEach items = "${materialCategory}" var = "materialCategory">
							 <option value="${materialCategory.materialCatId}">${materialCategory.category}</option>
						
						</c:forEach>
                        <!-- <option value="0">Select category</option>
                        <option value="1">Math</option>
                        <option value="2">Physical</option>
                        <option value="3">Category3</option>
                        <option value="4">Category4</option>
                        <option value="5">Category5</option> -->
                    </select>
                </div>
            </div>
            <div class="btn-search">
                <button type="button" class="btn btn-primary w-100" id="search">Search</button>
            </div>
        </form>
    </div>
</div>

<div class="container mt-5">
    <h1>Your Materials</h1>
    <table id="materialTable" class="table">
        <thead class="table-light">
            <tr>
                <th>Material_ID</th>
                <th>Type</th>
                <th>Category</th>
                <th>Name</th>
                <th>Author</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${materials}" var="material">
                <tr>
                    <td>${material[0]}</td>
                    <td>${material[1]}</td>
                    <td>${material[2]}</td>
                    <td><a href="/material/detail?id=${material[0]}">${material[3]}</a></td>
                    <td>${material[4]}</td>
                    <td><a href="delete-material?materialId=${material[0]}&category=${material[2]}" class="btn btn-danger">Delete</a></td>
                    <td><a href="update-material?materialId=${material[0]}&category=${material[2]}" class="btn btn-success">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-material" class="btn btn-success">Add Material</a>
</div>

<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/datatables/1.10.25/js/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function() {

	var errorMessage = "${errorMessage}";
    if (errorMessage) {
        $('#error-message').text(errorMessage).show();
    }
	
    var table = $('#materialTable').DataTable({
        "pageLength": 5, // Thiết lập số lượng mục hiển thị trên mỗi trang
        "lengthMenu": [5, 10, 15, 20], // Tùy chọn số lượng mục hiển thị
        "searching": true, // Cho phép tính năng tìm kiếm
        "info": false // Ẩn thông tin số trang và số lượng dòng
    });

    // Xử lý sự kiện khi nhấn nút "Search"
    $('#search').click(function() {
        $.fn.dataTable.ext.search.push(function(settings, data, dataIndex) {
            var searchTerm = $('#name').val().trim().toLowerCase(); // Lấy giá trị tìm kiếm và chuyển thành chữ thường
            var materialName = data[3].toLowerCase(); // Lấy giá trị của cột "Name" và chuyển thành chữ thường

            // Kiểm tra xem có khớp với từ khóa tìm kiếm
            if (materialName.startsWith(searchTerm)) {
                return true;
            }
            return false; // Nếu không khớp, trả về false để loại bỏ dòng này khỏi kết quả tìm kiếm
        });
        
        var term = $('#name').val().trim();
        table.search('').columns().search('').draw();
        table.columns(3).search(term).draw();
        if($('#category').val()!="0"){
        	var searchTerm = $("#category option:selected").text().trim();
        	table.columns(2).search(searchTerm).draw();
        }
        $.fn.dataTable.ext.search.pop();
        
    });
    
});
</script>
</body>
</html>
