CREATE TABLE attraction(
attraction_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20),
location VARCHAR(50),
`describe` VARCHAR(200),
score DOUBLE,
latitude DOUBLE,
longtitude DOUBLE,
visited_count BIGINT UNSIGNED,
want_count BIGINT UNSIGNED,
recommend_count BIGINT UNSIGNED,
cover VARCHAR(30),
author_id BIGINT UNSIGNED,
gmt_create DATETIME
)

 SELECT * FROM attraction   WHERE  NAME LIKE '河南' OR location LIKE '河南' OR `describe` LIKE '河南' ORDER BY 
 (SELECT COUNT(*) FROM attractionship WHERE attraction_id=attraction.`attraction_id`) DESC
 
  SELECT * FROM attraction   WHERE  NAME LIKE '河南' OR location LIKE '河南' OR `describe` LIKE '河南' ORDER BY 
 (SELECT COUNT(*) FROM post WHERE attraction_id=attraction.`attraction_id`) DESC
 
 
 
 SELECT * FROM attraction ORDER BY recommend_count DESC
 
 SELECT           attraction_id, NAME, location, `describe`, score, latitude, longtitude, visited_count,     want_count, recommend_count, cover, author_id, gmt_create         FROM attraction     WHERE attraction_id = 1