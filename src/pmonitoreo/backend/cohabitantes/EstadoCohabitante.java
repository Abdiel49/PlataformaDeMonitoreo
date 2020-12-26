package pmonitoreo.backend.cohabitantes;

public class EstadoCohabitante {

  private final String Color, Motivo;

  public EstadoCohabitante(String color, String motivo) {
    this.Color = color;
    this.Motivo = motivo;
  }

  public String getColor() {
    return Color;
  }

  public String getMotivo() {
    return Motivo;
  }
}
