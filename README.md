


---- db 설치

docker run --name mkahn-mysql -e MYSQL_ROOT_PASSWORD=1234qwer -e MYSQL_DATABASE=mkahnDB -e MYSQL_USER=mkahn -e MYSQL_PASSWORD=1234qwer -p 3306:3306 -d mysql:8.0


--- ec2
-- Swap 메모리 추가
-- 볼륨마운트
sudo mkdir -p /data/mysql
sudo chown -R 999:999 /data/mysql

docker run \
--name mkahn-mysql \
-e MYSQL_ROOT_PASSWORD=1234qwer \
-e MYSQL_DATABASE=mkahnDB \
-e MYSQL_USER=mkahn \
-e MYSQL_PASSWORD=1234qwer \
-p 3306:3306 \
--memory=512m \
--memory-swap=512m \
--restart=always \
-v /data/mysql:/var/lib/mysql \
-d mysql:8.0 \
--innodb-buffer-pool-size=256M

docker exec -it mkahn-mysql mysql -u mkahn -p
create database mkahnDB;
create user 'mkahn'@'%' identified by '1234qwer';
grant all privileges on *.* to 'mkahn'@'%';
flush privileges;

docker update --restart=unless-stopped mkahn-mysql

INSERT INTO mkahnDB.team (id, name) VALUES (1, '클리어FC');
INSERT INTO mkahnDB.user (user_id, reg_dt, update_dt, nick_name, pwd, refresh_token, status, token, user_email, team_id) VALUES (1, '2026-01-02 21:15:42.990465', '2026-01-02 22:02:07.716754', '앙민기', '$2a$10$oRhbcgY3I/XdU.rR84RS4ehEEnhzD0rjpSImtmFMoMtdRcerNeV3.', null, '정상', 'eyJ0eXBlIjoiSldUIiwicmVnRGF0ZSI6MTc2NzM1ODkyNzY4MiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE3Njc5NjM3MjcsInVzZXJJZCI6MSwibmlja05hbWUiOiLslZnrr7zquLAifQ.QSxUxlrqBzzc1XAv_MBvs0po1cP62psBnKwHJA_kYu8', 'dksalsrl86@gmail.com', null);
