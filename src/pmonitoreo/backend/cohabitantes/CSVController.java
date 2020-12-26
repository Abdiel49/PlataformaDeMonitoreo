package pmonitoreo.backend.cohabitantes;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.LinkedList;
import java.util.List;

public class CSVController {

  private final String absolutePath;
//  private String fileId;

  public CSVController() {
    absolutePath = "src/pmonitoreo/backend/cohabitantes/";
  }

  public List<String[]> readCondicionSanitaria(int id) {
    List <String[]> dataCSV = null;
    String path = absolutePath + "cohabitantes.csv";
    try {
      BufferedReader csvReader = Files.newBufferedReader( Paths.get( path ));
      dataCSV = new LinkedList<>();
      String line;
      while( (line = csvReader.readLine()) != null ){
        String[] data = line.split(",");
        if( data[0].equals(id+"") ){
          dataCSV.add(data);
        }
      }
      csvReader.close();
    }catch (IOException e) {
      e.printStackTrace();
    }
    return dataCSV;
  }
  public void saveCondicionSanitaria(int id, CondicionSanitaria condicionSanitaria) {
//    if()
    String path = absolutePath + "cohabitantes.csv";

    try {
      BufferedWriter writer = Files.newBufferedWriter(Paths.get(path), StandardOpenOption.APPEND);
      String rowInfo =
          id+","+
          condicionSanitaria.getFecha().toString()+","+
          condicionSanitaria.getNombreCondicion()+","+
          condicionSanitaria.getValorCondicion();

      writer.write("\n"+rowInfo);
      writer.close();
    }catch (IOException e){
      e.printStackTrace();
    }
  }


}
