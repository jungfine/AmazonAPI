<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="bPath" value="${pageContext.request.contextPath}" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>eTop Lighting Amazon API App</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
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
				<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
				<li class="breadcrumb-item active">Ranking</li>
			</ol>
			<!-- Example DataTables Card-->
			<div class="card mb-3">
				<div class="card-header">
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#addProduct">Add Products</button>
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
									<button type="button" class="btn btn-primary"
										data-dismiss="modal">Add</button>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>
					<!-- end Modal -->
					<!-- TABLE -->
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th width="15%">Category</th>
									<th width="15%">Image</th>
									<th width="10%">Item ASIN</th>
									<th width="20%">Item Title</th>
									<th width="10%">Reviews</th>
									<th width="10%">Rate</th>
									<th width="10%">Rank</th>
									<th width="10%">Price</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="vo" items="${detailsList }">
									<tr>
										<td class="details_category">${vo.category}</td>
										<td class="details_image" ><img
											src="${vo.img }" width="100%"></td>
										<td class="details_ASIN">${vo.asin}</td>
										<td class="details_title">${vo.title }</td>
										<td class="details_reviews">${vo.reviews }</td>
										<td class="details_rate">${vo.rate }</td>
										<td class="details_rank">${vo.ranking }</td>
										<td class="details_price">${vo.price }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- Footer -->
	<jsp:include page="../include/footer.jsp" />
	<script type="text/javascript">
$(document).ready(function(){
	$('#addBtn').on("click", function(event) {
		self.location = "/ranking/addProduct";
	});
});
</script>
</body>
</html>