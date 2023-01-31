CREATE TABLE favorites(
user_id BIGINT UNSIGNED,
folder_id BIGINT UNSIGNED,
NAME VARCHAR(20),
description VARCHAR(200),
public BOOL,
item_count INT,
follow_count INT,
visited_count INT,
thumbup_count INT,
cover VARCHAR(30),
gmt_create DATETIME,
gmt_edit DATETIME
)