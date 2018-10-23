package org.vironit.timoshuk.computershop.servlet;

import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.command.factory.ActionFactory;
import org.vironit.timoshuk.computershop.resource.MessageManager;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/controller")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        String page ;
        ActionFactory actionFactory = new ActionFactory();
        ActionCommand command = actionFactory.defineCommand(req);
        page = command.execute(req);
        if (page != null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(req,resp);
        }else {
            page = URLManager.getProperty("path.page.index");
            req.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullPage"));
            resp.sendRedirect(req.getContextPath() + page);
        }
    }
}