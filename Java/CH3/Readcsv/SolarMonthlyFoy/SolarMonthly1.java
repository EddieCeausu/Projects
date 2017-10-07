import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//***********************************************************
//Solar Monthly
//IMPORTANT
// expects each row in the .cvs data file to be, in this order
//  - local time
//  - UTC time
//  - Aggregate AC Power
//  - NOx
//  - CO2
//  - SO2
// File name is hardwired in, first change is to prompt for path.
//***********************************************************
public class SolarMonthly1 {

    static String[] thisLine = null;
    static String[] parsedLine = null;
    static final int ACPOSIT = 2;
    static final int NOXPOSIT = 3;
    static final int CO2POSIT = 4;
    static final int SO2POSIT = 5;
    //
    // Following format is for time stamps in solar project .cvs files
    //
    SimpleDateFormat dformat = new SimpleDateFormat("M/dd/yy hh:mm");

    // good example from web: http://stackoverflow.com/questions/3504986/extract-time-from-date-string
    // String originalString = "2010-07-14 09:00:02";
    // Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(originalString);
    // String newString = new SimpleDateFormat("H:mm").format(date); // 9:00

    //  *********************************************************
    //  Method buildLineArray reads the file, line by line
    //  - opens input buffered stream to read file
    //  - discards specified number of header lines
    //  - loads array thisLine, one file line per array entry
    //  - returns thisLine
    //  **********************************************************
	public static String[] buildLineArray(int hdrlines, int filelines)
	{
	      try{
		         // open input stream for reading purpose.
		         BufferedReader br = new BufferedReader(new FileReader("hvanov_monthly.csv"));

		         // strip header lines
	             for (int cnt = 0; cnt < hdrlines; cnt++) thisLine[cnt] = br.readLine();
		         for (int cnt = 0; cnt < filelines; cnt++)
		         {
		        	    thisLine[cnt] = br.readLine();

		         }   // end of for
		      }catch(Exception e){
		         e.printStackTrace();
		      }  // end of catch
	      return thisLine;
	}

	public static void loadArrays(String[] lines, int days, double[] NOX, double[] CO2, double[] SO2, double[] PWR)
	{
		 String cvsSplitBy = ",";
        for (int cnt = 0; cnt < days; cnt++)
        {
        	   String[] parsedLine = null;
           parsedLine = lines[cnt].split(cvsSplitBy);
           // this line avoids problem with NaN measurements

       	   PWR[cnt] = Double.valueOf(parsedLine[ACPOSIT]);
       	   NOX[cnt] = Double.valueOf(parsedLine[NOXPOSIT]);
       	   CO2[cnt] = Double.valueOf(parsedLine[CO2POSIT]);
       	   SO2[cnt] = Double.valueOf(parsedLine[SO2POSIT]);
        }   // end of for

	}

	   public static void main(String[] args) throws Exception {
//
//  	Important data variables:  ALL HAVE MAGNITUDE SPECIFIED BY USER RESPONSE
//  TO NUMBER OF LINES PROMPT.  USER WILL ALSO IDENTIFY HOW MANY HEADER LINES
//   thisLine: an array, each array entry is a single line from the data file
//   parsedLine: a single line from the thisLine array.  It has multiple string fields
//   spdarray and datetime are used for program debug, they are specific fields
//   in the parsedLine strings
//

		      String cvsSplitBy = ",";
		      double [] spdarray = null;
		      String[] datetime = null;
		      double[] NOX_array;
		      double[] CO2_array;
		      double[] SO2_array;
		      double[] ACPWR_array;
		      double xsum, ysum, xsqsum, ysqsum,xyprod;
		      double pwrsum, noxsum, co2sum, so2sum;
		      double pwravg;
		      double pwrsq;
		      double pwrnoxprod, pwrco2prod, pwrso2prod;
		      double coeffa_co2, coeffb_co2;
		      double coeffa_so2, coeffb_so2;
		      double coeffa_nox, coeffb_nox;
		      double denominator;
		      int spdcntr;
		      int hdrlines;
		      int nrlines;
		      int nrdays;
		      int maxlocator = 0;
		      double sum = 0;
		      double average;

		      Scanner invalue = new Scanner(System.in);
		      DecimalFormat dfmt = new DecimalFormat("###.###");
		      DecimalFormat coeff = new DecimalFormat("0.#####");

		      System.out.print("Enter number of days in monthly file:");
		      nrdays = invalue.nextInt();
		      System.out.print("\nEnter number of header lines: ");
		      hdrlines = invalue.nextInt();

		      spdcntr = 1;
		      // initialize array by size

		      thisLine = new String[nrdays];
		      NOX_array = new double[nrdays];
		      CO2_array = new double[nrdays];
		      SO2_array = new double[nrdays];
		      ACPWR_array = new double[nrdays];

// static method buildLineArray creates an array of string
// each array entry is a single line from the input file
		      thisLine = buildLineArray(hdrlines, nrdays);

		      loadArrays(thisLine, nrdays, NOX_array, CO2_array, SO2_array, ACPWR_array);

// loadArrays will load four arrays.  There are nrdays items in each
// array.  Each is the daily value for the selected variable from the
// solar panel monthly report.

			     pwrsum = 0;
			     noxsum = 0;
			     co2sum = 0;
			     so2sum = 0;
			     pwrsq = 0;
			     pwrnoxprod = 0;
			     pwrco2prod = 0;
			     pwrso2prod = 0;
			     coeffa_co2 = 0;
			     coeffb_co2 = 0;
			 for (int i = 0; i < nrdays; i++)
			 {
				pwrsum += ACPWR_array[i];
				noxsum += NOX_array[i];
				co2sum += CO2_array[i];
				so2sum += SO2_array[i];
				pwrsq += Math.pow(ACPWR_array[i], 2);
				pwrnoxprod += (ACPWR_array[i]) * NOX_array[i];
				pwrco2prod += (ACPWR_array[i]) * CO2_array[i];
				pwrso2prod += (ACPWR_array[i]) * SO2_array[i];
			 }  // end of for
	         pwravg = pwrsum / nrdays;
	         System.out.println("Average power is: " + coeff.format(pwravg) + " KWatts");

// calculate coefficients
			 denominator = pwrsq * nrdays - Math.pow(pwrsum, 2);
			 coeffa_co2 = ((co2sum * pwrsq) - (pwrsum * pwrco2prod))/denominator;
			 coeffb_co2 = (nrdays * pwrco2prod - pwrsum * co2sum) / denominator;
			 System.out.println("CO2 Coefficient");
	//		 System.out.println("Y-intercept: " + coeff.format(coeffa_co2));
			 System.out.println("Pounds CO2 per kWhr: " + coeff.format(coeffb_co2));
             coeffa_nox = ((noxsum * pwrsq) - (pwrsum * pwrnoxprod))/denominator;
             coeffb_nox = (nrdays * pwrnoxprod - pwrsum * noxsum)/denominator;
             System.out.println("NOx Coefficient");
             System.out.println("Pounds NOx per kWhr: " + coeff.format(coeffb_nox));
	         coeffa_so2 = ((so2sum * pwrsq) - (pwrsum * pwrso2prod))/denominator;
	         coeffb_so2 = (nrdays * pwrso2prod - pwrsum * so2sum)/denominator;
	          System.out.println("SO2 Coefficient");
	          System.out.println("Pounds SO2 per kWhr: " + coeff.format(coeffb_so2));
		System.out.println("\n Estimating Reductions");
		System.out.print("  Enter Nr Panels to be added: ");


	   }  // end of main
}  // end of class
