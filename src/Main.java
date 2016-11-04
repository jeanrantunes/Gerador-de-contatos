import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Gerador json = new Gerador();
        JSONArray array = json.generator(500);

        try {
            FileWriter file = new FileWriter("JSON\\list500.json");
            file.write(array.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
