import java.net.URL;
import java.util.Scanner;
//import java.util.Locale;

public class LowestTemperature {
  public static void main(String[] args ) throws Exception {
    String urlbase = "http://learnjavathehardway.org/txt/";
    double[] temps = arrayFromUrl(urlbase + "avg-daily-temps-atx.txt");

    System.out.println( temps.length + " temperatures in database." );

    double lowest = 9999.99, highest = 0000.01;

    for ( int i=0; i<temps.length; i++ ) {
      if (temps[i] < lowest ) {
        lowest = temps[i];
      }
    }

    for ( int i=0; i<temps.length; i++ ) {
      if (temps[i] > highest ) {
        highest = temps[i];
      }
    }

    System.out.print( "The lowest average daily temperature was " );
    System.out.println( lowest + "F (" + fToC(lowest) + "C)" );

    System.out.print( "The highest average daily temperature was " );
    System.out.println( highest + "F (" + fToC(highest) + "C)" );
  }

  public static double[] arrayFromUrl( String url ) throws Exception {
    Scanner fin = new Scanner((new URL(url)).openStream());
    //fin.useLocale(Locale.US);
    int count = fin.nextInt();

    double[] dubs = new double[count];

    for ( int i=0; i<dubs.length; i++ )
      dubs[i] = fin.nextDouble();
    fin.close();

    return dubs;
  }

  public static double fToC( double f ) {
    return (f-32)*5/9;
  }
}
