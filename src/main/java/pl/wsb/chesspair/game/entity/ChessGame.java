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
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pl.wsb.chesspair.player.entity.Player;
import pl.wsb.chesspair.tournament.entity.TournamentRound;

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

/** lab3 - przypisałem do partii gracza grającego białymi.*/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "white_player_id", nullable = false)
    private Player whitePlayer;

/** lab3 - przypisałem do partii gracza grającego czarnymi.*/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "black_player_id", nullable = false)
    private Player blackPlayer;

/**lab3 - powiazalem partie szachowa z jej runda */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_round_id")
    private TournamentRound tournamentRound;

    protected ChessGame() {
    }
/** lab3 - rozszerzylem konstruktor o gracza bialymi i czarnymi */
    public ChessGame(GameStatus status, LocalDateTime scheduledAt, boolean online, boolean tournament, TimeControl timeControl, Player whitePlayer, Player blackPlayer, TournamentRound tournamentRound) {
        this.status = status;
        this.scheduledAt = scheduledAt;
        this.online = online;
        this.tournament = tournament;
        this.timeControl = timeControl;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.tournamentRound = tournamentRound;
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

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public TournamentRound getTournamentRound() {
        return tournamentRound;
    }
}
