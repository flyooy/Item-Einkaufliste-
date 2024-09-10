package backend.supercode.einkaufsliste.entitites;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int menge;
    private String laden;
    private boolean gekauft;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public String getLaden() {
        return laden;
    }

    public void setLaden(String laden) {
        this.laden = laden;
    }

    public boolean isGekauft() {
        return gekauft;
    }

    public void setGekauft(boolean gekauft) {
        this.gekauft = gekauft;
    }
}