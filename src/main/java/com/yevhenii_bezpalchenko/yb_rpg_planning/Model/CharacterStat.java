package com.yevhenii_bezpalchenko.yb_rpg_planning.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "character_stat")
public class CharacterStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;

    @ManyToOne
    @JoinColumn(name = "stats_id")
    private Stats stats;

    @Column(nullable = false)
    private Double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStat(Stats stats) {
        this.stats = stats;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public CharacterStat(Long id, Character character, Stats stats, Double value) {
        this.id = id;
        this.character = character;
        this.stats = stats;
        this.value = value;
    }
}
