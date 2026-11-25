INSERT INTO patient (id, first_name, last_name, birth_date, gender, blood_group, phone_number, address, created_at, updated_at, insurance_id, nurse_id)
VALUES
    (gen_random_uuid(), 'Aarav', 'Sharma', '1998-05-14', 'MALE', 'O_pos', '9876543210', 'Model Town, Ludhiana, Punjab', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Priya', 'Verma', '2001-09-22', 'FEMALE', 'A_pos', '9876543211', 'Sector 22, Chandigarh', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Rahul', 'Mehta', '1985-12-10', 'MALE', 'B_pos', '9876543212', 'Civil Lines, Delhi', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Ananya', 'Kapoor', '1995-03-18', 'FEMALE', 'AB_pos', '9876543213', 'Bandra West, Mumbai, Maharashtra', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Vikram', 'Singh', '1978-07-25', 'MALE', 'O_neg', '9876543214', 'Civil Lines, Jaipur, Rajasthan', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Simran', 'Kaur', '2003-11-06', 'FEMALE', 'B_neg', '9876543215', 'Ferozepur Road, Ludhiana, Punjab', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Aditya', 'Gupta', '1990-01-30', 'MALE', 'A_neg', '9876543216', 'Indirapuram, Ghaziabad, Uttar Pradesh', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Neha', 'Malhotra', '1988-06-12', 'FEMALE', 'O_pos', '9876543217', 'Salt Lake, Kolkata, West Bengal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Karan', 'Chopra', '1996-10-21', 'MALE', 'AB_neg', '9876543218', 'Whitefield, Bengaluru, Karnataka', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Ishita', 'Aggarwal', '2000-02-28', 'FEMALE', 'B_pos', '9876543219', 'Vasant Kunj, New Delhi', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Rohan', 'Bhatia', '1993-04-17', 'MALE', 'A_pos', '9876543220', 'Sector 17, Chandigarh', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Meera', 'Joshi', '1999-08-09', 'FEMALE', 'O_neg', '9876543221', 'Vaishali Nagar, Jaipur, Rajasthan', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Arjun', 'Patel', '1982-11-23', 'MALE', 'B_pos', '9876543222', 'Satellite Road, Ahmedabad, Gujarat', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Sneha', 'Reddy', '1997-02-15', 'FEMALE', 'AB_pos', '9876543223', 'Banjara Hills, Hyderabad, Telangana', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Manav', 'Saxena', '1975-06-30', 'MALE', 'A_neg', '9876543224', 'Civil Lines, Prayagraj, Uttar Pradesh', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Pooja', 'Mishra', '2002-12-05', 'FEMALE', 'B_neg', '9876543225', 'Aliganj, Lucknow, Uttar Pradesh', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Kabir', 'Malik', '1991-03-27', 'MALE', 'O_pos', '9876543226', 'Rajouri Garden, New Delhi', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Tanya', 'Arora', '1986-10-19', 'FEMALE', 'A_pos', '9876543227', 'Sarabha Nagar, Ludhiana, Punjab', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Dev', 'Nair', '2004-07-11', 'MALE', 'AB_neg', '9876543228', 'Kakkanad, Kochi, Kerala', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL),
    (gen_random_uuid(), 'Ritika', 'Das', '1994-01-08', 'FEMALE', 'O_pos', '9876543229', 'Ballygunge, Kolkata, West Bengal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);


INSERT INTO doctor (id, first_name, last_name, email, specialty, date_of_birth, phone_number, gender, created_at, updated_at)
VALUES
    (gen_random_uuid(), 'Aarav', 'Sharma', 'aarav.sharma@hospital.com', 'Cardiology', '1982-04-15', '9876543210', 'MALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Priya', 'Patel', 'priya.patel@hospital.com', 'Neurology', '1986-09-22', '9876543211', 'FEMALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Rohan', 'Verma', 'rohan.verma@hospital.com', 'Orthopedics', '1979-11-03', '9876543212', 'MALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Meera', 'Nair', 'meera.nair@hospital.com', 'Pediatrics', '1990-02-18', '9876543213', 'FEMALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Vikram', 'Singh', 'vikram.singh@hospital.com', 'Dermatology', '1985-07-30', '9876543214', 'MALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Ananya', 'Gupta', 'ananya.gupta@hospital.com', 'Gynecology', '1988-03-12', '9876543215', 'FEMALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Kabir', 'Malhotra', 'kabir.malhotra@hospital.com', 'Oncology', '1977-08-25', '9876543216', 'MALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Sneha', 'Reddy', 'sneha.reddy@hospital.com', 'Ophthalmology', '1991-06-09', '9876543217', 'FEMALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Arjun', 'Mehta', 'arjun.mehta@hospital.com', 'Psychiatry', '1983-12-19', '9876543218', 'MALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Kavya', 'Joshi', 'kavya.joshi@hospital.com', 'Endocrinology', '1989-01-27', '9876543219', 'FEMALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Siddharth', 'Kapoor', 'siddharth.kapoor@hospital.com', 'Gastroenterology', '1980-05-14', '9876543220', 'MALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Neha', 'Bansal', 'neha.bansal@hospital.com', 'Radiology', '1987-10-05', '9876543221', 'FEMALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Aditya', 'Kulkarni', 'aditya.kulkarni@hospital.com', 'Urology', '1984-02-28', '9876543222', 'MALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Pooja', 'Desai', 'pooja.desai@hospital.com', 'Pulmonology', '1992-07-11', '9876543223', 'FEMALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'Manish', 'Tiwari', 'manish.tiwari@hospital.com', 'General Surgery', '1976-09-08', '9876543224', 'MALE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO nurse (first_name, last_name, date_of_birth, gender, phone_number, created_at, updated_at, department_id)
VALUES
    ('Simran', 'Kaur', '1994-03-18', 'FEMALE', '9812345601', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Harpreet', 'Gill', '1991-07-24', 'FEMALE', '9812345602', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Ritu', 'Sharma', '1995-11-09', 'FEMALE', '9812345603', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Deepak', 'Yadav', '1992-01-15', 'MALE', '9812345604', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Anjali', 'Menon', '1996-05-22', 'FEMALE', '9812345605', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Kiran', 'Bhatia', '1989-09-30', 'FEMALE', '9812345606', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Manpreet', 'Singh', '1993-04-12', 'MALE', '9812345607', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Divya', 'Chopra', '1997-08-05', 'FEMALE', '9812345608', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Sonal', 'Jain', '1990-12-19', 'FEMALE', '9812345609', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Nikhil', 'Rana', '1994-06-27', 'MALE', '9812345610', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Shreya', 'Das', '1995-02-14', 'FEMALE', '9812345611', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Komolika', 'Sen', '1992-10-08', 'FEMALE', '9812345612', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Pankaj', 'Thakur', '1991-03-21', 'MALE', '9812345613', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Nisha', 'Aggarwal', '1996-09-11', 'FEMALE', '9812345614', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
    ('Tanya', 'Malik', '1993-11-29', 'FEMALE', '9812345615', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL);