package collections.collection.set.sortedSet.treeSet;

import java.util.*;

public class Main {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static TreeSet<HeavenlyBody> planets = new TreeSet<>();

    public static void main(String[] args) {
        HeavenlyBody planet = new HeavenlyBody("Mercury", 80);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planet = new HeavenlyBody("Venus", 220);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planet = new HeavenlyBody("Earth", 365);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        HeavenlyBody planetMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addMoon(planetMoon);

        planet = new HeavenlyBody("Mars", 687);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planetMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addMoon(planetMoon);

        planetMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addMoon(planetMoon);

        planet = new HeavenlyBody("Jupiter", 4000);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planetMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addMoon(planetMoon);

        planetMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addMoon(planetMoon);

        planetMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addMoon(planetMoon);

        planetMoon = new HeavenlyBody("Callisto", 16.2);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addMoon(planetMoon);

        planet = new HeavenlyBody("Saturn", 10299);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planet = new HeavenlyBody("Uranus", 30680);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planet = new HeavenlyBody("Neptune", 165);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planet = new HeavenlyBody("Pluto", 248);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        System.out.println("Planets: ");
        for (HeavenlyBody currentPlanet : planets) {
            System.out.println("\t" + currentPlanet.getName());
        }

        HeavenlyBody heavenlyBody = solarSystem.get("Jupiter");
        System.out.println("Moons of " + heavenlyBody.getName());
        for (HeavenlyBody moon : heavenlyBody.getSatellites()) {
            System.out.println("\t" + moon.getName());
        }

        Set<HeavenlyBody> moons = new TreeSet<>();
        for(HeavenlyBody currentPlanet: planets){
            moons.addAll(currentPlanet.getSatellites());
        }

        System.out.println("All moons are: ");
        for(HeavenlyBody moon: moons){
            System.out.println("\t"+moon.getName());
        }

        HeavenlyBody heavenlyBody1 = new HeavenlyBody("Pluto", 211);
        planets.add(heavenlyBody1);

        System.out.println("Planets: ");
        for (HeavenlyBody currentPlanet : planets) {
            System.out.println("\t" + currentPlanet.getName() +" : "+currentPlanet.getOrbitalPeriod());
        }

        System.out.println("Actual Set: "+planets);

        System.out.println("Reverse Set: "+planets.descendingSet());

        System.out.println("Head Set: "+planets.headSet(new HeavenlyBody("Jupiter",4000), true));

        System.out.println("SubSet: "+planets.subSet(new HeavenlyBody("Jupiter",4000), true, new HeavenlyBody("Mercury",80), true));

        System.out.println("TailSet: "+planets.tailSet(new HeavenlyBody("Jupiter",4000), false));
    }
}
