package be.vdab.todoapplicatie;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "todos", schema = "todo", catalog = "")
public class Todo {
    @Basic
    @Column(name = "mensId")
    private Object mensId;
    @Basic
    @Column(name = "tekst")
    private String tekst;
    @Basic
    @Column(name = "prioriteit")
    private int prioriteit;
    @Basic
    @Column(name = "gemaakt")
    private Timestamp gemaakt;
    @ManyToOne
    @JoinColumn(name = "mensId", referencedColumnName = "id", nullable = false)
    private Mens mensenByMensId;

    public Object getMensId() {
        return mensId;
    }

    public void setMensId(Object mensId) {
        this.mensId = mensId;
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
        return prioriteit == todo.prioriteit && Objects.equals(mensId, todo.mensId) && Objects.equals(tekst, todo.tekst) && Objects.equals(gemaakt, todo.gemaakt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mensId, tekst, prioriteit, gemaakt);
    }

    public Mens getMensenByMensId() {
        return mensenByMensId;
    }

    public void setMensenByMensId(Mens mensenByMensId) {
        this.mensenByMensId = mensenByMensId;
    }
}
