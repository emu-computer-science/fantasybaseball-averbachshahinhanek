package hashmapversion;

public class Players extends Teams {

    public Players(String name, EntryType bodyType) {
        super(name, bodyType);
    }

    public static class Catcher extends Teams {

        public Catcher(String name) {
            super(name, EntryType.CATCHER);
        }
    }

    public static class FirstBaseman extends Teams {

        public FirstBaseman(String name) {
            super(name, EntryType.FIRST_BASEMAN);
        }
    }

    public static class SecondBaseman extends Teams {

        public SecondBaseman(String name) {
            super(name, EntryType.SECOND_BASEMAN);
        }
    }

    public static class ThirdBaseman extends Teams {

        public ThirdBaseman(String name) {
            super(name, EntryType.THIRD_BASEMAN);
        }
    }

    public static class ShortStop extends Teams {

        public ShortStop(String name) {
            super(name, EntryType.SHORT_STOP);
        }
    }

    public static class LeftFielder extends Teams {

        public LeftFielder(String name) {
            super(name, EntryType.LEFT_FIELDER);
        }
    }

    public static class RightFielder extends Teams {

        public RightFielder(String name) {
            super(name, EntryType.RIGHT_FIELDER);
        }
    }

    public static class CenterFielder extends Teams {

        public CenterFielder(String name) {
            super(name, EntryType.CENTER_FIELDER);
        }
    }

    public static class Pitcher1 extends Teams {

        public Pitcher1(String name) {
            super(name, EntryType.PICHER1);
        }
    }

    public static class Pitcher2 extends Teams {

        public Pitcher2(String name) {
            super(name, EntryType.PICHER2);
        }
    }

    public static class Pitcher3 extends Teams {

        public Pitcher3(String name) {
            super(name, EntryType.PICHER3);
        }
    }

    public static class Pitcher4 extends Teams {

        public Pitcher4(String name) {
            super(name, EntryType.PICHER4);
        }
    }

    public static class Pitcher5 extends Teams {

        public Pitcher5(String name) {
            super(name, EntryType.PICHER5);
        }
    }
//    public class TeamsMembers extends Teams {
//
//        public TeamsMembers(String name) {
//            super(name, EntryType.PICHERS);
//        }
//
//        @Override
//        public boolean addPlayers(Teams moon) {
//            if(moon.getKey().getEntryType() == EntryType.PLAYERS) {
//                return super.addPlayers(moon);
//            } else {
//                return false;
//            }
//        }
//    }
}
