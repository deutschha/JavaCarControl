package fahrzeugpack;
import java.util.Scanner;

public class Auto extends Fahrzeug {
    protected int plaetze;
    public static int anzAuto = 0;

    public Auto(){
        anzAuto ++;
    }

    public Auto(String kBez, int kplaetze, int kgesch){
        bezeichnung = kBez;
        plaetze = kplaetze;
        geschw = kgesch;
        anzAuto ++;
    }
    public boolean eingeben(){
        Scanner scan = new Scanner(System.in);
        try{
            System.out.print("Bezeichnung: ");
            bezeichnung = scan.next();
            System.out.print("Anzahl Plätzte: ");
            plaetze = scan.nextInt();
            System.out.print("Geschwindigkeit ");
            geschw = scan.nextInt();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean anzeigen() {
        System.out.println("Das Auto " + bezeichnung);
        System.out.println("Es hat " + plaetze + " Sitze ");
        if (verliehen) {
            System.out.println("Es ist verliehen");
        }
        else {
            System.out.println("Es ist nicht verliehen");
        }
        return true;
    }
    public String listEintrag(){
        String text;
        text = bezeichnung+ " , " + plaetze + " Sitzplätze " + geschw + " km/h Höchstgeschwindigkeit";
        if(verliehen){
            text = text + " *";
        }
        return text;
    }

}
