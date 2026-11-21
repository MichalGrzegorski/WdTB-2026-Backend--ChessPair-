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
import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;

/** lab3 - dodalem encje rundy turnieju
 * kazda runda nalezy do jednego turnieju */

@Entity
@Table(name = "tournament_round",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"tournament_id", "round_number"}))
public class TournamentRound {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    @Min(1)
    @Column(name = "round_number", nullable = false)
    private Integer roundNumber;

    @Column(name = "starts_at", nullable = false)
    private LocalDateTime startsAt;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    protected TournamentRound() {
    }

    public TournamentRound(Tournament tournament, Integer roundNumber,
                           LocalDateTime startsAt, String status) {
        this.tournament = tournament;
        this.roundNumber = roundNumber;
        this.startsAt = startsAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public String getStatus() {
        return status;
    }
}
