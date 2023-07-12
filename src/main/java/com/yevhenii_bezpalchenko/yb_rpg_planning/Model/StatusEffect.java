package com.yevhenii_bezpalchenko.yb_rpg_planning.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "statusEffect")
public class StatusEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String icon;
    @OneToMany(mappedBy = "statusEffect", cascade = CascadeType.ALL)
    private List<Stats> statsList;
    @Column(nullable = false)
    private double changeStat;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Stats> getStatsList() {
        return statsList;
    }

    public void setStatsList(List<Stats> statsList) {
        this.statsList = statsList;
    }

    public double getChangeStat() {
        return changeStat;
    }

    public void setChangeStat(double changeStat) {
        this.changeStat = changeStat;
    }

    public StatusEffect(Long id, String name, String description, String icon, List<Stats> statsList, double changeStat) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.statsList = statsList;
        this.changeStat = changeStat;
    }
}
