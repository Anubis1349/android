package Data;

/**
 * Created by Kerman on 23.4.2015.
 */
public class Rigg {
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    private int power;

    public double getVer() {
        return ver;
    }
    public void setVer(double ver) {
        this.ver = ver;
    }

    private double ver;

    public String getUsrString() {
        return usr.toString();
    }

    public Uporabnik getUsr() {
        return usr;
    }

    public void setUsr(Uporabnik usr) {
        this.usr = usr;
    }

    private Uporabnik usr;

    public Rigg(int power, double ver, Uporabnik usr) {
        super();
        this.setPower(power);
        this.setVer(ver);
        this.setUsr(usr);
    }

    @Override
    public String toString(){
        return "Power: " + power + "Mhz" + "\nSystem version: " + ver + "\nUser: " + usr.getIme();
    }
}
