import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.MathContext;

public class ReceiptRevisited {
  public static void main( String[] args ) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    PrintWriter fileout = new PrintWriter("receipt.txt");
    Double gallons, total;

    System.out.println("How much gas do ya want? ");
    gallons = keyboard.nextDouble();
    total = (gallons * 3.459);
    BigDecimal bd = new BigDecimal(total);
    bd = bd.round(new MathContext(3));
    double rounded = bd.doubleValue();

    fileout.println( "+------------------------+" );
    fileout.println( "|                         " );
    fileout.println( "|      CORNER STORE       " );
    fileout.println( "|                         " );
    fileout.println( "| 2014-06-25  04:38PM     " );
    fileout.println( "|                         " );
    fileout.println( "| Gallons:       "+gallons );
    fileout.println( "| Price/gallon: $ 3.459   " );
    fileout.println( "|                         " );
    fileout.println( "| Fuel total:  $ " + rounded  );
    fileout.println( "|                         " );
    fileout.println( "+------------------------+" );
    fileout.close();
  }
}
