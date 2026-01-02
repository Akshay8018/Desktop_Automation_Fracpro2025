package com.agentic.windows_automation_ai.agents;

import com.agentic.windows_automation_ai.utils.EnvConfig;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AIFailureAnalyzer {

    public static String analyze(String error, String uiTree) {
        try {
            JSONObject payload = new JSONObject();
            payload.put("model", "gpt-5.2");

            JSONArray messages = new JSONArray();
            messages.put(new JSONObject()
                    .put("role", "system")
                    .put("content", "You are a Windows desktop automation expert."));
            messages.put(new JSONObject()
                    .put("role", "user")
                    .put("content",
                            "Failure: " + error +
                            "\nUI Tree:\n" + uiTree +
                            "\nExplain the root cause and suggest a fix."));

            payload.put("messages", messages);
            payload.put("temperature", 0.2);

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
                    .getString("content");

        } catch (Exception e) {
            e.printStackTrace();
            return "AI Failure Analyzer Error: " + e.toString();
        }
    }
}
