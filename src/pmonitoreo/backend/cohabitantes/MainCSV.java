package pmonitoreo.backend.cohabitantes;

public class MainCSV {
  public static void main(String[] args){
    CSVReader csv = new CSVReader();
//    csv.readData();
    String[][] data = {
      {"1", "ibai", "37.5", "12-12-2020 08:08"},
      {"3", "beniju", "36.3", "12-12-2020 08:12"},
      {"2", "rodolfo", "35.0", "12-12-2020 08:16"},
      {"4", "kitty", "37.3", "12-12-2020 08:23"}
    };

    for(String[] row : data){
      String r = String.join(",", row);
//      System.out.println("row:\t" + r);
    }

    String date = "12-12-2020 08:12";
    double temp = 36.7;
    CondicionSanitaria condicionSanitaria = new CondicionSanitaria(date, temp);
    csv.saveCohabitanteStatus(5,condicionSanitaria);
  }
}
