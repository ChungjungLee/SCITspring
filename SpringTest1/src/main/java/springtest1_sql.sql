-- 영화 정보 테이블
DROP TABLE springtest1movie;
CREATE TABLE springtest1movie(
	movienum	NUMBER			PRIMARY KEY,
	title		VARCHAR2(50),
	director	VARCHAR2(50),
	stars		NUMBER
);

-- 영화정보 테이블 시퀀스
DROP SEQUENCE springtest1movie_seq;
CREATE SEQUENCE springtest1movie_seq;
