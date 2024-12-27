


---- db 설치

docker run --name mkahn-mysql -e MYSQL_ROOT_PASSWORD=1234qwer -e MYSQL_DATABASE=mkahnDB -e MYSQL_USER=mkahn -e MYSQL_PASSWORD=1234qwer -p 3306:3306 -d mysql:8.0

docker exec -it mkahn-mysql mysql -u mkahn -p
create database mkahnDB;
create user 'mkahn'@'%' identified by '1234qwer';
grant all privileges on *.* to 'mkahn'@'%';
flush privileges;
