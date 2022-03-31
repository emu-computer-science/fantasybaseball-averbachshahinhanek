package testing;

public class Pitcher extends Players{
    private String name;
    private String team;
    private String position;
    private double ip;

    //Only for pitchers
    public Pitcher(String name, String team, String position, double ip) {
        super(name,team,position);
        this.name = name;
        this.team = team;
        this.position = position;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return this.name + " " + this.team + " " + this.position + " " + this.ip;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public double getIp() {
        return ip;
    }
}
