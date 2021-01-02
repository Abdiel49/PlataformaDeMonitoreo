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
  private final String absolutePath;
  public CohabitanteServer (){
    this.absolutePath = "src/pmonitoreo/backend/cohabitantes/";
    this.csvController = new CSVController( absolutePath );
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
    String relativePath = "cohabitantes.csv";
    List<String[]> condicionSanitaria = csvController.readCSVFileFromRelativePath(idUsuario, relativePath);
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
    String relativePath = "cohabitantes.csv";
    String[] lineCondicionSanitaria ={
        idUsuario+"",
        condicionSanitaria.getFecha().toString(),
        condicionSanitaria.getNombreCondicion(),
        condicionSanitaria.getValorCondicion()
    };
    csvController.writeInCSVFileOnRelativePath(lineCondicionSanitaria, relativePath);
  }

  @Override
  public List<Cohabitante> obtenerListaDeCohabitantes() {
    return this.listCohabitantes;
  }

  @Override
  public Cohabitante obtenerCohabitante(int idUsuario) {
    return mapCohabitantes.get(idUsuario+"");
  }

  @Override
  public void cambiarEstadoCohabitante(int idUsuario, EstadoCohabitante estadoCohabitante) {
    if(mapCohabitantes.containsKey(idUsuario+"")){
      Cohabitante cohabitante = mapCohabitantes.get(idUsuario+"");

    }
  }



}
