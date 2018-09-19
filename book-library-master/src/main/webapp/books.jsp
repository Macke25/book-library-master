<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="includes/header.jsp">
    <jsp:param name="active_tab" value="book"/>
</jsp:include>
<div class="container">
    <div class="row align-items-center mt-4">
        <div class="col-md-8">
            <h1>Katalog książek</h1>
        </div>
        <div class="col-md-4 text-right">
            <a href="#" class="btn btn-primary btn-sm" role="button">
                Dodaj książkę
            </a>
            <a href="author" class="btn btn-secondary btn-sm" role="button">Autorzy</a>
        </div>
    </div>
    <div class="row">
        <div class="col-auto">
            Zawartość strony<br/>
            Tabela z wykazem książek, przyciski, itp.
        </div>
    </div>
</div>
<jsp:include page="includes/footer.jsp"/>