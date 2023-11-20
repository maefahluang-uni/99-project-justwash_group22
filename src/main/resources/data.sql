INSERT INTO MACHINE (ID, CAPACITY ,DATE, W_TIME, PRICE, M_STATUS) VALUES (1,  '15' , '2023-07-15 18:00:00', '30', '30', 'available');
INSERT INTO MACHINE (ID, CAPACITY ,DATE, W_TIME, PRICE, M_STATUS) VALUES (2,  '15' , '2023-08-20 20:30:00', '30', '30', 'available');
INSERT INTO MACHINE (ID, CAPACITY ,DATE, W_TIME, PRICE, M_STATUS) VALUES (3,  '15' , '2023-09-10 19:15:00', '30', '30', 'available');
INSERT INTO MACHINE (ID, CAPACITY ,DATE, W_TIME, PRICE, M_STATUS) VALUES (4,  '20' , '2023-07-30 21:00:00', '40', '45', 'available');
INSERT INTO MACHINE (ID, CAPACITY ,DATE, W_TIME, PRICE, M_STATUS) VALUES (5,  '20' , '2023-10-05 17:45:00', '40', '45', 'available');


INSERT INTO QUEUE ( USERNAME, BOOKED, DATE, W_STATUS, MACHINE_ID) VALUES ('A1', false, '2023-07-15 18:00:00', 'not started yet', 1);
INSERT INTO QUEUE ( USERNAME, BOOKED, DATE, W_STATUS, MACHINE_ID) VALUES ('A2', false, '2023-07-15 18:00:00', 'not started yet', 1);
INSERT INTO QUEUE ( USERNAME, BOOKED, DATE, W_STATUS, MACHINE_ID) VALUES ('B1', false, '2023-07-15 18:00:00', 'not started yet', 2);
INSERT INTO QUEUE ( USERNAME, BOOKED, DATE, W_STATUS, MACHINE_ID) VALUES ('B2', false, '2023-07-15 18:00:00', 'not started yet', 2);
INSERT INTO QUEUE ( USERNAME, BOOKED, DATE, W_STATUS, MACHINE_ID) VALUES ('C1', false, '2023-07-15 18:00:00', 'not started yet', 3);
INSERT INTO QUEUE ( USERNAME, BOOKED, DATE, W_STATUS, MACHINE_ID) VALUES ('C2', false, '2023-07-15 18:00:00', 'not started yet', 3);
INSERT INTO QUEUE ( USERNAME, BOOKED, DATE, W_STATUS, MACHINE_ID) VALUES ('D1', false, '2023-07-15 18:00:00', 'not started yet', 4);
INSERT INTO QUEUE ( USERNAME, BOOKED, DATE, W_STATUS, MACHINE_ID) VALUES ('D2', false, '2023-07-15 18:00:00', 'not started yet', 4);
INSERT INTO QUEUE ( USERNAME, BOOKED, DATE, W_STATUS, MACHINE_ID) VALUES ('E1', false, '2023-07-15 18:00:00', 'not started yet', 5);
INSERT INTO QUEUE ( USERNAME, BOOKED, DATE, W_STATUS, MACHINE_ID) VALUES ('E2', false, '2023-07-15 18:00:00', 'not started yet', 5);

-- Create the queue_status table
CREATE TABLE queue_status (
    ID BIGINT PRIMARY KEY,
    queue_id BIGINT,
    queue_status VARCHAR(255), -- Adjust the length according to your needs
    FOREIGN KEY (queue_id) REFERENCES queue (ID)
);

-- Insert some sample data into the queue_status table
INSERT INTO queue_status (ID, queue_id, queue_status) VALUES (1, 1, 'status1');
INSERT INTO queue_status (ID, queue_id, queue_status) VALUES (2, 2, 'status2');
INSERT INTO queue_status (ID, queue_id, queue_status) VALUES (3, 3, 'status3');



