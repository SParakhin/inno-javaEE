CREATE TABLE PERSON
(
  id         INT NOT NULL AUTO_INCREMENT,
  name       VARCHAR(250),
  birth_date LONG (250),
  login      VARCHAR(250),
  password   varchar(250)
);

insert into PERSON (name, birth_date, login, password) VALUES ('admin','01012000','admin','123');