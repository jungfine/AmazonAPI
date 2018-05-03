<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
<c:set var="bPath" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
  <!-- style CSS-->
  <link href="${bPath }/resources/scss/style.css" rel="stylesheet">
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">

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

<!-- Product Add -->
				<form role="form" method="post" id="addProductForm">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Product ASIN</label> <input type="text" name='asin' class="form-control" placeholder="Enter ASIN">
						</div>
					</div>

					<div class="box-footer">
						<div><hr></div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>
<!-- Product Add -->
</div>
        </div>
    <!-- /.container-fluid-->
    <jsp:include page="../include/footer.jsp" />
    
</body>
</html>
<script>
$("#addSightForm").submit(function(event){
	event.preventDefault();
	var obj=$(this);
	var str="";
	$(".uploadedList .delbtn").each(function(idx){
		str += "<input type='hidden' name='files["+idx+"]' value='" +$(this).attr("href")+"'>";
	});
	obj.append(str);
	obj.get(0).submit();
	
});
</script>