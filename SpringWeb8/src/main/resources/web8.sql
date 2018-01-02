-- 회원
CREATE TABLE customer8(
	custid		VARCHAR2(20)	PRIMARY KEY,
	password	VARCHAR2(20)	NOT NULL,
	name		VARCHAR2(30)	NOT NULL,
	email		VARCHAR2(30)	,
	division	VARCHAR2(30)	NOT NULL,
	idno		VARCHAR2(20)	UNIQUE,
	address		VARCHAR2(100)
);

-- 테스트용 데이터
-- division: personal(개인), company(법인)
INSERT INTO customer8
VALUES ('aaa', 'aaa', '홍길동', 'aaa@aaa.com', 'personal', '180102-3123456', '서울');

-- 게시판
CREATE TABLE board8(
	boardnum		NUMBER			PRIMARY KEY,
	id				VARCHAR2(20)	NOT NULL,
	title			VARCHAR2(100)	NOT NULL,
	content			VARCHAR2(2000)	,
	inputdate		DATE			DEFAULT SYSDATE,
	hits			NUMBER			DEFAULT 0,
	originalfile	VARCHAR2(200),	-- 원본 파일명
	savedfile		VARCHAR2(100)	-- 저장 파일명
);

-- 게시판 시퀀스
CREATE SEQUENCE board8_seq;

-- 테스트용 데이터
INSERT INTO board8 (boardnum, id, title, content)
VALUES (board8_seq.nextval, 'aaa', 'test1', 'content for test1');

-- 댓글
CREATE TABLE reply8(
	replynum	NUMBER			PRIMARY KEY,
	boardnum	NUMBER			NOT NULL,
	id			VARCHAR2(20)	NOT NULL,
	text		VARCHAR2(200)	NOT NULL,
	inputdate	DATE			DEFAULT SYSDATE,
	CONSTRAINT reply8_fk FOREIGN KEY(boardnum)
		REFERENCES board8(boardnum) ON DELETE CASCADE
);

-- 시퀀스
CREATE SEQUENCE reply8_seq;

-- 테스트용 데이터
INSERT INTO reply8(replynum, boardnum, id, text)
VALUES (reply8_seq.nextval, 1, 'aaa', 'text for test1');













