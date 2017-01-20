import java.util.Scanner;
import java.io.File;

class TemperatureSample {
  int month, day, year;
  double temperature;
}

public class TemperaturesByDate {
  public static void main(String[] args) throws Exception {
    //String site = "http://learnjavathehardway.org";
    //String path = "/txt/avg-daily-temps-with-dates-atx.txt";
    //Scanner inFile = new Scanner((new java.net.URL(site+path)).openStream());
    String hamburg = "hamburg.txt";
    Scanner tempGetter = new Scanner(new File(hamburg));


    TemperatureSample[] tempDB = new TemperatureSample[10000];
    int numRecords, i=0;

    while ( tempGetter.hasNextInt() && i < tempDB.length ) {
      TemperatureSample e = new TemperatureSample();
      e.month = tempGetter.nextInt();
      e.day   = tempGetter.nextInt();
      e.year  = tempGetter.nextInt();
      e.temperature = tempGetter.nextDouble();
      if ( e.temperature == -99 )
        continue;
      tempDB[i] = e;
      i++;
    }
    tempGetter.close();
    numRecords = i;

    System.out.println(numRecords + " daily temperatures loaded.");

    double total = 0, avg;
    int count = 0;
    for ( i=0; i<numRecords; i++) {
      if ( tempDB[i].month == 11 ) {
        total += tempDB[i].temperature;
        count++;
      }
    }

    avg = total / count;
    avg = roundToOneDecimal(avg);
    System.out.print("Average daily temperature over " + count);
    System.out.println( " days in November: " + avg);

    int minLoc = 0;
    for ( i=0; i<numRecords; i++) {
      if ( tempDB[i].month == 1 ) {
        if ( tempDB[i].temperature < tempDB[minLoc].temperature ) {
          minLoc = i;
        }
      }
    }

    System.out.println("Lowest temperature in January was: " + tempDB[minLoc].temperature );

    TemperatureSample ts = tempDB[5];
    System.out.println( ts );
  }


  public static double roundToOneDecimal( double d ) {
    return Math.round(d*10)/10.0;
  }
}
