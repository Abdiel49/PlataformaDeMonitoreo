package pmonitoreo.backend.cohabitantes;

public class Cohabitante {
  private final int ID;
  private final String userName, name;
  private final EstadoCohabitante estadoCohabitante;

  public Cohabitante(int ID, String userName, String name, EstadoCohabitante estadoCohabitante) {
    this.ID = ID;
    this.userName = userName;
    this.name = name;
    this.estadoCohabitante = estadoCohabitante;
  }

  public int getID() {
    return ID;
  }

  public String getUserName() {
    return userName;
  }

  public String getName() {
    return name;
  }

  public EstadoCohabitante getEstadoCohabitante() {
    return estadoCohabitante;
  }
}
