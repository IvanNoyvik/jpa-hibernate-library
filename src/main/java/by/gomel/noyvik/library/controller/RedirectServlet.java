package by.gomel.noyvik.library.controller;


import by.gomel.noyvik.library.controller.attribute.AttributeSetterFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", urlPatterns = {"/redirect"})
public class RedirectServlet extends HttpServlet {

    private final AttributeSetterFactory attributeSetter = AttributeSetterFactory.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String target = request.getParameter("target");

        if (target == null || target.isEmpty()){
            target = "main";
        }
        attributeSetter.getAttributeSetter(target, request);
//        SetAttribute.setAttribute(target, request);
        String path = "/" + target + ".jsp";
        getServletContext().getRequestDispatcher(path).forward(request, response);
    }


}
