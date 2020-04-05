CREATE TABLE IF NOT EXISTS TEAMVIEWER.USERS(
    num int primary_key auto_increase,
    id varchar(20) primary_key,
    pw varchar(20),
    name varchar(20)
)

