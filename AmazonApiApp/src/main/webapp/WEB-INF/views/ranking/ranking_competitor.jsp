<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
  <script src="vendor/jquery/jquery.min.js"></script>

</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<!-- Header -->
<jsp:include page="../include/header.jsp" />
  <div class="content-wrapper">
      <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Ranking</li>
      </ol>
     <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addProduct">Add Products</button>   
		<!-- Modal -->
		  <div class="modal fade" id="addProduct" role="dialog">
		    <div class="modal-dialog">    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">          
		          <h6 class="modal-title">Add Products</h6>
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		        </div>
		        <div class="modal-body">
		          <input type="text" class="form-control" id="usr">
		        </div>
		        <div class="modal-footer">
		      	  <button type="button" class="btn btn-primary" data-dismiss="modal">Add</button>
		          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        </div>
		      </div>
		      
		    </div>
		  </div>
		  <!-- end Modal -->
		</div>
        <div class="card-body">
        
          <div class="table-responsive">
          <div class="col-6">
            <table class="table table-bordered" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Image</th>
                  <th>Product</th>
                  <th>Seller</th>
                  <th>Ranking</th>
                  <th>Price</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="ranking_image" width="10%">
                  <img src="https://images-na.ssl-images-amazon.com/images/I/51T0awMZc-L._SL1000_.jpg" width="100px"></td>
                  <td class="ranking_title" width="20%">
                  </td>
                  <td class="ranking_seller" width="15%"></td>
                  <td class="ranking_rank" width="10%"></td>
                  <td class="ranking_price" width="15%"></td>
                </tr>
                <tr>
                  <td><img src=""></td>
                  <td>System Architect</td>
                  <td>Edinburgh</td>
                  <td>61</td>
                  <td>2011/04/25</td>
                </tr>
              </tbody>
            </table>
            </div>
            <div class="col-6">
            <table class="table table-bordered" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Image</th>
                  <th>Product</th>
                  <th>Seller</th>
                  <th>Ranking</th>
                  <th>Price</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="ranking_image" width="10%">
                  <img src="https://images-na.ssl-images-amazon.com/images/I/51T0awMZc-L._SL1000_.jpg" width="100px"></td>
                  <td class="ranking_title" width="20%">
                  </td>
                  <td class="ranking_seller" width="15%"></td>
                  <td class="ranking_rank" width="10%"></td>
                  <td class="ranking_price" width="15%"></td>
                </tr>
                <tr>
                  <td><img src=""></td>
                  <td>System Architect</td>
                  <td>Edinburgh</td>
                  <td>61</td>
                  <td>2011/04/25</td>
                </tr>
              </tbody>
            </table>
            </div>
            
          </div>
        </div>
        </div>
        </div>

</div>
<!-- Footer -->
<jsp:include page="../include/footer.jsp" />   
</body>
</html>