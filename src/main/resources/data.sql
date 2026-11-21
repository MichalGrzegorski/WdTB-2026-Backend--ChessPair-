-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01 (R1.03): dodałem konta członków zespołu, niezależne od kont GitHub.
insert into user_account (email, display_name, role, created_at) values
    ('s179785@student.wroclaw.merito.pl', 'Michał Grzegorski', 'USER', current_timestamp),
    ('s954533@student.wroclaw.merito.pl', 'Jakub Jakubowski', 'USER', current_timestamp),
    ('wrx101020@student.wroclaw.merito.pl', 'Radosław Jędraszek', 'USER', current_timestamp);

-- LAB 02: dodałem graczy o zbliżonych rankingach i przeciwnych kolorach.
-- Przygotowałem sześć profili, aby później pokazać trzy potencjalne pary.
-- lab3 - dodalem user_account_id i powiazalem trzy profile z kontami zespolu
-- konta maja identyfikatory 5, 6 i 7. pozostale profile nie maja konta (null)
insert into player (nickname, rating, color, available, created_at, user_account_id) values
    ('BialySkoczek', 1200, 'WHITE', true, current_timestamp, 5),
    ('CzarnyGoniec', 1220, 'BLACK', true, current_timestamp, 6),
    ('BialaWieza', 1500, 'WHITE', true, current_timestamp, 7),
    ('CzarnyHetman', 1530, 'BLACK', true, current_timestamp, null),
    ('BialyKrol', 1800, 'WHITE', false, current_timestamp, null),
    ('CzarnySkoczek', 1810, 'BLACK', false, current_timestamp, null);

-- LAB 02: dodałem turnieje na różnych etapach organizacji.
insert into tournament (name, start_date, location, max_players, status) values
    ('Jesienny turniej Merito', '2026-11-21', 'Wrocław, sala turniejowa Merito', 16, 'REGISTRATION'),
    ('Wieczorny turniej błyskawiczny', '2026-11-05', 'Online', 32, 'IN_PROGRESS'),
    ('Październikowy turniej akademicki', '2026-10-24', 'Wrocław, klub szachowy', 24, 'FINISHED');

-- lab3 - tournament registration
-- lab3 - dodalem zapisy graczy do turniejow
insert into tournament_registration
    (player_id, tournament_id, registered_at, status) values
    (3, 1, '2026-11-18 10:00:00', 'CONFIRMED'),
    (4, 1, '2026-11-18 10:15:00', 'CONFIRMED'),
    (1, 2, '2026-11-04 12:00:00', 'CONFIRMED'),
    (2, 2, '2026-11-04 12:15:00', 'CONFIRMED'),
    (3, 2, '2026-11-04 12:30:00', 'CONFIRMED'),
    (5, 3, '2026-10-23 09:00:00', 'CONFIRMED'),
    (6, 3, '2026-10-23 09:15:00', 'CONFIRMED');

-- lab3 - dodalem przykladowe rundy turniejow
insert into tournament_round
    (tournament_id, round_number, starts_at, status) values
    (1, 1, '2026-11-21 10:00:00', 'SCHEDULED'),
    (2, 1, '2026-11-05 19:00:00', 'IN_PROGRESS'),
    (3, 1, '2026-10-24 10:00:00', 'FINISHED');

-- LAB 02: dodałem partie bez relacji do graczy i turniejów, zgodnie z instrukcją.
-- Zmapowałem kolumny initial_seconds i increment_seconds w klasie wbudowanej TimeControl.
-- lab3 - przypisalem do kazdej partii gracza bialymi i czarnymi
-- lab3 - przypisalem partie turniejowa do rundy o identyfikatorze 1
insert into chess_game (status, scheduled_at, online, is_tournament, initial_seconds, increment_seconds, white_player_id, black_player_id, tournament_round_id) values
    ('SCHEDULED', '2026-11-20 18:00:00', true, false, 300, 3, 1, 2, null),
    ('SCHEDULED', '2026-11-21 10:00:00', false, true, 900, 10, 3, 4, 1),
    ('FINISHED', '2026-11-01 12:00:00', true, false, 180, 2, 5, 6, null);