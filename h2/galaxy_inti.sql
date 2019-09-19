CREATE SCHEMA space_schema authorization sa;

CREATE TABLE space_schema.galaxy (
ID INT auto_increment PRIMARY KEY,
FACT VARCHAR(255) DEFAULT '');


INSERT INTO space_schema.galaxy VALUES (1, 'Milky Way');

INSERT INTO space_schema.galaxy VALUES (2, 'Messier 63');

INSERT INTO space_schema.galaxy VALUES (3, 'Cartwheel');

select * from space_schema.galaxy;

UPDATE space_schema.galaxy SET FACT = 'Neptune’s giant, spinning storms could swallow the whole Earth.' WHERE ID =1;
UPDATE space_schema.galaxy SET FACT = 'Saturn is the only planet in our solar system that is less dense than water. It could float in a bathtub.' WHERE ID = 2;
UPDATE space_schema.galaxy SET FACT = 'On Mars, gravity is one third that on earth.' WHERE ID = 3;
