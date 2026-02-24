CREATE DATABASE SmartHome

USE SmartHome

CREATE TABLE HOME (
  ID INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
  CODE VARCHAR(20) UNIQUE,
  NAME NVARCHAR(50),
  ADDRESS NVARCHAR(200),
  STATUS NVARCHAR(20),
  CREATE_AT DATETIME
)

CREATE TABLE USERS (
  ID INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
  USERNAME NVARCHAR(100),
  PASSWORD VARCHAR(100),
  FULL_NAME NVARCHAR(100),
  EMAIL NVARCHAR(100),
  ROLE NVARCHAR(50),
  CREATE_AT DATETIME
)

CREATE TABLE HOMEMODE (
  ID INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
  NAME NVARCHAR(100),
  ACTIVE_FROM TIME,
  ACTIVE_TO TIME,
  IS_ACTIVE BIT,
  HOME_ID INT,
  CONSTRAINT FK_HOME_MODE FOREIGN KEY (HOME_ID) REFERENCES HOME(ID)
)

CREATE TABLE ROOM (
  ID INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
  NAME NVARCHAR(100),
  FLOOR INT,
  TYPE NVARCHAR(50),
  STATUS NVARCHAR(20),
  HOME_ID INT,
  CONSTRAINT FK_HOME_ROOM FOREIGN KEY (HOME_ID) REFERENCES HOME(ID)
)

CREATE TABLE DEVICE (
  ID INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
  TYPE NVARCHAR(50),
  SERIAL_NO VARCHAR(50),
  VENDOR NVARCHAR(100),
  STATUS NVARCHAR(20),
  LAST_SEEN_ST DATETIME,
  ROOM_ID INT,
  CONSTRAINT FK_ROOM_DEVICE FOREIGN KEY (ROOM_ID) REFERENCES ROOM(ID)
)

CREATE TABLE ALERT (
  ID INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
   TYPE NVARCHAR(50),
   SEVERITY NVARCHAR(50),
   STATUS NVARCHAR(20),
   START_TS DATETIME,
   END_TS DATETIME,
   MESSAGE NVARCHAR(500),
   CREATE_AT DATETIME,
   USER_ID INT,
   HOME_ID INT,
   DEVICE_ID INT,
   ROOM_ID INT,
   CONSTRAINT FK_USER_ALERT FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
   CONSTRAINT FK_HOME_ALERT FOREIGN KEY (HOME_ID) REFERENCES HOME(ID),
   CONSTRAINT FK_DEVICE_ALERT FOREIGN KEY (DEVICE_ID) REFERENCES DEVICE(ID),
   CONSTRAINT FK_ROOM_ALERT FOREIGN KEY (ROOM_ID) REFERENCES ROOM(ID),
)

CREATE TABLE RULES (
  ID INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
  NAME NVARCHAR(100),
  TRIGGER_TYPE VARCHAR(50),
  CONDITION_JSON NVARCHAR(MAX),
  ACTION_JSON NVARCHAR(MAX),
  PRIORITY INT,
  ACTIVE BIT,
  CREATED_AT DATETIME,
  HOME_ID INT,
  ALERT_ID INT,
  CONSTRAINT FK_HOME_RULE FOREIGN KEY (HOME_ID) REFERENCES HOME(ID),
  CONSTRAINT FK_ALERT_RULE FOREIGN KEY (ALERT_ID) REFERENCES ALERT(ID),
)

INSERT INTO RULES (HOME_ID, NAME, TRIGGER_TYPE, CONDITION_JSON, ACTION_JSON, PRIORITY, ACTIVE, CREATED_AT) VALUES 
  (1, N'Door left open', 'Duration', 
     N'{"event_type": "DoorOpen", "duration_minutes": 15}', 
     N'{"alert_type": "Security", "severity": "Medium", "message": "Door left opened more than 15 minutes"}', 
     2, 1, GETDATE()),
  (1, N'Door open in Away/Night', 'ModeViolation', 
     N'{"event_type": "DoorOpen", "forbidden_modes": ["Away", "Night"]}', 
     N'{"alert_type": "Security", "severity": "High", "message": "Door opened at night or away"}', 
     1, 1, GETDATE()),
  (1, N'Light on too long', 'Duration', 
     N'{"event_type": "LightOn", "duration_minutes": 120}', 
     N'{"alert_type": "Operation", "severity": "Low", "message": "Light on for more than 2 hours"}', 
     3, 1, GETDATE()),
  (1, N'Device disconnected', 'HealthCheck', 
     N'{"max_offline_minutes": 60}', 
     N'{"alert_type": "Operation", "severity": "Medium", "message": "Device unsignal for more than an hour"}', 
     2, 1, GETDATE()),
  (1, N'Repeated unlock failures', 'Frequency', 
     N'{"event_type": "UnlockFailed", "count_threshold": 3, "time_window_minutes": 5}', 
     N'{"alert_type": "Security", "severity": "High", "message": "Detected multiple failed unlock attempts"}', 
     1, 1, GETDATE());

CREATE TABLE EVENTLOG (
  ID INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
  TYPE NVARCHAR(20),
  VALUE VARCHAR(20),
  TS DATETIME,
  SOURCE VARCHAR(50),
  CREATE_AT DATETIME,
  USER_ID INT,
  DEVICE_ID INT,
  CONSTRAINT FK_USER_LOG FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
  CONSTRAINT FK_DEVICE_LOG FOREIGN KEY (DEVICE_ID) REFERENCES DEVICE(ID)
)

INSERT INTO EVENTLOG (DEVICE_ID, TYPE, VALUE, TS, USER_ID, SOURCE, CREATE_AT) VALUES
  (1, 'DoorOpen', NULL, '2023-10-26 07:30:00', NULL, 'Sensor', GETDATE()),
  (1, 'DoorClose', NULL, '2023-10-26 07:35:00', NULL, 'Sensor', GETDATE()),
  (2, 'LightOn', 'Brightness: 100%', '2023-10-26 18:00:00', 2, 'Manual', GETDATE()),
  (3, 'Heartbeat', 'Battery: 85%', '2023-10-26 18:15:00', NULL, 'Sensor', GETDATE()),
  (3, 'Unlock', 'Failed - Wrong PIN', '2023-10-26 22:30:00', NULL, 'Sensor', GETDATE()),
  (2, 'LightOff', NULL, '2023-10-26 23:00:00', NULL, 'Schedule', GETDATE());

CREATE TABLE ALERTACTION (
  ID INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
  TYPE NVARCHAR(20),
  NOTE NVARCHAR(MAX),
  ACTION_TS DATETIME,
  USER_ID INT,
  ALERT_ID INT,
  CONSTRAINT FK_USER_ACTION FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
  CONSTRAINT FK_ALERT_ACTION FOREIGN KEY (ALERT_ID) REFERENCES ALERT(ID)
)

INSERT INTO AlertAction (ALERT_ID, USER_ID, TYPE, NOTE, ACTION_TS) VALUES
  -- 1. Người dùng (VD: Home Owner - user_id = 2) ghi nhận (Ack) một cảnh báo an ninh (VD: alert_id = 1 là cửa mở quá lâu)
  (1, 2, 'Ack', N'Notification read, checking camera.', '2023-10-26 08:00:00'),
  -- 2. Người dùng thêm bình luận (Comment) để cập nhật tình trạng xử lý cho cảnh báo đó
  (1, 2, 'Comment', N'Door left open on purpose, no security problem.', '2023-10-26 08:05:00'),
  -- 3. Người dùng đóng cảnh báo (Close) sau khi vấn đề đã được giải quyết
  (1, 2, 'Close', N'Door safely closed.', '2023-10-26 08:10:00'),
  -- 4. Kỹ thuật viên (VD: Technician - user_id = 3) ghi nhận một cảnh báo vận hành (VD: alert_id = 2 là thiết bị offline)
  (2, 3, 'Ack', N'Notification read, checking device battery.', '2023-10-27 09:00:00'),
  -- 5. Kỹ thuật viên đóng cảnh báo sau khi đã khắc phục xong lỗi thiết bị
  (2, 3, 'Close', N'New battery changed.', '2023-10-27 15:30:00');