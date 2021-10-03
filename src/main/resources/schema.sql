DROP TABLE IF EXISTS example;
CREATE TABLE example(
    id PRIMARY KEY SERIAL,
    info VARCHAR,
    single_point public.POINT
);

INSERT INTO example(info,single_point) VALUES('info example','(1,2)');