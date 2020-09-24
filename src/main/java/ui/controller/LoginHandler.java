package ui.controller;

import domain.db.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        session = request.getSession();
        String password = request.getParameter("password");
        String userid = request.getParameter("userid").toLowerCase();
        if (service.get(userid).isCorrectPassword(password)) {
            session.setAttribute("user", service.get(request.getParameter("userid")));

        } else {
            String loginError = "No valid userid/password";
            request.setAttribute("loginError", loginError);
        }
        return "index.jsp";

    }
}
