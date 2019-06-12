package ru.inno.stc14.servlet;

import ru.inno.stc14.entity.Person;
import ru.inno.stc14.service.PersonService;
import ru.inno.stc14.service.PersonServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private PersonService personService;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        personService = new PersonServiceImpl(connection);
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Person person = personService.getPersonByLoginAndPassword(login, password);
        req.getSession().setAttribute("person", person);
        if (person != null && person.getLogin().equals(login) && person.getPassword().equals(password)) {
            resp.sendRedirect("/menu.jsp");
        } else {
            resp.sendRedirect("/error.jsp");
        }
    }
}