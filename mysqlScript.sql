DROP SCHEMA IF EXISTS mail_sender_prj;
CREATE SCHEMA IF NOT EXISTS mail_sender_prj;
USE mail_sender_prj;

CREATE TABLE IF NOT EXISTS Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Messages (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT NOT NULL,
    recipient_id INT NOT NULL,
    subject VARCHAR(255),
    body TEXT,
    FOREIGN KEY (sender_id) REFERENCES Users(user_id),
    FOREIGN KEY (recipient_id) REFERENCES Users(user_id)
);

-- inserts para teste
insert into Users(email) VALUES("diego.lautenschlager@pucpr.edu.br");
insert into Users(email) VALUES("liconl.felix@pucpr.edu.br");
insert into Users(email) VALUES("henrique.macaneiro@pucpr.edu.br");

insert into Messages(sender_id, recipient_id, subject, body) VALUES(1,1,"Mensagem de teste", "Isso é um teste");
insert into Messages(sender_id, recipient_id, subject, body) VALUES(1,2,"Mensagem de teste", "Isso é um teste");
insert into Messages(sender_id, recipient_id, subject, body) VALUES(1,3,"Mensagem de teste", "Isso é um teste");