package fahrzeugpack;

abstract class Fahrzeug {
    protected String bezeichnung;
    protected int geschw;
    protected boolean verliehen;
    abstract boolean eingeben();
    abstract boolean anzeigen();

    public boolean verliehen(){
        if (verliehen){
            return false;
        }
        else{
            verliehen = true;
            return true;
        }
    }

}
