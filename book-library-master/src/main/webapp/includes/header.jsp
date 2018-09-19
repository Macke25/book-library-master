<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>System zarządzania biblioteką</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Biblioteka</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item ${param.active_tab == 'rent' ? 'active' : ''}">
                    <a class="nav-link" href="rent">Wypożycz</a>
                </li>
                <li class="nav-item ${param.active_tab == 'book' ? 'active' : ''}">
                    <a class="nav-link" href="book">Katalog książek</a>
                </li>
                <li class="nav-item ${param.active_tab == 'user' ? 'active' : ''}">
                    <a class="nav-link" href="user">Użytkownicy</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Szukana fraza" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Szukaj</button>
            </form>
        </div>
    </nav>
</div>