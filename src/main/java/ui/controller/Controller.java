package ui.controller;

import domain.db.PersonService;
import domain.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private PersonService personService = new PersonService();
    public HandlerFactory handlerFactory = new HandlerFactory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String destination = "index.jsp";
        if (command != null) {
            try {
                RequestHandler handler = handlerFactory.getHandler(command, personService);
                destination = handler.handleRequest(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        request.getRequestDispatcher(destination).forward(request, response);

    }

    private String Overview(HttpServletRequest request, HttpServletResponse response) {
        List<Person> personenLijst = personService.getAll();
        request.setAttribute("personen", personenLijst);
        return "personoverview.jsp";
    }
}
