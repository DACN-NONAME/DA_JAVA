<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- main content -->
<main class="main">
    <div class="container-fluid">
        <div class="row">
            <!-- main title -->
            <div class="col-12">
                <div class="main__title">
                    <h2>Dashboard</h2>
                    <!--<a href="add-item.html" class="main__title-link">add item</a>-->
                </div>
            </div>
            <!-- end main title -->
        </div>
        <div class="row row--grid">
            <!-- stats -->
            <div class="col-12 col-sm-6 col-xl-3">
                <div class="stats">
                    <span>Tổng người dùng</span>
                    <p>${count_users}</p>
                    <img src="<c:url value="/assets/admin/img/graph-bar.svg" />" alt="">
                </div>
            </div>
            <!-- end stats -->
            <!-- stats -->
            <div class="col-12 col-sm-6 col-xl-3">
                <div class="stats">
                    <span>Tổng lần đặt (booking)</span>
                    <p>${count_bookings}</p>
                    <img src="<c:url value="/assets/admin/img/film.svg" />" alt="">
                </div>
            </div>
            <!-- end stats -->
            <!-- stats -->
            <div class="col-12 col-sm-6 col-xl-3">
                <div class="stats">
                    <span>Tổng lợi nhuận tạm tính</span>
                    <p>${profit}</p>
                    <img src="<c:url value="/assets/admin/img/star-half-alt.svg" />" alt="">
                </div>
            </div>
            <!-- end stats -->
        </div>
    </div>
</main>
<!-- end main content -->
<jsp:include page="footer.jsp" />