public class ArrayIntro {
  public static void main( String[] args ) {
    String[] planets = {"Mercury", "Venus", "Earth", "Mars",
                        "Jupiter", "Saturn", "Uranus", "Neptune" };

    for ( String p : planets ) {
      System.out.println( p + "\t" + p.toUpperCase() );
    }

    String[] household = {"Steph", "Mike", "Henry", "Roter Ampelmann", "Gruener Ampelmann"};

    for ( String h : household ) {
      System.out.println( h + " is part of the family!" );
    }
  }
}
