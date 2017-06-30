package ro.vladplaton.examweb.model;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by vladplaton on 30/06/2017.
 */
public class Document {
    public int id;
    public String title;
    public String listOfTemplates;

    public JSONObject toJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", this.id);
        jsonObject.put("title", this.title);
        jsonObject.put("listOfTemplates", this.listOfTemplates);
        return jsonObject;
    }
}
