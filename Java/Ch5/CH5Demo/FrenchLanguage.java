import java.util.*;

public class FrenchLanguage implements UserPrompts {

 public static Scanner invalue = new Scanner(System.in);


 public int menu() {
  int selection = 1;
// Validated by French Major Nicole Ceausu
  System.out.println("\nChapitre 5 Programe Démo");
  System.out.println("Action                            Option");
  System.out.println("Échange deux chiffre:                  1");
  System.out.println("Échange deux chiffre dans un tableau:  2");
  System.out.println("Changez la langue:                     3");
  System.out.println("Rechargez le tableau:                  4");
  System.out.println("Imprimez le tableau:                   5");
  System.out.println("Arrêtez:                               0");
  System.out.print("Entrez Option:  ");
  System.out.println();
  selection = invalue.nextInt();
  if ((selection < 0) || (selection > 5)) {
   System.out.println("Choix erroné, valeur par défaut à Échange deux chiffre");
   selection = 1;
  }
  return selection;
 }

 public int idSwapNrs(int[] intlist) {
  int itemindex = 0;
  System.out.print("\n  Entrez l'index de nombre qui échangerez: ");
  itemindex = invalue.nextInt();
  if ((itemindex < 0) || (itemindex > 19)) {
   System.out.println("L'entré erroné, valeur par défaut au index 3");
   itemindex = 3;
  }
  return itemindex;
 }

 public int languageMenu() {
   int selection;
   System.out.print("Anglais\t\t1\nroumain\t\t2\nAnglais\t\t3\nEntrez Option: ");
   selection = invalue.nextInt();
   return selection;
 }

 public String printHeader() {
   String headstring = new String("tableau");
   // TODO Auto-generated method stub
   return headstring;
  } // end of header string

 public String beforeSwap() {
   String localstring = "\n ...devant échange...";
   return localstring;
  } // end of beforeSwap

 public String afterSwap() {
   String localstring = "\n ...après échange...";
   return localstring;
  } // end of afterSwap
}
