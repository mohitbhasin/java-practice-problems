package javaNet;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestCallUsingHttpClient {
    public static void main(String[] args) throws Exception {
        modernWayUsingHttpClient();
    }

    // Java 11+ introduced java.net.http.HttpClient which is the current standard.
    // It is much clearner and has fluent api (like builder pattern) that handles async request easily.
    // Core Java does not include a built-in JSON parser.
    // The call will fetch raw string,
    // however library such as Jackson or Gson is required to convert string into Java Object.
    public static void modernWayUsingHttpClient() throws Exception {
        // create the client
        HttpClient httpClient = HttpClient.newHttpClient();

        // create the request
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .GET()
                .build();

        // send the request and get the response
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        // print result
        System.out.println("status code: "+httpResponse.statusCode());
        System.out.println("response body: "+httpResponse.body());
    }
}
