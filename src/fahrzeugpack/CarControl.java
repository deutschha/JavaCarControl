package fahrzeugpack;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;


public class CarControl {
    static int anzautos = 0;
    static final int ATUOMAX = 50;
    static Auto[] autoliste = new Auto[ATUOMAX];
    public static void main(String[] args){


    boolean ende = false;

                do{
                    HeadLine headLine = new HeadLine();
                    System.out.println("\n die Fahrzeugverwaltung");
                    System.out.println("#########################");
                    System.out.println("=========================");
                    System.out.println("1. Auto anzeigen (1):");
                    System.out.println("2. Neues Auto eingeben (2)");
                    System.out.println("3. Programm beenden  (0)");

                    try {
                        System.out.println("\n Auswahl: ");
                        Scanner scan = new Scanner(System.in);
                        short eingabe = scan.nextShort();
                        System.out.println(">>>>>>> AUSWAHL <<<<<<<<<<");
                        switch(eingabe){
                            case 1:
                                System.out.println("\n Auto anzeigen");
                                listeAnzeigen(anzautos);
                                break;
                            case 2:
                                if (anzautos<ATUOMAX && anzautos>=0){
                                    anzautos = neuesAuto(anzautos);
                                }
                                else{
                                    System.out.println("Die Autoliste ist voll!");
                                }
                                break;
                            case 0:
                                System.out.println("\n Ende!");
                                ende = true;
                                break;
                            default:
                                System.out.println("Felsche Eingabe!");
                        }
                    }
                    catch(Exception e){
                        System.out.println("Bitte nur Zahlen eingeben");
                    }
                }
                while(!ende);
            }

    static void listeAnzeigen(int autonr){
        System.out.println("\n Auto Liste");
        System.out.println("==========");
        for (int i = 0; i < autonr; i++){
            System.out.println((i+1)+")");
            System.out.println(autoliste[i].listEintrag());

        }
    }

    static int neuesAuto(int autonr){
        System.out.println("\n Beues Auto eingeben");
        System.out.println("======================");
        autoliste[autonr] = new Auto();
        while (!autoliste[autonr].eingeben()){
            System.out.println("Fehlerhafte Eingabe!");
        }
        System.out.println("neues Auto angelegt.");
        return(autonr + 1);
    }
}


