package hashmapversion;


public class TeamsMembers extends Teams {

    public TeamsMembers(String name) {
        super(name, EntryType.LEAGUE_MEMBER);
    }

    @Override
    public boolean addPlayers(Teams teams) {
//        if(teams.getKey().getEntryType() == EntryType.PLAYERS) {
            return super.addPlayers(teams);
//        } else {
//            return false;
//        }
    }
}
