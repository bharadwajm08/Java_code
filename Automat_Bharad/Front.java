import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Front.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Front
{
    public static void main(String[] args)
    {
     Scanner sc = new Scanner(System.in);
      
     Background prozess = new Automat();
       
     System.out.println("Gib deinen Input ein");
     String eingabe = sc.nextLine();
        
     System.out.println("Gib das gesuchte Pattern ein:");
     String pattern = sc.nextLine();
     boolean gefunden = prozess.suche(eingabe, pattern);
        
     if(gefunden){
       System.out.println("Pattern wurde gefunden");
      } else {
       System.out.println("Pattern wurde nicht gefunden");
    }
    sc.close();
    
}
}