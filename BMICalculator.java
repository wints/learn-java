import java.util.Scanner;

public class BMICalculator {
  public static void main ( String[] args ) {
    Scanner keyboard = new Scanner(System.in);
    double ft, in, tin, m, lb, kg, bmi;

    System.out.print( "Your height (feet only): " );
    ft = keyboard.nextDouble();
    System.out.print( "Your height (inches only): " );
    in = keyboard.nextDouble();
    tin = ft*12 + in;
    m = tin * 0.025;

    System.out.print( "Your weight in pounds: ");
    lb = keyboard.nextDouble();
    kg = lb * 0.45;

    bmi = kg / (m*m);

    System.out.println( "Your BMI is " + bmi );

  }
}
