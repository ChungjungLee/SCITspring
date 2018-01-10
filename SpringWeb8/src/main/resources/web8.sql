-- 회원
DROP TABLE customer8;
CREATE TABLE customer8(
	custid		VARCHAR2(20)	CONSTRAINT customer8_pk PRIMARY KEY,
	password	VARCHAR2(20)	NOT NULL,
	name		VARCHAR2(30)	NOT NULL,
	email		VARCHAR2(30)	,
	division	VARCHAR2(30)	NOT NULL,
	idno		VARCHAR2(20)	UNIQUE,
	address		VARCHAR2(100)
);

-- 게시판
DROP TABLE board8 CASCADE CONSTRAINTS;
CREATE TABLE board8(
	boardnum		NUMBER			CONSTRAINT board8_pk PRIMARY KEY,
	id				VARCHAR2(20)	NOT NULL,
	title			VARCHAR2(100)	NOT NULL,
	content			VARCHAR2(2000)	,
	inputdate		DATE			DEFAULT SYSDATE,
	hits			NUMBER			DEFAULT 0
);

-- 게시판 시퀀스
DROP SEQUENCE board8_seq;
CREATE SEQUENCE board8_seq;

-- 첨부파일
DROP TABLE attachment8;
CREATE TABLE attachment8(
	attachmentnum	NUMBER			CONSTRAINT attachment8_pk PRIMARY KEY,
	boardnum		NUMBER,
	originalfile	VARCHAR2(200)	NOT NULL,
	savedfile		VARCHAR2(100)	NOT NULL,
	CONSTRAINT attachment8_fk FOREIGN KEY(boardnum)
		REFERENCES board8(boardnum) ON DELETE CASCADE
);

-- 첨부파일 시퀀스
DROP SEQUENCE attachment8_seq;
CREATE SEQUENCE attachment8_seq;

-- 댓글
DROP TABLE reply8;
CREATE TABLE reply8(
	replynum	NUMBER			CONSTRAINT reply8_pk PRIMARY KEY,
	boardnum	NUMBER			NOT NULL,
	id			VARCHAR2(20)	NOT NULL,
	text		VARCHAR2(200)	NOT NULL,
	inputdate	DATE			DEFAULT SYSDATE,
	CONSTRAINT reply8_fk FOREIGN KEY(boardnum)
		REFERENCES board8(boardnum) ON DELETE CASCADE
);

-- 시퀀스
DROP SEQUENCE reply8_seq;
CREATE SEQUENCE reply8_seq;

-- 테스트용 데이터
-- division: personal(개인), company(법인)
INSERT INTO customer8
VALUES ('aaa', 'aaa', '홍길동', 'aaa@aaa.com', 'personal', '180102-3123456', '서울');

-- 테스트용 데이터
INSERT INTO board8 (boardnum, id, title, content)
VALUES (board8_seq.nextval, 'aaa', 'test1', 'content for test1');

-- 테스트용 데이터
INSERT INTO reply8(replynum, boardnum, id, text)
VALUES (reply8_seq.nextval, 1, 'aaa', 'text for test1');












