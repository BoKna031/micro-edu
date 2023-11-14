INSERT INTO profile (id, created_at, email, telephone) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'john.doe@example.com', '+123456789'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'jane.smith@example.com', '+987654321'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'alice.jones@example.com', '+1122334455'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'bob.williams@example.com', '+9988776655'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'emily.jackson@example.com', '+1122112233'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'david.miller@example.com', '+4455667788'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'susan.thompson@example.com', '+9988776655'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'michael.hall@example.com', '+1122334455'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'laura.smith@example.com', '+123456789'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'peter.jones@example.com', '+4455667788'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'natalie.white@example.com', '+1122112233'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'george.martin@example.com', '+9988776655'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'olivia.morris@example.com', '+9988776655'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'ryan.johnson@example.com', '+4455667788'),
(UNHEX(REPLACE(UUID(), '-', '')), NOW(), 'ava.anderson@example.com', '+123456789')
;
