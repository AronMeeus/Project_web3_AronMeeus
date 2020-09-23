package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OverviewHandler extends RequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<Person> personList = service.getAll();
        request.setAttribute("personen", personList);
        return "personoverview.jsp";
    }
}
