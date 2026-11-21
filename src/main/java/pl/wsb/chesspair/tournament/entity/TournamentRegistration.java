package pl.wsb.chesspair.tournament.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDateTime;
import pl.wsb.chesspair.player.entity.Player;

/** lab3 - dodalem encje zapisu gracza do turnieju
* laczy graczy z turniejami many to many */

@Entity
@Table(name = "tournament_registration",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"player_id", "tournament_id"}))
public class TournamentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    protected TournamentRegistration() {
    }

    public TournamentRegistration(Player player, Tournament tournament,
                                  LocalDateTime registeredAt, String status) {
        this.player = player;
        this.tournament = tournament;
        this.registeredAt = registeredAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public String getStatus() {
        return status;
    }

}
