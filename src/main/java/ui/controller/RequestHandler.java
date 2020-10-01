package ui.controller;

import domain.db.PersonService;
import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class RequestHandler {

    protected PersonService service;
    protected HttpSession session;

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response);

    public void setService(PersonService service) {
        this.service = service;
    }
    public void setSession(HttpSession session){
        this.session = session;
    }

    public PersonService getService() {
        return service;
    }
}
