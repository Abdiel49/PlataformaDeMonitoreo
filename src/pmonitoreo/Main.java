package pmonitoreo;

import pmonitoreo.backend.cohabitantes.CohabitanteServer;
import pmonitoreo.backend.cohabitantes.Cohabitantes;
import pmonitoreo.cohabitante.CohabitanteUI;
import pmonitoreo.cohabitante.MovilCohabitante;

public class Main {

  public static void main(String[] args) {
    Cohabitantes cohabitanteServer = new CohabitanteServer();
    MovilCohabitante mobilCohabitante = new CohabitanteUI(cohabitanteServer);
    mobilCohabitante.show();
  }

}
