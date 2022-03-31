package hashmapversion;


public class TeamsMembers extends Teams {

    public TeamsMembers(String name) {
        super(name, EntryType.LEAGUE_MEMBER);
    }

    @Override
    public boolean addPlayers(Teams moon) {
//        if(moon.getKey().getEntryType() == EntryType.PLAYERS) {
            return super.addPlayers(moon);
//        } else {
//            return false;
//        }
    }
}
