<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- ==========Newslater-Section========== -->
<footer class="footer-section">
    <div class="container">
        <div class="footer-top">
            <div class="logo">
                <a href="index-1.html">
                    <img src="<c:url value="/assets/images/footer/footer-logo.png" />" alt="footer" />
                </a>
            </div>
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
                        <i class="fab fa-pinterest-p"></i>
                    </a>
                </li>
                <li>
                    <a href="#0">
                        <i class="fab fa-google"></i>
                    </a>
                </li>
                <li>
                    <a href="#0">
                        <i class="fab fa-instagram"></i>
                    </a>
                </li>
            </ul>
        </div>
        <div class="footer-bottom">
            <div class="footer-bottom-area">
                <div class="left">
                    <p>Copyright &copy; 2023. All Rights Reserved By <a href="#0">NoName</a></p>
                </div>
                <ul class="links">
                    <li>
                        <a href="#0">About</a>
                    </li>
                    <li>
                        <a href="#0">Terms Of Use</a>
                    </li>
                    <li>
                        <a href="#0">Privacy Policy</a>
                    </li>
                    <li>
                        <a href="#0">FAQ</a>
                    </li>
                    <li>
                        <a href="#0">Feedback</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>
<!-- ==========Newslater-Section========== -->


<script src="<c:url value="/assets/js/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/assets/js/modernizr-3.6.0.min.js" />"></script>
<script src="<c:url value="/assets/js/plugins.js" />"></script>
<script src="<c:url value="/assets/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/assets/js/heandline.js" />"></script>
<script src="<c:url value="/assets/js/isotope.pkgd.min.js" />"></script>
<script src="<c:url value="/assets/js/magnific-popup.min.js" />"></script>
<script src="<c:url value="/assets/js/owl.carousel.min.js" />"></script>
<script src="<c:url value="/assets/js/wow.min.js" />"></script>
<script src="<c:url value="/assets/js/countdown.min.js" />"></script>
<script src="<c:url value="/assets/js/odometer.min.js" />"></script>
<script src="<c:url value="/assets/js/viewport.jquery.js" />"></script>
<script src="<c:url value="/assets/js/nice-select.js" />"></script>
<script src="<c:url value="/assets/js/main.js" />"></script>
<script>
    if (window.history.replaceState) {
        window.history.replaceState(null, null, window.location.href);
    }

    function redirectParams(name, value) {
        var url = new URL(window.location.href);
        url.searchParams.set(name, value);
        window.location.href = url.href;
    }

    function pagination(num) {
        redirectParams('page', num);
    }

    function numberWithDot(x) {
        return x.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ".");
    }

    $(document).ready(function () {
        // Nice Select
        $(".select-bar").niceSelect();
        $('div.select-bar').on('click', function (event) {
            console.log(event);
            if (event.target.className.includes("option") && !event.target.className.includes("focus"))
                redirectParams('date', event.target.innerText);
//                console.log(event.target.innerText);
        });
    });

    let schedule_id = 0;
    function setScheduleId(id) {
        schedule_id = id;
    }

    function redirectScheduleId() {
        window.location.href = './seats?id=' + schedule_id;
    }

    function redirectPurchase(sid) {
        window.location.href = './purchase?schedule_id=' + sid + '&seats=' + $('#code-seat').text().trim(',');
    }
</script>
</body>

</html>