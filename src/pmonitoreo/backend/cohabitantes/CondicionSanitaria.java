package pmonitoreo.backend.cohabitantes;

import java.time.LocalDateTime;


public class CondicionSanitaria {

  private final LocalDateTime fecha;
  private final String  nombreCondicion, valorCondicion;

  public CondicionSanitaria (LocalDateTime date, String nombreCondicion, String valorCondicion) {
    this.fecha = date;
    this.nombreCondicion = nombreCondicion;
    this.valorCondicion = valorCondicion;
  }

  public LocalDateTime getFecha() {
    return fecha;
  }

  public String getNombreCondicion() {
    return nombreCondicion;
  }

  public String getValorCondicion() {
    return valorCondicion;
  }
}
