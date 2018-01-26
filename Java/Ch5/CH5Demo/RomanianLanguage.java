import java.util.*;

public class RomanianLanguage implements UserPrompts {

public static Scanner invalue = new Scanner(System.in);

   public int menu() {
    int selection = 1;
// Validated by Romanian Native Roxana Ceausu

    System.out.println("\nCapitolul 5 demonstrare Programu");
    System.out.println("Acțiune                   Alegere");
    System.out.println("schimbi două numere:             1");
    System.out.println("schimbi două numere in matrice:  2");
    System.out.println("schimbi limba:                   3");
    System.out.println("Reîncarcă matrice:               4");
    System.out.println("afișază matrice:                 5");
    System.out.println("ieşire:                          0");
    System.out.print("introduce opțiunea:  ");
    selection = invalue.nextInt();
    System.out.println();
    if ((selection < 0) || (selection > 5)) {
     System.out.println("selecțiunea nu este bună, schimbăm două numere");
     selection = 1;
    }
    return selection;
   }

   public int idSwapNrs(int[] intlist) {
    int itemindex = 0;
    System.out.print("\n  Care index să se schimbe: ");
    // Spune care indexul sa ne schimb
    itemindex = invalue.nextInt();
    if ((itemindex < 0) || (itemindex > 19)) {
     System.out.println("Selectiunea nu este bună, indexul 3 a fost selectat");
     itemindex = 3;
    }
    return itemindex;
   }
   
   public int languageMenu() {
     int selection;
     System.out.println("Engleză       1");
     System.out.println("Românește     2");
     System.out.println("Franceză      3");
     System.out.print("introduce opțiunea: ");
     selection = invalue.nextInt();
     return selection;
   }

   public String printHeader() {
     String headstring = new String("Matrice");
     // TODO Auto-generated method stub
     return headstring;
    } // end of header string

   public String beforeSwap() {
     String localstring = "\n ...înainte ce sa schimbat...";
     return localstring;
    } // end of beforeSwap

   public String afterSwap() {
     String localstring = "\n ...după ce sa schimbat...";
     return localstring;
    } // end of afterSwap
  }
