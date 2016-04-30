CREATE TABLE animals
(
  id          INTEGER PRIMARY KEY,
  name        varchar2(256),
  species_id  INTEGER CONSTRAINT a_species_id_fk REFERENCES species(id),
  zoo_id      INTEGER CONSTRAINT a_zoo_id_fk REFERENCES zoo(id)
);

CREATE TABLE species
(
  id          INTEGER PRIMARY KEY,
  name        varchar2(256)
);

CREATE TABLE zoo
(
  id          INTEGER PRIMARY KEY,
  name        varchar2(256)
);

