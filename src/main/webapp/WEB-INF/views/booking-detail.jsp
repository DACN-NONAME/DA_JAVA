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

<!-- ==========Movie-Section========== -->
<div class="movie-facility padding-bottom padding-top">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="checkout-widget checkout-card mb-0">
                    <h5 class="title">Phương thức thanh toán</h5>
                    <ul class="payment-option">
                        <li>
                            <a>
                                <img src="./assets/images/payment/card.png" alt="payment" />
                                <span>Debit Card</span>
                            </a>
                        </li>
                        <li class="active">
                            <a>
                                <img src="./assets/images/payment/momo.png" alt="payment" />
                                <span>MOMO</span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <img src="./assets/images/payment/paypal.png" alt="payment" />
                                <span>paypal</span>
                            </a>
                        </li>
                    </ul>
                    <form class="payment-card-form">                   
                        <div class="form-group check-group">
                            <input id="card5" type="checkbox" checked>
                            <label for="card5">
                                <span class="title">QuickPay</span>
                                <span class="info">Lưu thông tin lại để thanh toán cho lần sau.</span>
                            </label>
                        </div>
                    </form>
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
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ==========Movie-Section========== -->
<jsp:include page="footer.jsp" />