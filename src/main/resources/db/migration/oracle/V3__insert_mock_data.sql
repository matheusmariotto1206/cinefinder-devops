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
-- MOVIES (média já em 0–10)
-- =========================
INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Inception', 'Dreams inside dreams', DATE '2010-07-16', 9.6, 'https://image.tmdb.org/t/p/w500/qmDpIHrmpJINaRKAfWQfftjCdyi.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Interstellar', 'Space exploration and time', DATE '2014-11-07', 9.4, 'https://image.tmdb.org/t/p/w500/rAiYTfKGqDCRIIqoNMq72g1XK8.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('The Matrix', 'Simulation reality', DATE '1999-03-31', 9.8, 'https://image.tmdb.org/t/p/w500/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg');

INSERT INTO cf_movie (title, description, release_date, average_rating, poster_url)
VALUES ('Avengers: Endgame', 'Final battle', DATE '2019-04-26', 9.0, 'https://image.tmdb.org/t/p/w500/or06FN3Dka5tukK1e9sl16pB3iy.jpg');

-- =========================
-- MOVIE GENRES
-- =========================
INSERT INTO cf_movie_genres (movie_id, genre) VALUES (1, 'SCI_FI');
INSERT INTO cf_movie_genres (movie_id, genre) VALUES (1, 'ACTION');
INSERT INTO cf_movie_genres (movie_id, genre) VALUES (2, 'SCI_FI');
INSERT INTO cf_movie_genres (movie_id, genre) VALUES (2, 'DRAMA');
INSERT INTO cf_movie_genres (movie_id, genre) VALUES (3, 'SCI_FI');
INSERT INTO cf_movie_genres (movie_id, genre) VALUES (3, 'ACTION');
INSERT INTO cf_movie_genres (movie_id, genre) VALUES (4, 'ACTION');
INSERT INTO cf_movie_genres (movie_id, genre) VALUES (4, 'ADVENTURE');

-- =========================
-- MOVIE LISTS
-- =========================
INSERT INTO cf_movie_list (name, user_id)
VALUES ('Favoritos do Jon', 1);

INSERT INTO cf_movie_list (name, user_id)
VALUES ('Filmes para assistir', 2);

-- =========================
-- MOVIE LIST MOVIES
-- =========================
INSERT INTO cf_movie_list_movies (movie_id, movie_list_id) VALUES (1, 1);
INSERT INTO cf_movie_list_movies (movie_id, movie_list_id) VALUES (3, 1);
INSERT INTO cf_movie_list_movies (movie_id, movie_list_id) VALUES (2, 2);
INSERT INTO cf_movie_list_movies (movie_id, movie_list_id) VALUES (4, 2);

-- =========================
-- REVIEWS (0–10)
-- =========================
INSERT INTO cf_review (user_id, movie_id, rating, comments)
VALUES (1, 1, 10.0, 'Mind blowing!');

INSERT INTO cf_review (user_id, movie_id, rating, comments)
VALUES (2, 1, 9.0, 'Very good');

INSERT INTO cf_review (user_id, movie_id, rating, comments)
VALUES (3, 2, 9.4, 'Amazing visuals');

INSERT INTO cf_review (user_id, movie_id, rating, comments)
VALUES (1, 3, 10.0, 'Classic!');

INSERT INTO cf_review (user_id, movie_id, rating, comments)
VALUES (2, 4, 8.0, 'Great ending');