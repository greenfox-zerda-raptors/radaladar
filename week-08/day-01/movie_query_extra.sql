/* https://lagunita.stanford.edu/courses/DB/SQL/SelfPaced/courseware/ch-sql/seq-exercise-sql_movie_query_extra/
Q1*/
select distinct name
from reviewer re
join rating r
	on re.rid = r.rid
join movie m
	on m.mid = r.mid
where title like "Gone with the Wind";

/*Q2*/
select name, title, stars
from reviewer re
join rating r
	on re.rid = r.rid
join movie m
	on m.mid = r.mid
where name = director;

/*Q3*/
select * from
( select name from reviewer
union
select title from movie) as bbb
order by name asc;

/*Q4 not ready*/
select distinct title
from reviewer re
join rating r
	on re.rid = r.rid
join movie m
	on m.mid = r.mid;
where name like "chris jackson";