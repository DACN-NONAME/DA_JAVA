<%@page import="com.noname.model.Booking"%>
<%@page import="com.noname.model.Booking_detail"%>
<%@page import="com.noname.model.Category"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- main content -->
<main class="main">
    <div class="container-fluid">
        <div class="row">
            <!-- main title -->
            <div class="col-12">
                <div class="main__title">
                    <h2>${main_title}</h2>
                </div>
            </div>
            <!-- end main title -->

            <!-- form -->
            <div class="col-12">
                <div class="row">
                    <form action="#"class="profile__form">
                        <div class="row">
                            <div class="col-12">
                                <h4 class="profile__title">Thông tin</h4>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-4">
                                <div class="profile__group">
                                    <label class="profile__label" for="user_id">ID người dùng</label>
                                    <input id="user_id" type="text" class="profile__input" value="${user.id}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-4">
                                <div class="profile__group">
                                    <label class="profile__label" for="full_name">Họ tên</label>
                                    <input id="full_name" type="text" class="profile__input" value="${user.full_name}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-4">
                                <div class="profile__group">
                                    <label class="profile__label" for="email">Email</label>
                                    <input id="email" type="email" class="profile__input" value="${user.email}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-6">
                                <div class="profile__group">
                                    <label class="profile__label" for="film_id">ID phim</label>
                                    <input id="film_id" type="text" name="film_id" class="profile__input" value="${booking.film_id}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-6">
                                <div class="profile__group">
                                    <label class="profile__label" for="film_name">Tên phim</label>
                                    <input id="film_name" type="text" name="film_name" class="profile__input" value="${booking.film_name}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-3">
                                <div class="profile__group">
                                    <label class="profile__label" for="schedule_id">ID lịch chiếu</label>
                                    <input id="schedule_id" type="text" name="schedule_id" class="profile__input" value="${schedule.id}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-3">
                                <div class="profile__group">
                                    <label class="profile__label" for="schedule_start_time">Suất chiếu</label>
                                    <input id="schedule_start_time" type="text" name="schedule_start_time" class="profile__input" value="${schedule.start_time}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-3">
                                <div class="profile__group">
                                    <label class="profile__label" for="cinema_name">Rạp</label>
                                    <input id="cinema_name" type="text" name="cinema_name" class="profile__input" value="${schedule.cinema_name}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-3">
                                <div class="profile__group">
                                    <label class="profile__label" for="room_name">Phòng</label>
                                    <input id="room_name" type="text" name="room_name" class="profile__input" value="${schedule.room_name}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-12">
                                <div class="profile__group">
                                    <label class="profile__label" for="booking_detail">Chi tiết vé</label>
                                    <%
                                        List<Booking_detail> listBDs = (List<Booking_detail>) request.getAttribute("booking_details");
                                        String booking_detail = "";
                                        for (Booking_detail ele : listBDs) {
                                            booking_detail += ele.getSeat() + " (" + String.format("%,d", ele.getPrice()) + "), ";
                                        }
                                    %>
                                    <input id="booking_detail" type="text" name="booking_detail" class="profile__input" value="<%= booking_detail%>" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-6">
                                <div class="profile__group">
                                    <label class="profile__label" for="booking_total_price">Tổng tiền</label>
                                    <%
                                        Booking booking = (Booking) request.getAttribute("booking");
                                        String total_price = String.format("%,d", booking.getTotal_price());
                                    %>
                                    <input id="booking_total_price" type="text" name="booking_total_price" class="profile__input" value="<%= total_price%> đ" disabled />
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- end form -->
        </div>
    </div>
</main>
<!-- end main content -->
<jsp:include page="footer.jsp" />