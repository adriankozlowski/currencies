import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static jdk.nashorn.internal.runtime.PropertyDescriptor.GET;

public class HttpMain {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://api.nbp.pl");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.connect();

        int responseCode = http.getResponseCode();
        if (responseCode == 200) { //jeżeli ok TO:
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(http.getInputStream()));

            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line+"\n");
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
