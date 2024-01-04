package be.vdab.todoapplicatie;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mensen", schema = "todo")
public class Mens {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "voornaam")
    private String voornaam;
    @Basic
    @Column(name = "familienaam")
    private String familienaam;
    @ElementCollection
    @CollectionTable(name = "todos", joinColumns = @JoinColumn(name = "mensId"))
    private Collection<Todo> todos;

    public Mens(String voornaam, String familienaam) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
    }
    protected Mens() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mens mens = (Mens) o;
        return Objects.equals(id, mens.id) && Objects.equals(voornaam, mens.voornaam) && Objects.equals(familienaam, mens.familienaam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, voornaam, familienaam);
    }

    public Collection<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }
}
