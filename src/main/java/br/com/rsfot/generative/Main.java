package br.com.rsfot.generative;

import java.net.URI;
import java.net.http.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://api.together.xyz/v1/chat/completions";
        String apiKey = "ec7da4ab8955a9ee52f857bc45a8ba5cec4b414123815819713f5ba1a58c1659";

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + apiKey);

        String data = "{"
                + "\"model\": \"mistralai/Mixtral-8x7B-Instruct-v0.1\","
                + "\"max_tokens\": 1024,"
                + "\"messages\": ["
                +     "{"
                +         "\"role\": \"system\","
                +         "\"content\": \"You are agente in the hunt the Wumpus\""
                +     "},"
                +     "{"
                +         "\"role\": \"user\","
                +         "\"content\": \"Do you know the game about Wumpus?\""
                +     "}"
                + "]"
                + "}";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .headers(headers.entrySet().stream()
                            .map(e -> Map.entry(e.getKey(), e.getValue()))
                            .flatMap(e -> List.of(e.getKey(), e.getValue()).stream())
                            .toArray(String[]::new))
                    .POST(HttpRequest.BodyPublishers.ofString(data))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
