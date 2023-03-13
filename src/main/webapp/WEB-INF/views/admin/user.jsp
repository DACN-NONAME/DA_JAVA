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
                            <div class="col-12 col-md-6 col-lg-12 col-xl-6">
                                <div class="profile__group">
                                    <label class="profile__label" for="id">ID người dùng</label>
                                    <input id="id" type="text" class="profile__input" value="${user.id}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-6">
                                <div class="profile__group">
                                    <label class="profile__label" for="full_name">Họ tên</label>
                                    <input id="full_name" type="text" class="profile__input" value="${user.full_name}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-6">
                                <div class="profile__group">
                                    <label class="profile__label" for="email">Email</label>
                                    <input id="email" type="email" class="profile__input" value="${user.email}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-6">
                                <div class="profile__group">
                                    <label class="profile__label" for="address">Địa chỉ</label>
                                    <input id="address" type="text" name="address" class="profile__input" value="${user.address}" disabled />
                                </div>
                            </div>
                            <div class="col-12 col-md-6 col-lg-12 col-xl-6">
                                <div class="profile__group">
                                    <label class="profile__label" for="created_at">Ngày tham gia</label>
                                    <input id="created_at" type="text" name="created_at" class="profile__input" value="${user.created_at}" disabled />
                                </div>
                            </div>
                            <!--                            <div class="col-12">
                                                            <button class="profile__btn" type="submit">Thực hiện</button>
                                                        </div>-->
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