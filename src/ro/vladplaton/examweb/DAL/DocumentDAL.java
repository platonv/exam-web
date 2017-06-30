package ro.vladplaton.examweb.DAL;

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

    public List<Template> findAll() {
        List<Template> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from template");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Template template = new Template();
                template.id = rs.getInt("id");
                template.name = rs.getString("name");
                template.textContent = rs.getString("textContent");
                template.priv = rs.getInt("private");
                list.add(template);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int save(Template template){
        int status=0;
        try {
            Connection con = getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into template(id, name, textContent, private) values(?,?,?, ?)");
            ps.setInt(1, template.id);
            ps.setString(2, template.name);
            ps.setString(3, template.textContent);
            ps.setInt(4, template.priv);
            status=ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        return status;
    }

}