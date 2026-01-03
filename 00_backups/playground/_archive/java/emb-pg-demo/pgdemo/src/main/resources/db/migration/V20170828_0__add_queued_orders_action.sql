CREATE TABLE queued_orders_action (
	id SERIAL PRIMARY KEY,
	expected_inbound_date TEXT NOT NULL,
	type TEXT NOT NULL,
	timestamp_added TIMESTAMP
);
