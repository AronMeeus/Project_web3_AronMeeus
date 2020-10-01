package ui.controller;

import domain.db.DbException;
import domain.db.PersonService;

import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;

public class HandlerFactory {
    public RequestHandler getHandler(String handlerName, PersonService service ) throws DbException, ClassNotFoundException {
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("ui.controller." + handlerName);
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setService(service);

        } catch (Exception e) {
            throw new RuntimeException("Deze pagina bestaat niet!!!!");
        }
        return handler;
    }
}
