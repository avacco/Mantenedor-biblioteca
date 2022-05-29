 ## MARIA DB
CREATE TABLE usuarios(
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255),
    password VARCHAR(255),
    roles VARCHAR(255),
    CONSTRAINT usuarios_pk PRIMARY KEY ( id )
);

CREATE TABLE autor(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    CONSTRAINT autor_pk PRIMARY KEY ( id )
);

CREATE TABLE libro(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    descripcion VARCHAR(255),
    autor_id      INTEGER NOT NULL,
    CONSTRAINT libro_pk PRIMARY KEY ( id )
);

ALTER TABLE libro
    ADD CONSTRAINT libro_autor_fk FOREIGN KEY ( autor_id )
        REFERENCES autor ( id );