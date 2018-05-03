<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Custom fonts for this template-->
  <link href="${bPath }/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<c:set var="bPath" value="${pageContext.request.contextPath}" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap core CSS-->
<link href="${bPath }/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link
	href="${bPath }/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link
	href="${bPath }/resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="${bPath }/resources/css/sb-admin.css" rel="stylesheet">
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Header -->
	<jsp:include page="../include/header.jsp" />
	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
				<li class="breadcrumb-item active">Check Buybox</li>
			</ol>
			<div class="card mb-3">
				<div class="card-header">
					<button type="button" class="btn btn-primary">Add Product</button>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="card-body">
							<!-- Table -->
							<!-- Table -->
							<table class="table table-bordered" id="dataTable" width="100%"
								height="200px" cellspacing="0">
								<thead>
									<tr>

										<th width="20">Image</th>
										<th width="20%">Product Title</th>
										<th width="10%">ASIN</th>
										<th width="17%">Top Seller</th>
										<th width="17%">Top Seller Price</th>
										<th width="16%">Alert</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="vo" items="${buyboxList }">
										<tr>
											<td class="details_image"><img src="${vo.img }"
												width="100%"></td>
											<td>${vo.title }</td>
											<td>${vo.asin}</td>
											<td>${vo.topSeller}</td>
											<td>${vo.topSellerPrice}</td>
											<c:if test="${vo.topSeller=='KimOutlet' }">
											
											<td><i class="fa fa-smile"></i></td>
											</c:if>
											<c:if test="${vo.topSeller!='KimOutlet' }">
											<td><i class="fa fa-exclamation-triangle"></i></td>
											</c:if>
											
										</tr>
									</c:forEach>
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