import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Gerador {

    public JSONArray generator(int quantity) {
        JSONArray array = new JSONArray();
        String url="https://github.com/fangyidong/json-simple/blob/master/src/main/java/org/json/simple/parser/Yylex.java";
        for(int i=0; i<quantity; i++) {
            JSONObject obj = new JSONObject();

            obj.put("Name",randomString(7));
            obj.put("LastName", randomString(7));
            obj.put("Birthday", String.valueOf(randomDate()));
            obj.put("Email",randomString(10)+"@"+randomString(5)+"."+"com");
            obj.put("Phone", randomNumbers(2) + "-" + randomNumbers(8));
            obj.put("CellPhone", randomNumbers(2) + "-" + randomNumbers(8));

            obj.put("Photo", "Photos/"+(i+1)+".jpg");

            array.add(obj);
        }
        return array;
    }

    private String randomString(int num_chars){

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < num_chars; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();

        return output;
    }

    private String randomNumbers(int num){

        char[] chars = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();

        return output;
    }
    private LocalDate randomDate(){
        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2016, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

        return randomBirthDate;
    }
}
