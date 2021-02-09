package fahrzeugpack;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;


public class CarControl {
    static int anzautos = 0;
    static final int ATUOMAX = 50;
    static Auto[] autoliste = new Auto[ATUOMAX];

    public static void main(String[] args) {


        boolean ende = false;

        do {
            HeadLine headLine = new HeadLine();
            System.out.println("\n die Fahrzeugverwaltung");
            System.out.println("#########################");
            System.out.println("=========================");
            System.out.println("1. Auto anzeigen (1):");
            System.out.println("2. Neues Auto eingeben (2)");
            System.out.println("3. Auto verleihen (3)");
            System.out.println("4 Auto löschen (4)");
            System.out.println("3. Programm beenden  (0)");


            try {
                System.out.println("\n Auswahl: ");
                Scanner scan = new Scanner(System.in);
                short eingabe = scan.nextShort();
                System.out.println(">>>>>>> AUSWAHL <<<<<<<<<<");
                switch (eingabe) {
                    case 1:
                        System.out.println("\n Auto anzeigen");
                        listeAnzeigen(anzautos);
                        break;
                    case 2:
                        if (anzautos < ATUOMAX && anzautos >= 0) {
                            anzautos = neuesAuto(anzautos);
                        } else {
                            System.out.println("Die Autoliste ist voll!");
                        }
                        break;
                    case 3:
                        if (autoliste[autoWahl(anzautos)].verliehen){
                            System.out.println("Ok");
                        }
                        else{
                            System.out.println("Auto ist bereits verliehen!");
                        }
                        break;
                    case 4:
                        anzautos=loeschen(anzautos,autoWahl(anzautos));
                        break;
                    case 0:
                        System.out.println("\n Ende!");
                        ende = true;
                        break;
                    default:
                        System.out.println("Felsche Eingabe!");
                }
            } catch (Exception e) {
                System.out.println("Bitte nur Zahlen eingeben");
            }
        }
        while (!ende);
    }

    static void listeAnzeigen(int autonr) {
        System.out.println("\n Auto Liste");
        System.out.println("==========");
        for (int i = 0; i < autonr; i++) {
            System.out.println((i + 1)+ ")");
            System.out.println(autoliste[i].listEintrag());

        }
    }

    static int neuesAuto(int autonr) {
        System.out.println("\n Beues Auto eingeben");
        System.out.println("======================");
        autoliste[autonr] = new Auto();
        while (!autoliste[autonr].eingeben()) {
            System.out.println("Fehlerhafte Eingabe!");
        }
        System.out.println("neues Auto angelegt.");
        if (autonr + 1 > 1) {
            sortieren(autonr + 1);
        }
        return (autonr + 1);
    }

    static void sortieren(int autonr) {
        Auto puffer;
        for (int lauf = 0; lauf < autonr; lauf++) {
            for (int pos = 0; pos < autonr - 1; pos++) {
                if (autoliste[pos].listEintrag().compareTo
                        (autoliste[pos + 1].listEintrag()) > 0) {
                    puffer = autoliste[pos];
                    autoliste[pos] = autoliste[pos + 1];
                    autoliste[pos + 1] = puffer;
                }
            }
        }
    }
    static int autoWahl(int autoNr){
        boolean ende = false;
        short auswahl = 0;
        do {

        listeAnzeigen(autoNr);
            try {
                System.out.println("\nAuswahl: ");
                Scanner eingabe = new Scanner(System.in);
                auswahl = eingabe.nextShort();

                if (auswahl > 0 && auswahl <= autoNr) {
                    ende = true;
                } else {
                    System.out.println("Ungültige Auswahl!");
                }
            } catch (Exception e) {
                System.out.println("Eine ZAHL eingeben!");
            }
        }
        while (!ende);
        return (auswahl -1);
    }

    static int loeschen (int autos, int index){
        for (int i=0; i < (autos - 1);i++){
            autoliste[i] = autoliste[i + 1];
        }
        autoliste[autos -1] = null;
        return (autos - 1);
    }

}




