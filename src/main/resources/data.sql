DROP TABLE IF EXISTS PERSON;
DROP TABLE IF EXISTS BATCH_JOB_EXECUTION_CONTEXT;
DROP TABLE IF EXISTS BATCH_JOB_EXECUTION_PARAMS;
DROP TABLE IF EXISTS BATCH_STEP_EXECUTION_CONTEXT;
DROP TABLE IF EXISTS BATCH_STEP_EXECUTION;
DROP TABLE IF EXISTS BATCH_JOB_EXECUTION;
DROP TABLE IF EXISTS BATCH_JOB_INSTANCE;
DROP TABLE IF EXISTS PHARMACIEN;

CREATE TABLE IF NOT EXISTS PERSON  (
    ID SERIAL,
    PRENOM VARCHAR(20) NOT NULL,
    NOM VARCHAR(20),
    METIER VARCHAR(20),
    ADRESSE VARCHAR(255),
    PRIMARY KEY(ID)
    ) ;

INSERT INTO PERSON(PRENOM, NOM, ADRESSE, METIER) VALUES
('Jean', 'Dupont', '1 avenue nationale', 'Docteur'),('Marc', 'Martin', '2 avenue nationale', 'Pharmacien'),
('Corinne', 'Muller', '3 avenue nationale', 'Plombier'),('Marcel', 'Cohen', '4 avenue nationale', 'Pharmacien'),
('Sarah', 'Connor', '5 avenue nationale', 'Boxeuse'),('Louis', 'Dugué', '6 avenue nationale', 'Docteur'),
('Paul', 'Jaquet', '7 avenue nationale', 'Pharmacien'),('Louise', 'Adam', '8 avenue nationale', 'Pharmacien'),
('Jijou', 'Zizou', '9 avenue nationale', 'Docteur'),('Léa', 'Vise', '10 avenue nationale', 'Docteur');