package pmonitoreo.backend.cohabitantes;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.LinkedList;
import java.util.List;

public class CSVReader {

  private final String absolutePath;
  private String fileId;

  public CSVReader() {
    absolutePath = "src/pmonitoreo/backend/cohabitantes/";
  }

  public List<String[]> readData() {

    List <String[]> dataCSV = null;
    try {
      String path = absolutePath + "cohabitantes.csv";
      BufferedReader csvReader = Files.newBufferedReader( Paths.get( path ));
      String line;
      dataCSV = new LinkedList<>();
      while( (line = csvReader.readLine()) != null ){
        String[] data = line.split(",");
        dataCSV.add(data);
      }
    }catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return dataCSV;
  }
  public void saveCohabitanteStatus(int id, CondicionSanitaria condicionSanitaria){
    String path = absolutePath + "cohabitantes.csv";
    /*try {     // method with BufferedWriter -> Files.newBufferedWriter(Paths.get(_path_))
      BufferedWriter writer = Files.newBufferedWriter(Paths.get(path), Charset.forName("UTF-8"), StandardOpenOption.APPEND);
      String[] datas = condicionSanitaria.getCondicionSanitaria();
      String rowInfo = String.join(",", datas);
      writer.write(rowInfo);
      writer.newLine();
      System.out.println("Se a escrito en el documento");
    }catch (IOException e){
      System.out.println(e);
    }*/

    // using CSVReader library
    
  }
}
