import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Httprequist {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://us-central1-swe206-221.cloudfunctions.net/app/UserSignIn?username=6412&password=7562"); // i put the password and user name just to test but it need to be removed
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        int status = con.getResponseCode();
        System.out.println(status);
        String[] words = null;
        String type = null;
        int count=0;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null){
                    content.append(inputLine);
                    words = inputLine.split(",");
                    for (String word : words)
                    {
                        if (word.equals("\"type\":\"student\""))   //Search for the given word
                        {
                            count++;
                         type = "Stu";
                        }
                        else{
                            type = "admin";



                        }


                    }
                    System.out.print(count);



                }


    }
}
