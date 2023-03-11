<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JS -->
<script src="<c:url value="/assets/admin/js/jquery-3.6.0.min.js" />"></script>
<script src="<c:url value="/assets/admin/js/bootstrap.bundle.min.js" />"></script>
<script src="<c:url value="/assets/admin/js/jquery.magnific-popup.min.js" />"></script>
<script src="<c:url value="/assets/admin/js/jquery.mousewheel.min.js" />"></script>
<script src="<c:url value="/assets/admin/js/jquery.mCustomScrollbar.min.js" />"></script>
<script src="<c:url value="/assets/admin/js/select2.min.js" />"></script>
<script src="<c:url value="/assets/admin/js/admin.js" />"></script>
<script>
    let country_id = 0;
    function setDeleteCountry(id) {
        country_id = id;
    }
    function deleteCountry() {
        $.get('<c:url value="/admin/country/delete?id=" />' + country_id, function (data) {
            window.location.href = '<c:url value="/admin/countries" />';
        });
    }
</script>
</body>

</html>