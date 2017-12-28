DROP TABLE web7_member;

CREATE TABLE web7_member(
	id			VARCHAR2(20)	PRIMARY KEY,
	password	VARCHAR2(20)	NOT NULL,
	name		VARCHAR2(20)	NOT NULL
);

INSERT INTO web7_member
	(id, password, name)
VALUES
	('aaa', 'aaa', '마이크 미라-');

COMMIT;
