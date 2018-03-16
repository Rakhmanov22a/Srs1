package kz.kaznitu.lessons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClientMoto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameMoto;
    private int god;
    private int cena;


    public ClientMoto() { }

    public ClientMoto(String nameMoto, int god, int cena) {
        this.nameMoto = nameMoto;
        this.god = god;
        this.cena= cena;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameMoto() {
        return nameMoto;
    }

    public void setNameMoto(String nameMoto) {
        this.nameMoto = nameMoto;
    }

    public int getGod() {
        return god;
    }

    public void setGod(int god) {
        this.god= god;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena= cena;
    }
}
