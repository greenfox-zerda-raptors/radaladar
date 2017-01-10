-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

/*https://lagunita.stanford.edu/courses/DB/SQL/SelfPaced/courseware/ch-sql/seq-exercise-sql_movie_query_core/
Q1*/
select m.title from movie m where m.director like "%spielberg%";
 
/*Q2*/
select distinct year from movie m join rating r on m.mid = r.mid where r.stars > 3 order by year asc;

/*Q3*/
select m.title from movie m left join rating r on m.mid = r.mid where r.mid is null;

/*Q4*/
select re.name
from reviewer re
left join rating r
	on re.rid = r.rid
where r.ratingdate is null;

/*Q5*/
select re.name, m.title, r.stars, r.ratingdate
from reviewer re
join rating r
	on re.rid = r.rid
join movie m
	on r.mid = m.mid
order by re.name, m.title, r.stars;

/*Q6*/
select name, title
from Reviewer, Movie, Rating, Rating r2
where Rating.mID=Movie.mID and Reviewer.rID=Rating.rID 
  and Rating.rID = r2.rID and r2.mID = Movie.mID
  and Rating.stars < r2.stars and Rating.ratingDate < r2.ratingDate;
  
/*Q7*/
select title, max(stars)
from rating r
join movie m
	on m.mid = r.mid
group by title
order by title;

/*Q8*/
select title, max(stars) - min(stars) as spread
from rating r
join movie m
	on m.mid = r.mid
group by title
order by spread desc, title;

/*Q9*/
select abs(avg(avgrating2) - avg(avgrating1)) as difference
from (
select title, avg(stars) as avgrating1
from rating r
join movie m
	on m.mid = r.mid
where year < 1980
group by title) as beforeeighties
join (
select title, avg(stars) as avgrating2
from rating r
join movie m
	on m.mid = r.mid
where year > 1980
group by title) as aftereighties;