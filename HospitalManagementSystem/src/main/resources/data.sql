INSERT INTO patient(name, gender, birth_date, email, blood_group)
VALUES
    ('Rahul', 'Male', '1999-05-21', 'rahul11@gmail.com', 'O_pos'),
    ('Virat', 'Male', '2000-08-15', 'virat1321@gmail.com', 'A_neg'),
    ('Kunal', 'Male', '2003-05-19', 'kunalp111@gmail.com', 'AB_pos'),
    ('Manav', 'Male', '2001-09-11', 'manav@gmail.com', 'B_pos'),
    ('Akash', 'Male', '1998-09-07', 'akash2231@gmail.com', 'O_pos'),
    ('Kiran', 'Female', '1989-02-21', 'kiran1234@gmail.com', 'A_pos'),
    ('Varun', 'Male', '1999-10-08', 'varunsharma@gmail.com', 'AB_neg');


INSERT INTO Doctor(name, specialization, email)
VALUES
    ('Dr. Rakesh Sharma', 'Cardiology', 'rakesh.sharma@gmail.com'),
    ('Dr. Minal Thakur', 'Dermatology', 'minal.thakur@gmail.com'),
    ('Dr. Arjun Nair', 'Orthopedic', 'arjun.nair@gmail.com');


INSERT INTO appointment(appointment_time, reason, doctor_id, patient_id)
VALUES
    ('2025-02-11 10:30:20', 'General CheckUp', 1, 2),
    ('2025-01-17 15:30:45', 'Skin Rash', 2, 2),
    ('2025-02-14 18:10:45', 'Knee Pain', 3, 3),
    ('2025-02-20 11:55:38', 'Follow-up visit', 1, 1),
    ('2025-03-01 16:45:25', 'Consultation', 1, 4),
    ('2025-01-30 17:10:15', 'Allergy Treatment', 2, 5);