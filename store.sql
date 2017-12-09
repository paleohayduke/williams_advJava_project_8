DROP TABLE authorISBN;
DROP TABLE titles;
DROP TABLE authors;
DROP TABLE Book_t;
DROP TABLE Movie_t;
DROP TABLE Painting_t;
DROP TABLE Actor_t;
DROP TABLE StoreItem_t;

CREATE TABLE StoreItem_t (
   itemID INT NOT NULL,
   title varchar (50) NOT NULL,
   author varchar (30) NOT NULL,
   dateAquired varchar (30) NOT NULL,
   purchasePrice varchar (30) NOT NULL,
   askingPrice varchar (30) NOT NULL,
   type varchar (20) NOT NULL,
   sold varchar(10) NOT NULL,

   genre varchar (20),
   director varchar (20),
   height varchar (20),
   width varchar (20),
   media varchar (20),
   
   PRIMARY KEY (itemID)
);

CREATE TABLE Book_t(
   itemID INT NOT NULL,
   genre varchar (30),
   FOREIGN KEY (itemID) REFERENCES StoreItem_t(itemID)
);

create TABLE Movie_t(
   itemID INT NOT NULL,
   director varchar (30),
   FOREIGN KEY (itemID) REFERENCES StoreItem_t(itemID)
);

create TABLE Painting_t(
   itemID INT NOT NULL,
   height varchar (20),
   width varchar (20),
   media varchar (20),
   FOREIGN KEY (itemID) REFERENCES StoreItem_t(itemID)
);

CREATE TABLE Actor_t(
   actor varchar(30),
   itemID INT NOT NULL,
   FOREIGN KEY (itemID) REFERENCES StoreItem_t(itemID)
);

INSERT INTO StoreItem_t (itemID, title, author, dateAquired, purchasePrice, askingPrice, type, sold)
VALUES
   (1,'Internet & World Wide Web How to Program', 'Stan','5 10 1998','24.00','20.12', 'book', 'false'),
   (2,'Some book', 'Janus Silvershoes','7 12 2008','34.66','77.99','book', 'false'),
   (3,'Jurassic Park', 'Michael Crichton','2 10 1992','14.99','50.99','movie', 'false'),
   (4,'Martin', 'George Romero','9 1 1986','5.00','1.00','movie','false'),
   (5,'Cheese on a Table', 'Mickey Mouse','1 1 2002','1.00','200.41','painting','false');

INSERT INTO Book_t (itemID, genre)
VALUES
   (1,'IT how to'),
   (2,'misc');

INSERT INTO Movie_t(itemID, director)
VALUES
   (3,'Steven Speilberg'),
   (4,'George Romero');

INSERT INTO Painting_t(itemID, height, width, media)
VALUES
   (5,'5','5','crayon');

INSERT INTO Actor_t (actor, itemID)
VALUES 
   ('Paul',3), 
   ('Harvey',3),
   ('Abbey',4), 
   ('Dan',4),
   ('Michael',4);