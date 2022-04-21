package testing;

import java.io.Serializable;

public class Pitcher extends Players implements Serializable
{
    private final String name;
    private final String team;
    private String position;
    private final double era;
    private final double g;
    private final double gs;
    private final double ip;
    private final double bb;
    private final double so;

    //Only for pitchers
    public Pitcher(String name, String team, String position, double era, double g,
                   double gs, double ip, double bb, double so) {
        super(name,team,position);
        this.name = name;
        this.team = team;
        this.position = position;
        this.era = era;
        this.g = g;
        this.gs = gs;
        this.ip = ip;
        this.bb = bb;
        this.so = so;
    }

    //To String Methods and Getter Methods
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

    public void setPosition(String position) {
        this.position = position;
    }

    public double getIp() {
        return ip;
    }
}
