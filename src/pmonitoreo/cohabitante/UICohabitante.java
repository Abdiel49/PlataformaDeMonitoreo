package pmonitoreo.cohabitante;


public interface UICohabitante extends PanelManager{
  void reportarEstado(StatusType status);
  void solicitarPrueba();
}
