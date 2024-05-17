-- Dodawanie danych do UserDetails
INSERT INTO user_details (id, first_name, last_name, email, phone_number, address, birth_date, image_url, system_role)
VALUES
    (nextval('user_details_seq'), 'John', 'Doe', 'john@example.com', '123456789', '123 Main St, Anytown', '1990-01-01 00:00:00', 'https://example.com/johndoe.jpg', 'USER'),
    (nextval('user_details_seq'), 'Alice', 'Smith', 'alice@example.com', '987654321', '456 Elm St, Othertown', '1995-05-15 00:00:00', 'https://example.com/alicesmith.jpg', 'DOCTOR');

-- Dodawanie danych do AuthData
INSERT INTO auth_data (id, email, password, account_expired, account_locked, credentials_expired, enabled)
VALUES
    (nextval('auth_datas_seq'), 'john@example.com', '$2a$10$g9cRnJRUsD8P880CMwiFsuz1YUUaydbO4IN4NH7c2BvCxJ3b.T5Su', false, false, false, true),
    (nextval('auth_datas_seq'), 'alice@example.com', '$2a$10$g9cRnJRUsD8P880CMwiFsuz1YUUaydbO4IN4NH7c2BvCxJ3b.T5Su', false, false, false, true);

-- Dodawanie danych do Auth Data Roles
INSERT INTO postgres.public.auth_data_roles (auth_data_id, role)
VALUES
    (1, 'ROLE_USER'),
    (2, 'ROLE_DOCTOR');

-- Dodawanie danych do Owner
INSERT INTO owners (id, user_details_id, auth_data_id)
VALUES
    (nextval('owners_seq'), 1, 1),
    (nextval('owners_seq'), 2, 2);
