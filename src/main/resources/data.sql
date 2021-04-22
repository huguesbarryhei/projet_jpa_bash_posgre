DELETE FROM PERSON;
DELETE FROM BATCH_JOB_EXECUTION_CONTEXT;
DELETE FROM BATCH_JOB_EXECUTION_PARAMS;
DELETE FROM BATCH_JOB_EXECUTION_SEQ;
DELETE FROM BATCH_JOB_SEQ;
DELETE FROM BATCH_STEP_EXECUTION_SEQ;
DELETE FROM BATCH_STEP_EXECUTION_CONTEXT;
DELETE FROM BATCH_STEP_EXECUTION;
DELETE FROM BATCH_JOB_EXECUTION;
DELETE FROM BATCH_JOB_INSTANCE;

INSERT INTO PERSON(PRENOM, NOM, ADRESSE, METIER) VALUES
("Jean", "Dupont", "1 avenue nationale", "Docteur"),("Marc", "Martin", "2 avenue nationale", "Pharmacien"),
("Corinne", "Muller", "3 avenue nationale", "Plombier"),("Marcel", "Cohen", "4 avenue nationale", "Pharmacien"),
("Sarah", "Connor", "5 avenue nationale", "Boxeuse"),("Louis", "Dugué", "6 avenue nationale", "Docteur"),
("Paul", "Jaquet", "7 avenue nationale", "Pharmacien"),("Louise", "Adam", "8 avenue nationale", "Pharmacien"),
("Jijou", "Zizou", "9 avenue nationale", "Docteur"),("Léa", "Vise", "10 avenue nationale", "Docteur");