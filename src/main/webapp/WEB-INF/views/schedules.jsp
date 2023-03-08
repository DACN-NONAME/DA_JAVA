<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" /> 
<!-- ==========Window-Warning-Section========== -->
<section class="window-warning inActive">
    <div class="lay"></div>
    <div class="warning-item">
        <h6 class="subtitle">Tiếp theo</h6>
        <h4 class="title">Bạn sẽ chọn vị trí ngồi</h4>
        <div class="thumb">
            <img src="./assets/images/movie/seat-plan.png" alt="movie">
        </div>
        <a href="javascript:" onclick="redirectScheduleId()" class="custom-button seatPlanButton">Xem vị trí<i class="fas fa-angle-right"></i></a>
    </div>
</section>
<!-- ==========Window-Warning-Section========== -->

<!-- ==========Banner-Section========== -->
<section class="details-banner hero-area bg_img" data-background="${film.poster}">
    <div class="container">
        <div class="details-banner-wrapper">
            <div class="details-banner-content">
                <h3 class="title">${film.name}</h3>
                <div class="tags">
                    <c:forEach items="${categories}" var="category">
                        <a href="#0">${category.name}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- ==========Banner-Section========== -->

<!-- ==========Book-Section========== -->
<section class="book-section bg-one">
    <div class="container">
        <form class="ticket-search-form two">
            <!--            <div class="form-group">
                            <div class="thumb">
                                <img src="./assets/images/ticket/city.png" alt="ticket">
                            </div>
                            <span class="type">city</span>
                            <select class="select-bar">
                                <option value="london">London</option>
                                <option value="dhaka">dhaka</option>
                                <option value="rosario">rosario</option>
                                <option value="madrid">madrid</option>
                                <option value="koltaka">kolkata</option>
                                <option value="rome">rome</option>
                                <option value="khoksa">khoksa</option>
                            </select>
                        </div>-->
            <div class="form-group">
                <div class="thumb">
                    <img src="./assets/images/ticket/date.png" alt="ticket">
                </div>
                <span class="type">date</span>
                <select class="select-bar">
                    <c:forEach items="${dates}" var="date">
                        <option value="${date}"${param.date eq date ? " selected" : ""}>${date}</option>
                    </c:forEach>
                </select>
            </div>
        </form>
    </div>
</section>
<!-- ==========Book-Section========== -->

<!-- ==========Movie-Section========== -->
<div class="ticket-plan-section padding-bottom padding-top">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-9 mb-5 mb-lg-0">
                <ul class="seat-plan-wrapper bg-five">
                    <c:forEach items="${schedules}" var="schedule">
                        <li>
                            <div class="movie-name" title="${schedule.cinema_address}">
                                <div class="icons">
                                    <i class="far fa-heart"></i>
                                    <i class="fas fa-heart"></i>
                                </div>
                                <a href="#0" class="name">${schedule.cinema_name}</a>
                                <div class="location-icon">
                                    <i class="fas fa-map-marker-alt"></i>
                                </div>
                            </div>
                            <div class="movie-schedule">
                                <c:forEach items="${schedule.rooms}" var="room">
                                    <div class="item" onclick="setScheduleId(${schedule.id})">${room.start_time}</div>
                                </c:forEach>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-10">
                <div class="widget-1 widget-banner">
                    <div class="widget-1-body">
                        <a href="#0">
                            <img src="./assets/images/sidebar/banner/banner03.jpg" alt="banner">
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ==========Movie-Section========== -->
<jsp:include page="footer.jsp" />