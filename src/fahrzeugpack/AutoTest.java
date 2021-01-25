package fahrzeugpack;

public class AutoTest {

    public static void main(String[] args){
        Auto erstesAuto;
        erstesAuto = new Auto();
        if(erstesAuto.eingeben()){
            erstesAuto.anzeigen();
        }
        else {
            System.out.println("Fehlerhafte eingabe");
        }
    }
}
