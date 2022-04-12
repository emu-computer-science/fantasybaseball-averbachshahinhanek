package testing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Team implements Serializable {
    private ArrayList<Players> team = new ArrayList<>();// here

    private String name;

    private int catcherC = 1;
    private int firstBaseC = 1;
    private int secondBaseC = 1;
    private int thirdBaseC = 1;
    private int SSC = 1;
    private int leftFieldC = 1;
    private int rightFieldC = 1;
    private int centerFieldC = 1;
    private int pitcherC = 5;

    public Team(String name) {
        this.name = name;
    }

    //Checks to see if a player has already been drafted for that spot, if not, it drafts a player.
    public boolean addPlayer(Players teammate) {
        switch (teammate.getPosition()) {
            case "C":
                if (catcherC == 0) {
                    System.out.println("Max Catchers reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                catcherC--;
                return true;
            case "1B":
                if (firstBaseC == 0) {
                    System.out.println("Max first basemen reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                firstBaseC--;
                return true;
            case "2B":
                if (secondBaseC == 0) {
                    System.out.println("Max second basemen reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                secondBaseC--;
                return true;
            case "3B":
                if (thirdBaseC == 0) {
                    System.out.println("Max third basemen reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                thirdBaseC--;
                return true;
            case "SS":
                if (SSC == 0) {
                    System.out.println("Max Short Stops reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                SSC--;
                return true;
            case "LF":
                if (leftFieldC == 0) {
                    System.out.println("Max Left Fielders reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                leftFieldC--;
                return true;
            case "CF":
                if (centerFieldC == 0) {
                    System.out.println("Max Center Fielders reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                centerFieldC--;
                return true;
            case "RF":
                if (rightFieldC == 0) {
                    System.out.println("Max Right Fielders reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                rightFieldC--;
                return true;
            case "P":
                if (pitcherC == 0) {
                    System.out.println("Max Pitchers reached");
                    return false;
                }

                switch (pitcherC) {
                    case 5:
                        teammate.setPosition("P1");
                        teammate.assignWeight(teammate.getPosition());
                        System.out.println("Drafted: " + teammate.toString() + "\n");
                        team.add(teammate);
                        pitcherC--;
                        return true;
                    case 4:
                        teammate.setPosition("P2");
                        teammate.assignWeight(teammate.getPosition());
                        System.out.println("Drafted: " + teammate.toString() + "\n");
                        team.add(teammate);
                        pitcherC--;
                        return true;
                    case 3:
                        teammate.setPosition("P3");
                        teammate.assignWeight(teammate.getPosition());
                        System.out.println("Drafted: " + teammate.toString() + "\n");
                        team.add(teammate);
                        pitcherC--;
                        return true;
                    case 2:
                        teammate.setPosition("P4");
                        teammate.assignWeight(teammate.getPosition());
                        System.out.println("Drafted: " + teammate.toString() + "\n");
                        team.add(teammate);
                        pitcherC--;
                        return true;
                    case 1:
                        teammate.setPosition("P5");
                        teammate.assignWeight(teammate.getPosition());
                        System.out.println("Drafted: " + teammate.toString() + "\n");
                        team.add(teammate);
                        pitcherC--;
                        return true;
                    default:
                        System.out.println("An unknown error has occurred");
                }
            default:
                System.out.println("ERROR");
                return false;
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Players> getTeam() {
        return team;
    }

    //Sorts based on players position
    public void team() {
        ArrayList<Players> temp = team;
        Collections.sort(temp);

        for (Players p : temp) {
            System.out.println(p.getPosition() + " " + p.getName());
        }

        System.out.println();
    }

    //Main method for POVERALL command
    public void displayPitch(ArrayList<Pitcher> pitchers) {
        if (this.getPitcherC() == 0) {
            System.out.println("You already drafted 5 Pitchers.");
            return;
        }
        for (Pitcher player : pitchers) {
            System.out.println(player.toString());
        }
    }

    //Single argument OVERALL Method
    //Prints all players of requested position in order of rank
    public void displayPos(String position, ArrayList<NonPitcher> allNonPitchers) {
        for (NonPitcher player : allNonPitchers) {
            if (this.isDrafted(position)) {
                System.out.println("You already drafted the maximum amount of " + position);
                return;
            }
            if (player.getPosition().equals(position))
                System.out.println(player.toString());
        }
    }

    //No arguments OVERALL method
    public void displayPos(ArrayList<NonPitcher> allNonPitchers) {
        for (NonPitcher player : allNonPitchers) {
            if (player.getPosition().equals("C")) {
                if (catcherC == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("1B")) {
                if (firstBaseC == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("2B")) {
                if (secondBaseC == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("3B")) {
                if (thirdBaseC == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("SS")) {
                if (SSC == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("LF")) {
                if (leftFieldC == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("RF")) {
                if (rightFieldC == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("CF")) {
                if (centerFieldC == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            }
        }
    }

    //Getter methods
    public int getCatcherC() {
        return catcherC;
    }

    public int getFirstBaseC() {
        return firstBaseC;
    }

    public int getSecondBaseC() {
        return secondBaseC;
    }

    public int getThirdBaseC() {
        return thirdBaseC;
    }

    public int getSSC() {
        return SSC;
    }

    public int getLeftFieldC() {
        return leftFieldC;
    }

    public int getRightFieldC() {
        return rightFieldC;
    }

    public int getCenterFieldC() {
        return centerFieldC;
    }

    public int getPitcherC() {
        return pitcherC;
    }

    public void setTeam(ArrayList<Players> team) {
        this.team = team;
    }

    //Checks to see if a player has been drafted by checking if their position variables are set to 0
    public boolean isDrafted(String position) {
        switch (position) {
            case "C":
                if (catcherC == 0)
                    return true;
                return false;
            case "1B":
                if (firstBaseC == 0)
                    return true;
                return false;
            case "2B":
                if (secondBaseC == 0)
                    return true;
                return false;
            case "3B":
                if (thirdBaseC == 0)
                    return true;
                return false;
            case "SS":
                if (SSC == 0)
                    return true;
                return false;
            case "LF":
                if (leftFieldC == 0)
                    return true;
                return false;
            case "RF":
                if (rightFieldC == 0)
                    return true;
                return false;
            case "CF":
                if (centerFieldC == 0)
                    return true;
                return false;
            case "P":
                if (pitcherC == 0)
                    return true;
                return false;
            default:
                return false;
        }
    }
}

