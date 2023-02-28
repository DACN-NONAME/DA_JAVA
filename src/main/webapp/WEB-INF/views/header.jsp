<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@page import="com.noname.model.User"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/all.min.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="assets/css/flaticon.css">
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <link rel="stylesheet" href="assets/css/odometer.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="assets/css/nice-select.css">
        <link rel="stylesheet" href="assets/css/jquery.animatedheadline.css">
        <link rel="stylesheet" href="assets/css/main.css">

        <link rel="shortcut icon" href="assets/images/favicon.png" type="image/x-icon">

        <title>Boleto  - Đặt vé phim trực tuyến</title>


    </head>

    <body>
        <!-- ==========Preloader========== -->
        <div class="preloader">
            <div class="preloader-inner">
                <div class="preloader-icon">
                    <span></span>
                    <span></span>
                </div>
            </div>
        </div>
        <!-- ==========Preloader========== -->
        <!-- ==========Overlay========== -->
        <div class="overlay"></div>
        <a href="#0" class="scrollToTop">
            <i class="fas fa-angle-up"></i>
        </a>
        <!-- ==========Overlay========== -->

        <!-- ==========Header-Section========== -->
        <header class="header-section">
            <div class="container">
                <div class="header-wrapper">
                    <div class="logo">
                        <a href="index.html">
                            <img src="./assets/images/logo/logo.png" alt="logo">
                        </a>
                    </div>
                    <ul class="menu">
                        <li>
                            <a href="./">Home</a>
                        </li>
                        <li>
                            <a href="./films">Phim</a>
                            <ul class="submenu">
                                <li>
                                    <a href="movie-grid.html">Movie Grid</a>
                                </li>
                                <li>
                                    <a href="movie-list.html">Movie List</a>
                                </li>
                                <li>
                                    <a href="movie-details.html">Movie Details</a>
                                </li>
                                <li>
                                    <a href="movie-details-2.html">Movie Details 2</a>
                                </li>
                                <li>
                                    <a href="movie-ticket-plan.html">Movie Ticket Plan</a>
                                </li>
                                <li>
                                    <a href="movie-seat-plan.html">Movie Seat Plan</a>
                                </li>
                                <li>
                                    <a href="movie-checkout.html">Movie Checkout</a>
                                </li>
                                <li>
                                    <a href="popcorn.html">Movie Food</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="contact.html">contact</a>
                        </li>
                        <li>
                            <%
                                if (session.getAttribute("user") == null) {
                            %>
                            <a href="./sign-in">Đăng nhập</a>
                            <%
                            } else {
//                                User user = (User) session.getAttribute("user");
                            %>
                            <a href="#">Xin chào ${user.full_name}</a>
                            <ul class="submenu">
                                <li>
                                    <a href="./profile">Trang cá nhân</a>
                                </li>
                                <li>
                                    <a href="./history">Lịch sử mua vé</a>
                                </li>
                                <li>
                                    <a href="./logout">Đăng xuất</a>
                                </li>
                            </ul>
                            <%
                                }
                            %>
                        </li>
                    </ul>
                    <div class="header-bar d-lg-none">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </div>
            </div>
        </header>
        <!-- ==========Header-Section========== -->
