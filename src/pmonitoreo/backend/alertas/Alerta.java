package pmonitoreo.backend.alertas;

import java.util.Date;
import java.util.List;

public class Alerta implements Alertas{

  private final int id;
  private final int  idCohab;
  private final Date fecha;
  private final String status;
  private final String descripcion;

  public  Alerta(int id, int idCohab, Date fecha, String status, String descripcion){
    this.id = id;
    this.idCohab = idCohab;
    this.fecha = fecha;
    this. status = status;
    this.descripcion = descripcion;
  }

  public int getId(){
    return id;
  }


  public int getIdCohab(){
    return idCohab;
  }

  public Date getFecha(){
    return fecha;
  }

  public String getStatus(){
    return status;
  }

  public String getdescripcion(){ return descripcion; }

  @Override
  public void eliminarAlerta(int id) {

  }

  @Override
  public void agregarAlerta(Alerta alerta) {

  }

  @Override
  public List<Alerta> getAlertas() {
    return null;
  }

  @Override
  public List<Alerta> getAlertasxCohab(int id) {
    return null;
  }
}
