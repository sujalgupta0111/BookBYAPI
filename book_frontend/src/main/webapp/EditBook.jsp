<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Add Book</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #141e30, #243b55);
            color: #fff;
            font-family: 'Arial', sans-serif;
        }
        .navbar {
            background-color: #243b55 !important;
        }
        .navbar-brand, .nav-link, .text-dark, .btn-danger {
            color: #fff !important;
        }
        .navbar-brand:hover, .nav-link:hover, {
            color: #e3e3e3 !important;
        }
        .btn-custom {
            background-color: #141e30;
            color: #fff;
        }
        .btn-custom:hover {
            background-color: #243b55;
        }
        .container {
            margin-top: 50px;
            max-width: 600px;
            background: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.3);
            color: #000;
        }
        h2 {
            color: #141e30;
        }
        
        hr { 
  		background-color:grey;
  		height:3px;
		} 
    </style>
</head>
<body>
<header>
    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="adminHome">
            <img alt="" src="https://cdn.icon-icons.com/icons2/317/PNG/512/book-bookmark-icon_34486.png" height="30px">
            ${appName}
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Profile
                        </a>
                        <ul class="dropdown-menu">
                            <li><span class="dropdown-item">Welcome: <b>${sessionScope.name}</b></span></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#passwordModal">Change Password</a></li>
                            <li><a class="m-2 btn btn-sm btn-danger" href="logout">Logout</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="adminHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="allBook">All Books</a>
                    </li>
                </ul>
                <!-- <a class="btn btn-danger" href="logout">Logout</a> -->
            </div>
        </div>
    </nav>
    
	<!-- Modal -->
	<div class="modal fade" id="passwordModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header bg-info text-white">
	        <h1 class="modal-title fs-5" id="exampleModalLabel">Change Password</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
		       	<form action="" method="post">
		            <div class="mb-3">
		                <input type="password" name="opass" maxlength="30" class="form-control" placeholder="Enter old password" required>
		            </div>
		            <div class="mb-3">
		               	<input type="password" name="npass" maxlength="30" class="form-control" placeholder="Enter new password" required>
		            </div>
		            <div class="mb-3">
		               	<input type="password" name="rpass" maxlength="30" class="form-control" placeholder="Re-Enter new password" required>
		            </div>
		            <button type="submit" class="btn btn-info">Update</button>
		        </form>
	      </div>
	    </div>
	  </div>
	</div>
</header>
		<c:if test="${msg != null}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>Message:</strong> ${msg}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
<div class="container text-start">
    <div class="row mb-3 ">
    	<div class="col-sm-6">
    		<img alt="book image" src="/getBookImage?name=${b.name}" height="100px">
    		<br>
    		<form action="updateBookImage" enctype="multipart/form-data"  method="post">
    			<input type="hidden" name="name" value="${b.name}">
    			<input type="file" name="image" accept=".jpg,.png" class="form-control" required>
    			<br>
    			<button class="btn btn-primary" type="submit">Change Image</button>
    		</form>
    	</div>
    	<div class="col-sm-6">
    	<form action="updateBook" method="post" class="mt-4">
	        <div class="mb-3">
	        	<span>Name:</span>
	            <input type="text" name="name" value="${b.name}" maxlength="30" class="form-control" placeholder="Book name" readonly />
	        </div>
	        <div class="mb-3">
	        	<span>Price:</span>
	            <input type="number" name="price" value="${b.price}" max="30000" min="0" class="form-control" placeholder="Book price" required/>
	        </div>
	        <div class="mb-3">
	        	<span>Author Name:</span>
	            <input type="text" name="aname" value="${b.aname}" maxlength="30" class="form-control" placeholder="Book author" required/>
	        </div>
	        <div class="mb-3">
	        	<span>Publisher Name:</span>
	            <input type="text" name="pname" value="${b.pname}" maxlength="30" class="form-control" placeholder="Book publisher" required/>
	        </div>
	        <button type="submit" class="btn btn-custom w-100 py-2">Update Book</button>
	    </form>
	    <hr>
	    <form action="deleteBook"  method="post">
  			<input type="hidden" name="name" value="${b.name}">
  			<button class="btn btn-danger" type="submit">Delete Book</button>
  		</form>
    	</div>
    </div>
  		
</div>


<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
