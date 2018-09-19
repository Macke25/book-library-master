<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--@elvariable id="authors" type="java.util.List"--%>
<jsp:include page="includes/header.jsp">
    <jsp:param name="active_tab" value="book"/>
</jsp:include>
<div class="container">
    <div class="row align-items-center mt-4">
        <div class="col-md-8">
            <h1>Autorzy</h1>
        </div>
        <div class="col-md-4 text-right">
            <c:url var="authorCreateLink" value="author">
                <c:param name="operation" value="create"/>
            </c:url>
            <a href="${authorCreateLink}" class="btn btn-primary btn-sm" role="button">
                Dodaj autora
            </a>
            <a href="book" class="btn btn-secondary btn-sm" role="button">Książki</a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Imię</th>
                    <th scope="col">Nazwisko</th>
                    <th scope="col">Akcje</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="author" items="${authors}">
                    <c:url var="authorUpdateLink" value="author">
                        <c:param name="operation" value="update"/>
                        <c:param name="id" value="${author.id}"/>
                    </c:url>
                    <c:url var="authorDeleteLink" value="author">
                        <c:param name="operation" value="delete"/>
                        <c:param name="id" value="${author.id}"/>
                    </c:url>
                    <tr>
                        <th scope="row">${author.id}</th>
                        <td>${author.firstName}</td>
                        <td>${author.lastName}</td>
                        <td>
                            <a href="${authorUpdateLink}">Edytuj</a> |
                            <a href="${authorDeleteLink}">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <nav>
                <ul class="pagination justify-content-end">
                    <li class="page-item ${currentPage <= 1 ? 'disabled' : ''}">
                        <a class="page-link" href="author?page=${currentPage-1}&size=${pageSize}" tabindex="-1">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="author?page=${currentPage}&size=${pageSize}">${currentPage}</a></li>
                    <li class="page-item ${totalPages <= currentPage ? 'disabled' : ''}">
                        <a class="page-link" href="author?page=${currentPage+1}&size=${pageSize}">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<jsp:include page="includes/footer.jsp"/>