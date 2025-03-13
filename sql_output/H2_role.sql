BEGIN TRANSACTION;

CREATE TABLE IF NOT EXISTS role (
    publicId VARCHAR(255),
    code VARCHAR(255),
    en_CA VARCHAR(255),
    fr_CA VARCHAR(255),
    en_US VARCHAR(255),
    es_US VARCHAR(255),
    es_MX VARCHAR(255),
    retired VARCHAR(255)
    ,PRIMARY KEY (publicId)
);

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '0bc7b4e5-aa01-44d5-a114-8dc46e75c824')
WHEN MATCHED THEN
    UPDATE SET code = 'Policy Analyst', en_CA = 'Policy Analyst', fr_CA = 'Analyste des politiques', en_US = 'Policy Analyst', es_US = 'Analista de Políticas', es_MX = 'Analista de Políticas', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('0bc7b4e5-aa01-44d5-a114-8dc46e75c824', 'Policy Analyst', 'Policy Analyst', 'Analyste des politiques', 'Policy Analyst', 'Analista de Políticas', 'Analista de Políticas', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '7641965e-ae83-4c1f-b126-a21a908bfa22')
WHEN MATCHED THEN
    UPDATE SET code = 'System Architect', en_CA = 'System Architect', fr_CA = 'Architecte de systèmes', en_US = 'System Architect', es_US = 'Arquitecto de Sistemas', es_MX = 'Arquitecto de Sistemas', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('7641965e-ae83-4c1f-b126-a21a908bfa22', 'System Architect', 'System Architect', 'Architecte de systèmes', 'System Architect', 'Arquitecto de Sistemas', 'Arquitecto de Sistemas', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = 'b80abae7-a9f5-474d-8e75-808739f25b01')
WHEN MATCHED THEN
    UPDATE SET code = 'Cybersecurity Analyst', en_CA = 'Cybersecurity Analyst', fr_CA = 'Analyste en cybersécurité', en_US = 'Cybersecurity Analyst', es_US = 'Analista de Ciberseguridad', es_MX = 'Analista de Ciberseguridad', retired = 'TRUE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('b80abae7-a9f5-474d-8e75-808739f25b01', 'Cybersecurity Analyst', 'Cybersecurity Analyst', 'Analyste en cybersécurité', 'Cybersecurity Analyst', 'Analista de Ciberseguridad', 'Analista de Ciberseguridad', 'TRUE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = 'c76751d4-3f79-43bb-b468-13305bc5185f')
WHEN MATCHED THEN
    UPDATE SET code = 'QA Engineer', en_CA = 'QA Engineer', fr_CA = 'Ingénieur en assurance qualité', en_US = 'QA Engineer', es_US = 'Ingeniero de Control de Calidad', es_MX = 'Ingeniero de Control de Calidad', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('c76751d4-3f79-43bb-b468-13305bc5185f', 'QA Engineer', 'QA Engineer', 'Ingénieur en assurance qualité', 'QA Engineer', 'Ingeniero de Control de Calidad', 'Ingeniero de Control de Calidad', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '3473be84-999c-42af-aafa-23b36d3b59e1')
WHEN MATCHED THEN
    UPDATE SET code = 'Actuary', en_CA = 'Actuary', fr_CA = 'Actuaire', en_US = 'Actuary', es_US = 'Actuario', es_MX = 'Actuario', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('3473be84-999c-42af-aafa-23b36d3b59e1', 'Actuary', 'Actuary', 'Actuaire', 'Actuary', 'Actuario', 'Actuario', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = 'ed7f3167-b49e-4e3e-8dcc-f9c4e32f21ce')
WHEN MATCHED THEN
    UPDATE SET code = 'Automation Engineer', en_CA = 'Automation Engineer', fr_CA = 'Ingénieur en automatisation', en_US = 'Automation Engineer', es_US = 'Ingeniero de Automatización', es_MX = 'Ingeniero de Automatización', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('ed7f3167-b49e-4e3e-8dcc-f9c4e32f21ce', 'Automation Engineer', 'Automation Engineer', 'Ingénieur en automatisation', 'Automation Engineer', 'Ingeniero de Automatización', 'Ingeniero de Automatización', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = 'dab01602-1a19-4c7b-b665-afa1054f898b')
WHEN MATCHED THEN
    UPDATE SET code = 'Data Analyst', en_CA = 'Data Analyst', fr_CA = 'Analyste de données', en_US = 'Data Analyst', es_US = 'Analista de Datos', es_MX = 'Analista de Datos', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('dab01602-1a19-4c7b-b665-afa1054f898b', 'Data Analyst', 'Data Analyst', 'Analyste de données', 'Data Analyst', 'Analista de Datos', 'Analista de Datos', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '89dc866d-92e4-4504-a087-e0b87402600a')
WHEN MATCHED THEN
    UPDATE SET code = 'Database Administrator', en_CA = 'Database Administrator', fr_CA = 'Administrateur de bases de données', en_US = 'Database Administrator', es_US = 'Administrador de Bases de Datos', es_MX = 'Administrador de Bases de Datos', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('89dc866d-92e4-4504-a087-e0b87402600a', 'Database Administrator', 'Database Administrator', 'Administrateur de bases de données', 'Database Administrator', 'Administrador de Bases de Datos', 'Administrador de Bases de Datos', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '90b1326d-fa73-4bf1-80f8-fb3a0187f9c8')
WHEN MATCHED THEN
    UPDATE SET code = 'Incident Responder', en_CA = 'Incident Responder', fr_CA = 'Répondant aux incidents', en_US = 'Incident Responder', es_US = 'Especialista en Respuesta a Incidentes', es_MX = 'Especialista en Respuesta a Incidentes', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('90b1326d-fa73-4bf1-80f8-fb3a0187f9c8', 'Incident Responder', 'Incident Responder', 'Répondant aux incidents', 'Incident Responder', 'Especialista en Respuesta a Incidentes', 'Especialista en Respuesta a Incidentes', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '28b8101c-e6f2-4018-8491-eedbd6e5d440')
WHEN MATCHED THEN
    UPDATE SET code = 'Cloud Solutions Architect', en_CA = 'Cloud Solutions Architect', fr_CA = 'Architecte de solutions en nuage', en_US = 'Cloud Solutions Architect', es_US = 'Arquitecto de Soluciones en la Nube', es_MX = 'Arquitecto de Soluciones en la Nube', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('28b8101c-e6f2-4018-8491-eedbd6e5d440', 'Cloud Solutions Architect', 'Cloud Solutions Architect', 'Architecte de solutions en nuage', 'Cloud Solutions Architect', 'Arquitecto de Soluciones en la Nube', 'Arquitecto de Soluciones en la Nube', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = 'e5ebdfdd-0bc1-445e-9f76-b0edac37022d')
WHEN MATCHED THEN
    UPDATE SET code = 'Software Developer', en_CA = 'Software Developer', fr_CA = 'Développeur de logiciels', en_US = 'Software Developer', es_US = 'Desarrollador de Software', es_MX = 'Desarrollador de Software', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('e5ebdfdd-0bc1-445e-9f76-b0edac37022d', 'Software Developer', 'Software Developer', 'Développeur de logiciels', 'Software Developer', 'Desarrollador de Software', 'Desarrollador de Software', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '94a402b1-f03f-4711-a3c9-978a74353e94')
WHEN MATCHED THEN
    UPDATE SET code = 'Customer Success Manager', en_CA = 'Customer Success Manager', fr_CA = 'Gestionnaire de la réussite client', en_US = 'Customer Success Manager', es_US = 'Gerente de Éxito del Cliente', es_MX = 'Gerente de Éxito del Cliente', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('94a402b1-f03f-4711-a3c9-978a74353e94', 'Customer Success Manager', 'Customer Success Manager', 'Gestionnaire de la réussite client', 'Customer Success Manager', 'Gerente de Éxito del Cliente', 'Gerente de Éxito del Cliente', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '0a20f55e-af33-4304-b9e3-986c970d0a30')
WHEN MATCHED THEN
    UPDATE SET code = 'DevOps Engineer', en_CA = 'DevOps Engineer', fr_CA = 'Ingénieur DevOps', en_US = 'DevOps Engineer', es_US = 'Ingeniero de DevOps', es_MX = 'Ingeniero de DevOps', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('0a20f55e-af33-4304-b9e3-986c970d0a30', 'DevOps Engineer', 'DevOps Engineer', 'Ingénieur DevOps', 'DevOps Engineer', 'Ingeniero de DevOps', 'Ingeniero de DevOps', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '16571f12-b9e3-4103-9303-685be047b033')
WHEN MATCHED THEN
    UPDATE SET code = 'Risk Manager', en_CA = 'Risk Manager', fr_CA = 'Gestionnaire des risques', en_US = 'Risk Manager', es_US = 'Gerente de Riesgos', es_MX = 'Gerente de Riesgos', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('16571f12-b9e3-4103-9303-685be047b033', 'Risk Manager', 'Risk Manager', 'Gestionnaire des risques', 'Risk Manager', 'Gerente de Riesgos', 'Gerente de Riesgos', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '325a4f55-8408-44bc-ba64-e41df282a261')
WHEN MATCHED THEN
    UPDATE SET code = 'Security Consultant', en_CA = 'Security Consultant', fr_CA = 'Consultant en sécurité', en_US = 'Security Consultant', es_US = 'Consultor de Seguridad', es_MX = 'Consultor de Seguridad', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('325a4f55-8408-44bc-ba64-e41df282a261', 'Security Consultant', 'Security Consultant', 'Consultant en sécurité', 'Security Consultant', 'Consultor de Seguridad', 'Consultor de Seguridad', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = 'ddf99346-bfa1-4676-91e4-f6a41ffefa85')
WHEN MATCHED THEN
    UPDATE SET code = 'Underwriter', en_CA = 'Underwriter', fr_CA = 'Souscripteur d'assurance', en_US = 'Underwriter', es_US = 'Suscriptor de Seguros', es_MX = 'Suscriptor de Seguros', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('ddf99346-bfa1-4676-91e4-f6a41ffefa85', 'Underwriter', 'Underwriter', 'Souscripteur d'assurance', 'Underwriter', 'Suscriptor de Seguros', 'Suscriptor de Seguros', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = 'cba74225-ca33-46f9-a5f7-ddaf4b322e19')
WHEN MATCHED THEN
    UPDATE SET code = 'Claims Adjuster', en_CA = 'Claims Adjuster', fr_CA = 'Expert en sinistres', en_US = 'Claims Adjuster', es_US = 'Perito de Seguros', es_MX = 'Perito de Seguros', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('cba74225-ca33-46f9-a5f7-ddaf4b322e19', 'Claims Adjuster', 'Claims Adjuster', 'Expert en sinistres', 'Claims Adjuster', 'Perito de Seguros', 'Perito de Seguros', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '5e0c71e0-e067-4e61-8549-5f888882d205')
WHEN MATCHED THEN
    UPDATE SET code = 'Customer Support Specialist', en_CA = 'Customer Support Specialist', fr_CA = 'Spécialiste du support client', en_US = 'Customer Support Specialist', es_US = 'Especialista en Atención al Cliente', es_MX = 'Especialista en Atención al Cliente', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('5e0c71e0-e067-4e61-8549-5f888882d205', 'Customer Support Specialist', 'Customer Support Specialist', 'Spécialiste du support client', 'Customer Support Specialist', 'Especialista en Atención al Cliente', 'Especialista en Atención al Cliente', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '38f14ea3-a651-4a52-a78c-74e388120856')
WHEN MATCHED THEN
    UPDATE SET code = 'Operations Manager', en_CA = 'Operations Manager', fr_CA = 'Gestionnaire des opérations', en_US = 'Operations Manager', es_US = 'Gerente de Operaciones', es_MX = 'Gerente de Operaciones', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('38f14ea3-a651-4a52-a78c-74e388120856', 'Operations Manager', 'Operations Manager', 'Gestionnaire des opérations', 'Operations Manager', 'Gerente de Operaciones', 'Gerente de Operaciones', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '5ebe3de7-3532-4c20-9800-3e4a45ca49fc')
WHEN MATCHED THEN
    UPDATE SET code = 'IT Administrator', en_CA = 'IT Administrator', fr_CA = 'Administrateur TI', en_US = 'IT Administrator', es_US = 'Administrador de TI', es_MX = 'Administrador de TI', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('5ebe3de7-3532-4c20-9800-3e4a45ca49fc', 'IT Administrator', 'IT Administrator', 'Administrateur TI', 'IT Administrator', 'Administrador de TI', 'Administrador de TI', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = 'cde33f9f-3b72-4480-ad39-8134ceed1473')
WHEN MATCHED THEN
    UPDATE SET code = 'AI Specialist', en_CA = 'AI Specialist', fr_CA = 'Spécialiste en intelligence artificielle', en_US = 'AI Specialist', es_US = 'Especialista en Inteligencia Artificial', es_MX = 'Especialista en Inteligencia Artificial', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('cde33f9f-3b72-4480-ad39-8134ceed1473', 'AI Specialist', 'AI Specialist', 'Spécialiste en intelligence artificielle', 'AI Specialist', 'Especialista en Inteligencia Artificial', 'Especialista en Inteligencia Artificial', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '0d0b8bff-9e03-4f0b-b5b9-d19a47f8e8ea')
WHEN MATCHED THEN
    UPDATE SET code = 'Fraud Investigator', en_CA = 'Fraud Investigator', fr_CA = 'Enquêteur en fraude', en_US = 'Fraud Investigator', es_US = 'Investigador de Fraudes', es_MX = 'Investigador de Fraudes', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('0d0b8bff-9e03-4f0b-b5b9-d19a47f8e8ea', 'Fraud Investigator', 'Fraud Investigator', 'Enquêteur en fraude', 'Fraud Investigator', 'Investigador de Fraudes', 'Investigador de Fraudes', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '70ce3726-7034-4f40-8edd-72eef6faf2ab')
WHEN MATCHED THEN
    UPDATE SET code = 'Business Analyst', en_CA = 'Business Analyst', fr_CA = 'Analyste d'affaires', en_US = 'Business Analyst', es_US = 'Analista de Negocios', es_MX = 'Analista de Negocios', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('70ce3726-7034-4f40-8edd-72eef6faf2ab', 'Business Analyst', 'Business Analyst', 'Analyste d'affaires', 'Business Analyst', 'Analista de Negocios', 'Analista de Negocios', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '2c239590-8e9a-4871-aaac-b17dbb72e380')
WHEN MATCHED THEN
    UPDATE SET code = 'Support Manager', en_CA = 'Support Manager', fr_CA = 'Gestionnaire du support', en_US = 'Support Manager', es_US = 'Gerente de Soporte', es_MX = 'Gerente de Soporte', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('2c239590-8e9a-4871-aaac-b17dbb72e380', 'Support Manager', 'Support Manager', 'Gestionnaire du support', 'Support Manager', 'Gerente de Soporte', 'Gerente de Soporte', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '7bb2cf92-f484-4132-a4bb-885e7a00b7f9')
WHEN MATCHED THEN
    UPDATE SET code = 'Compliance Officer', en_CA = 'Compliance Officer', fr_CA = 'Agent de conformité', en_US = 'Compliance Officer', es_US = 'Oficial de Cumplimiento', es_MX = 'Oficial de Cumplimiento', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('7bb2cf92-f484-4132-a4bb-885e7a00b7f9', 'Compliance Officer', 'Compliance Officer', 'Agent de conformité', 'Compliance Officer', 'Oficial de Cumplimiento', 'Oficial de Cumplimiento', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '41f75079-6928-4e70-8c89-1b671f64b780')
WHEN MATCHED THEN
    UPDATE SET code = 'Insurance Agent', en_CA = 'Insurance Agent', fr_CA = 'Agent d'assurance', en_US = 'Insurance Agent', es_US = 'Agente de Seguros', es_MX = 'Agente de Seguros', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('41f75079-6928-4e70-8c89-1b671f64b780', 'Insurance Agent', 'Insurance Agent', 'Agent d'assurance', 'Insurance Agent', 'Agente de Seguros', 'Agente de Seguros', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '3e579903-b52d-47d4-871d-f91661867774')
WHEN MATCHED THEN
    UPDATE SET code = 'Service Desk Analyst', en_CA = 'Service Desk Analyst', fr_CA = 'Analyste du centre de services', en_US = 'Service Desk Analyst', es_US = 'Analista de Mesa de Servicios', es_MX = 'Analista de Mesa de Servicios', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('3e579903-b52d-47d4-871d-f91661867774', 'Service Desk Analyst', 'Service Desk Analyst', 'Analyste du centre de services', 'Service Desk Analyst', 'Analista de Mesa de Servicios', 'Analista de Mesa de Servicios', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = 'ab965b2d-fd36-4f2c-a098-9f7b81d7bac0')
WHEN MATCHED THEN
    UPDATE SET code = 'Technical Account Manager', en_CA = 'Technical Account Manager', fr_CA = 'Gestionnaire de comptes techniques', en_US = 'Technical Account Manager', es_US = 'Gerente de Cuentas Técnicas', es_MX = 'Gerente de Cuentas Técnicas', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('ab965b2d-fd36-4f2c-a098-9f7b81d7bac0', 'Technical Account Manager', 'Technical Account Manager', 'Gestionnaire de comptes techniques', 'Technical Account Manager', 'Gerente de Cuentas Técnicas', 'Gerente de Cuentas Técnicas', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '8278c8ea-3750-4ede-9188-ff8c15861421')
WHEN MATCHED THEN
    UPDATE SET code = 'Help Desk Technician', en_CA = 'Help Desk Technician', fr_CA = 'Technicien du support technique', en_US = 'Help Desk Technician', es_US = 'Técnico de Soporte Técnico', es_MX = 'Técnico de Soporte Técnico', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('8278c8ea-3750-4ede-9188-ff8c15861421', 'Help Desk Technician', 'Help Desk Technician', 'Technicien du support technique', 'Help Desk Technician', 'Técnico de Soporte Técnico', 'Técnico de Soporte Técnico', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '168688b7-e971-4dde-b756-c4f5a544623c')
WHEN MATCHED THEN
    UPDATE SET code = 'Network Engineer', en_CA = 'Network Engineer', fr_CA = 'Ingénieur en réseaux', en_US = 'Network Engineer', es_US = 'Ingeniero de Redes', es_MX = 'Ingeniero de Redes', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('168688b7-e971-4dde-b756-c4f5a544623c', 'Network Engineer', 'Network Engineer', 'Ingénieur en réseaux', 'Network Engineer', 'Ingeniero de Redes', 'Ingeniero de Redes', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '289cff83-751e-4d89-9d07-726a2a5348ce')
WHEN MATCHED THEN
    UPDATE SET code = 'Product Manager', en_CA = 'Product Manager', fr_CA = 'Gestionnaire de produit', en_US = 'Product Manager', es_US = 'Gerente de Producto', es_MX = 'Gerente de Producto', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('289cff83-751e-4d89-9d07-726a2a5348ce', 'Product Manager', 'Product Manager', 'Gestionnaire de produit', 'Product Manager', 'Gerente de Producto', 'Gerente de Producto', 'FALSE');

MERGE INTO role USING (SELECT 1) AS DUAL
ON (role.publicId = '8fe213ad-5d74-4774-a2cb-b6134228453f')
WHEN MATCHED THEN
    UPDATE SET code = 'Tech Support Engineer', en_CA = 'Tech Support Engineer', fr_CA = 'Ingénieur en support technique', en_US = 'Tech Support Engineer', es_US = 'Ingeniero de Soporte Técnico', es_MX = 'Ingeniero de Soporte Técnico', retired = 'FALSE'
WHEN NOT MATCHED THEN
    INSERT (publicId, code, en_CA, fr_CA, en_US, es_US, es_MX, retired) VALUES ('8fe213ad-5d74-4774-a2cb-b6134228453f', 'Tech Support Engineer', 'Tech Support Engineer', 'Ingénieur en support technique', 'Tech Support Engineer', 'Ingeniero de Soporte Técnico', 'Ingeniero de Soporte Técnico', 'FALSE');


COMMIT;
