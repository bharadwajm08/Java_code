
/**
 * Beschreiben Sie hier die Klasse Midground.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Automat implements Background
{
    private char Szustand ;

    /**
     * Konstruktor für Objekte der Klasse Midground
     */
    
    public Automat()
    {
       this.Szustand = 'S';  
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public boolean suche(String eingabe, String pattern)
    {
        boolean gefunden = false;
        char zustand = Szustand;
        char aktuell;
        int index = 0;
        for (int i = 0; i < eingabe.length(); i++){
            aktuell = eingabe.charAt(i);
            System.out.println("Eingabe:[" + i + "] = " + aktuell + " | Pattern[" + index + "] = " + pattern.charAt(index));
            if (aktuell == pattern.charAt(index)){
                zustand = (char) ('A' + index);
                index++;
                if (index == pattern.length()){
                    zustand = 'Z';
                    gefunden = true;
                    break;
                }
            } else {
                
                if(aktuell == pattern.charAt(0)){
                    zustand = 'A';
                    index = 1;
                } else{
                    zustand = Szustand;
                    index = 0;
                }
            }
        }
        return gefunden;
    }
}