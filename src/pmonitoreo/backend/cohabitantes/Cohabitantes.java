package pmonitoreo.backend.cohabitantes;

import java.util.List;

public interface Cohabitantes {

  boolean validarUsuario(int idUsuario);

  List<CondicionSanitaria> obtenerListaDeCondicionesSanitarias(int idUsuario);

  void registrarCondicionSanitaria(int idUsuario, CondicionSanitaria condicionSanitaria);

  List<CohabitanteServer> obtenerListaDeCohabitantes();

  CohabitanteServer obtenerCohabitante(int idUsuario);

  void cambiarEstadoCohabitante(int idUsuario, EstadoCohabitante estadoCohabitante);

}
