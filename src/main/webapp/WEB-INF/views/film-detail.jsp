<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<!-- ==========Banner-Section========== -->
<section class="details-banner bg_img" data-background="${film.poster}">
    <div class="container">
        <div class="details-banner-wrapper">
            <div class="details-banner-thumb">
                <img src="${film.poster}" alt="movie">
                <a href="${film.trailer}" class="video-popup">
                    <img src="assets/images/movie/video-button.png" alt="movie">
                </a>
            </div>
            <div class="details-banner-content offset-lg-3">
                <h3 class="title">${film.name}</h3>
                <div class="tags">
                    <b>${film.rated_name}</b>
                </div>
                <c:forEach items="${categories}" var="category">
                    <a href="./films?category_id=${category.id}" class="button">${category.name}</a>
                </c:forEach>
                <div class="social-and-duration">
                    <div class="duration-area">
                        <div class="item">
                            <i class="fas fa-calendar-alt"></i><span>${film.opening_day}</span>
                        </div>
                        <div class="item">
                            <i class="far fa-clock"></i><span>${film.duration} phút</span>
                        </div>
                    </div>
                    <!--                    <ul class="social-share">
                                            <li><a href="#0"><i class="fab fa-facebook-f"></i></a></li>
                                            <li><a href="#0"><i class="fab fa-twitter"></i></a></li>
                                            <li><a href="#0"><i class="fab fa-pinterest-p"></i></a></li>
                                            <li><a href="#0"><i class="fab fa-linkedin-in"></i></a></li>
                                            <li><a href="#0"><i class="fab fa-google-plus-g"></i></a></li>
                                        </ul>-->
                </div>
            </div>
        </div>

    </div>
</section>
<!-- ==========Banner-Section========== -->

<!-- ==========Book-Section========== -->
<section class="book-section bg-one">
    <div class="container">
        <div class="book-wrapper offset-lg-3">
            <a href="./schedules?film_id=${film.id}&date=${date}" class="custom-button">Đặt vé</a>
        </div>
    </div>
</section>
<!-- ==========Book-Section========== -->

<!-- ==========Movie-Section========== -->
<section class="movie-details-section padding-top padding-bottom">
    <div class="container">
        <div class="row justify-content-center flex-wrap-reverse mb--50">
            <div class="col-lg-3 col-sm-10 col-md-6 mb-50">
                <div class="widget-1 widget-tags">
                    <ul>
                        <li>
                            <a href="#0">2D</a>
                        </li>
                        <!--                        <li>
                                                    <a href="#0">imax 2D</a>
                                                </li>
                                                <li>
                                                    <a href="#0">4DX</a>
                                                </li>-->
                    </ul>
                </div>
                <div class="widget-1 widget-banner">
                    <div class="widget-1-body">
                        <a href="#0">
                            <img src="assets/images/sidebar/banner/banner01.jpg" alt="banner">
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-lg-9 mb-50">
                <div class="movie-details">
                    <div class="tab summery-review">
                        <ul class="tab-menu">
                            <li class="active">Tóm tắt</li>
                        </ul>
                        <div class="tab-area">
                            <div class="tab-item active">
                                <div class="item">
                                    <p>${film.description}</p>
                                </div>
                                <div class="item">
                                    <div class="header">
                                        <h5 class="sub-title">cast</h5>
                                        <div class="navigation">
                                            <div class="cast-prev"><i class="flaticon-double-right-arrows-angles"></i></div>
                                            <div class="cast-next"><i class="flaticon-double-right-arrows-angles"></i></div>
                                        </div>
                                    </div>
                                    <div class="casting-slider owl-carousel">
                                        <c:forEach items="${actors}" var="actor">
                                            <div class="cast-item">
                                                <div class="cast-thumb">
                                                    <a href="#0">
                                                        <img src="./assets/images/cast/cast01.jpg" alt="cast">
                                                    </a>
                                                </div>
                                                <div class="cast-content">
                                                    <h6 class="cast-title"><a href="#0">${actor.full_name}</a></h6>
                                                    <!--<span class="cate">Diễn viên</span>-->
                                                    <!--<p>As Richie Tozier</p>-->
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- ==========Movie-Section========== -->
<jsp:include page="footer.jsp" />