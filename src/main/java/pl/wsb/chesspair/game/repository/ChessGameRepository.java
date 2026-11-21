package pl.wsb.chesspair.game.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.chesspair.game.entity.ChessGame;

/** lab3 - dodalem wyszukiwanie partii po pseudonimie gracza bialymi*/
public interface ChessGameRepository
        extends JpaRepository<ChessGame, Long> {

    List<ChessGame> findByWhitePlayer_Nickname(String nickname);
}