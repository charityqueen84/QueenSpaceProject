CREATE SCHEMA space_schema authorization sa;

CREATE TABLE space_schema.galaxy (
ID INT auto_increment PRIMARY KEY,
TITLE VARCHAR(255) DEFAULT '',


INSERT INTO space_schema.galaxy VALUES (1, 'Milky Way');

INSERT INTO space_schema.galaxy VALUES (2, 'Messier 63');

INSERT INTO space_schema.galaxy VALUES (3, 'Cartwheel');

select * from space_schema.galaxy;