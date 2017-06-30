package ro.vladplaton.examweb;

import ro.vladplaton.examweb.DAL.KeywordDAL;
import ro.vladplaton.examweb.model.Keyword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vladplaton on 30/06/2017.
 */
public class KeywordServlet extends HttpServlet {
    KeywordDAL keywordDAL = new KeywordDAL();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        Keyword keyword = new Keyword();
        keyword.id = id;
        keyword.key = key;
        keyword.value = value;

        keywordDAL.save(keyword);
        response.sendRedirect("index.jsp");
    }
}
