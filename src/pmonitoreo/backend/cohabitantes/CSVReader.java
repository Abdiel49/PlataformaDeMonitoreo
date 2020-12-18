package pmonitoreo.backend.cohabitantes;


import java.io.BufferedReader;
import java.io.FileNotFoundException;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CSVReader {

  private final String absolutePath;

  public CSVReader() {
    absolutePath = "src/pmonitoreo/backend/cohabitantes/";
  }

  public List<String[]> getData() {

    List <String[]> dataCSV = null;
    try {
      String path = absolutePath + "cohabitantes.csv";
      BufferedReader csvReader = Files.newBufferedReader( Paths.get( path ));
      String line;
      dataCSV = new LinkedList<>();
      while( (line = csvReader.readLine()) != null ){
        String[] data = line.split(",");
        dataCSV.add(data);
        System.out.println(Arrays.toString(data));
      }
    }catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return dataCSV;
  }
  public void whiteData(){

  }
}
