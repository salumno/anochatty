INSERT INTO preference(preference_type, name)
SELECT 'food', 'Meat'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 1
);

INSERT INTO preference(preference_type, name)
SELECT 'food', 'Fish'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 2
);

INSERT INTO preference(preference_type, name)
SELECT 'food', 'Vegetables'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 3
);

INSERT INTO preference(preference_type, name)
SELECT 'food', 'Fruits'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 4
);


INSERT INTO preference(preference_type, name)
SELECT 'food', 'Eggs'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 5
);

INSERT INTO preference(preference_type, name)
SELECT 'food', 'Fast Food'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 6
);

INSERT INTO preference(preference_type, name)
SELECT 'movie', 'Action'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 7
);

INSERT INTO preference(preference_type, name)
SELECT 'movie', 'Adventure'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 8
);

INSERT INTO preference(preference_type, name)
SELECT 'movie', 'Comedy'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 9
);

INSERT INTO preference(preference_type, name)
SELECT 'movie', 'Drama'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 10
);

INSERT INTO preference(preference_type, name)
SELECT 'movie', 'Fantasy'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 11
);

INSERT INTO preference(preference_type, name)
SELECT 'movie', 'Thriller'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 12
);

INSERT INTO preference(preference_type, name)
SELECT 'music', 'Alternative'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 13
);

INSERT INTO preference(preference_type, name)
SELECT 'music', 'Blues'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 14
);

INSERT INTO preference(preference_type, name)
SELECT 'music', 'Classical'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 15
);

INSERT INTO preference(preference_type, name)
SELECT 'music', 'Country'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 16
);

INSERT INTO preference(preference_type, name)
SELECT 'music', 'Dance'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 17
);

INSERT INTO preference(preference_type, name)
SELECT 'music', 'Pop'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 18
);

INSERT INTO preference(preference_type, name)
SELECT 'music', 'Rock'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 19
);

INSERT INTO preference(preference_type, name)
SELECT 'music', 'Hip-Hop'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 20
);