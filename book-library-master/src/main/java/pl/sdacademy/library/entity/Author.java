package pl.sdacademy.library.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
public class Author extends Person {

    @Column(name = "biography", length = 4000)
    private String biography;

    @ManyToMany(mappedBy = "authors")
    private List<Publication> publications;

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }
}
