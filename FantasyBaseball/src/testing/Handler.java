package testing;

import java.util.ArrayList;

public class Handler {
    ArrayList<String> draftedDB = new ArrayList<>(); //Holds players who've already been drafted



    public static class Catcher extends Teams {

        public Catcher(String name) {
            super(name, Teams.EntryType.CATCHER);
        }
    }

    public static class FirstBaseman extends Teams {

        public FirstBaseman(String name) {
            super(name, Teams.EntryType.FIRST_BASEMAN);
        }
    }

    public static class SecondBaseman extends Teams {

        public SecondBaseman(String name) {
            super(name, Teams.EntryType.SECOND_BASEMAN);
        }
    }

    public static class ThirdBaseman extends Teams {

        public ThirdBaseman(String name) {
            super(name, Teams.EntryType.THIRD_BASEMAN);
        }
    }

    public static class ShortStop extends Teams {

        public ShortStop(String name) {
            super(name, Teams.EntryType.SHORT_STOP);
        }
    }

    public static class LeftFielder extends Teams {

        public LeftFielder(String name) {
            super(name, Teams.EntryType.LEFT_FIELDER);
        }
    }

    public static class RightFielder extends Teams {

        public RightFielder(String name) {
            super(name, Teams.EntryType.RIGHT_FIELDER);
        }
    }

    public static class CenterFielder extends Teams {

        public CenterFielder(String name) {
            super(name, Teams.EntryType.CENTER_FIELDER);
        }
    }

    public static class Pitchers extends Teams {

        public Pitchers(String name) {
            super(name, Teams.EntryType.PITCHERS);
        }//PICHERS
    }

    public class TeamsMembers extends Teams {

        public TeamsMembers(String name) {
            super(name, Teams.EntryType.PLAYERS);
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


}
