<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #141e30, #243b55);
            color: #f8f9fa;
            font-family: 'Poppins', sans-serif;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.1);
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
        }
        .btn-custom {
            background-color: #007bff;
            color: white;
            border: none;
        }
        .btn-custom:hover {
            background-color: #0056b3;
        }
        .form-label {
            font-size: 1.2rem;
        }
        .admin-login {
            font-size: 0.9rem;
            text-align: right;
        }
        .admin-login a {
            color: #f8f9fa;
            text-decoration: underline;
        }
        .admin-login a:hover {
            color: #007bff;
        }
    </style>
</head>
<body>
    <div class="container text-center">
        <h1 class="mb-4">${appName}</h1>
        <hr class="border border-light">

        <form action="getBooks" method="get" class="mt-4">
            <div class="mb-3">
                <label for="bookName" class="form-label">Enter Book Name:</label>
                <input type="text" id="bookName" name="name" maxlength="30" class="form-control" placeholder="E.g., Harry Potter" required>
            </div>
            <button type="submit" class="btn btn-custom w-100 py-2">Search</button>
        </form>

        <div class="admin-login mt-3">
            <p>
                Are you an admin? <a href="login">Login here</a>
            </p>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
