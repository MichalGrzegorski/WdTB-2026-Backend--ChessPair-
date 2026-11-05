package pl.wsb.chesspair.player.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import jakarta.validation.constraints.Min;

/** Dodałem profil szachisty. Powiązanie z kontem użytkownika zostawiłem na kolejne laboratoria. */
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname", nullable = false, unique = true, length = 60)
    private String nickname;

    @Min(0)
    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Enumerated(EnumType.STRING)
    @Column(name = "color", nullable = false, length = 10)
    private PieceColor color;

    @Column(name = "available", nullable = false)
    private boolean available;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    protected Player() {
    }

    public Player(String nickname, Integer rating, PieceColor color, boolean available, LocalDateTime createdAt) {
        this.nickname = nickname;
        this.rating = rating;
        this.color = color;
        this.available = available;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getRating() {
        return rating;
    }

    public PieceColor getColor() {
        return color;
    }

    public boolean isAvailable() {
        return available;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
