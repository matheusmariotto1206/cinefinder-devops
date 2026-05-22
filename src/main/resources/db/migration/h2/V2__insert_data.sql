-- =========================
-- USERS
-- =========================
INSERT INTO cf_user (name, email, password, age, is_admin) VALUES
                                                               ('Jon', 'jon@email.com', '$2a$10$RhSleCCmroOvMSrrtNbhzearAG4Blpfm3do73DhGGNprho.tW/JEC', 20, TRUE),
                                                               ('Maria', 'maria@email.com', '$2a$10$LdpMVsbt0tfhMsOqGHARdebUDtyGQ7o6Ljjo7LqfOQgcz/WHJhUGe', 22, FALSE),
                                                               ('Carlos', 'carlos@email.com', '$2a$10$LdpMVsbt0tfhMsOqGHARdebUDtyGQ7o6Ljjo7LqfOQgcz/WHJhUGe', 30, FALSE);
-- =========================
-- MOVIES
-- =========================
INSERT INTO cf_movie ( title, description, release_date, average_rating, poster_url) VALUES
                                                                                ( 'Inception', 'Dreams inside dreams', '2010-07-16', 4.8, 'https://image.tmdb.org/t/p/w500/qmDpIHrmpJINaRKAfWQfftjCdyi.jpg'),
                                                                                ('Interstellar', 'Space exploration and time', '2014-11-07', 4.7, 'https://image.tmdb.org/t/p/w500/rAiYTfKGqDCRIIqoNMq72g1XK8.jpg'),
                                                                                ( 'The Matrix', 'Simulation reality', '1999-03-31', 4.9, 'https://image.tmdb.org/t/p/w500/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg'),
                                                                                ( 'Avengers: Endgame', 'Final battle', '2019-04-26', 4.5, 'https://image.tmdb.org/t/p/w500/or06FN3Dka5tukK1e9sl16pB3iy.jpg');

-- =========================
-- MOVIE GENRES
-- =========================
INSERT INTO cf_movie_genres (movie_id, genre) VALUES
                                                  (1, 'SCI_FI'),
                                                  (1, 'ACTION'),
                                                  (2, 'SCI_FI'),
                                                  (2, 'DRAMA'),
                                                  (3, 'SCI_FI'),
                                                  (3, 'ACTION'),
                                                  (4, 'ACTION'),
                                                  (4, 'ADVENTURE');

-- =========================
-- MOVIE LISTS
-- =========================
INSERT INTO cf_movie_list ( name, user_id) VALUES
                                                  ( 'Favoritos do Jon', 1),
                                                  ('Filmes para assistir', 2);

-- =========================
-- MOVIE LIST MOVIES
-- =========================
INSERT INTO cf_movie_list_movies (movie_id, movie_list_id) VALUES
                                                               (1, 1),
                                                               (3, 1),
                                                               (2, 2),
                                                               (4, 2);

-- =========================
-- REVIEWS
-- =========================
INSERT INTO cf_review (user_id, movie_id, rating, comments) VALUES
                                                                    (1, 1, 5.0, 'Mind blowing!'),
                                                                    ( 2, 1, 4.5, 'Very good'),
                                                                    (3, 2, 4.7, 'Amazing visuals'),
                                                                    (1, 3, 5.0, 'Classic!'),
                                                                    (2, 4, 4.0, 'Great ending');