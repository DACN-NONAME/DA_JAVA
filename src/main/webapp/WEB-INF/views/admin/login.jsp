<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

        <!-- CSS -->
        <link rel="stylesheet" href="<c:url value="/assets/admin/css/bootstrap-reboot.min.css" />" />
        <link rel="stylesheet" href="<c:url value="/assets/admin/css/bootstrap-grid.min.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/admin/css/magnific-popup.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/admin/css/jquery.mCustomScrollbar.min.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/admin/css/select2.min.css" />"/>
        <link rel="stylesheet" href="<c:url value="/assets/admin/css/admin.css" />"/>

        <!-- Favicons -->
        <link rel="icon" type="image/png" href="<c:url value="/assets/admin/icon/favicon-32x32.png" />" sizes="32x32" />
        <link rel="apple-touch-icon" href="<c:url value="/assets/admin/icon/favicon-32x32.png" />"/>

        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <meta name="author" content="Dmitry Volkov" />
        <title>Admin - Đăng nhập</title>

    </head>
    <body>

        <div class="sign section--bg" data-bg="<c:url value="/assets/admin/img/section/section.jpg" />">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="sign__content">
                            <!-- authorization form -->
                            <form action="" method="POST" class="sign__form">
                                <a href="index.html" class="sign__logo">
                                    <img src="<c:url value="/assets/admin/img/logo.png" />" alt="" />
                                </a>
                                <div class="sign__group">
                                    <input type="text" class="sign__input" placeholder="tên đăng nhập" name="email" />
                                </div>
                                <div class="sign__group">
                                    <input type="password" class="sign__input" placeholder="mật khẩu" name="password" />
                                </div>
                                <button class="sign__btn" type="submit">Đăng nhập</button>
                                <!--                                <span class="sign__text">Don't have an account? <a href="signup.html">Sign up!</a></span>
                                                                <span class="sign__text"><a href="forgot.html">Forgot password?</a></span>-->
                            </form>
                            <!-- end authorization form -->
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- JS -->
        <script src="<c:url value="/assets/admin/js/jquery-3.6.0.min.js" />"></script>
        <script src="<c:url value="/assets/admin/js/bootstrap.bundle.min.js" />"></script>
        <script src="<c:url value="/assets/admin/js/jquery.magnific-popup.min.js" />"></script>
        <script src="<c:url value="/assets/admin/js/jquery.mousewheel.min.js" />"></script>
        <script src="<c:url value="/assets/admin/js/jquery.mCustomScrollbar.min.js" />"></script>
        <script src="<c:url value="/assets/admin/js/select2.min.js" />"></script>
        <script src="<c:url value="/assets/admin/js/admin.js "/>"></script>
    </body>
</html>