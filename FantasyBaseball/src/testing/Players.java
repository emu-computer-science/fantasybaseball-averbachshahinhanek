package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Players implements Comparable<Players> {
    private String name;
    private String team;
    private String position;
    private int weight;
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
                this.weight = 0;
                break;
            case "1B":
                this.weight = 1;
                break;
            case "2B":
                this.weight = 2;
                break;
            case "3B":
                this.weight = 3;
                break;
            case "SS":
                this.weight = 4;
                break;
            case "LF":
                this.weight = 5;
                break;
            case "CF":
                this.weight = 6;
                break;
            case "RF":
                this.weight = 7;
                break;
            case "P1":
                this.weight = 8;
                break;
            case "P2":
                this.weight = 9;
                break;
            case "P3":
                this.weight = 10;
                break;
            case "P4":
                this.weight = 11;
                break;
            case "P5":
                this.weight = 12;
                break;
            default:
                return;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return this.position + " " + this.name + " " + this.weight;
    }

    @Override
    public int compareTo(Players p) {
        int compare = ((Players)p).getWeight();
        return this.weight - compare;
    }
}
