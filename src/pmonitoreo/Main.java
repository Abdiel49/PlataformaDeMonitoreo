package pmonitoreo;

import pmonitoreo.backend.cohabitantes.CohabitanteServer;
import pmonitoreo.backend.cohabitantes.Cohabitantes;
import pmonitoreo.cohabitante.Cohabitante;
import pmonitoreo.cohabitante.CohabitanteUI;

public class Main {

  public static void main(String[] args) {
    Cohabitantes cohabitanteServer = new CohabitanteServer();
    CohabitanteUI mobilCohabitante = new Cohabitante(cohabitanteServer);
    mobilCohabitante.show();
  }

}
