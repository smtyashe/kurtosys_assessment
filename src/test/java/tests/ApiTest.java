package tests;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApiTest {


    @Test
    public void validateApiCallTest() throws Exception {

        final String API_URL = "https://www.kurtosys.com";
        final int TIMEOUT_MILLIS = 2000; // 2 seconds


            // Set up the connection
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get response status code
            int statusCode = connection.getResponseCode();
            assertEquals(200, statusCode, "Expected status code 200");

            // Get response time
            long startTime = System.currentTimeMillis();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            long responseTime = System.currentTimeMillis() - startTime;
            assertTrue(responseTime < TIMEOUT_MILLIS, "Response time is not less than 2 seconds");

            // Check server header
            String serverHeader = connection.getHeaderField("Server");
            assertEquals("Cloudflare", serverHeader, "Server header is not Cloudflare");

            // Clean up
            connection.disconnect();
        }
    }
}

