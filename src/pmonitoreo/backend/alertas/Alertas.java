package pmonitoreo.backend.alertas;

import java.util.List;

public interface Alertas {
  void eliminarAlerta(int id);
  void agregarAlerta(Alerta alerta);
  List<Alerta> getAlertas();
  List<Alerta> getAlertasxCohab(int id);
}