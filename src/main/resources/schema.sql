CREATE TABLE Billetter (
                           id SMALLINT NOT NULL AUTO_INCREMENT,
                           film CHAR(30) NOT NULL,
                           antall INT NOT NULL,
                           fornavn VARCHAR(50) NOT NULL,
                           etternavn VARCHAR(50) NOT NULL,
                           telefon VARCHAR(10) NOT NULL,
                           epost VARCHAR(50) NOT NULL,
                           PRIMARY KEY (id),
);