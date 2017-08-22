Развернуть БД на локальном компьютере и установить необходимые компоненты не представляет труда.

SQL server
http://www.mysql.ru/download/

Запуск
../../mysql-5.6.15\bin
"открыть командную строку как администратор"

mysqld --console
В случае успешного запуска последняя строка что-то вроде:
Version: '5.5.23'  socket: ''  port: 3306  MySQL Community Server (GPL)

Для удобства работы с MySQL я использую MySQL WorkBench 6.3. CE.

SQL-script

CREATE TABLE contact (
ID INT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(60) NOT NULL,
last_name VARCHAR(40) NOT NULL,
birth_date DATE,
version INT NOT NULL DEFAULT 0,
UNIQUE UQ_CONTACT_1 (first_name, last_name),
PRIMARY KEY (id)
);

//связанная таблица
CREATE TABLE `ИМЯ_БД`.hobby (
hobby_id VARCHAR(20) NOT NULL,
PRIMARY KEY (hobby_id)
);

CREATE TABLE `ИМЯ_БД`.contact_tel_detail(
id INT NOT NULL AUTO_INCREMENT,
contact_id INT NOT NULL,
tel_type VARCHAR(20) NOT NULL,
tel_number VARCHAR(20) NOT NULL,
version INT NOT NULL DEFAULT 0,
UNIQUE uq_contact_tel_detail_1 (contact_id, tel_type),
PRIMARY KEY (id),
CONSTRAINT FK_CONTACT_TEL_DETAIL_1 FOREIGN KEY (contact_id) REFERENCES ИМЯ_БД.contact (id)
);

CREATE TABLE `ИМЯ_БД`.contact_hobby_detail (
contact_id INT NOT NULL,
hobby_id VARCHAR(20) NOT NULL,
PRIMARY KEY (contact_id, hobby_id),
CONSTRAINT FK_CONTACT_HOBBY_DETAIL_1 FOREIGN KEY (contact_id) REFERENCES ИМЯ_БД.contact (id) ON DELETE CASCADE,
CONSTRAINT FK_CONTACT_HOBBY_DETAIL_2 FOREIGN KEY (hobby_id) REFERENCES ИМЯ_БД.hobby (hobby_id)
);


Справа в окне необходимо выбрать в вертикальном меню пункт Database и нажать +. Там выбираем поставщика нашей базы данных — MySQL.


Важное замечание. У меня уже был установлен драйвер для подключения к MySQL базе данных — mysql-connector-java-5.1.34-bin.jar. В принципе он устанавливается при установке Workbench, но если у вас его нет, то можете скачать с оф. сайта и вложить в папку с IDEA, как сделано в этом случае.

*на всякий случай путь, где лежит драйвер. Обратите внимание, что находится он в скрытой папке .IntelliJIdea14 конкретного пользователя:

C:/Users/iMacPC/.IntelliJIdea14/config/jdbc-drivers/mysql-connector-java-5.1.34-bin.jar
Теперь необходимо ввести данные о хосте, имени базы данных, пользователе и пароле. Если вы выбрали все настройки по умолчанию, то данные будут такие же как у меня: Host: localhost, порт 3306. Имя пользователя и пароль здесь root/admin.

http://javastudy.ru/webapp/create-mysql-connect-intellij-idea/




