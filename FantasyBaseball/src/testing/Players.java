package testing;

import java.io.Serializable;

public class Players implements Comparable<Players>, Serializable
{
    private String name;
    private String team;
    private String position;
    private int order;
    private boolean drafted = false;

    //Constructor for generic player.
    public Players(String name, String team, String position) {
        this.name = name;
        this.team = team;
        this.position = position;
    }


    //To String and Getter methods
    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public void assignWeight(String position) {
        switch(position) {
            case "C":
                this.order = 0;
                break;
            case "1B":
                this.order = 1;
                break;
            case "2B":
                this.order = 2;
                break;
            case "3B":
                this.order = 3;
                break;
            case "SS":
                this.order = 4;
                break;
            case "LF":
                this.order = 5;
                break;
            case "CF":
                this.order = 6;
                break;
            case "RF":
                this.order = 7;
                break;
            case "P1":
                this.order = 8;
                break;
            case "P2":
                this.order = 9;
                break;
            case "P3":
                this.order = 10;
                break;
            case "P4":
                this.order = 11;
                break;
            case "P5":
                this.order = 12;
                break;
            default:
                return;
        }
    }

    public int getOrder() {
        return order;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return this.position + " " + this.name + " " + this.order;
    }

    @Override
    public int compareTo(Players p) {
        int compare = ((Players)p).getOrder();
        return this.order - compare;
    }
}
