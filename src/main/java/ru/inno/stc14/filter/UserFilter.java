package ru.inno.stc14.filter;

import ru.inno.stc14.entity.Person;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ДЗ_17
 * Доработать проект с урока.
 * 1) Избавиться от объявлений сервлетов, фильтров и слушателей в web.xml. Использовать аннотации. В web.xml должны остаться только параметры базы и описание ошибок.
 * 2) Добавить в базу данных пользователей
 * 3) Реализовать страницу с возможностью авторизации в приложении и получить доступ ко всем страницам.
 * 4) При успешной авторизации перенаправлять пользователя на искомую страницу.
 * Логин для первого входа admin, пароль 123.
 */
@WebFilter(urlPatterns = {"/person/*"})
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        Person person = (Person) session.getAttribute("person");
        if (person != null) {
            filterChain.doFilter(req, res);
        } else {
            res.sendRedirect("/error.jsp");
        }
    }

    @Override
    public void destroy() {
    }
}