<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<c:set var="bPath" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Link</title>
  <!-- style CSS-->
  <link href="${bPath }/resources/scss/style.css" rel="stylesheet">
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">

<jsp:include page="include/header.jsp" />
  <div class="content-wrapper">
      <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Link</li>
      </ol>
     <!-- Example DataTables Card-->

      <!-- Icon Cards-->
      <div class="row">
      <!-- Amazon / Amazon Sellelr centrual / Amazon Affiliate / eTop Lighting Homepage -->
      <table width="100%">
      <tr>
      <th class="link_title" width="25%">Amazon</th>
      <th class="link_title" width="25%">Amazon Seller Central</th>
      <th class="link_title" width="25%">Amazon Associate</th>
      <th class="link_title" width="25%">eTop Lighting</th>
      </tr>
      <tr>
      <td width="25%"><a href="http://sellercentral.amazon.com"><img src="${bPath }/resources/images/amazon.png" width="80%" class="link_image"></a></td>
      <td width="25%"><a href="http://sellercentral.amazon.com"><img src="${bPath }/resources/images/ASC.png" width="80%" class="link_image"></a></td>
      <td width="25%"><a href="http://sellercentral.amazon.com"><img src="${bPath }/resources/images/associates.png" class="link_image"></a></td>
      <td width="25%"><a href="https://www.etoplighting.com/"><img src="${bPath }/resources/images/eTop.png" class="link_image"></a></td>
      </tr>
      </table>
</div>
</div>
        </div>
    <!-- /.container-fluid-->
    <jsp:include page="include/footer.jsp" />
</body>
</html>