package pmonitoreo.backend.Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class ReaderAndWriterFiles implements FileManager {
  String absolutePath;
  private static ReaderAndWriterFiles readerAndWriterFiles = null;
  private static ReaderAndWriterFiles csvFile = null;

  private ReaderAndWriterFiles(String absolutePath ) {
    this.absolutePath = absolutePath;
  }

  private ReaderAndWriterFiles(){
    this.absolutePath = "";
  }

  /*private static void createInstance(String absolutePath){
    if ( readerAndWriterFiles == null){
      if (absolutePath.length() > 0)
        readerAndWriterFiles = new ReaderAndWriterFiles(absolutePath);
      else readerAndWriterFiles = new ReaderAndWriterFiles();
    }
  }

  public static FileManager getInstance(String absolutePath){
    if (readerAndWriterFiles == null){
      createInstance(absolutePath);
    }
    return  readerAndWriterFiles;
  }*/

  @Override
  public List<String> readFileFromPath(String realativePath) {
    List<String> dataCSV = null;
    absolutePath += realativePath;
    try {
      BufferedReader csvReader = Files.newBufferedReader( Paths.get(absolutePath));
      dataCSV = new LinkedList<>();
      String lineData;
      while( (lineData = csvReader.readLine() ) != null){
        if(lineData.length() > 0) {
          dataCSV.add(lineData);
        }
      }
      csvReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return dataCSV;
  }

  @Override
  public void writeInFileOfPath(String data, String relativePath) {
    absolutePath += relativePath;
    try {
      BufferedWriter writer = Files.newBufferedWriter(
              Paths.get(absolutePath),
              StandardOpenOption.APPEND);
      writer.write(data);
      writer.newLine();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
