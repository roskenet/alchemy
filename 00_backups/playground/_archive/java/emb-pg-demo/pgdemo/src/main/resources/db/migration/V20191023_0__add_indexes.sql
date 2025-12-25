CREATE INDEX IF NOT EXISTS inbounded_article_time_and_ordered_idx ON inbounded_article((inbound_timestamp::DATE), is_ordered);

CREATE INDEX IF NOT EXISTS inbounded_article_ql_idx ON inbounded_article(ql);

CREATE INDEX IF NOT EXISTS ordered_article_expected_inbound_date_idx ON ordered_article((expected_inbound_date::DATE));

CREATE INDEX IF NOT EXISTS ordered_article_ean_idx ON ordered_article(ean);