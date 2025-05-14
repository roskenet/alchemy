ALTER TABLE not_synchronized_article
ADD COLUMN type text NOT NULL DEFAULT 'LVS_SYNC';

ALTER TABLE not_synchronized_article RENAME TO queued_article_action;