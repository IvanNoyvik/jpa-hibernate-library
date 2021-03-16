-- CREATE SEQUENCE USER_ID_SEQ_GEN START WITH 1 INCREMENT BY 1 CACHE 10 NOCYCLE;
CREATE TABLE USERS(ID INTEGER AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(50) NOT NULL, EMAIL VARCHAR(50) NOT NULL);


-- CREATE TABLE AUTHENTICATES(LOGIN VARCHAR(50) NOT NULL, PASSWORD VARCHAR(50) NOT NULL, USER_ID INTEGER PRIMARY KEY NOT NULL);
CREATE TABLE AUTHENTICATES(LOGIN VARCHAR(50) NOT NULL, PASSWORD VARCHAR(50) NOT NULL, USER_ID INTEGER PRIMARY KEY NOT NULL);


-- CREATE SEQUENCE PRODUCT_ID_SEQ_GEN START WITH 1 INCREMENT BY 1 CACHE 10 NOCYCLE;
-- CREATE TABLE PRODUCTS(ID INTEGER NOT NULL, NAME VARCHAR(50) NOT NULL, DESCRIPTION VARCHAR(255) NOT NULL, PRICE DOUBLE NOT NULL, ENABLED BOOLEAN NOT NULL, USER_ID INTEGER);


-- CREATE SEQUENCE ROLE_ID_SEQ_GEN START WITH 1 INCREMENT BY 1 CACHE 10 NOCYCLE;
CREATE TABLE ROLES(ID INTEGER AUTO_INCREMENT PRIMARY KEY, ROLE VARCHAR(50) NOT NULL, USER_ID INTEGER NOT NULL);
-- CREATE TABLE ROLE_USER(ROLE_ID INTEGER NOT NULL, USER_ID INTEGER NOT NULL);


-- Administrator, User, Guest
CREATE TABLE ROLES (
                       ID int NOT NULL AUTO_INCREMENT,
                       ROLE varchar(20) NOT NULL UNIQUE,
                       PRIMARY KEY (ID)
);

-- ok, limited, locked
CREATE TABLE USERS_STATUSES (
                                ID int NOT NULL AUTO_INCREMENT,
                                STATUS varchar(20) NOT NULL,
                                DURATION date NOT NULL,
                                PRIMARY KEY (ID)
);


CREATE TABLE USERS (
                       ID int NOT NULL AUTO_INCREMENT,
                       NAME varchar(40) NOT NULL,
                       EMAIL VARCHAR(50) NOT NULL,
                       DATE_RECEIVING date NOT NULL,	    -- дата разблокировки()

                       ROLES_ID int NOT NULL,
                       USERS_STATUSES_ID int NOT NULL,

                       PRIMARY KEY (ID),
                       FOREIGN KEY (ROLES_ID) REFERENCES ROLES(ID),
                       FOREIGN KEY (USERS_STATUSES_ID) REFERENCES USERS_STATUSES (ID)
);

-- дата разблокировки (если меньше текущей - статус ок)

CREATE TABLE AUTHENTICATES(LOGIN VARCHAR(50) NOT NULL, PASSWORD VARCHAR(50) NOT NULL, USER_ID INTEGER PRIMARY KEY NOT NULL);




CREATE TABLE AUTHORS (
                         AUTHOR varchar(40) NOT NULL UNIQUE,
                         BOOK_ID
                         PRIMARY KEY (ID)
);


CREATE TABLE GENRES (
                        ID int NOT NULL AUTO_INCREMENT,
                        GENRE varchar(20) NOT NULL UNIQUE,
                        PRIMARY KEY (ID)
);


CREATE TABLE BOOKS (
                       ID int NOT NULL AUTO_INCREMENT,
                       TITLE varchar(63) NOT NULL,
                       DESCRIPTION varchar(255),	    -- описание
                       IMAGE BLOB,                     -- изображение
                       QUANTITY int NOT NULL,          -- колличество
                       AUTHORS_ID int NOT NULL,
                       GENRES_ID int NOT NULL,
                       PRIMARY KEY (ID),
                       FOREIGN KEY (AUTHORS_ID) REFERENCES AUTHORS(ID),
                       FOREIGN KEY (GENRES_ID) REFERENCES GENRES (ID)
);

-- Книги взятые пользавателями
CREATE TABLE ORDERS (
                        ID int NOT NULL AUTO_INCREMENT,
                        DATE_RECEIVING date NOT NULL,	    -- дата получения
                        DAYS int NOT NULL,		            -- на сколько дней
                        BOOKS_ID int NOT NULL,
                        USERS_ID int NOT NULL,
                        PRIMARY KEY (ID),
                        FOREIGN KEY (BOOKS_ID) REFERENCES BOOKS (ID),
                        FOREIGN KEY (USERS_ID) REFERENCES USERS (ID)
);

CREATE TABLE MESSAGES (
                          ID int NOT NULL AUTO_INCREMENT,
                          DATE_SENT date NOT NULL,
                          CONTENT varchar(255),
                          USERS_ID int NOT NULL,
                          PRIMARY KEY (ID),
                          FOREIGN KEY (USERS_ID) REFERENCES USERS (ID)
);