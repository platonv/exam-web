package ro.vladplaton.examweb.DAL;

import ro.vladplaton.examweb.model.Keyword;

import java.security.Key;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladplaton on 30/06/2017.
 */
public class KeywordDAL extends DALBase {

    public List<Keyword> findAll() {
        List<Keyword> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from keyword");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Keyword keyword = new Keyword();
                keyword.id = rs.getInt("id");
                keyword.key = rs.getString("k");
                keyword.value = rs.getString("value");
                list.add(keyword);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int save(Keyword keyword){
        int status=0;
        System.out.println(keyword.id);
        System.out.println(keyword.key);
        System.out.println(keyword.value);
        try {
            Connection con = getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into keyword(id, k, value) values(?,?,?)");
            ps.setInt(1, keyword.id);
            ps.setString(2, keyword.key);
            ps.setString(3, keyword.value);
            status=ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        return status;
    }

}
