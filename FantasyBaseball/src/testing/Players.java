package testing;

public class Players {
    private String name;
    private String team;
    private String position;

    public Players(String name, String team, String position) {
        this.name = name;
        this.team = team;
        this.position = position;
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

    @Override
    public String toString() {
        return this.position + " " + this.name;
    }
}
