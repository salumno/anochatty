INSERT INTO preference(name)
SELECT 'Music'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 1
);

INSERT INTO preference(name)
SELECT 'Movie'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 2
);

INSERT INTO preference(name)
SELECT 'Food'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 3
);

INSERT INTO preference(name)
SELECT 'Series'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 4
);

INSERT INTO preference(name)
SELECT 'Adult'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 5
);

INSERT INTO preference(name)
SELECT 'Games'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 6
);

INSERT INTO preference(name)
SELECT 'Fashion'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 7
);

INSERT INTO preference(name)
SELECT 'IT'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 8
);

INSERT INTO preference(name)
SELECT 'Business'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 9
);

INSERT INTO preference(name)
SELECT 'Cars'
WHERE NOT EXISTS (
  SELECT id FROM preference WHERE id = 10
);


