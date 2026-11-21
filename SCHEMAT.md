# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 6 · kolumny: 38 · relacje: 6 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 0 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| chess_game | ChessGame | 10 | black_player_id, tournament_round_id, white_player_id |
| player | Player | 7 | user_account_id |
| tournament | Tournament | 6 | — |
| tournament_registration | TournamentRegistration | 5 | player_id, tournament_id |
| tournament_round | TournamentRound | 5 | tournament_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    chess_game {
        Long id PK
        Long black_player_id FK
        Integer increment_seconds
        Integer initial_seconds
        boolean is_tournament
        boolean online
        LocalDateTime scheduled_at
        GameStatus status
        Long tournament_round_id FK
        Long white_player_id FK
    }
    player {
        Long id PK
        boolean available
        PieceColor color
        LocalDateTime created_at
        String nickname
        Integer rating
        Long user_account_id FK
    }
    tournament {
        Long id PK
        String location
        Integer max_players
        String name
        LocalDate start_date
        TournamentStatus status
    }
    tournament_registration {
        Long id PK
        Long player_id FK
        LocalDateTime registered_at
        String status
        Long tournament_id FK
    }
    tournament_round {
        Long id PK
        Integer round_number
        LocalDateTime starts_at
        String status
        Long tournament_id FK
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    player ||--o{ chess_game : "black_player_id"
    player ||--o{ chess_game : "white_player_id"
    player ||--o{ tournament_registration : "player_id"
    tournament ||--o{ tournament_registration : "tournament_id"
    tournament ||--o{ tournament_round : "tournament_id"
    tournament_round |o--o{ chess_game : "tournament_round_id"
    user_account |o--o| player : "user_account_id"
```
