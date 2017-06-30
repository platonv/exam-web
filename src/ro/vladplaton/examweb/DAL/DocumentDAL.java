package ro.vladplaton.examweb.DAL;

import ro.vladplaton.examweb.model.Document;
import ro.vladplaton.examweb.model.Template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladplaton on 30/06/2017.
 */
public class DocumentDAL extends DALBase {

    public List<Document> findAll() {
        List<Document> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from document");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Document document = new Document();
                document.id = rs.getInt("id");
                document.title = rs.getString("title");
                document.listOfTemplates = rs.getString("listOfTemplates");
                list.add(document);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int save(Document document){
        int status=0;
        try {
            Connection con = getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into document(title, listOfTemplates) values(?,?)");
            ps.setString(1, document.title);
            ps.setString(2, document.listOfTemplates);
            status=ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        return status;
    }

}
