

import java.util.TreeMap;

/**
 * Created by Stas on 31.05.2015.
 */
public class SuperHero implements SomeAmazingInterface{

    int power, defence;
    String name;

    TreeMap<String,SomeAmazingInterface> superPeople = new TreeMap<String,SomeAmazingInterface>();


    public SuperHero (String name, int power, int defence){
        this.power = power;
        this.defence = defence;
        this.name = name;
    }

    public void addSuperHero(SuperHero superHero) {
        superPeople.put(superHero.name,superHero);
    }

    public void powerIncreasing(int additionalPower) {
        power += additionalPower;
    }

    public void defenceIncreasing(int additionalDefence) {
        defence += additionalDefence;
    }

    public void fightManFight(SuperHero hostile) {
        System.out.println(this.name + " and " + hostile.name + " are fighting");
    }

    public int getPower() {
        return power;
    }

    public int getDefence() {
        return defence;
    }

    public boolean isHeALive() {
        return defence > 0 ? true : false;
    }
}
