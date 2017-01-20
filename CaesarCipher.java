import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

public class CaesarCipher {
  /**
   * Returns the character shifted by the given number of letters.
   */
   public static char shiftLetter( char c, int n) {
     int u = c;

     if (! Character.isLetter(c) )
      return c;

     u = u + n;
     if ( Character.isUpperCase(c) && u > 'Z'
       || Character.isLowerCase(c) && u > 'z' ) {
         u -= 26;
       }
     if ( Character.isUpperCase(c) && c < 'A'
       || Character.isLowerCase(c) && u < 'a') {
         u += 26;
       }

     return (char)u;
  }

  public static void main( String[] args ) throws Exception {
    String input = "text-to-encrypt.txt", cipher = "", readFile;
    int shift;
    Scanner keyboard = new Scanner(System.in);
    Scanner fileScramblr = new Scanner(new File(input));
    PrintWriter scrambled = new PrintWriter("encrypted-text.txt");

    System.out.print("Collecting file... ");
    readFile = fileScramblr.nextLine();
    fileScramblr.close();
    System.out.print("Shift (0-26): ");
    shift = keyboard.nextInt();

    for ( int i=0 ; i<readFile.length(); i++ ) {
      cipher += shiftLetter( readFile.charAt(i), shift );
    }
    scrambled.println( cipher );
    scrambled.close();
  }
}
