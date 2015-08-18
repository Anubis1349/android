package Data;

/**
 * Created by Kerman on 23.4.2015.
 */
public class Target {
    public Target(int req, String name, int reward, String status) {
        super();
        this.setReq(req);
        this.setName(name);
        this.setReward(reward);
        this.setStatus(status);
    }

    public int getReq() {
        return req;
    }
    public void setReq(int req) {
        this.req = req;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public Rigg getAttacker() { return attacker; }

    public void setAttacker(Rigg attacker) { this.attacker = attacker; }

    public String getStatus(){ return this.status; }

    public void setStatus(String status){ this.status = status; }


    public void attack(Rigg atc, int attackType){
        if(attackType == 1){
            this.status = "Offline";
            //return reward
        }
        if(attackType == 2){
            this.status = "Infected";
            //return reward
        }
        if(attackType == 3) {
            if (atc.getPower() >= this.getReq()) {
                System.out.println("Breach successful");
                //return reward
            } else
                System.out.println("Breach failed");
        }
    }

    private int req;
    private String name;
    private int reward;
    private Rigg attacker;
    private String status;
    //private int reward1;
    //private int reward2;
    //private int reward3;
}
