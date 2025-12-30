package com.agentic.windows_automation_ai.agents;

import com.agentic.windows_automation_ai.utils.EnvConfig;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AILocatorHealer {

    public static String heal(String elementDescription, String uiTree) {
        try {
            JSONObject payload = new JSONObject();
            payload.put("model", "gpt-5.2");

            JSONArray messages = new JSONArray();
            messages.put(new JSONObject()
                    .put("role", "system")
                    .put("content",
                            "You generate ONLY a valid locator. No explanation."));
            messages.put(new JSONObject()
                    .put("role", "user")
                    .put("content",
                            "Find Loctor for: " + elementDescription +
                            "\nUI Tree:\n" + uiTree));

            payload.put("messages", messages);
            payload.put("temperature", 0);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                    .header("Authorization", "Bearer " + EnvConfig.get("openai.key"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
                    .build();

            HttpResponse<String> response =
                    HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject json = new JSONObject(response.body());

            return json
                    .getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content")
                    .trim();

        } catch (Exception e) {
            e.printStackTrace();
            return "AI Locator Healer Error: " + e.toString();
        }
    }
}
