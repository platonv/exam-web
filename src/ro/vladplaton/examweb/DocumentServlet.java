package ro.vladplaton.examweb;

import org.json.JSONArray;
import org.json.JSONException;
import ro.vladplaton.examweb.DAL.DocumentDAL;
import ro.vladplaton.examweb.model.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vladplaton on 30/06/2017.
 */
public class DocumentServlet extends HttpServlet {
    DocumentDAL documentDAL = new DocumentDAL();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");

        List<Document> documents = documentDAL.findAll();
        List<Document> filteredDocuments = documents.stream().filter(document -> document.title.contains(title)).collect(Collectors.toList());
        JSONArray resultJson = new JSONArray();
        for (Document document: filteredDocuments) {
            try {
                resultJson.put(document.toJson());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.write(resultJson.toString());
        writer.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String listOfTemplates = request.getParameter("listOfTemplates");

        Document document = new Document();
        document.title = title;
        document.listOfTemplates = listOfTemplates;

        documentDAL.save(document);
        response.sendRedirect("index.jsp");
    }
}
