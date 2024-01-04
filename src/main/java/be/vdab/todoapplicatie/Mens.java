package be.vdab.todoapplicatie;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "mensen", schema = "todo", catalog = "")
public class Mens {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Object id;
    @Basic
    @Column(name = "voornaam")
    private String voornaam;
    @Basic
    @Column(name = "familienaam")
    private String familienaam;
    @OneToMany(mappedBy = "mensenByMensId")
    private Collection<Todo> todosById;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
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

    public Collection<Todo> getTodosById() {
        return todosById;
    }

    public void setTodosById(Collection<Todo> todosById) {
        this.todosById = todosById;
    }
}
