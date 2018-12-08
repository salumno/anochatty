INSERT INTO food(name)
SELECT 'Meat'
WHERE NOT EXISTS (
  SELECT id FROM food WHERE id = 1
);

INSERT INTO food(name)
SELECT 'Fish'
WHERE NOT EXISTS (
  SELECT id FROM food WHERE id = 2
);

INSERT INTO food(name)
SELECT 'Vegetables'
WHERE NOT EXISTS (
  SELECT id FROM food WHERE id = 3
);

INSERT INTO food(name)
SELECT 'Fruits'
WHERE NOT EXISTS (
  SELECT id FROM food WHERE id = 4
);

INSERT INTO food(name)
SELECT 'Eggs'
WHERE NOT EXISTS (
  SELECT id FROM food WHERE id = 5
);

INSERT INTO food(name)
SELECT 'Fast Food'
WHERE NOT EXISTS (
  SELECT id FROM food WHERE id = 6
);

INSERT INTO movie(name)
SELECT 'Action'
WHERE NOT EXISTS (
  SELECT id FROM movie WHERE id = 1
);


INSERT INTO movie(name)
SELECT 'Adventure'
WHERE NOT EXISTS (
  SELECT id FROM movie WHERE id = 2
);


INSERT INTO movie(name)
SELECT 'Comedy'
WHERE NOT EXISTS (
  SELECT id FROM movie WHERE id = 3
);


INSERT INTO movie(name)
SELECT 'Drama'
WHERE NOT EXISTS (
  SELECT id FROM movie WHERE id = 4
);


INSERT INTO movie(name)
SELECT 'Fantasy'
WHERE NOT EXISTS (
  SELECT id FROM movie WHERE id = 5
);


INSERT INTO movie(name)
SELECT 'Thriller'
WHERE NOT EXISTS (
  SELECT id FROM movie WHERE id = 6
);

INSERT INTO music(name)
SELECT 'Alternative'
WHERE NOT EXISTS (
  SELECT id FROM music WHERE id = 1
);

INSERT INTO music(name)
SELECT 'Blues'
WHERE NOT EXISTS (
  SELECT id FROM music WHERE id = 2
);

INSERT INTO music(name)
SELECT 'Classical'
WHERE NOT EXISTS (
  SELECT id FROM music WHERE id = 3
);

INSERT INTO music(name)
SELECT 'Country'
WHERE NOT EXISTS (
  SELECT id FROM music WHERE id = 4
);

INSERT INTO music(name)
SELECT 'Dance'
WHERE NOT EXISTS (
  SELECT id FROM music WHERE id = 5
);

INSERT INTO music(name)
SELECT 'Pop'
WHERE NOT EXISTS (
  SELECT id FROM music WHERE id = 6
);

INSERT INTO music(name)
SELECT 'Rock'
WHERE NOT EXISTS (
  SELECT id FROM music WHERE id = 7
);