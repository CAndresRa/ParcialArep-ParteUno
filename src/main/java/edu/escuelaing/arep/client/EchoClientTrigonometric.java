package edu.escuelaing.arep.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;

// Con base en https://www.baeldung.com/httpurlconnection-post

public class EchoClientTrigonometric {
    /**
     * Server for the client
     * @param args n/a
     * @throws IOException because of the libraries used in the implementation of sockets
     */
    public static void main(String[] args) throws IOException {
        URL url = new URL ("https://parcialarep1.herokuapp.com/");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        String tan = "tan";
        String jsonInputString = "{\"List\":"+0+",\"operation\":"+tan+"}";
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }

    }
}
