ALTER TABLE queued_article_action
  ADD COLUMN action_status TEXT NOT NULL,
  ADD COLUMN execution_after TIMESTAMP NOT NULL DEFAULT (now()),
  ADD COLUMN last_modification TIMESTAMP NOT NULL,
  ADD COLUMN version INT NOT NULL,

  ADD UNIQUE (article_id, action_status, type);