package fahrzeugpack;

public class Autotest6 {
    public static void main(String[] args) {
        CarControl eingabe = new CarControl();
        System.out.println(Auto.anzAuto);
        Auto erstesAuto = new Auto();
        System.out.println(Auto.anzAuto);
        Auto zweitesAuto = new Auto("Kia Venga ",5, 165);
        System.out.println(Auto.anzAuto);
        zweitesAuto.anzeigen();
        CarControl view = new CarControl();


    }
}
