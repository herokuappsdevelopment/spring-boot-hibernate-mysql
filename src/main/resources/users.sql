CREATE TABLE myusers (
  userid INTEGER NOT NULL,
  firstName VARCHAR(50) NOT NULL,
  lastName VARCHAR(50) NOT NULL,
  address VARCHAR(100) NOT NULL,
  PRIMARY KEY (userid)
);

INSERT INTO myusers (userid,
 firstName,
 lastName, 
 address) VALUES (001,"Diane","Murphy","19,Quaker Ridge Rd,06801");

INSERT INTO myusers (userid,
 firstName,
 lastName, 
 address) VALUES (002,"Jeff","Firrelli","1000,Coney Island Ave,11230");


INSERT INTO myusers (userid,
 firstName,
 lastName, 
 address) VALUES (003,"Gerard","Bondur","2962,Dunedin CvGermantown,38138");

INSERT INTO myusers (userid,
 firstName,
 lastName, 
 address) VALUES (004,"Vanauf","George","1500,Vance Ave Memphis,38104");


INSERT INTO myusers (userid,
 firstName,
 lastName, 
 address) VALUES (005,"King","Tom","1577,Lobby Ave,38804");
 
COMMIT;

DROP PROCEDURE IF EXISTS fetch_users;

DELIMITER $$
CREATE PROCEDURE `boot`.`fetch_users` (IN uid INT, OUT total INT)
BEGIN
SELECT COUNT(userid) INTO total FROM myusers WHERE userid=uid;
END$$

DELIMITER ;

DROP PROCEDURE IF EXISTS fetch_userbyid;

DELIMITER $$
CREATE PROCEDURE `boot`.`fetch_userbyid` (IN uid INT)
BEGIN
SELECT * FROM myusers WHERE userid=uid;
END$$

DELIMITER ;

DROP PROCEDURE IF EXISTS fetch_all_users;

DELIMITER $$
CREATE PROCEDURE `boot`.`fetch_all_users`()
   
BEGIN
	SELECT * FROM myusers;
END$$

DELIMITER ;

COMMIT;

CALL fetch_userbyid(1);

CALL fetch_all_users();

CALL fetch_users(5,@count);

SELECT @count;

 