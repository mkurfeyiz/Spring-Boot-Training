CREATE TABLE IF NOT EXISTS `employees`
(
    `id`   int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20),
    `email` varchar(20),
    `date_of_birth` timestamp
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;