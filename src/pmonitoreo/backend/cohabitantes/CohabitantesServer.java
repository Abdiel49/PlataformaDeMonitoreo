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
public class CohabitantesServer implements Cohabitantes{

  private final CSVController csvController;

  private final Map<String, Cohabitante> mapCohabitantes;
  private final List<Cohabitante> listCohabitantes;
  private final String absolutePath;

  public CohabitantesServer(){
    this.absolutePath = "src/pmonitoreo/backend/cohabitantes/";
    this.csvController = new CSVController( absolutePath );
    this.listCohabitantes = new LinkedList<>();
    mapCohabitantes = new HashMap<>();
  }

  @Override
  public boolean validarUsuario(int idUsuario) {
    String RELATIVE_PATH = "data/AuthCohabitantes.csv";
    List<String[]> cohabitanteFindById = csvController.readCSVFileFromRelativePath(idUsuario, RELATIVE_PATH);
    if( !cohabitanteFindById.isEmpty() ){
      int ID = Integer.parseInt(cohabitanteFindById.get(0)[0]);
      boolean isID = ID == idUsuario;
      if(isID){

        String[] data = cohabitanteFindById.get(0);
        String userName = data[1];
        String name = data[2];
        // get 'Estado Cohabitantes' data
        RELATIVE_PATH = "data/EstadoCohabitantes.csv";
        cohabitanteFindById = csvController.readCSVFileFromRelativePath(ID, RELATIVE_PATH);
        data = cohabitanteFindById.get(0);
        String color = data[3];
        String motivo = data[4];

        EstadoCohabitante estado = new EstadoCohabitante(color, motivo);
        Cohabitante cohabitante = new Cohabitante(ID, userName, name, estado);
        mapCohabitantes.put(ID+"", cohabitante);
        listCohabitantes.add(cohabitante);

        System.out.println("Se encontro el ususario con ID: "+idUsuario+"\t estado de busqueda: "+isID);
        System.out.println("Data:\tID: "+ID+"\tUser Name: "+userName+"\tName: "+name+"\tColor: "+color+"\tMotivo: "+motivo);
      }
    }else{
      // show a system error on validate user
      System.out.println("NO se encontro el ususario con ID: "+idUsuario);
    }

    return true;
  }

  private boolean idUserValid(){
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
    String relativePath = "data/CondicionesSanitarias/"+idUsuario+".csv";
//    String relativePath = "cohabitantes.csv";
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
    String IDUsuario = idUsuario+"";
    if(mapCohabitantes.containsKey(IDUsuario)){
      Cohabitante cohabitanteBefore = mapCohabitantes.get(idUsuario+"");
      int ID = cohabitanteBefore.getID();
      String userName = cohabitanteBefore.getUserName();
      String name = cohabitanteBefore.getName();

      Cohabitante cohabitanteAfter = new Cohabitante(ID, userName, name, estadoCohabitante);

      mapCohabitantes.remove(IDUsuario);
      mapCohabitantes.put(IDUsuario, cohabitanteAfter);
    }
  }



}
