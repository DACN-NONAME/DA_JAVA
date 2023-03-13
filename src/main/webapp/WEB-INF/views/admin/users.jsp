<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- main content -->
<main class="main">
    <div class="container-fluid">
        <div class="row">
            <!-- main title -->
            <div class="col-12">
                <div class="main__title">
                    <h2>Danh sách phim</h2>
                    <!--<span class="main__title-stat">14,452 Total</span>-->
                </div>
            </div>
            <!-- end main title -->
            <!-- users -->
            <div class="col-12">
                <div class="main__table-wrap">
                    <table class="main__table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>HỌ TÊN</th>
                                <th>EMAIL</th>
                                <th>SDT</th>
                                <th>NGÀY TẠO</th>
                                <th>ACTIONS</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td>
                                        <div class="main__table-text">${user.id}</div>
                                    </td>
                                    <td>
                                        <div class="main__table-text">${user.full_name}</div>
                                    </td>
                                    <td>
                                        <div class="main__table-text">${user.email}</div>
                                    </td>
                                    <td>
                                        <div class="main__table-text">${user.phone}</div>
                                    </td>
                                    <td>
                                        <div class="main__table-text">${user.created_at}</div>
                                    </td>
                                    <td>
                                        <div class="main__table-btns">
                                            <a href="<c:url value="/admin/user?id=${user.id}" />" class="main__table-btn main__table-btn--view">
                                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M21.92,11.6C19.9,6.91,16.1,4,12,4S4.1,6.91,2.08,11.6a1,1,0,0,0,0,.8C4.1,17.09,7.9,20,12,20s7.9-2.91,9.92-7.6A1,1,0,0,0,21.92,11.6ZM12,18c-3.17,0-6.17-2.29-7.9-6C5.83,8.29,8.83,6,12,6s6.17,2.29,7.9,6C18.17,15.71,15.17,18,12,18ZM12,8a4,4,0,1,0,4,4A4,4,0,0,0,12,8Zm0,6a2,2,0,1,1,2-2A2,2,0,0,1,12,14Z"/></svg>
                                            </a>
                                            <!--                                            <a href="add-item.html" class="main__table-btn main__table-btn--edit">
                                                                                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M5,18H9.24a1,1,0,0,0,.71-.29l6.92-6.93h0L19.71,8a1,1,0,0,0,0-1.42L15.47,2.29a1,1,0,0,0-1.42,0L11.23,5.12h0L4.29,12.05a1,1,0,0,0-.29.71V17A1,1,0,0,0,5,18ZM14.76,4.41l2.83,2.83L16.17,8.66,13.34,5.83ZM6,13.17l5.93-5.93,2.83,2.83L8.83,16H6ZM21,20H3a1,1,0,0,0,0,2H21a1,1,0,0,0,0-2Z"/></svg>
                                                                                        </a>
                                                                                        <a href="#modal-delete" class="main__table-btn main__table-btn--delete open-modal">
                                                                                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M20,6H16V5a3,3,0,0,0-3-3H11A3,3,0,0,0,8,5V6H4A1,1,0,0,0,4,8H5V19a3,3,0,0,0,3,3h8a3,3,0,0,0,3-3V8h1a1,1,0,0,0,0-2ZM10,5a1,1,0,0,1,1-1h2a1,1,0,0,1,1,1V6H10Zm7,14a1,1,0,0,1-1,1H8a1,1,0,0,1-1-1V8H17Z"/></svg>
                                                                                        </a>-->
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- end users -->

            <!-- paginator -->
            <!--                                    <div class="col-12">
                                                    <div class="paginator-wrap">
                                                        <span>10 from 14 452</span>
            
                                                        <ul class="paginator">
                                                            <li class="paginator__item paginator__item--prev">
                                                                <a href="#"><svg xmlns="http://www.w3.org/2000/svg" enable-background="new 0 0 24 24" viewBox="0 0 24 24"><path d="M8.5,12.8l5.7,5.6c0.4,0.4,1,0.4,1.4,0c0,0,0,0,0,0c0.4-0.4,0.4-1,0-1.4l-4.9-5l4.9-5c0.4-0.4,0.4-1,0-1.4c-0.2-0.2-0.4-0.3-0.7-0.3c-0.3,0-0.5,0.1-0.7,0.3l-5.7,5.6C8.1,11.7,8.1,12.3,8.5,12.8C8.5,12.7,8.5,12.7,8.5,12.8z"></path></svg></a>
                                                            </li>
                                                            <li class="paginator__item"><a href="#">1</a></li>
                                                            <li class="paginator__item paginator__item--active"><a href="#">2</a></li>
                                                            <li class="paginator__item"><a href="#">3</a></li>
                                                            <li class="paginator__item"><a href="#">4</a></li>
                                                            <li class="paginator__item paginator__item--next">
                                                                <a href="#"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M15.54,11.29,9.88,5.64a1,1,0,0,0-1.42,0,1,1,0,0,0,0,1.41l4.95,5L8.46,17a1,1,0,0,0,0,1.41,1,1,0,0,0,.71.3,1,1,0,0,0,.71-.3l5.66-5.65A1,1,0,0,0,15.54,11.29Z"></path></svg></a>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>-->
            <!-- end paginator -->
        </div>
    </div>
</main>
<!-- end main content -->

<!-- modal status -->
<div id="modal-status" class="zoom-anim-dialog mfp-hide modal">
    <h6 class="modal__title">Status change</h6>
    <p class="modal__text">Are you sure about immediately change status?</p>
    <div class="modal__btns">
        <button class="modal__btn modal__btn--apply" type="button">Apply</button>
        <button class="modal__btn modal__btn--dismiss" type="button">Dismiss</button>
    </div>
</div>
<!-- end modal status -->

<!-- modal delete -->
<div id="modal-delete" class="zoom-anim-dialog mfp-hide modal">
    <h6 class="modal__title">Item delete</h6>
    <p class="modal__text">Are you sure to permanently delete this item?</p>
    <div class="modal__btns">
        <button class="modal__btn modal__btn--apply" type="button">Delete</button>
        <button class="modal__btn modal__btn--dismiss" type="button">Dismiss</button>
    </div>
</div>
<!-- end modal delete -->
<jsp:include page="footer.jsp" />