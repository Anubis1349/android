package Data;

/**
 * Created by Kerman on 23.4.2015.
 */
public class Uporabnik {
    @Override
    public String toString() {
        return "Uporabnik [ime=" + ime + ", pass=" + pass + ", score=" + score + "]";
    }

    public Uporabnik(String ime, String pass, int score) {
        super();
        this.ime = ime;
        this.pass = pass;
        this.score = score;
    }

    private String ime;
    private String pass;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
