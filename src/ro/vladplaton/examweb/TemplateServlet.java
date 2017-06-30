package ro.vladplaton.examweb;

import ro.vladplaton.examweb.DAL.TemplateDAL;
import ro.vladplaton.examweb.model.Template;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vladplaton on 30/06/2017.
 */
public class TemplateServlet extends HttpServlet {
    TemplateDAL templateDAL = new TemplateDAL();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String textContent = request.getParameter("textContent");
        int priv = Integer.parseInt(request.getParameter("private"));

        Template template = new Template();
        template.id = id;
        template.name = name;
        template.textContent = textContent;
        template.priv = priv;

        templateDAL.save(template);
        response.sendRedirect("index.jsp");
    }
}
