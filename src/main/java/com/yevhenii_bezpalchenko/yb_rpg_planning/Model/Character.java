package com.yevhenii_bezpalchenko.yb_rpg_planning.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Entity
@Table(name = "character")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int xp;
    @Column(nullable = false)
    private int level;
    @Column(nullable = false)
    private double health;
    @Column(nullable = false)
    private double maxHealth;
    @Column(nullable = false)
    private double energy;

    @Column(nullable = false)
    private double maxEnergy;
    @Column(nullable = false)
    private int skillPoints;
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
    private List<StatusEffect> effects;
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
    private List<CharacterStat> stats;
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
    private List<Skill> skills;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setMaxHealth() {
        AtomicReference<Double> health = new AtomicReference<>((double) 0);
        this.stats.forEach(stat -> {
            if (stat.getStats().getName().equals("Health")) {
                health.set(stat.getValue());
            }
        });
        this.effects.forEach(effect -> {
            effect.getStatsList().forEach(stat -> {
                if (stat.getName().equals("Health")) {
                    health.set(health.get() + effect.getChangeStat());
                }
            });
        });
        this.maxHealth = health.get();
    }

}
