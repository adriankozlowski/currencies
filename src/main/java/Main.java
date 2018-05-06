import com.google.gson.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Created by Adrian on 18.06.2017.
 */
public class Main {
    private static final String CODE = "code";
    private static final String CURRENCY = "currency";
    private static final String GET = "GET";

    public static void main(String[] args) {

        try {
            //tabele, ktore rozpatrujemy
            String[] tables = {"A", "B", "C"};
            //iterujemy przez tablice tabel
            List<String> result = new ArrayList<>();
            for (String table : tables) {
                //tworzymy żądanie
                URL url = null;
                url = new URL("http://api.nbp.pl/api/exchangerates/tables/" + table + "/");
                //rzutujemy url connection na HTTP
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                //wybiramy metodę żądania HTTP
                http.setRequestMethod(GET);
                //wysyłamy żądanie

                http.connect();
                //sprawdzamy odpowiedź
                int responseCode = http.getResponseCode();
                if (responseCode == 200) { //jeżeli ok TO:
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(http.getInputStream()));

                    String line = null;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
//                    System.out.println(stringBuilder.toString());
                    parse(stringBuilder);
                } else {
                    System.out.println("tabla " + table + " nie obsluzona");
                }
            }

//
            HashMap<String, String> map = new HashMap<String, String>();
            Set<String> strings = map.keySet();
            Collection<String> values = map.values();
//
            for (String string : strings) {
                map.get(string);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void parse(StringBuilder stringBuilder) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        JsonArray o = parser.parse(stringBuilder.toString()).getAsJsonArray();

        JsonObject jsonObject = o.getAsJsonObject();
        jsonObject.get("rates").getAsJsonArray();

        String s = gson.toJson(o);
        System.out.println(s);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
