package pokemon;

import java.util.Map;

public class Type {

    private static Map<String, Integer> indexes = Map.ofEntries(
        Map.entry("normal", 0),
        Map.entry("fire", 1),
        Map.entry("water", 2),
        Map.entry("electric", 3),
        Map.entry("grass", 4),
        Map.entry("ice", 5),
        Map.entry("fighting", 6),
        Map.entry("poison", 7),
        Map.entry("ground", 8),
        Map.entry("flying", 9),
        Map.entry("psychic", 10),
        Map.entry("bug", 11),
        Map.entry("rock", 12),
        Map.entry("ghost", 13),
        Map.entry("dragon", 14)
    );

    private String name;

    public Type(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Type){
            return this.name.equals(((Type)other).name);
        }
        return false;
    }

    private static double[][] effect = {
    //    n   f   w   e   g   i   f   p   g   f   p   b   r   g   d
        {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.5,0.0,1.0},// Normal
        {1.0,0.5,0.5,1.0,2.0,2.0,1.0,1.0,1.0,1.0,1.0,2.0,0.5,1.0,0.5},// Fire
        {1.0,2.0,0.5,1.0,0.5,1.0,1.0,1.0,2.0,1.0,1.0,1.0,2.0,1.0,0.5},// Water
        {1.0,1.0,2.0,0.5,0.5,1.0,1.0,1.0,0.0,2.0,1.0,1.0,1.0,1.0,0.5},// Electric
        {1.0,0.5,2.0,1.0,0.5,1.0,1.0,0.5,2.0,0.5,1.0,0.5,2.0,1.0,0.5},// Grass
        {1.0,1.0,0.5,1.0,2.0,0.5,1.0,1.0,1.0,2.0,1.0,1.0,1.0,1.0,2.0},// Ice
        {2.0,1.0,1.0,1.0,1.0,2.0,1.0,0.5,1.0,0.5,0.5,0.5,2.0,0.0,1.0},// Fighting
        {1.0,1.0,1.0,1.0,2.0,1.0,1.0,0.5,0.5,1.0,1.0,2.0,0.5,0.5,1.0},// Poison
        {1.0,2.0,1.0,2.0,0.5,1.0,1.0,2.0,1.0,0.0,1.0,0.5,2.0,1.0,1.0},// Ground
        {1.0,1.0,1.0,0.5,2.0,1.0,2.0,1.0,1.0,1.0,1.0,2.0,0.5,1.0,1.0},// Flying
        {1.0,1.0,1.0,1.0,1.0,1.0,2.0,2.0,1.0,1.0,0.5,1.0,1.0,1.0,1.0},// Psychic
        {1.0,0.5,1.0,1.0,2.0,1.0,0.5,2.0,1.0,0.5,2.0,1.0,1.0,0.5,1.0},// Bug
        {1.0,2.0,1.0,1.0,1.0,2.0,0.5,1.0,0.5,2.0,1.0,2.0,1.0,1.0,1.0},// Rock
        {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0},// Ghost
        {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0},// Dragon
    };

    public static double getEffect(Type attacker, Type defender) {
        int atkIndex = indexes.get(attacker.getName());
        int defIndex = indexes.get(defender.getName());
        return effect[atkIndex][defIndex];
    }

}