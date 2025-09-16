package javaNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestCall {
    public static void main(String[] args) {
        httpFundamental();
    }

    public static void httpFundamental() {
        try {
            // Create url
            URL url = new URL("http://google.com");

            // Create HTTPURLConnection
            // Just a representation of the connection,
            // not the actual call to the server.
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            // Setting request method as get
            urlConnection.setRequestMethod("GET");

            // Set request header to accept a json response (optional but recommended)
            urlConnection.setRequestProperty("Accept", "application/json");

            // make a call and get the response code.
            // Typically, the response code is checked to be 200 OK before reading response body.
            // When the next call to getInputStream() is happening,
            // a new call to server will not be made.
            // The previous call's response will be buffered.
            // The call to the server will be made only one,
            // regardless of other methods for the url.
            int responseCode = urlConnection.getResponseCode();
            System.out.println(responseCode);

            // Reading response body.
            // Like mentioned above, call to server is already made when getResponseCode() was called.
            // If getInputStream() was called before getResponseCode(),
            // then like before, its response would have been used for getResponse().
            if(responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
            }
            urlConnection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
