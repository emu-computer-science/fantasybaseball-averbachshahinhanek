package main;

public class League {
    private String TeamA;
    private String TeamB;
    private String TeamC;
    private String TeamD;

    public League(String teamA, String teamB, String teamC, String teamD) {
        TeamA = teamA;
        TeamB = teamB;
        TeamC = teamC;
        TeamD = teamD;
    }

    public League() {
    }

    public String getTeamA() {
        return TeamA;
    }

    public void setTeamA(String teamA) {
        TeamA = teamA;
    }

    public String getTeamB() {
        return TeamB;
    }

    public void setTeamB(String teamB) {
        TeamB = teamB;
    }

    public String getTeamC() {
        return TeamC;
    }

    public void setTeamC(String teamC) {
        TeamC = teamC;
    }

    public String getTeamD() {
        return TeamD;
    }

    public void setTeamD(String teamD) {
        TeamD = teamD;
    }
}
