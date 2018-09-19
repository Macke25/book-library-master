<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--@elvariable id="author" type="pl.sdacademy.library.entity.Author"--%>
<jsp:include page="includes/header.jsp">
    <jsp:param name="active_tab" value="book"/>
</jsp:include>
<div class="container">
    <div class="row align-items-center mt-4">
        <div class="col-md-8">
            <c:set var="pageTitle" value="${empty author ? 'Nowy autor' : 'Edytuj autora'}"/>
            <h1>${pageTitle}</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <form action="author" method="post">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <input type="hidden" value="${author.id}" name="id">
                        <label for="firstName">Imię</label>
                        <input type="text" class="form-control" value="${author.firstName}"
                               id="firstName" name="firstName" autocomplete="off">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="lastName">Nazwisko</label>
                        <input type="text" class="form-control" value="${author.lastName}"
                               id="lastName" name="lastName" autocomplete="off">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <label for="biography">Biografia</label>
                        <textarea class="form-control" id="biography" rows="4" name="biography"
                                  autocomplete="off">${author.biography}</textarea>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Zapisz</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="includes/footer.jsp"/>