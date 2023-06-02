import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class API {
    public String getApiKey(){
        String TBA_AUTH_KEY = "";

        try {
          File API_KEY = new File(
              "C:\\Users\\emcgi\\IdeaProjects\\google-sheets-api-java\\src\\main\\resources\\X-TBA-Auth-Key.txt");
                //TODO: update path
          Scanner myReader = new Scanner(API_KEY);

          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
            TBA_AUTH_KEY = data;
          }

          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }

        return TBA_AUTH_KEY;
    }

    public static String callTheApi(String api_url, String API_KEY){
        try {
            return new BufferedReader(new InputStreamReader(new URL(api_url + "?X-TBA-Auth-Key=" + API_KEY).openStream())).readLine();
        } catch (Exception ignored) {
            return "Failed to get.";
        }
    }
}