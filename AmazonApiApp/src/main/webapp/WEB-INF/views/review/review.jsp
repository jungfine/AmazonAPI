<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
        <li class="breadcrumb-item active">Review</li>
      </ol>
     <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <button type="button" class="btn btn-primary">Add Product</button></div>
          </div>
			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Image</th>
                  <th>Seller</th>
                  <th>Sku</th>
                  <th>Title</th>
                  <th>Review</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td width="20%"></td>
                  <td width="15%"></td>
                  <td width="15%"></td>
                  <td width="30%"></td>
                  <td width="20%"></td>
                </tr>
              </tbody>
            </table>
          
          </div></div>

<!-- Footer -->
<jsp:include page="../include/footer.jsp" />
</body>
</html>