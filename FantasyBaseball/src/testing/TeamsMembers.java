package testing;

public class TeamsMembers extends Teams {

    public TeamsMembers(String name) {
        super(name, Teams.EntryType.LEAGUE_MEMBER);
    }

    @Override
    public boolean addPlayers(Teams moon) {
        if(moon.getKey().getEntryType() == Teams.EntryType.PLAYERS) {
            return super.addPlayers(moon);
        } else {
            return false;
        }
    }
}
