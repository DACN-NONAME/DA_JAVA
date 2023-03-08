<%@page import="com.noname.database.DBQuery"%>
<%@page import="java.util.List"%>
<%@page import="com.noname.model.Category"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.noname.model.User"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/all.min.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/animate.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/flaticon.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/magnific-popup.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/odometer.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/owl.carousel.min.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/owl.theme.default.min.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/nice-select.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/jquery.animatedheadline.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/main.css" />"/>

        <link rel="shortcut icon" href="<c:url value="/assets/images/favicon.png" />" type="image/x-icon">

        <c:choose>
            <c:when test="${not empty title}"><title>Boleto  - ${title}</title></c:when>
            <c:otherwise><title>Boleto  - Đặt vé phim trực tuyến</title></c:otherwise>
        </c:choose>

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
                        <a href="./">
                            <img src="<c:url value="/assets/images/logo/logo.png" />" alt="logo">
                        </a>
                    </div>
                    <ul class="menu">
                        <li>
                            <a href="./">Home</a>
                        </li>
                        <li>
                            <a href="./films">Phim</a>
                        </li>
                        <li>
                            <a href="#">Thể loại</a>
                            <ul class="submenu">
                                <%
                                    DBQuery dbq = new DBQuery();
                                    for (Category ele : dbq.GetCategories()) {
                                %>
                                <li><a href="./films?category_id=<%= ele.getId()%>"><%= ele.getName()%></a></li>
                                    <%
                                        }
                                    %>
                            </ul>
                        </li>
                        <li>
                            <%
                                if (session.getAttribute("user") == null) {
                            %>
                            <a href="./sign-in">Đăng nhập</a>
                            <%
                            } else {
                                User user = (User) session.getAttribute("user");
                            %>
                            <a href="#">Xin chào <%= user.getFull_name()%></a>
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
