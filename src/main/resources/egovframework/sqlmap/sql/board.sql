
CREATE TABLE BOARD(
  NO INTEGER GENERATED BY DEFAULT AS IDENTITY,
    SUBJECT VARCHAR(255) NOT NULL,
  CONTENT VARCHAR(255),
  CREATED datetime,
  PRIMARY KEY (NO)
);