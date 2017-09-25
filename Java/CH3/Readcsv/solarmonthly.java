import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class solarmonthly {

  static String[] thisLine = null;
  static String[] parsedLine = null;
  static final int ACPOSIT = 2;
  static final int NOXPOSIT = 3;
  static final int CO2POSIT = 4;
  static final int SO2POSIT = 5;

  SimpleDateFormat dformat = new SimpleDateFormat("M/dd/yy hh:mm");

  public static File findfile() {
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "CSV files", "csv");
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(chooser);
    File file = chooser.getSelectedFile();
    return file;
  }
  public static String[] buildLineArray(int hdrlines, int filelines, File file) {
	      try {
		         // open input stream for reading purpose.
		         BufferedReader br = new BufferedReader(new FileReader(file));

		         // strip header lines
	             for (int cnt = 0; cnt < hdrlines; cnt++) thisLine[cnt] = br.readLine();
		             for (int cnt = 0; cnt < filelines; cnt++) {
		        	        thisLine[cnt] = br.readLine();
		              }
		      }catch(Exception e){
		         e.printStackTrace();
		      }  // end of catch
	      return thisLine;
	}

  public void getlines(File file) { /*
    String cvsSplitBy = ",";
    BufferedReader br = null; // needs to be initialized outside of try for Following
    // catch statements
    int i = 1;
    try {
      br = new BufferedReader(new FileReader(file));
      String line = br.readLine();

      while(line != null) {
        String parsedLine[] = line.split(cvsSplitBy);
        if((Double.valueOf(line)). {

        }
        i++;
      }

    } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } */
  }

  public static void main(String[] args) {
    String cvsSplitBy = ",";
    double[] spdarray, NOX_array, CO2_array, SO2_array, ACPWR_array = null;
    double xsum, ysum, xsqsum, ysqsum,xyprod, pwrsum, noxsum, co2sum, so2sum, pwravg, pwrsq = 0;
    double pwrnoxprod, pwrco2prod, pwrso2prod, coeffa_co2, coeffb_co2, coeffa_so2, coeffb_so2, coeffa_nox, coeffb_nox = 0;
    double denominator, sum, average = 0;
    int spdcntr, hdrlines, nrlines, nrdays;
    Scanner invalue = new Scanner(System.in);
    DecimalFormat dfmt = new DecimalFormat("###.###");
    DecimalFormat coeff = new DecimalFormat("0.#####");

    File file = findfile();


  }
}
