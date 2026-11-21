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
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import pl.wsb.chesspair.account.domain.UserAccount;




/** Dodałem profil szachisty. Powiązanie z kontem użytkownika zostawiłem na kolejne laboratoria. */
/** Lab3 - powiazalem profil z kontem uzytkownika */
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

/** lab3 - dodalem opcjonalna relacje one to one z kontem
* ustawilem lazy, aby dane konta byly pobierane dopiero gdy sa potrzebne. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id", unique = true)
    private UserAccount account;

    protected Player() {
    }

/** lab3 - rozszerzylem konstruktor o konto przypisane do gracza. */
    public Player(String nickname, Integer rating, PieceColor color, boolean available, LocalDateTime createdAt, UserAccount account) {
        this.nickname = nickname;
        this.rating = rating;
        this.color = color;
        this.available = available;
        this.createdAt = createdAt;
        this.account = account;
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

/** lab3 - dodalem getter pozwalajacy odczytac konto gracza */
    public UserAccount getAccount() {return account; }
}
