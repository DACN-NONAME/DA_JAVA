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
                <form action="" method="POST" class="form">
                    <div class="row">
                        <div class="col-12 col-md-5 form__cover">
                            <div class="row">
                                <div class="col-12 col-sm-6 col-md-12">
                                    <div class="form__img">
                                        <label for="form__img-upload">Upload cover (270 x 400)</label>
                                        <!--<input id="form__img-upload" name="form__img-upload" type="file" accept=".png, .jpg, .jpeg">-->
                                        <img id="form__img" src="${film.poster}" alt=" ">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-md-7 form__content">
                            <div class="row">
                                <div class="col-12">
                                    <input type="text" class="form__input" placeholder="Title" value="${film.name}" name="name" required />
                                </div>
                                <div class="col-12">
                                    <textarea id="text" name="description" class="form__textarea" placeholder="Mô tả" required>${film.description}</textarea>
                                </div>
                                <div class="col-12 col-sm-6 col-lg-3">
                                    <input type="date" class="form__input" placeholder="Ngày phát hành" title="Ngày phát hành" value="${film.opening_day}" name="opening_day" required />
                                </div>
                                <div class="col-12 col-sm-6 col-lg-3">
                                    <input type="number" class="form__input" placeholder="Thời lượng (phút)" title="Thời lượng (phút)" value="${film.duration}" name="duration" required />
                                </div>
                                <div class="col-12 col-sm-6 col-lg-3">
                                    <select class="js-example-basic-single" id="country" name="country_id" required>
                                        <c:forEach items="${countries}" var="country">
                                            <option value="${country.id}"<c:if test="${country.id eq film.country_id}">selected</c:if>>${country.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-12 col-sm-6 col-lg-3">
                                    <select class="js-example-basic-single" id="rated" name="rated_id" required>
                                        <c:forEach items="${list_rated}" var="rated">
                                            <option value="${rated.id}"<c:if test="${rated.id eq film.rated_id}">selected</c:if>>${rated.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-12 col-lg-6">
                                    <select class="js-example-basic-multiple" id="category" multiple="multiple" name="categories_s" required>
                                        <%
                                            List<Category> listCategories = (List<Category>) request.getAttribute("categories");
                                            List<Category> listCategoriesSelected = (List<Category>) request.getAttribute("categories_selected");
                                            for (Category c : listCategories) {
                                                boolean selected = false;
                                                for (Category cs : listCategoriesSelected) {
                                                    if (c.getId() == cs.getId()) {
                                                        selected = true;
                                                        listCategoriesSelected.remove(cs);
                                                        break;
                                                    }
                                                }
                                        %>
                                        <option value="<%= c.getId()%>"<%= selected ? "selected" : ""%>><%= c.getName()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-12  col-lg-6">
                                    <input type="text" class="form__input" placeholder="Trailer" title="Trailer" value="${film.trailer}" name="trailer" required />
                                </div>
                                <div class="col-12  col-lg-6">
                                    <input type="text" class="form__input" placeholder="Đạo diễn" title="Đạo diễn" value="${film.director}" name="director" required />
                                </div>
                                <div class="col-12  col-lg-6">
                                    <input type="text" class="form__input" placeholder="Diễn viên" title="Diễn viên" value="${film.actor}" name="actor" required />
                                </div>
                                <div class="col-12">
                                    <input type="text" class="form__input" placeholder="Link poster" title="Link poster" value="${film.poster}" name="poster" required />
                                </div>
                            </div>
                        </div>
                        <!--                        <div class="col-12">
                                                    <ul class="form__radio">
                                                        <li>
                                                            <span>Item type:</span>
                                                        </li>
                                                        <li>
                                                            <input id="type1" type="radio" name="type" data-toggle="collapse" data-target=".multi-collapse" checked="">
                                                            <label for="type1">Movie</label>
                                                        </li>
                                                        <li>
                                                            <input id="type2" type="radio" name="type" data-toggle="collapse" data-target=".multi-collapse">
                                                            <label for="type2">TV Series</label>
                                                        </li>
                                                    </ul>
                                                </div>-->
                        <div class="col-12">
                            <button type="submit" class="form__btn">Thực hiện</button>
                        </div>
                    </div>
                </form>
            </div>
            <!-- end form -->
        </div>
    </div>
</main>
<!-- end main content -->
<jsp:include page="footer.jsp" />