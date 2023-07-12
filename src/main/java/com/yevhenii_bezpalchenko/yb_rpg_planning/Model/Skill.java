package com.yevhenii_bezpalchenko.yb_rpg_planning.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int skillPointsToLearn;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSkillPointsToLearn() {
        return skillPointsToLearn;
    }

    public void setSkillPointsToLearn(int skillPointsToLearn) {
        this.skillPointsToLearn = skillPointsToLearn;
    }

    public Skill(Long id, String name, String description, int skillPointsToLearn) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.skillPointsToLearn = skillPointsToLearn;
    }
}
