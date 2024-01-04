package be.vdab.todoapplicatie;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class Todo {
    private String tekst;

    private int prioriteit;

    private Timestamp gemaakt;


    public Todo(String tekst, int prioriteit) {
        this.tekst = tekst;
        this.prioriteit = prioriteit;
        this.gemaakt = new Timestamp(System.currentTimeMillis());
    }

    protected Todo() {

    }


    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getPrioriteit() {
        return prioriteit;
    }

    public void setPrioriteit(int prioriteit) {
        this.prioriteit = prioriteit;
    }

    public Timestamp getGemaakt() {
        return gemaakt;
    }

    public void setGemaakt(Timestamp gemaakt) {
        this.gemaakt = gemaakt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return prioriteit == todo.prioriteit && Objects.equals(tekst, todo.tekst) && Objects.equals(gemaakt, todo.gemaakt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tekst, prioriteit, gemaakt);
    }



}
