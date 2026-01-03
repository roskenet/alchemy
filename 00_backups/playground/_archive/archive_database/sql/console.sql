create table test (id serial, sometext text, someint INTEGER);

insert into test (sometext, someint) VALUES ('Blubber', 1234);
insert into test (sometext, someint) VALUES ('MyNewInsert', 4321);

select * from test;

explain analyze verbose select * from test;

-- If you want to analyze an insert or delete put it in a begin / rollback