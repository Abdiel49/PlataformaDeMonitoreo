package pmonitoreo.cohabitante;

import java.util.Date;

public class StatusType {

  /*private*/ final int id;
  /*private*/ final String user;
  /*private*/ final double temperature;
  /*private*/ final Date date;

  public StatusType( int id, String userName, double temperature, Date date){
    this.id = id;
    this.user = userName;
    this.temperature = temperature;
    this.date = date;
  }



}
