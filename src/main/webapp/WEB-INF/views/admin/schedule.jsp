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
                    <form action="" method="POST" class="profile__form">
                        <div class="row">
                            <div class="col-12">
                                <h4 class="profile__title">Thông tin</h4>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-6">
                                <div class="profile__group">
                                    <label class="profile__label" for="film_id">ID phim</label>
                                    <input type="hidden" name="film_id"value="${film.id}" />
                                    <input id="film_id" type="text" class="profile__input" value="${film.id}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-6">
                                <div class="profile__group">
                                    <label class="profile__label" for="cinema">Rạp</label>
                                    <select class="js-example-basic-single" id="cinema" name="cinema_id">
                                        <c:forEach items="${cinemas}" var="cinema">
                                            <option value="${cinema.id}"<c:if test="${cinema.id eq schedule.cinema_id}"> selected</c:if>>${cinema.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-6">
                                <div class="profile__group">
                                    <label class="profile__label" for="room">Phòng</label>
                                    <select class="js-example-basic-single" id="room" name="room_id">
                                        <c:forEach items="${rooms}" var="room">
                                            <option value="${room.id}"<c:if test="${room.id eq schedule.room_id}"> selected</c:if>>${room.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-3">
                                <div class="profile__group">
                                    <label class="profile__label" for="date">Ngày</label>
                                    <input id="date" type="date" name="date" class="profile__input" value="${date}" />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-3">
                                <div class="profile__group">
                                    <label class="profile__label" for="time">Giờ</label>
                                    <input id="time" type="time" name="time" class="profile__input" value="${time}" />
                                </div>
                            </div>
                            <div class="col-12">
                                <button class="profile__btn" type="submit">Thực hiện</button>
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