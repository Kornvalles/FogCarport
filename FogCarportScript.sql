create schema if not exists `FogCarport`;
use `FogCarport`;

create table if not exists `FogCarport`.`orders` (
	`id` int(10) not null auto_increment,
    `idcustomer` int(10) not null,
    `email` varchar(90) not null,
    `height` int(10) not null,
    `length` int(10) not null,
    `width` int(10) not null,
    primary key (`id`),
    unique key (`idcustomer`)
);
    
