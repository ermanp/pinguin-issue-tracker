package com.pinguin.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "developer")
    private Set<Story> stories;

    public Developer() {
    }

    public Developer(Long id, String name, Set<Story> stories) {
        this.id = id;
        this.name = name;
        this.stories = stories;
    }

    public Developer(String name) {
        this.name = name;
    }

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

    public Set<Story> getStories() {
        return stories;
    }

    public void setStories(Set<Story> stories) {
        this.stories = stories;
    }
}
