CREATE TABLE if NOT EXISTS trainer (
    trainer_id INT(5) AUTO_INCREMENT,
    trainer_name VARCHAR(30),
    trainer_age INT(5),
    trainer_gender CHAR,

     CONSTRAINT pk_trainer PRIMARY KEY (trainer_id)
);

ALTER TABLE trainer AUTO_INCREMENT=10000;

CREATE TABLE if NOT EXISTS element_type (
    element_type_id INT(5) AUTO_INCREMENT,
    element_type VARCHAR(15),
    element_type_desc VARCHAR(1000),

    CONSTRAINT pk_element_type PRIMARY KEY (element_type_id)
);

ALTER TABLE element_type AUTO_INCREMENT=20000;

CREATE TABLE if NOT EXISTS pokemon_attack (
    pokemon_attack_id INT(5) AUTO_INCREMENT,
    element_type_id INT(5),
    pokemon_attack_desc VARCHAR(400),

    CONSTRAINT pk_pokemon_attack PRIMARY KEY (pokemon_attack_id),
    CONSTRAINT fk_pro_element_type_id FOREIGN KEY (element_type_id) REFERENCES element_type(element_type_id)
);

ALTER TABLE pokemon_attack AUTO_INCREMENT=30000;

CREATE TABLE if NOT EXISTS pokemon_defence (
    pokemon_defence_id INT(5) AUTO_INCREMENT,
    element_type_id INT(5),
    pokemon_defence_desc VARCHAR(400),

    CONSTRAINT pk_pokemon_defence PRIMARY KEY (pokemon_defence_id),
    CONSTRAINT fk_con_element_type_id FOREIGN KEY (element_type_id) REFERENCES element_type(element_type_id)
);

ALTER TABLE pokemon_defence AUTO_INCREMENT=40000;

CREATE TABLE if NOT EXISTS pokemon (
    pokemon_id INT(5) AUTO_INCREMENT,
    pokemon_name VARCHAR(25),
    pokemon_desc VARCHAR(500),
    pokemon_generation INT(3),
    pokemon_evolution_level INT(3),
    trainer_id INT(5),

    CONSTRAINT pk_pokemon PRIMARY KEY (pokemon_id),
    CONSTRAINT fk_trainer_id FOREIGN KEY (trainer_id) REFERENCES trainer(trainer_id)
);

ALTER TABLE pokemon AUTO_INCREMENT=50000;

CREATE TABLE if NOT EXISTS pokemon_type (
    pokemon_type_id INT(5) AUTO_INCREMENT,
    pokemon_id INT(5),
    element_type_id INT(5),


    CONSTRAINT pk_pokemon_type_id PRIMARY KEY (pokemon_type_id, element_type_id, pokemon_id),
    CONSTRAINT fk_type_pokemon_id FOREIGN KEY (pokemon_id) REFERENCES pokemon(pokemon_id),
    CONSTRAINT fk_pokemon_element_type_id FOREIGN KEY (element_type_id) REFERENCES element_type(element_type_id)
   );

ALTER TABLE pokemon_type AUTO_INCREMENT=60000;

CREATE TABLE if NOT EXISTS abilities (
    ability_id INT(5) AUTO_INCREMENT,
    ability_name VARCHAR(25),
    ability_description VARCHAR(50),

    CONSTRAINT pk_abilities PRIMARY KEY (ability_id)
);

ALTER TABLE abilities AUTO_INCREMENT=70000;

CREATE TABLE if NOT EXISTS evolution(
    evolution_id INT(5) AUTO_INCREMENT,
    pokemon_id INT(5),
    evolution_first_stage VARCHAR(15),
    evolution_second_stage VARCHAR(15),
    evolution_third_stage VARCHAR(15),

    CONSTRAINT pk_evolution PRIMARY KEY (evolution_id),
    CONSTRAINT fk_pokemon_evolution_id FOREIGN KEY (pokemon_id) REFERENCES pokemon(pokemon_id)
);

ALTER TABLE evolution AUTO_INCREMENT=80000;

CREATE TABLE if NOT EXISTS pokemon_abilities(
    pokemon_id INT(5),
    ability_id INT(5),

    CONSTRAINT pk_pokemon_abilities PRIMARY KEY (pokemon_id, ability_id),
    CONSTRAINT fk_pokemon_abilities_id FOREIGN KEY (pokemon_id) REFERENCES pokemon(pokemon_id),
    CONSTRAINT fk_abilities_id FOREIGN KEY (ability_id) REFERENCES abilities(ability_id)
);
