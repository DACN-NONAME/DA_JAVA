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
    let item_id = 0;
    function setDeleteItem(id) {
        item_id = id;
    }
    function deleteItem(api, href) {
        $.get(api, function (data) {
            window.location.href = href;
        });
    }
</script>
</body>

</html>