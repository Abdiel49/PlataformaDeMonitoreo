package pmonitoreo.backend.cohabitantes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class mainLocalDate {
  public static void main(String[] args) {
    String dateFormat = "dd-MM-yyyy HH:mm";
    DateTimeFormatter formatter =  DateTimeFormatter.ofPattern(dateFormat);
    LocalDateTime time = LocalDateTime.now().withNano(0);
    System.out.println("LocalDate.now() :\t"+ time);
    String date = formatter.format(time);
    System.out.println("LocalDate to String:\t"+ date);


    LocalDateTime time2 = LocalDateTime.parse("26-12-2020 22:00", formatter);
    System.out.println("String to LocalDate:\t"+ time2);
    LocalDateTime furure = time2.plusMinutes(2);
    System.out.println("LocalDateTime plus 2 Minutes:\t"+ furure);
    if(time.isAfter(furure)){
      System.out.println("La hora de inicio\t"+time+"\tYA ES es dos minutos o MAS tarde");
    }else{
      System.out.println("La hora de inicio\t"+time+"\tAUN NO es dos minutos despues");
    }

    /*System.out.println("Dia:\t" + time2.getDayOfMonth());
    System.out.println("Mes:\t" + time2.getMonthValue());
    System.out.println("Anio:\t" + time2.getYear());
    System.out.println("Hora:\t" + time2.getHour());
    System.out.println("Minuto:\t" + time2.getMinute());*/


  }
}
