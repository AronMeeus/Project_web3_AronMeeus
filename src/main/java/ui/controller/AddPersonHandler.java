package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

public class AddPersonHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<String> errors = new ArrayList<>();
        Person person = new Person();
        setUserid(errors, person, request);
        setFirstName(errors, person, request);
        setLastName(errors, person, request);
        setEmail(errors, person, request);
        setPassword(errors, person, request);

        if (errors.size() == 0) {
            try {
                service.add(person);
                return "Controller?command=OverviewHandler";
            } catch (Exception e) {
                errors.add(e.getMessage());

            }
        }
        request.setAttribute("errors", errors);
        return "Controller?command=RegisterHandler";


    }

    private void setPassword(List<String> errors, Person person, HttpServletRequest request) {
        String password = request.getParameter("password");
        try {
            person.setPassword(password);
            request.setAttribute("prevPassword", password);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setEmail(List<String> errors, Person person, HttpServletRequest request) {
        String email = request.getParameter("email");
        try {
            person.setEmail(email);
            request.setAttribute("prevEmail", email);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setLastName(List<String> errors, Person person, HttpServletRequest request) {
        String lastname = request.getParameter("lastName");
        try {
            person.setLastName(lastname);
            request.setAttribute("prevLastName", lastname);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setFirstName(List<String> errors, Person person, HttpServletRequest request) {
        String firstname = request.getParameter("firstName");
        try {
            person.setFirstName(firstname);
            request.setAttribute("prevFirstName", firstname);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setUserid(List<String> errors, Person person, HttpServletRequest request) {
        String userid = request.getParameter("userid");
        try {
            person.setUserid(userid);
            request.setAttribute("prevUserid", userid);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }
}
