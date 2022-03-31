package testing;

import java.util.ArrayList;

public class League {
    private ArrayList<Team> teams = new ArrayList<>();
    public League() {}

    public void addTeam(String name) {
        teams.add(new Team(name));
    }

    public Team getTeam(String teamName) {
        for(Team t : teams) {
            if(t.getName().equalsIgnoreCase(teamName)) {
                return t;
            }
        }

        return null;
    }

    public Team getTeam(int index) {
        return teams.get(index);
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }
}
