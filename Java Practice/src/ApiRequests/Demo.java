package ApiRequests;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class Demo {

	public static void main(String[] args) {
		
		HttpClient client = HttpClient.newHttpClient();
		
//		Gson gson = new Gson();
//		Question question = new Question(
//				"Tallest mountain in the world?", 
//				"Fuji", 
//				"Everest", 
//				"Mt1", 
//				"Mt2", 
//				"Everest", 
//				"Easy", 
//				"Geography");

//		String req = gson.toJson(question);
		
		try {
			
//			HttpRequest httpRequest = HttpRequest.newBuilder()
//					.uri(new URI("http://localhost:8080/api/question"))
//					.header("Content-Type", "application/json")
//					.POST(BodyPublishers.ofString("{\r\n"
//							+ "    \"questionTitle\": \"How many bits in 1 byte?\",\r\n"
//							+ "    \"option1\": \"15\",\r\n"
//							+ "    \"option2\": \"8\",\r\n"
//							+ "    \"option3\": \"16\",\r\n"
//							+ "    \"option4\": \"5\",\r\n"
//							+ "    \"answer\": \"8\",\r\n"
//							+ "    \"difficultyLevel\": \"Easy\",\r\n"
//							+ "    \"category\": \"Technology\"\r\n"
//							+ "}"))
//					.build();

			
			HttpRequest httpRequest = HttpRequest.newBuilder()
					.uri(new URI("https://random-word-api.herokuapp.com/word?length=7"))
					.header("Content-Type", "application/json")
					.GET()
					.build();
			
			HttpResponse<String> res = client.send(httpRequest, BodyHandlers.ofString());
			System.out.println(res.body());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
