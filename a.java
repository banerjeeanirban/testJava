import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
​
public class App
{
  public static void main( String[] args ) throws Exception
  {
    //Here will be your code
  }
}
​
// Host url
      String host = "https://movie-database-imdb-alternative.p.rapidapi.com/";
      String charset = "UTF-8";
      // Headers for a request
      String x_rapidapi_host = "movie-database-imdb-alternative.p.rapidapi.com";
      String x_rapidapi_key = <YOUR_RAPIDAPI_KEY>;//Type here your key
      // Params
      String s = "Pulp";
  // Format query for preventing encoding problems
      String query = String.format("s=%s",
       URLEncoder.encode(s, charset));
​
​
HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
      .header("x-rapidapi-host", x_rapidapi_host)
      .header("x-rapidapi-key", x_rapidapi_key)
      .asJson();
    System.out.println(response.getStatus());
      System.out.println(response.getHeaders().get("Content-Type"));
​
// Host, charset and headers vars should be the same
      String i = "tt0110912";
  // Format query for preventing encoding problems
      query = String.format("i=%s",
       URLEncoder.encode(i, charset));      
      // Json response
      HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
      .header("x-rapidapi-host", x_rapidapi_host)
      .header("x-rapidapi-key", x_rapidapi_key)
      .asJson();
  //Prettifying
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      JsonParser jp = new JsonParser();
      JsonElement je = jp.parse(response.getBody().toString());
      String prettyJsonString = gson.toJson(je);
      System.out.println(prettyJsonString);
​
// Host url
      String host = "https://ronreiter-meme-generator.p.rapidapi.com/meme";
      String charset = "UTF-8";
      // Headers for a request
      String x_rapidapi_host = "ronreiter-meme-generator.p.rapidapi.com";
      String x_rapidapi_key = <YOUR_RAPIDAPI_KEY>;
      // Params
      String meme = "Chuck-Norris-Approves";
      String top = "We made this meme with Chuck";
      String bottom = "Although we weren't even connected to the internet";
​
      String query = String.format("meme=%s&top=%s&bottom=%s",
       URLEncoder.encode(meme, charset),
       URLEncoder.encode(top, charset),
       URLEncoder.encode(bottom, charset));
​
      // Meme generator
      HttpResponse httpResponse = Unirest.get(host + "?" + query)
      .header("x-rapidapi-host", x_rapidapi_host)
      .header("x-rapidapi-key", x_rapidapi_key)
      .asBinary();
  //Image saving
      InputStream is = httpResponse.getRawBody();
      BufferedImage inputStreamImage = ImageIO.read(is);
      File image = new File("image.jpg");
      ImageIO.write(inputStreamImage, "jpg", image);
      System.out.println( httpResponse.getHeaders()
.get("Content-Type"));
​
