<%@page import="com.noname.model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    User user = (User) session.getAttribute("user");
%>
<jsp:include page="header.jsp" />
<!-- ==========Banner-Section========== -->
<section class="main-page-header speaker-banner bg_img" data-background="./assets/images/banner/banner07.jpg">
    <div class="container">
        <div class="speaker-banner-content">
            <h2 class="title">Trang cá nhân</h2>
        </div>
    </div>
</section>
<!-- ==========Banner-Section========== -->

<!-- ==========Contact-Section========== -->
<section class="contact-section padding-top">
    <div class="contact-container">
        <!--<div class="bg-thumb bg_img" data-background="<c:url value="/assets/images/contact/contact.jpg" />"></div>-->
        <div class="container">
            <div class="row justify-content-between">
                <div class="col-md-7 col-lg-6 col-xl-5">
                    <div class="section-header-3 left-style">
                        <span class="cate">Thông tin của bạn</span>
                        <!--<h2 class="title">chỉnh sửa nếu cần</h2>-->
                        <!--<p>We’d love to talk about how we can work together. Send us a message below and we’ll respond as soon as possible.</p>-->
                    </div>
                    <form class="contact-form" id="contact_form_submit" action="" method="POST" enctype="application/x-www-form-urlencoded;charset=UTF-8" accept-charset="UTF-8">
                        <div class="form-group">
                            <label for="full_name">Họ tên <span>*</span></label>
                            <input type="text" name="full_name" id="full_name" value="<%= user.getFull_name()%>" required />
                        </div>
                        <div class="form-group">
                            <label for="email">Email <span>*</span></label>
                            <input type="email" name="email" id="email" value="<%= user.getEmail()%>" disabled />
                        </div>
                        <div class="form-group">
                            <label for="phone">SDT <span>*</span></label>
                            <input type="text" name="phone" id="phone" value="<%= user.getPhone()%>" required />
                        </div>
                        <div class="form-group">
                            <label for="address">Địa chỉ</label>
                            <textarea name="address" id="address"><%= user.getAddress()%></textarea>
                        </div>
                        <div class="form-group">
                            <input type="submit" value="Thay đổi" />
                        </div>
                    </form>
                </div>
                <div class="col-md-5 col-lg-6">
                    <!--                    <div class="padding-top padding-bottom contact-info">
                                            <div class="info-area">
                                                <div class="info-item">
                                                    <div class="info-thumb">
                                                        <img src="./assets/images/contact/contact01.png" alt="contact" />
                                                    </div>
                                                    <div class="info-content">
                                                        <h6 class="title">phone number</h6>
                                                        <a href="Tel:82828282034">+1234 56789</a>
                                                    </div>
                                                </div>
                                                <div class="info-item">
                                                    <div class="info-thumb">
                                                        <img src="./assets/images/contact/contact02.png" alt="contact">
                                                    </div>
                                                    <div class="info-content">
                                                        <h6 class="title">Email</h6>
                                                        <a href="Mailto:info@gmail.com"><span class="__cf_email__" data-cfemail="761f1810193634191a130219">[email&#160;protected]</span> .com</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>-->
                    <div class="section-header-3 left-style">
                        <span class="cate">Đổi mật khẩu</span>
                        <!--<h2 class="title">chỉnh sửa nếu cần</h2>-->
                        <!--<p>We’d love to talk about how we can work together. Send us a message below and we’ll respond as soon as possible.</p>-->
                    </div>
                    <form class="contact-form" id="contact_form_submit" action="<c:url value="/profile/changepass" />" method="POST">
                        <div class="form-group">
                            <label>${msg}</label>
                        </div>
                        <div class="form-group">
                            <label for="password">Mật khẩu cũ <span>*</span></label>
                            <input type="password" name="password" id="password" required />
                        </div>
                        <div class="form-group">
                            <label for="password2">Mật khẩu mới <span>*</span></label>
                            <input type="password" name="password2" id="password2" required />
                        </div>
                        <div class="form-group">
                            <label for="repassword2">Nhập lại mật khẩu mới <span>*</span></label>
                            <input type="password" name="repassword2" id="repassword2" required />
                        </div>
                        <div class="form-group">
                            <input type="submit" value="Thay đổi" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- ==========Contact-Section========== -->

<!-- ==========Contact-Counter-Section========== -->
<section class="contact-counter padding-top padding-bottom">
    <div class="container">
        <div class="row justify-content-center mb-30-none">
            <!--            <div class="col-sm-6 col-md-3">
                            <div class="contact-counter-item">
                                <div class="contact-counter-thumb">
                                    <i class="fab fa-facebook-f"></i>
                                </div>
                                <div class="contact-counter-content">
                                    <div class="counter-item">
                                        <h5 class="title odometer" data-odometer-final="130">0</h5>
                                        <h5 class="title">k</h5>
                                    </div>
                                    <p>Phim đã xem</p>
                                </div>
                            </div>
                        </div>-->
            <div class="col-sm-6 col-md-3">
                <div class="contact-counter-item">
                    <div class="contact-counter-thumb">
                        <i class="fas fa-users"></i>
                    </div>
                    <div class="contact-counter-content">
                        <div class="counter-item">
                            <h5 class="title odometer" data-odometer-final="${count_bookings}">0</h5>
                            <!--<h5 class="title">k</h5>-->
                        </div>
                        <p>Số lần đã đặt</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- ==========Contact-Counter-Section========== -->
<jsp:include page="footer.jsp" />