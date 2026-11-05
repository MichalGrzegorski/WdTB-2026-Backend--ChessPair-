package pl.wsb.chesspair.game.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;

/** Zgrupowałem czas podstawowy na gracza i przyrost za ruch w tempo gry; obie wartości zapisałem w sekundach. */
@Embeddable
public class TimeControl {

    @Min(1)
    @Column(name = "initial_seconds", nullable = false)
    private Integer initialSeconds;

    @Min(0)
    @Column(name = "increment_seconds", nullable = false)
    private Integer incrementSeconds;

    protected TimeControl() {
    }

    public TimeControl(Integer initialSeconds, Integer incrementSeconds) {
        this.initialSeconds = initialSeconds;
        this.incrementSeconds = incrementSeconds;
    }

    public Integer getInitialSeconds() {
        return initialSeconds;
    }

    public Integer getIncrementSeconds() {
        return incrementSeconds;
    }
}
