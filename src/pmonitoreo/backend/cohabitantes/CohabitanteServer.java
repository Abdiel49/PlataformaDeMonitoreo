package pmonitoreo.backend.cohabitantes;

import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * CondicionSanitaria.csv -> una por cohabitante
 * Cohabitantes.csv ->  maneja el EstadoCohabitante
 */
public class CohabitanteServer implements Cohabitantes{

  private final CSVController csvController;

  public CohabitanteServer (){
    csvController = new CSVController();
  }

  @Override
  public boolean validarUsuario(int idUsuario) {
    return true;
  }

  @Override
  public List<CondicionSanitaria> obtenerListaDeCondicionesSanitarias(int idUsuario) {
    List<String[]> condicionSanitaria = csvController.readCondicionSanitaria(idUsuario);
    List< CondicionSanitaria > condicionSanitariaUsuario= null;
//    String dateFormat = "dd-MM-yyyy HH:mm";
//    DateTimeFormatter formatter =  DateTimeFormatter.ofPattern(dateFormat);
    if(condicionSanitaria != null){
      condicionSanitariaUsuario = new LinkedList<>();
      for (String[] info : condicionSanitaria){
        LocalDateTime date = LocalDateTime.parse(info[1]);
        String nombreCondicion = info[2];
        String valorCondicion = info[3];
        condicionSanitariaUsuario.add( new CondicionSanitaria( date, nombreCondicion, valorCondicion ) );
      }
    }

    return condicionSanitariaUsuario;
  }

  @Override
  public void registrarCondicionSanitaria(int idUsuario, CondicionSanitaria condicionSanitaria) {
    csvController.saveCondicionSanitaria(idUsuario,condicionSanitaria);
  }

  @Override
  public List<CohabitanteServer> obtenerListaDeCohabitantes() {
    return null;
  }

  @Override
  public CohabitanteServer obtenerCohabitante(int idUsuario) {
    return null;
  }

  @Override
  public void cambiarEstadoCohabitante(int idUsuario, EstadoCohabitante estadoCohabitante) {

  }


}
