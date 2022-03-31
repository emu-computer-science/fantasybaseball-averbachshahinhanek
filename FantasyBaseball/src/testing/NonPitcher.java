package testing;

public class NonPitcher extends Teams {
    private String name;
    private String team;
    private String position;
    private double avg;

    //Generic NonPitcher class to hold all non-pitchers
    public NonPitcher(String name, String team, String position, double avg) {
        super(name, Teams.EntryType.CATCHER);
        this.name = name;
        this.team = team;
        this.position = position;
        this.avg = avg;
    }

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
