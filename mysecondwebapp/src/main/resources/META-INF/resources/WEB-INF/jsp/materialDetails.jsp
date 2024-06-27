<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Material Details</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .card {
      max-width: 600px;
      margin: 0 auto;
      margin-top: 50px;
      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }
    .card-header {
      background-color: #007bff;
      color: #fff;
      font-weight: bold;
      text-transform: uppercase;
    }
    .card-body {
      background-color: #fff; /* Màu nền của nội dung */
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="card">
      <div class="card-header">
        Material Details
      </div>
      <div class="card-body">
        <h5 class="card-title">This is ${material.name}'s description</h5>
        <p class="card-text">${material.description}</p>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS and dependencies (optional) -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
