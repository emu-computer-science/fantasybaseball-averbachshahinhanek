package testing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    //private static Map<Teams.Key, Teams> solarSystem = new HashMap<>();
    private static Map<Teams.Key, Teams> mapContainer = new HashMap<>();
    private static Set<Teams> leagueMembers = new HashSet<>();

    public static void main(String[] args) {
        Teams league = new TeamsMembers("MemberA");
        mapContainer.put(league.getKey(), league);
        leagueMembers.add(league);


        Teams tempMoon = new Moon("Player1");
        mapContainer.put(tempMoon.getKey(), tempMoon);
        league.addPlayers(tempMoon);

//        Teams.addLeagueMembers(new TeamsMembers("MemberA"));
//        Teams.addLeagueMembers(new TeamsMembers("MemberB"));
//        Teams.addLeagueMembers(new TeamsMembers("MemberC"));
//        Teams.addLeagueMembers(new TeamsMembers("MemberD"));

        league = new TeamsMembers("MemberB");
        mapContainer.put(league.getKey(), league);
        leagueMembers.add(league);

        league = new TeamsMembers("MemberC");
        mapContainer.put(league.getKey(), league);
        leagueMembers.add(league);

         tempMoon = new Moon("Player1");
        mapContainer.put(tempMoon.getKey(), tempMoon);
        league.addPlayers(tempMoon);



        league = new TeamsMembers("Player1");
        mapContainer.put(league.getKey(), league);
        leagueMembers.add(league);
//
//        tempMoon = new Moon("Deimos");
//        mapContainer.put(tempMoon.getKey(), tempMoon);
//        league.addPlayers(tempMoon); // league is still Mars
//
//        tempMoon = new Moon("Phobos");
//        mapContainer.put(tempMoon.getKey(), tempMoon);
//        league.addPlayers(tempMoon); // league is still Mars
//
//        league = new TeamsMembers("Jupiter");
//        mapContainer.put(league.getKey(), league);
//        leagueMembers.add(league);
//
//        tempMoon = new Moon("Io");
//        mapContainer.put(tempMoon.getKey(), tempMoon);
//        league.addPlayers(tempMoon); // league is still Jupiter
//
//        tempMoon = new Moon("Europa");
//        mapContainer.put(tempMoon.getKey(), tempMoon);
//        league.addPlayers(tempMoon); // league is still Jupiter
//
//        tempMoon = new Moon("Ganymede");
//        mapContainer.put(tempMoon.getKey(), tempMoon);
//        league.addPlayers(tempMoon); // league is still Jupiter
//
//        tempMoon = new Moon("Callisto");
//        mapContainer.put(tempMoon.getKey(), tempMoon);
//        league.addPlayers(tempMoon); // league is still Jupiter
//
//        league = new TeamsMembers("Saturn");
//        mapContainer.put(league.getKey(), league);
//        leagueMembers.add(league);
//
//        league = new TeamsMembers("Uranus");
//        mapContainer.put(league.getKey(), league);
//        leagueMembers.add(league);
//
//        league = new TeamsMembers("Neptune");
//        mapContainer.put(league.getKey(), league);
//        leagueMembers.add(league);
//
//        league = new TeamsMembers("Pluto");
//        mapContainer.put(league.getKey(), league);
//        leagueMembers.add(league);

//        System.out.println("Planets");
//        for(Teams planet : leagueMembers) {
//            System.out.println("\t" + planet.getKey());
//        }
//
//        Teams body = mapContainer.get(Teams.makeKey("Mars", Teams.EntryType.LEAGUE_MEMBER));
//        System.out.println("Moons of " + body.getKey());
//        for(Teams jupiterMoon: body.getPlayers()) {
//            System.out.println("\t" + jupiterMoon.getKey());
//        }
//
//        Set<Teams> moons = new HashSet<>();
//        for(Teams planet : leagueMembers) {
//            moons.addAll(planet.getPlayers());
//        }
//        //printAll(leagueMembers,Teams.getPlayers());
//        System.out.println("All Moons");
//        for(Teams moon : moons) {
//            System.out.println("\t" + moon.getKey());
//        }
//
//        Teams pluto = new Catcher("Pluto", 842);
//        leagueMembers.add(pluto);
//
//        for(Teams planet : leagueMembers) {
//            System.out.println(planet);
////            System.out.println(planet.getKey() + ": " + planet.getOrbitalPeriod());
//        }
//
//        Teams earth1 = new TeamsMembers("Earth");
//        Teams earth2 = new TeamsMembers("Earth");
//        System.out.println(earth1.equals(earth2));
//        System.out.println(earth2.equals(earth1));
//        System.out.println(earth1.equals(pluto));
//        System.out.println(pluto.equals(earth1));
//
//        mapContainer.put(pluto.getKey(), pluto);
//        System.out.println(mapContainer.get(Teams.makeKey("Pluto", Teams.EntryType.LEAGUE_MEMBER)));
//        System.out.println(mapContainer.get(Teams.makeKey("Pluto", Teams.EntryType.DWARF_PLANET)));
//
//        System.out.println();
//        System.out.println("The solar system contains:");
//        for(Teams heavenlyBody : mapContainer.values()) {
//            System.out.println(heavenlyBody);
//        }

    }


}
