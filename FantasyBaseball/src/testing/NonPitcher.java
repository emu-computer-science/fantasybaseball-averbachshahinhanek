package testing;

public class NonPitcher extends Players{
    private String name;
    private String team;
    private String position;
    private double avg;

    //Generic NonPitcher class to hold all non-pitchers
    public NonPitcher(String name, String team, String position, double avg) {
        super(name,team,position);
        this.name = name;
        this.team = team;
        this.position = position;
        this.avg = avg;
    }

    //TO String Method and getter methods
    @Override
    public String toString() {
        return name + " " + team + " " + position + " " + avg;
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

    public double getAvg() {
        return avg;
    }
}
