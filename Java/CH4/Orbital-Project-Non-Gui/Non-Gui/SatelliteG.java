import java.util.InputMismatchException;
public class SatelliteG {
  String sName, oName;
  double radius = 0, mass = 0;
  private double altitude, oPeriod, oVelocity;
  private String oType; // 0 = Solar orbit; 2 = Mars orbit
  private String powerType; //"battery", "solar", "nuclear"
  public String[] powerTypeSel = {"battery", "solar", "nuclear"};
  final static double ERADIUS = 6.638e6;
  final static double EMASS = 5.98e24;
  final static double UGRAV = 6.673e-11;
  final static double SRADIUS = 6.96E8;
  final static double SMASS = 1.99e30;
  final static double MRADIUS = 3.386e6;
  final static double MMASS = 6.4171e23;

  // Constructor
  public SatelliteG(String name, double alt, String oname, String otype) {
    sName = name;
    //System.out.println(oName);
    altitude = alt;
    //System.out.println(altitude);
    oName = oname;
    //System.out.println(sName);
    oType = otype;
    //System.out.println(oType);
  }

  // Main Functions
  public double sec2min(double sec) { return sec / 60; }
  public double mps2mph(double mps) { return mps * 2.2369; }

  public void setPwrType() {
    int j = 1, res = 0;
      System.out.println("Please select a Power Type: ");
      for(String i : powerTypeSel)
        System.out.println(i + "\t\t" + j++);
    while(true){
      try {
        res = Orbits.scan.nextInt();
        switch(res) {
          case 1: powerType = "battery"; break;
          case 2: powerType = "solar"; break;
          case 3: powerType = "nuclear"; break;
          default: System.out.println("Not an Option"); break;
        }
        break;
      } catch(Exception ex) { System.out.println(ex + " Try again:"); }
    }
 }

  public void MassRadsel() { // Method for selecting Mass and Radius and Power type through orbit type (oType)
    switch (oType) {
      case "Earth":
        radius = ERADIUS;
        mass = EMASS;
      break;

      case "Mars":
        radius = MRADIUS;
        mass = MMASS;
      break;

      case "Sun":
        radius = SRADIUS;
        mass = SMASS;
      break;

      default:
        System.out.println("Something went wrong in MassRadsel");
      break;
    }
  }

  public void oVelocity__period() {
    oVelocity = Math.sqrt((UGRAV * mass) / (radius + altitude));
    oPeriod = (2.0 * Math.PI * (radius + altitude)) / oVelocity;
//    System.out.println(oVelocity + " " + oPeriod);

    System.out.println("Orbital Velocity: " + Orbits.dfmt.format(oVelocity) + " m/s or " + Orbits.dfmt.format(mps2mph(oVelocity)) + " mph");
    System.out.println("Orbital Period: " + Orbits.dfmt.format(oPeriod) + " seconds or " + Orbits.dfmt.format(sec2min(oPeriod)) + " minutes");
  }

  public void oSel(String newOrbit) { // change of orbit type inhibited by orbit file
    switch(newOrbit) {
      case "Earth": oType = "Earth"; break;
      case "Mars": oType = "Mars"; break;
      case "Sun": oType = "Sun"; break;
      default: System.out.println("Check switch in case 4 of menu");
    }
  }

  public String toString() {
    return "Satellite name: " + sName + "\nOrbit Altitude: " + altitude + "\nOrbiting Planet: " + oType + "\nOrbit Type: " + oName + "\n";
  }

}
