package ui.controller;

import domain.db.PersonService;
import domain.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private PersonService personService = new PersonService();
    public HandlerFactory handlerFactory = new HandlerFactory();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String command = request.getParameter("command");
        String destination = "index.jsp";
        RequestHandler handler = null;
        if (command != null) {
            try {
                handler = handlerFactory.getHandler(command, personService);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            handler = handlerFactory.getHandler("IndexHandler", personService);

        }
        destination = handler.handleRequest(request, response);
        request.getRequestDispatcher(destination).forward(request, response);

    }

}
