CREATE TABLE topic(
topic_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20),
`describe` VARCHAR(200),
author_id BIGINT UNSIGNED,
gmt_create DATETIME,
visited_count BIGINT UNSIGNED,
follow_count BIGINT UNSIGNED
)
 SELECT * FROM topic  WHERE `name` LIKE '%' '2' '%' OR description LIKE '2'`public`