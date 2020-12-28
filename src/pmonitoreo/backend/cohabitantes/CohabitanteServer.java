package pmonitoreo.backend.cohabitantes;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * CondicionSanitaria.csv -> una por cohabitante
 * Cohabitantes.csv ->  maneja el EstadoCohabitante
 */
public class CohabitanteServer implements Cohabitantes{

  private final CSVController csvController;
  private final Map<String, Cohabitante> mapCohabitantes;
  private final List<Cohabitante> listCohabitantes;

  public CohabitanteServer (){
    this.csvController = new CSVController();
    this.listCohabitantes = new LinkedList<>();
    mapCohabitantes = new HashMap<>();
  }

  @Override
  public boolean validarUsuario(int idUsuario) {
    int ID = 1;
    String userName = "ibai";
    String name = "Ibai Llanos";
    String color = "green";
    String motivo = "Sin sintomas";
    EstadoCohabitante estado = new EstadoCohabitante(color, motivo);
    Cohabitante cohabitante = new Cohabitante(ID, userName, name, estado);
    mapCohabitantes.put(ID+"", cohabitante);
    listCohabitantes.add(cohabitante);
    return true;
  }

  @Override
  public List<CondicionSanitaria> obtenerListaDeCondicionesSanitarias(int idUsuario) {
    List<String[]> condicionSanitaria = csvController.readCondicionSanitaria(idUsuario);
    List< CondicionSanitaria > condicionSanitariaUsuario= null;
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
  public List<Cohabitante> obtenerListaDeCohabitantes() {
    return this.listCohabitantes;
  }

  @Override
  public Cohabitante obtenerCohabitante(int idUsuario) {
    String id = idUsuario+"";
    if ( mapCohabitantes.containsKey(id) ) {
      return mapCohabitantes.get(id);
    } else {
      return null;
    }
  }

  @Override
  public void cambiarEstadoCohabitante(int idUsuario, EstadoCohabitante estadoCohabitante) {

  }


}
