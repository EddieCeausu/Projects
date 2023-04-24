/**
 * @Author: Edmond Ceausu <eddieceausu>
 * @Date:   2018-02-23T15:55:20-05:00
 * @Email:  eddieswim101@gmail.com
 * @Filename: DNAtoProtienSeq.java
 * @Last modified by:   eddieceausu
 * @Last modified time: 2018-08-23T17:55:08-04:00
 * @Copyright: © Edmond Ceausu 2018
 */



import java.util.*;
import java.util.regex.Pattern;

public class DNAtoProtienSeq {
  public static String seq = "";
  public static String finalSeq = "";
  public static Map<String, String> codonTable = new HashMap<String, String>();

  public static void main(String... args) {
    fillMap();
    boolean done = false;
    do {
      System.out.println("Enter your sequence: ");
      seq = new Scanner(System.in).nextLine();
      seq.toUpperCase();
      seq.replaceAll("\\s","").replaceAll("[^A-Za-z0-9]","").toLowerCase();
      if(Pattern.compile("[ATCG]").matcher(seq.toString()).find()) {
        //if(seq.length() % 3 == 0)
          done = true;
        } else
          System.out.println("Try again (Sequence can only contain A T G C and must be a multiple of 3)");
    } while(!done);

    transcription();
    System.out.println("\n " + translation().toUpperCase());
  }

  public static void transcription() {
    for(char i : seq.toCharArray())
      switch(i) {
        case 'T': finalSeq += "A"; break;
        case 'A': finalSeq += "U"; break;
        case 'C': finalSeq += "G"; break;
        case 'G': finalSeq += "C"; break;
      }
      //System.out.println(finalSeq);
  }

  public static String translation() {
    String base = "", protien = "";

    for(char i : finalSeq.toCharArray()) {
        base += i;
        if(base.length() == 3) {
      //  System.out.println(base);
        protien += codonTable.get(base) + " ";
        base = "";
      }
    }
    return protien;
  }


  public static void fillMap() {
    codonTable.put("UUU", "Phe");
    codonTable.put("UUC", "Phe");

    codonTable.put("UUA", "Leu");
    codonTable.put("UUG", "Leu");
    codonTable.put("UUG", "Leu");
    codonTable.put("CUU", "Leu");
    codonTable.put("CUC", "Leu");
    codonTable.put("CUA", "Leu");
    codonTable.put("CUG", "Leu");

    codonTable.put("AUU", "Ile");
    codonTable.put("AUC", "Ile");
    codonTable.put("AUA", "Ile");

    codonTable.put("AUG", "MET");

    codonTable.put("GUU", "Val");
    codonTable.put("GUC", "Val");
    codonTable.put("GUA", "Val");
    codonTable.put("GUG", "Val");

    codonTable.put("UCU", "Ser");
    codonTable.put("UCC", "Ser");
    codonTable.put("UCA", "Ser");
    codonTable.put("UCG", "Ser");
    codonTable.put("AGU", "Ser");
    codonTable.put("AGC", "Ser");

    codonTable.put("CCU", "Pro");
    codonTable.put("CCC", "Pro");
    codonTable.put("CCA", "Pro");
    codonTable.put("CCA", "Pro");
    codonTable.put("CCG", "Pro");

    codonTable.put("ACU", "Thr");
    codonTable.put("ACC", "Thr");
    codonTable.put("ACA", "Thr");
    codonTable.put("ACG", "Thr");

    codonTable.put("GCU", "Ala");
    codonTable.put("GCC", "Ala");
    codonTable.put("GCA", "Ala");
    codonTable.put("GCG", "Ala");

    codonTable.put("UAU", "Tyr");
    codonTable.put("UAC", "Tyr");

    codonTable.put("UGU", "Cys");
    codonTable.put("UGC", "Cys");

    codonTable.put("UGG", "Trp");

    codonTable.put("UAA", "STOP\n");
    codonTable.put("UAG", "STOP\n");
    codonTable.put("UGA", "STOP\n");

    codonTable.put("CAU", "His");
    codonTable.put("CAC", "His");

    codonTable.put("CAA", "Gin");
    codonTable.put("CAG", "Gin");

    codonTable.put("AAU", "Asn");
    codonTable.put("AAC", "Asn");

    codonTable.put("AAA", "Lys");
    codonTable.put("AAG", "Lys");

    codonTable.put("GAU", "Asp");
    codonTable.put("GAC", "Asp");

    codonTable.put("GAA", "Glu");
    codonTable.put("GAG", "Glu");

    codonTable.put("CGU", "Arg");
    codonTable.put("CGC", "Arg");
    codonTable.put("CGA", "Arg");
    codonTable.put("CGG", "Arg");
    codonTable.put("AGA", "Arg");
    codonTable.put("AGG", "Arg");

    codonTable.put("GGU", "Gly");
    codonTable.put("GGC", "Gly");
    codonTable.put("GGA", "Gly");
    codonTable.put("GGC", "Gly");

  }
}
