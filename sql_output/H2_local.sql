BEGIN TRANSACTION;

CREATE TABLE IF NOT EXISTS local (
    publicId VARCHAR(255),
    code VARCHAR(255),
    retired VARCHAR(255)
    ,PRIMARY KEY (publicId)
);

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = '3349eb05-d98e-46be-a0b6-a8cd545b46c5')
WHEN MATCHED THEN
    UPDATE SET code = 'en_CA', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('3349eb05-d98e-46be-a0b6-a8cd545b46c5', 'en_CA', 'FALSE');

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = '872b181d-d0ce-48a2-8730-4961867d9e2c')
WHEN MATCHED THEN
    UPDATE SET code = 'fr_CA', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('872b181d-d0ce-48a2-8730-4961867d9e2c', 'fr_CA', 'FALSE');

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = '2ea4440c-8280-4c9d-b342-36412879940c')
WHEN MATCHED THEN
    UPDATE SET code = 'es_MX', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('2ea4440c-8280-4c9d-b342-36412879940c', 'es_MX', 'FALSE');

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = 'b76c1ba3-b3a5-4a44-8631-21a1a2cefaba')
WHEN MATCHED THEN
    UPDATE SET code = 'pt_BR', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('b76c1ba3-b3a5-4a44-8631-21a1a2cefaba', 'pt_BR', 'FALSE');

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = '68e4e64b-35ef-4d55-aea0-e07d4aa69f7e')
WHEN MATCHED THEN
    UPDATE SET code = 'en_US', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('68e4e64b-35ef-4d55-aea0-e07d4aa69f7e', 'en_US', 'FALSE');

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = '13fe32d5-165b-46d2-900f-4114d423d211')
WHEN MATCHED THEN
    UPDATE SET code = 'fr_FR', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('13fe32d5-165b-46d2-900f-4114d423d211', 'fr_FR', 'FALSE');

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = 'ed9c378d-e552-40a2-90db-052ff4a2b424')
WHEN MATCHED THEN
    UPDATE SET code = 'de_DE', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('ed9c378d-e552-40a2-90db-052ff4a2b424', 'de_DE', 'FALSE');

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = '64f16e96-de1c-492c-a009-8b1127b4f6be')
WHEN MATCHED THEN
    UPDATE SET code = 'it_IT', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('64f16e96-de1c-492c-a009-8b1127b4f6be', 'it_IT', 'FALSE');

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = '3f877fd9-dd00-4c16-8220-09a25e98e20a')
WHEN MATCHED THEN
    UPDATE SET code = 'zh_CN', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('3f877fd9-dd00-4c16-8220-09a25e98e20a', 'zh_CN', 'FALSE');

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = 'c5069d36-7f1f-40cd-a65c-5205c00255c3')
WHEN MATCHED THEN
    UPDATE SET code = 'ja_JP', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('c5069d36-7f1f-40cd-a65c-5205c00255c3', 'ja_JP', 'FALSE');

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = 'edde0712-d9cb-438a-8f21-d4c9c697fcd3')
WHEN MATCHED THEN
    UPDATE SET code = 'fa_IR', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('edde0712-d9cb-438a-8f21-d4c9c697fcd3', 'fa_IR', 'FALSE');

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = '7b47b31e-e671-4218-8dde-5ef8dd91bf91')
WHEN MATCHED THEN
    UPDATE SET code = 'ar_SA', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('7b47b31e-e671-4218-8dde-5ef8dd91bf91', 'ar_SA', 'FALSE');

MERGE INTO local USING (SELECT 1) AS DUAL
ON (local.publicId = '29b7bebd-f9ce-450c-b7aa-21a3213673f6')
WHEN MATCHED THEN
    UPDATE SET code = 'tr_TR', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, retired) VALUES ('29b7bebd-f9ce-450c-b7aa-21a3213673f6', 'tr_TR', 'FALSE');


COMMIT;
