CREATE DATABASE IF NOT EXISTS voicemathdb;

USE voicemathdb;

CREATE TABLE IF NOT EXISTS calculations (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    expression VARCHAR(500),
    result VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS conversation_memory (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_input TEXT,
    assistant_response TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS learning_progress (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    topic VARCHAR(255),
    score DOUBLE,
    last_attempt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS achievements (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    title VARCHAR(255),

    description VARCHAR(500),

    achieved BOOLEAN
);