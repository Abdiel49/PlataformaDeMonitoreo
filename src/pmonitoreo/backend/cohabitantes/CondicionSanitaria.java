package pmonitoreo.backend.cohabitantes;

public class CondicionSanitaria {

  private double Temperatura;
  private String Date;

  public CondicionSanitaria (String date, double temp) {
    this.Date = date;
    this.Temperatura = temp;
  }

  public String[] getCondicionSanitaria(){
    return new String[]{
        this.Date,
        this.Temperatura+""
    };
  }

}
