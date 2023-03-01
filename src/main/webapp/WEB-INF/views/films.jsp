<%@page import="com.noname.database.DBQuery"%>
<%@page import="com.noname.config.Utils"%>
<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- ==========Banner-Section========== -->
<section class="banner-section">
    <div class="banner-bg bg_img bg-fixed" data-background="./assets/images/banner/banner02.jpg"></div>
    <div class="container">
        <div class="banner-content">
            <h1 class="title bold">get <span class="color-theme">movie</span> tickets</h1>
            <p>Buy movie tickets in advance, find movie times watch trailers, read movie reviews and much more</p>
        </div>
    </div>
</section>
<!-- ==========Banner-Section========== -->

<!-- ==========Ticket-Search========== -->
<section class="search-ticket-section padding-top pt-lg-0">
    <div class="container">
        <div class="search-tab bg_img" data-background="./assets/images/ticket/ticket-bg01.jpg">
            <div class="row align-items-center mb--20">
                <div class="col-lg-6 mb-20">
                    <div class="search-ticket-header">
                        <h6 class="category">welcome to Boleto </h6>
                        <h3 class="title">what are you looking for</h3>
                    </div>
                </div>
                <div class="col-lg-6 mb-20">
                    <ul class="tab-menu ticket-tab-menu">
                        <li class="active">
                            <div class="tab-thumb">
                                <img src="./assets/images/ticket/ticket-tab01.png" alt="ticket">
                            </div>
                            <span>movie</span>
                        </li>
                        <li>
                            <div class="tab-thumb">
                                <img src="./assets/images/ticket/ticket-tab02.png" alt="ticket">
                            </div>
                            <span>events</span>
                        </li>
                        <li>
                            <div class="tab-thumb">
                                <img src="./assets/images/ticket/ticket-tab03.png" alt="ticket">
                            </div>
                            <span>sports</span>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="tab-area">
                <div class="tab-item active">
                    <form class="ticket-search-form">
                        <div class="form-group large">
                            <input type="text" placeholder="Search fo Movies">
                            <button type="submit"><i class="fas fa-search"></i></button>
                        </div>
                        <div class="form-group">
                            <div class="thumb">
                                <img src="./assets/images/ticket/city.png" alt="ticket">
                            </div>
                            <span class="type">city</span>
                            <select class="select-bar">
                                <option value="london">London</option>
                                <option value="dhaka">dhaka</option>
                                <option value="rosario">rosario</option>
                                <option value="madrid">madrid</option>
                                <option value="koltaka">kolkata</option>
                                <option value="rome">rome</option>
                                <option value="khoksa">khoksa</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <div class="thumb">
                                <img src="./assets/images/ticket/date.png" alt="ticket">
                            </div>
                            <span class="type">date</span>
                            <select class="select-bar">
                                <option value="26-12-19">23/10/2020</option>
                                <option value="26-12-19">24/10/2020</option>
                                <option value="26-12-19">25/10/2020</option>
                                <option value="26-12-19">26/10/2020</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <div class="thumb">
                                <img src="./assets/images/ticket/cinema.png" alt="ticket">
                            </div>
                            <span class="type">cinema</span>
                            <select class="select-bar">
                                <option value="Awaken">Awaken</option>
                                <option value="dhaka">dhaka</option>
                                <option value="rosario">rosario</option>
                                <option value="madrid">madrid</option>
                                <option value="koltaka">kolkata</option>
                                <option value="rome">rome</option>
                                <option value="khoksa">khoksa</option>
                            </select>
                        </div>
                    </form>
                </div>
                <div class="tab-item">
                    <form class="ticket-search-form">
                        <div class="form-group large">
                            <input type="text" placeholder="Search fo Events">
                            <button type="submit"><i class="fas fa-search"></i></button>
                        </div>
                        <div class="form-group">
                            <div class="thumb">
                                <img src="./assets/images/ticket/city.png" alt="ticket">
                            </div>
                            <span class="type">city</span>
                            <select class="select-bar">
                                <option value="london">London</option>
                                <option value="dhaka">dhaka</option>
                                <option value="rosario">rosario</option>
                                <option value="madrid">madrid</option>
                                <option value="koltaka">kolkata</option>
                                <option value="rome">rome</option>
                                <option value="khoksa">khoksa</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <div class="thumb">
                                <img src="./assets/images/ticket/date.png" alt="ticket">
                            </div>
                            <span class="type">date</span>
                            <select class="select-bar">
                                <option value="26-12-19">23/10/2020</option>
                                <option value="26-12-19">24/10/2020</option>
                                <option value="26-12-19">25/10/2020</option>
                                <option value="26-12-19">26/10/2020</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <div class="thumb">
                                <img src="./assets/images/ticket/cinema.png" alt="ticket">
                            </div>
                            <span class="type">event</span>
                            <select class="select-bar">
                                <option value="angular">angular</option>
                                <option value="startup">startup</option>
                                <option value="rosario">rosario</option>
                                <option value="madrid">madrid</option>
                                <option value="koltaka">kolkata</option>
                                <option value="Last-First">Last-First</option>
                                <option value="wish">wish</option>
                            </select>
                        </div>
                    </form>
                </div>
                <div class="tab-item">
                    <form class="ticket-search-form">
                        <div class="form-group large">
                            <input type="text" placeholder="Search fo Sports">
                            <button type="submit"><i class="fas fa-search"></i></button>
                        </div>
                        <div class="form-group">
                            <div class="thumb">
                                <img src="./assets/images/ticket/city.png" alt="ticket">
                            </div>
                            <span class="type">city</span>
                            <select class="select-bar">
                                <option value="london">London</option>
                                <option value="dhaka">dhaka</option>
                                <option value="rosario">rosario</option>
                                <option value="madrid">madrid</option>
                                <option value="koltaka">kolkata</option>
                                <option value="rome">rome</option>
                                <option value="khoksa">khoksa</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <div class="thumb">
                                <img src="./assets/images/ticket/date.png" alt="ticket">
                            </div>
                            <span class="type">date</span>
                            <select class="select-bar">
                                <option value="26-12-19">23/10/2020</option>
                                <option value="26-12-19">24/10/2020</option>
                                <option value="26-12-19">25/10/2020</option>
                                <option value="26-12-19">26/10/2020</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <div class="thumb">
                                <img src="./assets/images/ticket/cinema.png" alt="ticket">
                            </div>
                            <span class="type">sports</span>
                            <select class="select-bar">
                                <option value="football">football</option>
                                <option value="cricket">cricket</option>
                                <option value="cabadi">cabadi</option>
                                <option value="madrid">madrid</option>
                                <option value="gadon">gadon</option>
                                <option value="rome">rome</option>
                                <option value="khoksa">khoksa</option>
                            </select>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>    
<!-- ==========Ticket-Search========== -->

<!-- ==========Movie-Section========== -->
<section class="movie-section padding-top padding-bottom">
    <div class="container">
        <div class="row flex-wrap-reverse justify-content-center">
            <div class="col-sm-10 col-md-8 col-lg-3">
                <div class="widget-1 widget-banner">
                    <div class="widget-1-body">
                        <a href="#0">
                            <img src="./assets/images/sidebar/banner/banner01.jpg" alt="banner" />
                        </a>
                    </div>
                </div>
                <div class="widget-1 widget-banner">
                    <div class="widget-1-body">
                        <a href="#0">
                            <img src="./assets/images/sidebar/banner/banner01.jpg" alt="banner" />
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-lg-9 mb-50 mb-lg-0">
                <div class="filter-tab tab">
                    <div class="filter-area">
                        <div class="filter-main">
                            <div class="left">
                                <div class="item">
                                    <span class="show">Show :</span>
                                    <select class="select-bar">
                                        <option value="12">12</option>
                                        <option value="15">15</option>
                                        <option value="18">18</option>
                                        <option value="21">21</option>
                                        <option value="24">24</option>
                                        <option value="27">27</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="item">
                                    <span class="show">Sort By :</span>
                                    <select class="select-bar">
                                        <option value="showing">now showing</option>
                                        <option value="exclusive">exclusive</option>
                                        <option value="trending">trending</option>
                                        <option value="most-view">most view</option>
                                    </select>
                                </div>
                            </div>
                            <ul class="grid-button tab-menu">
                                <li class="active">
                                    <i class="fas fa-th"></i>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="tab-area">
                        <div class="tab-item active">
                            <div class="row mb-10 justify-content-center">
                                <c:forEach items="${films}" var="film">
                                    <div class="col-sm-6 col-lg-4">
                                        <div class="movie-grid">
                                            <div class="movie-thumb c-thumb">
                                                <a href="./film-detail?id=${film.id}">
                                                    <img src="${film.poster}" alt="movie" height="357px" width="255px" />
                                                </a>
                                            </div>
                                            <div class="movie-content bg-one">
                                                <h5 class="title m-0" style="font-size: 18px;">
                                                    <a href="./film-detail?id=${film.id}">${film.name}</a>
                                                </h5>
                                                <ul class="movie-rating-percent">
                                                    <li>
                                                        <div class="thumb">
                                                            <img src="./assets/images/movie/tomato.png" alt="movie" />
                                                        </div>
                                                        <span class="content">${film.duration} phút</span>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="pagination-area text-center">
                        <%
                            DBQuery dbq = new DBQuery();
                            int pg = Utils.Page(request.getParameter("page"));
                            int end_page = (int) Math.ceil((double) dbq.getCountFilms() / Utils.LIMIT_ROWS);
                            for (int i = 1; i <= end_page; i++)
                                if (Math.abs(pg - i) <= 3 || i == 1 || i == end_page) {
                        %>
                        <a href="javascript:" onclick="pagination(<%= i%>)" class="<%= pg == i ? "active" : ""%>"><%= i%></a>
                        <%
                            }
                        %>
                        <!--                        <a href="#0"><i class="fas fa-angle-double-left"></i><span>Prev</span></a>
                                                <a href="#0">1</a>
                                                <a href="#0">2</a>
                                                <a href="#0" class="active">3</a>
                                                <a href="#0">4</a>
                                                <a href="#0">5</a>
                                                <a href="#0"><span>Next</span><i class="fas fa-angle-double-right"></i></a>-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- ==========Movie-Section========== -->
<jsp:include page="footer.jsp" />