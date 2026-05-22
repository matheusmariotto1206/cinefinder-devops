-- =========================
-- LIMPA DADOS DE DESENVOLVIMENTO
-- =========================
DELETE FROM cf_movie_list_movies;
DELETE FROM cf_movie_list;
DELETE FROM cf_review;
DELETE FROM cf_movie_genres;
DELETE FROM cf_movie;
DELETE FROM cf_user;

-- =========================
-- USERS
-- =========================
INSERT INTO cf_user (name, email, password, age, is_admin)
VALUES ('Jon', 'jon@email.com', '$2a$10$RhSleCCmroOvMSrrtNbhzearAG4Blpfm3do73DhGGNprho.tW/JEC', 20, 1);

INSERT INTO cf_user (name, email, password, age, is_admin)
VALUES ('Maria', 'maria@email.com', '$2a$10$LdpMVsbt0tfhMsOqGHARdebUDtyGQ7o6Ljjo7LqfOQgcz/WHJhUGe', 22, 0);

INSERT INTO cf_user (name, email, password, age, is_admin)
VALUES ('Carlos', 'carlos@email.com', '$2a$10$LdpMVsbt0tfhMsOqGHARdebUDtyGQ7o6Ljjo7LqfOQgcz/WHJhUGe', 30, 0);

-- =========================
-- MOVIES (da TMDB)
-- =========================
INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('O Jogo do Predador', 'Uma mulher em luto embarca sozinha em uma aventura pela natureza selvagem da Austrália, mas acaba se envolvendo em um jogo cruel de gato e rato com um assassino.', DATE '2026-04-24', 6.5, 'https://image.tmdb.org/t/p/w500/s0ub7FDXEyu8DqGcHKQpaOSem49.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Super Mario Galaxy: O Filme', 'Depois de salvar o Reino dos Cogumelos, Mario e seus amigos se encontram em uma missão intergaláctica para deter um novo vilão ameaçador.', DATE '2026-04-01', 6.7, 'https://image.tmdb.org/t/p/w500/b3WeTp42eJSRuE4UZfyPCOJW4c.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Socorro!', 'Após um acidente aéreo, um chefe e uma funcionária que se odeiam são os únicos sobreviventes. Isolados numa ilha deserta, eles precisam decidir se cooperam ou competem para escapar.', DATE '2026-01-22', 7.0, 'https://image.tmdb.org/t/p/w500/furPD78BZsKAWZoGvoqArIJYPy2.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Um Amor de Mentiras', 'Polina faz um acordo com o principal valentão da escola: ele finge ser seu namorado e a protege, e ela faz tudo o que ele mandar. Durante esse jogo, desenvolvem sentimentos verdadeiros.', DATE '2026-03-26', 6.9, 'https://image.tmdb.org/t/p/w500/hXNn25hE2SH2kHMPVOLjqDISSxf.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Michael', 'A história da vida de Michael Jackson além da música, desde os Jackson Five até se tornar o maior artista do mundo.', DATE '2026-04-22', 7.6, 'https://image.tmdb.org/t/p/w500/2FYFBgdNVVaUgVfNSh9z5WVTZ9y.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Avatar: Fogo e Cinzas', 'Jake Sully e Neytiri enfrentam o Povo das Cinzas, uma tribo Na''vi violenta liderada pela implacável Varang, em uma luta pela sobrevivência e pelo futuro de Pandora.', DATE '2025-12-17', 7.4, 'https://image.tmdb.org/t/p/w500/9k2zKeUfcKkAz1dGt5MP6dZMm4G.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Eles Vão te Matar', 'Uma mulher aceita um emprego como governanta em um arranha-céu de Nova York, sem saber da história de desaparecimentos do prédio.', DATE '2026-03-25', 6.4, 'https://image.tmdb.org/t/p/w500/kPiqEJ8reCWKZXIWgweQd6eR2tP.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Vingança Brutal', 'Quando sua esposa é brutalmente assassinada, Carlos Estrada, herói das forças especiais, transforma sua fortuna em um arsenal e inicia uma caçada pelos responsáveis.', DATE '2026-02-26', 7.1, 'https://image.tmdb.org/t/p/w500/88P3qzWBRYvI0K5fNtqwwXQsvwi.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Devoradores de Estrelas', 'O professor de ciências Ryland Grace acorda em uma espaçonave anos-luz de casa sem memória de quem ele é ou como chegou lá.', DATE '2026-03-15', 8.2, 'https://image.tmdb.org/t/p/w500/bOzG3SG6gBxHGGHYiq7xXeNb1bG.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Cara de Um, Focinho de Outro', 'Mabel transfere sua mente para um castor robô e tenta convencer animais a impedir a construção de uma rodovia que destruirá suas florestas.', DATE '2026-03-04', 7.6, 'https://image.tmdb.org/t/p/w500/ftPFJBGbldoWiiPrmesW96zBzdH.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Missão Refúgio', 'Um ex-assassino de aluguel salva uma garota de uma tempestade, forçando-o a sair da aposentadoria e enfrentar seu passado perigoso para protegê-la.', DATE '2026-01-28', 6.8, 'https://image.tmdb.org/t/p/w500/hSvhZRkbYD9crC4nqy8uCk9EdFH.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Um Cabra Bom de Bola', 'Uma pequena cabra com grandes sonhos recebe uma oportunidade única de se juntar aos profissionais no berrobol, esporte dominado pelos animais mais rápidos do mundo.', DATE '2026-02-11', 7.9, 'https://image.tmdb.org/t/p/w500/x0SRTrltSJi1iQiIAUpyvkxnr41.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Caminhos do Crime', 'Um ladrão realiza assaltos de alto risco pela rodovia 101. Seu caminho cruza com uma corretora de seguros desiludida enquanto um detetive implacável se aproxima.', DATE '2026-02-11', 6.9, 'https://image.tmdb.org/t/p/w500/3u8Pr8WF9hqMptlnuYL52YXSs8F.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Demon Slayer: Kimetsu no Yaiba Castelo Infinito', 'Tanjiro e os Hashira são lançados por Muzan Kibutsuji em um espaço misterioso para um confronto final no Castelo Infinito.', DATE '2025-07-18', 7.7, 'https://image.tmdb.org/t/p/w500/c55sXCaQBj3vuHqZe62tv90xCQS.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Malèna', 'Em 1941, numa pequena vila na Sicília, um grupo de garotos de 13 anos nutre uma profunda paixão por Malena, a viúva de um soldado local.', DATE '2000-10-27', 7.4, 'https://image.tmdb.org/t/p/w500/aGK0x9RblIUqkLp6xKYMSttlqMn.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('O Diabo Veste Prada', 'Andrea Sachs consegue um emprego como assistente de Miranda Priestly, principal executiva da maior revista de moda de Nova York.', DATE '2006-06-29', 7.4, 'https://image.tmdb.org/t/p/w500/clsvqIWM5ZILUcHjobQd4WtHZdu.jpg');

-- =========================
-- MOVIE GENRES
-- =========================
-- O Jogo do Predador
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'O Jogo do Predador'), 'ACTION');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'O Jogo do Predador'), 'THRILLER');

-- Super Mario Galaxy: O Filme
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Super Mario Galaxy: O Filme'), 'FAMILY');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Super Mario Galaxy: O Filme'), 'COMEDY');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Super Mario Galaxy: O Filme'), 'ADVENTURE');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Super Mario Galaxy: O Filme'), 'FANTASY');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Super Mario Galaxy: O Filme'), 'ANIMATION');

-- Socorro!
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Socorro!'), 'HORROR');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Socorro!'), 'THRILLER');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Socorro!'), 'COMEDY');

-- Um Amor de Mentiras
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Um Amor de Mentiras'), 'ROMANCE');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Um Amor de Mentiras'), 'DRAMA');

-- Michael
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Michael'), 'MUSIC');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Michael'), 'DRAMA');

-- Avatar: Fogo e Cinzas
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Avatar: Fogo e Cinzas'), 'SCI_FI');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Avatar: Fogo e Cinzas'), 'ADVENTURE');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Avatar: Fogo e Cinzas'), 'FANTASY');

-- Eles Vão te Matar
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Eles Vão te Matar'), 'HORROR');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Eles Vão te Matar'), 'ACTION');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Eles Vão te Matar'), 'COMEDY');

-- Vingança Brutal
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Vingança Brutal'), 'ACTION');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Vingança Brutal'), 'THRILLER');

-- Devoradores de Estrelas
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Devoradores de Estrelas'), 'SCI_FI');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Devoradores de Estrelas'), 'ADVENTURE');

-- Cara de Um, Focinho de Outro
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Cara de Um, Focinho de Outro'), 'ANIMATION');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Cara de Um, Focinho de Outro'), 'FAMILY');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Cara de Um, Focinho de Outro'), 'SCI_FI');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Cara de Um, Focinho de Outro'), 'COMEDY');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Cara de Um, Focinho de Outro'), 'ADVENTURE');

-- Missão Refúgio
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Missão Refúgio'), 'CRIME');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Missão Refúgio'), 'ACTION');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Missão Refúgio'), 'THRILLER');

-- Um Cabra Bom de Bola
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Um Cabra Bom de Bola'), 'ANIMATION');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Um Cabra Bom de Bola'), 'COMEDY');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Um Cabra Bom de Bola'), 'FAMILY');

-- Caminhos do Crime
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Caminhos do Crime'), 'CRIME');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Caminhos do Crime'), 'THRILLER');

-- Demon Slayer
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Demon Slayer: Kimetsu no Yaiba Castelo Infinito'), 'ANIMATION');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Demon Slayer: Kimetsu no Yaiba Castelo Infinito'), 'ACTION');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Demon Slayer: Kimetsu no Yaiba Castelo Infinito'), 'FANTASY');

-- Malèna
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'Malèna'), 'DRAMA');

-- O Diabo Veste Prada
INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'O Diabo Veste Prada'), 'DRAMA');

INSERT INTO cf_movie_genres (movie_id, genre)
VALUES ((SELECT id FROM cf_movie WHERE title = 'O Diabo Veste Prada'), 'COMEDY');