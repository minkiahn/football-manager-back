


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

ps -ef | grep java
kill -9 ---
ec2]        sudo rm -rf /tmp/back/*
IntelliJ 우측 Gradle 탭 → Tasks → build → bootJar → 더블클릭
scp -i fm-ec2-key.pem -r C:\Users\user\Documents\GitHub\football-manager-back\build\libs/* ec2-user@43.202.159.31:/tmp/back
cd /tmp/back
nohup java -Xms512m -Xmx1024m -jar mkahn-0.0.1-SNAPSHOT.jar \ > app.log 2>&1 &