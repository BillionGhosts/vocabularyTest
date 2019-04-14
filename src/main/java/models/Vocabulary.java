package models;

import javax.persistence.*;

/**
 * Created by Bill on 14.04.2019.
 */

@Entity
@Table(name = "vocabulary")

public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int object_id;

    private String word;
    private String comment;

    ///пустой конструктор
    public Vocabulary() {}

    public void setWord(String a) {
        word = a;
    }
    public void setComment(String a) {
        comment = a;
    }
    public String getWord() {
        return word;
    }
    public String getComment() {
        return comment;
    }
    public int getId() {
        return object_id;
    }

    @Override
    public String toString () {
        return "|"+object_id+" |"+word+" |"+comment;
    }
}
