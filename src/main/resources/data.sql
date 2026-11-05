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
