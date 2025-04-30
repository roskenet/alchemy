SELECT * FROM configs LIMIT 1;

SELECT '1974-08-22T03:42:18.123456+01'::timestamptz;

SELECT to_char(created_at, 'DD.MM.YYYY')
FROM configs
WHERE config_sku = 'ZI3-mzw-0014-99';