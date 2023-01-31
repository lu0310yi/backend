CREATE TABLE post(
post_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
author_id BIGINT UNSIGNED,
gmt_create DATETIME,
gmt_edit DATETIME,
attraction_id BIGINT UNSIGNED,
topic_id BIGINT UNSIGNED,
content VARCHAR(200),
image VARCHAR(50),
comment_count INT,
collection_count INT,
thumbup_count INT
)

