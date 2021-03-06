package caro.controller;

import caro.domain.MessageService;
import caro.domain.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private PersonService personService = new PersonService();
    private MessageService messageService = new MessageService();
    private ControllerFactory controllerFactory = new ControllerFactory();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String destination = "index.jsp";
        if (action != null) {
            RequestHandler handler;
            try {
                handler = controllerFactory.getController(action, personService, messageService);
                handler.handleRequest(request, response);
                return;
            } catch (NotAuthorizedException exc) {
                List<String> errors = new ArrayList<>();
                errors.add(exc.getMessage());
                request.setAttribute("errors", errors);
                destination = "index.jsp";
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }

}
