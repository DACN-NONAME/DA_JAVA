<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<!-- ==========Banner-Section========== -->
<section class="details-banner hero-area bg_img seat-plan-banner" data-background="./assets/images/banner/banner04.jpg">
    <div class="container">
        <div class="details-banner-wrapper">
            <div class="details-banner-content style-two">
                <h3 class="title">${film.name}</h3>
                <div class="tags">
                    <!--<a href="#0">City Walk</a>-->
                    <a href="#0">Cinema 2D</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- ==========Banner-Section========== -->

<!-- ==========Page-Title========== -->
<section class="page-title bg-one">
    <div class="container">
        <div class="page-title-area">
            <div class="item md-order-1">
                <!--                <a href="movie-ticket-plan.html" class="custom-button back-button">
                                    <i class="flaticon-double-right-arrows-angles"></i>trở về
                                </a>-->
            </div>
            <div class="item date-item">
                <span class="date">Thời gian chiếu: ${schedule.start_time}</span>
                <!--                <select class="select-bar">
                                    <option value="sc1">09:40</option>
                                    <option value="sc2">13:45</option>
                                    <option value="sc3">15:45</option>
                                    <option value="sc4">19:50</option>
                                </select>-->
            </div>
            <div class="item">
                <!--                <h5 class="title">05:00</h5>
                                <p>Mins Left</p>-->
            </div>
        </div>
    </div>
</section>
<!-- ==========Page-Title========== -->

<!-- ==========Movie-Section========== -->
<div class="seat-plan-section padding-bottom padding-top">
    <div class="container">
        <div class="screen-area">
            <h4 class="screen">screen</h4>
            <div class="screen-thumb">
                <img src="./assets/images/movie/screen-thumb.png" alt="movie">
            </div>
            <h5 class="subtitle">Thường</h5>
            <div class="screen-wrapper">
                <ul class="seat-area">
                    <%
                        for (char i = 'A'; i <= 'D'; i++) {
                    %>
                    <li class="seat-line">
                        <span><%= i%></span>
                        <ul class="seat--area">
                            <%
                                int index = 1;
                                for (int j = 1; j <= 3; j++) {
                            %>
                            <li class="front-seat">
                                <ul>
                                    <%
                                        for (int k = 1; k <= 8; k++) {
                                            if ((j == 1 || j == 3) && k == 3) {
                                                break;
                                            }
                                    %>
                                    <li class="single-seat seat-free" data-price="${tickets[0].price}">
                                        <img src="./assets/images/movie/seat01-free.png" alt="seat">
                                        <span class="sit-num"><%= i%><%= index++%></span>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </li>
                            <%
                                }
                            %>
                        </ul>
                        <span><%= i%></span>
                    </li>
                    <%
                        }
                    %>
                </ul>
            </div>
            <h5 class="subtitle">VIP (Prime)</h5>
            <div class="screen-wrapper">
                <ul class="seat-area">
                    <%
                        for (char i = 'E'; i <= 'H'; i++) {
                    %>
                    <li class="seat-line">
                        <span><%= i%></span>
                        <ul class="seat--area">
                            <%
                                int index = 1;
                                for (int j = 1; j <= 3; j++) {
                            %>
                            <li class="front-seat">
                                <ul>
                                    <%
                                        for (int k = 1; k <= 8; k++) {
                                            if ((j == 1 || j == 3) && k == 3) {
                                                break;
                                            }
                                    %>
                                    <li class="single-seat seat-free" data-price="${tickets[1].price}">
                                        <img src="./assets/images/movie/seat01-free.png" alt="seat">
                                        <span class="sit-num"><%= i%><%= index++%></span>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </li>
                            <%
                                }
                            %>
                        </ul>
                        <span><%= i%></span>
                    </li>
                    <%
                        }
                    %>
                </ul>
            </div>
            <h5 class="subtitle">Sweetbox</h5>
            <div class="screen-wrapper">
                <ul class="seat-area couple">
                    <li class="seat-line">
                        <span>J</span>
                        <ul class="seat--area">
                            <%
                                int index = 1;
                                for (int j = 1; j <= 3; j++) {
                            %>
                            <li class="front-seat">
                                <ul>
                                    <%
                                        for (int k = 1; k <= 4; k++) {
                                            if ((j == 1 || j == 3) && k == 2) {
                                                break;
                                            }
                                    %>
                                    <li class="single-seat seat-free-two" data-price="${tickets[2].price}">
                                        <img src="./assets/images/movie/seat02-free.png" alt="seat">
                                        <span class="sit-num">J<%= index++%> J<%= index++%></span>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </li>
                            <%
                                }
                            %>
                        </ul>
                        <span>J</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="proceed-book bg_img" data-background="./assets/images/movie/movie-bg-proceed.jpg">
            <div class="proceed-to-book">
                <div class="book-item">
                    <span>Ghế đã chọn</span>
                    <h3 class="title"><span id="chose-seat"></span></h3>
                </div>
                <div class="book-item">
                    <span>Tạm tính</span>
                    <h3 class="title" id="price">0 đ</h3>
                </div>
                <div class="book-item">
                    <a href="javascript:" class="custom-button">Thanh toán</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ==========Movie-Section========== -->
<jsp:include page="footer.jsp" />