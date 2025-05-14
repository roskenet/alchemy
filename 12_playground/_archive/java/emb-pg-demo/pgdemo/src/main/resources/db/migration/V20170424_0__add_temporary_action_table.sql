CREATE TABLE temporary_action (
	id SERIAL PRIMARY KEY,
	article_id bigint NOT NULL,
	action_type text NOT NULL,
	timestamp TIMESTAMP
);
