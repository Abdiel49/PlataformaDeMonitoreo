package pmonitoreo;

import pmonitoreo.backend.alertas.Alerta;
import pmonitoreo.backend.alertas.Alertas;
import pmonitoreo.backend.cohabitantes.CohabitantesServer;
import pmonitoreo.backend.cohabitantes.Cohabitantes;
import pmonitoreo.cohabitante.CohabitanteUI;
import pmonitoreo.cohabitante.MovilCohabitante;

import java.util.Date;

public class Main {

  public static void main(String[] args) {
    Alertas alertas = new Alerta(4, 3, new Date(), "normal", "Sin sintomas");
    Cohabitantes cohabitanteServer = new CohabitantesServer();
    MovilCohabitante mobilCohabitante = new CohabitanteUI(cohabitanteServer, alertas);
    mobilCohabitante.show();
  }

}
