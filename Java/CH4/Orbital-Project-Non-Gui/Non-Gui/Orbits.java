import java.util.*;
import java.text.DecimalFormat;
import java.lang.*;

public class Orbits {
  public static Scanner scan = new Scanner(System.in);
  public static DecimalFormat dfmt = new DecimalFormat("###.###");
  public static Satellite[] sat = new Satellite[5];
  public static Satellite csat;
  static int res = 0;

  public static void menu() {

    System.out.println("\n    Satellite control Panel");
    System.out.println("|*********************************|");
    System.out.println("| Print all Satellites\t\t1 |");
    System.out.println("| Select a Satellite\t\t2 |");
    System.out.println("| Update satellite velocity\t3 |");
    System.out.println("| Change satellite orbit type\t4 |");
    System.out.println("| Chanage satellite power type\t5 |");
    System.out.println("| Quit\t\t\t\t0 |");
    System.out.println("|*********************************|");

    res = scan.nextInt();

    switch (res) {
      case 1: // print ALL satellites
        for(int i = 0; i < 5; i++) System.out.println(sat[i]);
        System.out.println("\nCurrent Selected Satellite:\n" + csat);
      break;

      case 2: // satellite select
        satsel();
      break;

      case 3: // Mass and Radius select for the proper Velocity and Period calculations
        csat.MassRadsel();
        csat.oVelocity__period();
      break;

      case 4:
        String newOrbit = "";
        while(true) { // This will allow the user to select a new orbit planet
          System.out.println("Change orbit to which planet?");
          System.out.println("Earth\t\t1\nMars\t\t2\nSun\t\t3\n");
          res = scan.nextInt();
          switch(res) {
            case 1: newOrbit = "Earth"; break;
            case 2: newOrbit = "Mars"; break;
            case 3: newOrbit = "Sun"; break;
            default: System.out.println("Not an Option"); break;
          }
          break;
        }
        csat.oSel(newOrbit); // changes orbit type in satellite file
      break;

      case 5:
        csat.setPwrType();
      break;

      case 0:
        System.out.println("GoodBye!");
        System.exit(0);
      break;

      default:
        System.out.println("You stupid");
      break;
    }
  }

  public static void satsel() {

    while(true) { // while is here so switch doesn't end after default
      System.out.println("Select a Satellite");
      System.out.println("ISS\t\t1\nMRO\t\t2\nJWST/Webb\t3\nSkylab\t\t4\nChinaSat\t5");
      int response = scan.nextInt();

      switch(response) {
        case 1:
          csat = sat[0];
          System.out.println(csat);
        break;

        case 2:
          csat = sat[1];
          System.out.println(csat);
        break;

        case 3:
          csat = sat[2];
          System.out.println(csat);
        break;

        case 4:
          csat = sat[3];
          System.out.println(csat);
        break;

        case 5:
          csat = sat[4];
          System.out.println(csat);
        break;

        default:
          System.out.println("Not an option");
        break;
      } // end switch
      break; // for ending while
    } // end while
  }
  public static void main(String[] args) {
    // List of possible satellites saved to array sat[i]
    for(int i = 0; i < 5; i++) {
      sat[0] = new Satellite("ISS", 408000.0, "Low Earth Orbit", "Earth");
      sat[1] = new Satellite("MRO", 2.85e5, "Near-polar orbit", "Mars");
      sat[2] = new Satellite("Webb", 1.609344e9, "Solar orbit", "Sun");
      sat[3] = new Satellite("Skylab", 234964, "Low Earth Orbit", "Earth");
      sat[4] = new Satellite("ChinaSat", 3.58e7, "Geo Sationary", "Earth");
    }
    satsel(); // init csat selection
    csat.setPwrType(); // init power type selection

    while(true) menu(); // will run indefinatly

  }

}
