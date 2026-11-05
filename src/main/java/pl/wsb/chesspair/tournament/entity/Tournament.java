package pl.wsb.chesspair.tournament.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import jakarta.validation.constraints.Min;

/** Dodałem dane turnieju. Powiązania z uczestnikami i partiami zostawiłem na kolejne laboratoria. */
@Entity
@Table(name = "tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "location", nullable = false, length = 160)
    private String location;

    @Min(2)
    @Column(name = "max_players", nullable = false)
    private Integer maxPlayers;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private TournamentStatus status;

    protected Tournament() {
    }

    public Tournament(String name, LocalDate startDate, String location, Integer maxPlayers, TournamentStatus status) {
        this.name = name;
        this.startDate = startDate;
        this.location = location;
        this.maxPlayers = maxPlayers;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getLocation() {
        return location;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public TournamentStatus getStatus() {
        return status;
    }
}
