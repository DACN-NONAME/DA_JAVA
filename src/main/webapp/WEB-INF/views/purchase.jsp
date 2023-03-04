<%@page import="com.noname.model.Ticket"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- ==========Banner-Section========== -->
<section class="details-banner hero-area bg_img seat-plan-banner" data-background="./assets/images/banner/banner04.jpg">
    <div class="container">
        <div class="details-banner-wrapper">
            <div class="details-banner-content style-two">
                <h3 class="title">${film.name}</h3>
                <div class="tags">
                    <a href="#0">Cinema 2D</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- ==========Banner-Section========== -->

<!-- ==========Page-Title========== -->
<!--<section class="page-title bg-one">
    <div class="container">
        <div class="page-title-area">
            <div class="item md-order-1">
                <a href="movie-ticket-plan.html" class="custom-button back-button">
                    <i class="flaticon-double-right-arrows-angles"></i>back
                </a>
            </div>
            <div class="item date-item">
                <span class="date">MON, SEP 09 2020</span>
                <select class="select-bar">
                    <option value="sc1">09:40</option>
                    <option value="sc2">13:45</option>
                    <option value="sc3">15:45</option>
                    <option value="sc4">19:50</option>
                </select>
            </div>
            <div class="item">
                <h5 class="title">05:00</h5>
                <p>Mins Left</p>
            </div>
        </div>
    </div>
</section>-->
<!-- ==========Page-Title========== -->

<!-- ==========Movie-Section========== -->
<div class="movie-facility padding-bottom padding-top">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <!--                <div class="checkout-widget d-flex flex-wrap align-items-center justify-cotent-between">
                                    <div class="title-area">
                                        <h5 class="title">Already a Boleto  Member?</h5>
                                        <p>Sign in to earn points and make booking easier!</p>
                                    </div>
                                    <a href="#0" class="sign-in-area">
                                        <i class="fas fa-user"></i><span>Sign in</span>
                                    </a>
                                </div>-->
                <div class="checkout-widget checkout-contact">
                    <h5 class="title">Thông tin của bạn</h5>
                    <form class="checkout-contact-form">
                        <div class="form-group">
                            <input type="text" placeholder="Full Name">
                        </div>
                        <div class="form-group">
                            <input type="text" placeholder="Enter your Mail">
                        </div>
                        <div class="form-group">
                            <input type="text" placeholder="Enter your Phone Number ">
                        </div>
                        <div class="form-group">
                            <input type="submit" value="Continue" class="custom-button">
                        </div>
                    </form>
                </div>
                <!--                <div class="checkout-widget checkout-contact">
                                    <h5 class="title">Promo Code </h5>
                                    <form class="checkout-contact-form">
                                        <div class="form-group">
                                            <input type="text" placeholder="Please enter promo code">
                                        </div>
                                        <div class="form-group">
                                            <input type="submit" value="Verify" class="custom-button">
                                        </div>
                                    </form>
                                </div>-->
                <div class="checkout-widget checkout-card mb-0">
                    <h5 class="title">Phương thức thanh toán</h5>
                    <ul class="payment-option">
                        <li class="active">
                            <a href="#0">
                                <img src="./assets/images/payment/card.png" alt="payment">
                                <span>Debit Card</span>
                            </a>
                        </li>
                        <li>
                            <a href="#0">
                                <img src="./assets/images/payment/card.png" alt="payment">
                                <span>MOMO</span>
                            </a>
                        </li>
                        <li>
                            <a href="#0">
                                <img src="./assets/images/payment/paypal.png" alt="payment">
                                <span>paypal</span>
                            </a>
                        </li>
                    </ul>
                    <h6 class="subtitle">Enter Your Card Details </h6>
                    <form class="payment-card-form">
                        <div class="form-group w-100">
                            <label for="card1">Card Details</label>
                            <input type="text" id="card1">
                            <div class="right-icon">
                                <i class="flaticon-lock"></i>
                            </div>
                        </div>
                        <div class="form-group w-100">
                            <label for="card2"> Name on the Card</label>
                            <input type="text" id="card2">
                        </div>
                        <div class="form-group">
                            <label for="card3">Expiration</label>
                            <input type="text" id="card3" placeholder="MM/YY">
                        </div>
                        <div class="form-group">
                            <label for="card4">CVV</label>
                            <input type="text" id="card4" placeholder="CVV">
                        </div>
                        <div class="form-group check-group">
                            <input id="card5" type="checkbox" checked>
                            <label for="card5">
                                <span class="title">QuickPay</span>
                                <span class="info">Save this card information to my Boleto  account and make faster payments.</span>
                            </label>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="custom-button" value="make payment">
                        </div>
                    </form>
                    <p class="notice">
                        By Clicking "Make Payment" you agree to the <a href="#0">terms and conditions</a>
                    </p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="booking-summery bg-one">
                    <h4 class="title">chi tiết</h4>
                    <ul>
                        <li>
                            <h6 class="subtitle">${film.name}</h6>
                            <span class="info">Cinema-2d</span>
                        </li>
                        <li>
                            <h6 class="subtitle"><span>${schedule.cinema_name}</span><span>${schedule.room_name}</span></h6>
                            <div class="info"><span>${schedule.start_time}</span> <span>Rạp</span></div>
                        </li>
                        <!--                        <li>
                                                    <h6 class="subtitle mb-0"><span>Tickets  Price</span><span>$150</span></h6>
                                                </li>-->
                    </ul>
                    <ul class="side-shape">
                        <c:if test="${not empty seats1}">
                            <li>
                                <h6 class="subtitle"><span>Thường</span><span>x${seats1.size()}</span></h6>
                                <span class="info"><span><c:forEach items="${seats1}" var="seat">${seat.seat}&nbsp;</c:forEach></span></span>
                                </li>
                        </c:if>
                        <c:if test="${not empty seats2}">
                            <li>
                                <h6 class="subtitle"><span>VIP (Prime)</span><span>x${seats2.size()}</span></h6>
                                <span class="info"><span><c:forEach items="${seats2}" var="seat">${seat.seat}&nbsp;</c:forEach></span></span>
                                </li>
                        </c:if>
                        <c:if test="${not empty seats3}">
                            <li>
                                <h6 class="subtitle"><span>Sweetbox</span><span>x${seats3.size()}</span></h6>
                                <span class="info"><span><c:forEach items="${seats3}" var="seat">${seat.seat}&nbsp;</c:forEach></span></span>
                                </li>
                        </c:if>
                    </ul>
                    <ul>
                        <%
                            List<Ticket> listTickets = (List<Ticket>) request.getAttribute("tickets");
                        %>
                        <c:if test="${not empty seats1}">
                            <li>
                                <span class="info"><span>Thường</span><span><%= String.format("%,d", listTickets.get(0).getPrice())%></span></span>
                            </li>
                        </c:if>
                        <c:if test="${not empty seats2}">
                            <li>
                                <span class="info"><span>VIP (Prime)</span><span><%= String.format("%,d", listTickets.get(1).getPrice())%></span></span>
                            </li>
                        </c:if>
                        <c:if test="${not empty seats3}">
                            <li>
                                <span class="info"><span>Sweetbox</span><span><%= String.format("%,d", listTickets.get(2).getPrice())%></span></span>
                            </li>
                        </c:if>
                        <li>
                            <span class="info"><span>vat 5%</span><span>(đã bao gồm)</span></span>
                        </li>
                    </ul>
                </div>
                <div class="proceed-area  text-center">
                    <h6 class="subtitle"><span>Tổng cộng</span><span>${total_price}</span></h6>
                    <a href="#0" class="custom-button back-button">Thanh toán</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ==========Movie-Section========== -->
<jsp:include page="footer.jsp" />