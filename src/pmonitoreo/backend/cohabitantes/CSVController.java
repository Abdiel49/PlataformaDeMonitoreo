package pmonitoreo.backend.cohabitantes;

import pmonitoreo.backend.Files.FileManager;
import pmonitoreo.backend.Files.ReaderAndWriterFiles;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.LinkedList;
import java.util.List;

public class CSVController {

  private final String absolutePath;
  private FileManager csvController;
//  private String fileId;

  public CSVController(String absolutePath) {
//    absolutePath = "src/pmonitoreo/backend/cohabitantes/";
    this.absolutePath = absolutePath;
    csvController = ReaderAndWriterFiles.getInstance(absolutePath);
  }

  public List<String[]> readCSVFileFromRelativePath(int id, String relativePath) {
    List <String[]> dataCSV = null;
    String path = absolutePath + relativePath;
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
  public void writeInCSVFileOnRelativePath(String[] lineInformation, String relativePath) {
    String path = absolutePath + relativePath;
    try {
      BufferedWriter writer = Files.newBufferedWriter(Paths.get(path), StandardOpenOption.APPEND);
      String lineData = String.join(",", lineInformation);
      writer.write("\n"+lineData);
      writer.close();
    }catch (IOException e){
      e.printStackTrace();
    }
  }


}
