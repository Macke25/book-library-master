package pl.sdacademy.library.controller;

import pl.sdacademy.library.entity.Author;
import pl.sdacademy.library.repository.AuthorRepository;
import pl.sdacademy.library.service.AuthorService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("author")
public class AuthorController extends HttpServlet {

    @EJB
    private AuthorService authorService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String operation = request.getParameter("operation");

        if (operation != null) {
            handleOperation(operation, request, response);
            return;
        }

        String currentPageParam = request.getParameter("page");
        int currentPage = 1;
        if (currentPageParam != null && !currentPageParam.isEmpty()) {
            currentPage = Integer.parseInt(request.getParameter("page"));
        }

        String sizeParam = request.getParameter("size");
        int size = 5;
        if (sizeParam != null && !sizeParam.isEmpty()) {
            size = Integer.parseInt(sizeParam);
        }

        int totalPages = (int) (authorService.getCount() / size) + 1;

        if (currentPage > totalPages) {
            currentPage = totalPages;
        }

        List<Author> authors = authorService.getAuthors(currentPage, size);
        request.setAttribute("authors", authors);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("pageSize", size);

        RequestDispatcher dispatcher = request.getRequestDispatcher("authors.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idString = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String biography = request.getParameter("biography");

        if (idString == null || idString.trim().isEmpty()) {
            authorService.createAuthor(firstName, lastName, biography);
        } else {
            Long id = Long.parseLong(request.getParameter("id"));
            authorService.updateAuthor(id, firstName, lastName, biography);
        }

        response.sendRedirect("author");
    }

    private void handleOperation(String operation, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        switch (operation) {
            case "create":
                response.sendRedirect("author_edit.jsp");
                return;
            case "update":
                Long updateId = Long.parseLong(request.getParameter("id"));
                Author authorToUpdate = authorService.getAuthor(updateId);
                request.setAttribute("author", authorToUpdate);
                RequestDispatcher dispatcher = request.getRequestDispatcher("author_edit.jsp");
                dispatcher.forward(request, response);
                return;
            case "delete":
                Long deleteId = Long.parseLong(request.getParameter("id"));
                authorService.deleteAuthorById(deleteId);
                break;
        }
        response.sendRedirect("author");
    }
}