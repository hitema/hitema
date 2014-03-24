
USE `dbproject`;

DROP TABLE IF EXISTS registry;
DROP TABLE IF EXISTS process;
DROP TABLE IF EXISTS candidat;


CREATE TABLE IF NOT EXISTS registry 
(
	ID_registry	int(4) NOT NULL AUTO_INCREMENT,
	service_name	varchar(32) not null,
	url		varchar(255) not null,
s
	PRIMARY KEY (ID_registry)
)ENGINE=InnoDB;

insert into registry (service_name, url) values ('initialiser', 'http://init.com');
insert into registry (service_name, url) values ('rediger', 'http://rediger.com');
insert into registry (service_name, url) values ('publier', 'http://publier.com');
insert into registry (service_name, url) values ('selectionner', 'http://selectionner.com');
insert into registry (service_name, url) values ('interviewer RH', 'http://interviewerRH.com');
insert into registry (service_name, url) values ('interviewer OP', 'http://interviewerOP.com');
insert into registry (service_name, url) values ('valider', 'http://valider.com');


CREATE TABLE IF NOT EXISTS process
(	
	ID_process	int(4) NOT NULL AUTO_INCREMENT,
	process_order	int(4) NOT NULL,
	ID_registry	int(4) NOT NULL,
	role		varchar(32) not null,
	name		varchar(32) not null,
	description	varchar(255),
	
	PRIMARY KEY (ID_process)
)ENGINE=InnoDB;

select p.ID_process, p.process_order, p.role, p.name, r.ID_registry, r.url
from process p, registry r
where p.ID_registry = r.ID_registry
order by p.process_order;

insert into process (process_order, ID_registry, role, name, description) values (1,1,'DRH','initialiser','intitialisation d un recrutement');
insert into process (process_order, ID_registry, role, name, description) values (2,2,'ARH','rediger','redaction de l offre');
insert into process (process_order, ID_registry, role, name, description) values (3,3,'ARH','publier','publication de l offre');
insert into process (process_order, ID_registry, role, name, description) values (4,4,'DRH','selectionner','selection du candidat');
insert into process (process_order, ID_registry, role, name, description) values (5,5,'ARH','interviewer RH','premiere entretien RH');
insert into process (process_order, ID_registry, role, name, description) values (6,6,'DOP','interviewer OP','entretien operationnel');
insert into process (process_order, ID_registry, role, name, description) values (7,7,'DRH','valider','validation embauche');


CREATE TABLE IF NOT EXISTS candidat
(
	ID_candidat 	int(4) NOT NULL AUTO_INCREMENT,
	process_order	int(4) NOT NULL,
	dateexec	varchar(32) not null,

	position	varchar(32),
	description	varchar(64),	
	firstname	varchar(32),
	lastname	varchar(32),
	resume		varchar(32),
	interviewrh	varchar(32),
	interviewop	varchar(32),
	validation	varchar(32),

	PRIMARY KEY (ID_candidat)
) ENGINE=InnoDB;

insert into candidat (process_order, dateexec, position) values ();

