package hashmapversion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public abstract class Teams {
    private final Key key;
    //private final double orbitalPeriod;
    private final Set<Teams> Players;

    private static Map<Key, Teams> mapContainer = new HashMap<>();
    private static Set<Teams> leagueMembers = new HashSet<>();

    public static void addLeagueMembers(TeamsMembers memberA) {
        mapContainer.put(memberA.getKey(), memberA);
        leagueMembers.add(memberA);
    }

    public enum EntryType {
        LEAGUE_MEMBER,
        PLAYERS,
        CATCHER,            //C
        FIRST_BASEMAN,      //1B
        SECOND_BASEMAN,     //2B
        THIRD_BASEMAN,      //3B
        SHORT_STOP,         //SS
        LEFT_FIELDER,       //LF
        RIGHT_FIELDER,      //RF
        CENTER_FIELDER,     //CF
        PICHER1,            //p1
        PICHER2,            //p2
        PICHER3,            //p3
        PICHER4,            //p4
        PICHER5             //p5
    }

    public Teams(String name, EntryType bodyType) {

        this.key = new Key(name, bodyType);
       // this.orbitalPeriod = orbitalPeriod;
        this.Players = new HashSet<>();
    }

//    public double getOrbitalPeriod() {
//        return orbitalPeriod;
//    }

    public Key getKey() {
        return key;
    }

    public boolean addPlayers(Teams teams) {
        return this.Players.add(teams);
    }

    public Set<Teams> getPlayers() {
        return new HashSet<>(this.Players);
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj instanceof Teams) {
            Teams theObject = (Teams) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    public static Key makeKey(String name, EntryType bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.entryType;
    }

    public static final class Key {
        private String name;
        private EntryType entryType;

        private Key(String name, EntryType entryType) {
            this.name = name;
            this.entryType = entryType;
        }

        public String getName() {
            return name;
        }

        public EntryType getEntryType() {
            return entryType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 59 + this.entryType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())) {
                return(this.entryType == key.getEntryType());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.entryType;
        }
    }



}
