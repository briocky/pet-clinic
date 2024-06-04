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
    (nextval('owners_seq'), 1, 1);

INSERT INTO doctors (id, user_details_id, auth_data_id, specialization)
VALUES
    (nextval('doctors_seq'), 2, 2, 'SURGERY');

INSERT INTO appointments_slots (id, date, time_from, time_to, doctor_id)
VALUES
    (nextval('appointments_slots_seq'), '2024-05-27', '10:30', '11:00', 1),
    (nextval('appointments_slots_seq'), '2024-05-27', '11:30', '12:00', 1),
    (nextval('appointments_slots_seq'), '2024-05-27', '12:30', '13:00', 1),
    (nextval('appointments_slots_seq'), '2024-05-27', '13:30', '14:00', 1),
    (nextval('appointments_slots_seq'), '2024-05-28', '10:30', '11:00', 1),
    (nextval('appointments_slots_seq'), '2024-05-28', '11:30', '12:00', 1),
    (nextval('appointments_slots_seq'), '2024-05-28', '12:30', '13:00', 1),
    (nextval('appointments_slots_seq'), '2024-05-28', '13:30', '14:00', 1);

INSERT INTO patients (id, owner_id, breed, name, species, birth_date)
VALUES
    (nextval('patients_seq'), 1, 'PARROT', 'Jelly', 'BIRD', '2022-01-01'),
    (nextval('patients_seq'), 1, 'PERSIAN', 'Casper', 'CAT', '2023-02-01'),
    (nextval('patients_seq'), 1, 'LABRADOR', 'Hanny', 'DOG', '2024-01-21'),
    (nextval('patients_seq'), 1, 'HOLSTEIN', 'Marry', 'COW', '2021-02-01'),
    (nextval('patients_seq'), 1, 'BETTA', 'Boll', 'FISH', '2022-03-04'),
    (nextval('patients_seq'), 1, 'THOROUGHBRED', 'Jody', 'HORSE', '2022-06-07');
