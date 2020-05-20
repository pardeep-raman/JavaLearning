package collections.collection.set.sortedSet.treeSet;

import java.util.Set;
import java.util.TreeSet;

public final class HeavenlyBody implements Comparable<HeavenlyBody>{

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){
        return satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites(){
        return new TreeSet<>(satellites);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null){
            return false;
        }
        if (this == object) {
            return true;
        }
        if (object instanceof HeavenlyBody) {
            String name = ((HeavenlyBody) object).getName();
            return this.getName().equals(name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 57;
    }

    @Override
    public int compareTo(HeavenlyBody o) {
        return this.getName().compareTo(o.getName());
    }
}
