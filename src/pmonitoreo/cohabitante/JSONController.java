package pmonitoreo.cohabitante;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.json.simple.parser.ParseException;
//import com.faster

public class JSONController {

  public static JSONObject getJSONObjectFromFile( String path ){
    JSONObject object = null;
    try (Reader reader = new FileReader(path)) {
      JSONParser parser = new JSONParser();
      object = (JSONObject) parser.parse(reader);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return object;
  }


}
