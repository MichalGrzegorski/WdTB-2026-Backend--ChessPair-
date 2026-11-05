package pl.wsb.chesspair.game.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;

/** Dodałem partię szachową. Na LAB 02 pominąłem relacje do graczy i turnieju. */
@Entity
@Table(name = "chess_game")
public class ChessGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private GameStatus status;

    @Column(name = "scheduled_at", nullable = false)
    private LocalDateTime scheduledAt;

    @Column(name = "online", nullable = false)
    private boolean online;

    @Column(name = "is_tournament", nullable = false)
    private boolean tournament;

    @Embedded
    @NotNull
    private TimeControl timeControl;

    protected ChessGame() {
    }

    public ChessGame(GameStatus status, LocalDateTime scheduledAt, boolean online, boolean tournament, TimeControl timeControl) {
        this.status = status;
        this.scheduledAt = scheduledAt;
        this.online = online;
        this.tournament = tournament;
        this.timeControl = timeControl;
    }

    public Long getId() {
        return id;
    }

    public GameStatus getStatus() {
        return status;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public boolean isOnline() {
        return online;
    }

    public boolean isTournament() {
        return tournament;
    }

    public TimeControl getTimeControl() {
        return timeControl;
    }
}
