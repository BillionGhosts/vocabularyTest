package models;

import javax.persistence.*;

/**
 * Created by Bill on 20.04.2019.
 */


@Entity
@Table (name = "character")
public class Character {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int character_id;

    private int strength;
    private int agility;
    private int intellect;
    private String name;

    public Character() {}

    public int getId() {
        return character_id;
    }



    @Override
    public String toString() {
        return name+" with Str: "+strength+", Agl: "+agility+", Int: "+intellect;
    }
    //getters and setters
    public int getCharStr() {
        return strength;
    }
    public int getCharAgl() {
        return agility;
    }
    public int getCharInt() {
        return intellect;
    }
    public String getName() {
        return name;
    }

    public void setStr(int a) {
        this.strength = a;
    }

    public void setAgl(int a) {
        this.agility = a;
    }

    public void setInt(int a) {
        this.intellect = a;
    }

    public void setName(String a) {
        this.name = a;
    }
}
