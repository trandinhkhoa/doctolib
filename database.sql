-- Create a new SQLite database
PRAGMA foreign_keys = ON;
CREATE TABLE doctor_events (
    id INTEGER PRIMARY KEY,
    event_type TEXT NOT NULL, -- 'opening' or 'appointment'
    event_start DATETIME NOT NULL,
    event_end DATETIME NOT NULL
);

-- Insert sample data
INSERT INTO doctor_events (event_type, event_start, event_end) VALUES
    ('opening', '2024-01-30 09:00:00', '2024-01-30 12:00:00'),
    ('appointment', '2024-01-30 10:00:00', '2024-01-30 11:00:00'),

    ('opening', '2024-01-31 14:00:00', '2024-01-31 18:00:00'),

    ('opening', '2024-02-01 08:00:00', '2024-02-01 12:00:00'),
    ('appointment', '2024-02-01 10:30:00', '2024-02-01 11:30:00'),

    ('opening', '2024-02-02 09:00:00', '2024-02-02 14:00:00'),

    ('opening', '2024-02-03 10:00:00', '2024-02-03 16:00:00'),
    ('appointment', '2024-02-03 11:30:00', '2024-02-03 12:30:00'),

    ('opening', '2024-02-04 13:00:00', '2024-02-04 17:00:00'),
    ('opening', '2024-02-04 18:00:00', '2024-02-04 20:00:00');
