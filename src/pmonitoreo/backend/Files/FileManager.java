package pmonitoreo.backend.Files;

import java.util.List;

public interface FileManager {
  List<String> readFileFromPath(String relativePath);
  void writeInFileOfPath(String data, String relativePath);
}
