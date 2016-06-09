
-- create the db schema from the sql cli or mysql workbench, that flyway will migrate on:

CREATE SCHEMA `note-db` ;


mvn clean install flyway:clean flyway:migrate

mvn spring-boot:run

-- in case of any problem with the flyway, you can run the db script under 

test-app/src/main/resources/db/migration/V1__create_tables.sql