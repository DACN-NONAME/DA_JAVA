<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
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
        <link rel="stylesheet" href="assets/css/main.css">

        <link rel="shortcut icon" href="assets/images/favicon.png" type="image/x-icon">

        <title>Boleto  - Đăng ký</title>


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

        <!-- ==========Sign-In-Section========== -->
        <section class="account-section bg_img" data-background="./assets/images/account/account-bg.jpg">
            <div class="container">
                <div class="padding-top padding-bottom">
                    <div class="account-area">
                        <div class="section-header-3">
                            <span class="cate">welcome</span>
                            <h2 class="title">to Boleto</h2>
                        </div>
                        <form class="account-form">
                            <c:if test="${msg}">
                                <div class="form-group"><p>${msg}</p></div>
                                    </c:if>
                            <div class="form-group">
                                <label for="email">Email <span>*</span></label>
                                <input type="email" placeholder="Email" id="email" name="email" required />
                            </div>
                            <div class="form-group">
                                <label for="password">Mật khẩu <span>*</span></label>
                                <input type="password" placeholder="Password" id="password" name="password" minlength="6" required />
                            </div>
                            <div class="form-group">
                                <label for="password2">Nhập lại mật khẩu <span>*</span></label>
                                <input type="password" placeholder="Password" id="password2" name="password2" minlength="6" required />
                            </div>
                            <div class="form-group">
                                <label for="phone">SDT <span>*</span></label>
                                <input type="text" placeholder="SDT" id="phone" name="phone" required />
                            </div>
                            <div class="form-group checkgroup">
                                <input type="checkbox" id="bal" required checked>
                                <label for="bal">Tôi đồng ý với <a href="#0">Điều khoản, Chính sách riêng tư</a> và <a href="#0">Phụ phí</a></label>
                            </div>
                            <div class="form-group text-center">
                                <input type="submit" value="Đăng Ký">
                            </div>
                        </form>
                        <div class="option">Đã có tài khoản? <a href="./sign-in">Đăng nhập</a></div>
                        <!--                        <div class="or"><span>Or</span></div>
                                                <ul class="social-icons">
                                                    <li>
                                                        <a href="#0">
                                                            <i class="fab fa-facebook-f"></i>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="#0" class="active">
                                                            <i class="fab fa-twitter"></i>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="#0">
                                                            <i class="fab fa-google"></i>
                                                        </a>
                                                    </li>
                                                </ul>-->
                    </div>
                </div>
            </div>
        </section>
        <!-- ==========Sign-In-Section========== -->


        <script src="assets/js/jquery-3.3.1.min.js"></script>
        <script src="assets/js/modernizr-3.6.0.min.js"></script>
        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/isotope.pkgd.min.js"></script>
        <script src="assets/js/magnific-popup.min.js"></script>
        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/wow.min.js"></script>
        <script src="assets/js/countdown.min.js"></script>
        <script src="assets/js/odometer.min.js"></script>
        <script src="assets/js/viewport.jquery.js"></script>
        <script src="assets/js/nice-select.js"></script>
        <script src="assets/js/main.js"></script>
    </body>

</html>