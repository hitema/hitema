
USE `dbproject`;

DROP TABLE IF EXISTS registry;
DROP TABLE IF EXISTS process;
DROP TABLE IF EXISTS candidat;


CREATE TABLE IF NOT EXISTS registry 
(
	ID_registry	int(4) NOT NULL AUTO_INCREMENT,
	service_name	varchar(32) not null,
	url		varchar(255) not null,

	PRIMARY KEY (ID_registry)
)ENGINE=InnoDB;

/*
insert into registry (service_name, url) values ('accessdb', 'http://accessdb.workflow','Accessdb');
insert into registry (service_name, url) values ('initialiser', 'http://init.com',);
insert into registry (service_name, url) values ('rediger', 'http://rediger.com','Rediger');
insert into registry (service_name, url) values ('publier', 'http://publier.com','IServiceWebPublication');
insert into registry (service_name, url) values ('selectionner', 'http://selectionner.com','Selectionner');
insert into registry (service_name, url) values ('interviewer RH', 'http://interviewerRH.com','InterviewerRH');
insert into registry (service_name, url) values ('interviewer OP', 'http://interviewerOP.com','InterviewerOP');
insert into registry (service_name, url) values ('valider', 'http://valider.com','Valider');
*/

insert into registry (service_name, url) values ('accessdb', 'http://localhost:8080/ServiceAccessdb/Service/Accessdb?wsdl');
insert into registry (service_name, url) values ('rediger', 'http://localhost:8080/ServiceRediger/Service/rediger?wsdl');
insert into registry (service_name, url) values ('publier', 'http://milonas.cloudapp.net/ServiceWebPublication.svc?wsdl');
insert into registry (service_name, url) values ('selectionner', 'http://localhost:8080/ServiceSelectionner/Service/selectionner?wsdl');
insert into registry (service_name, url) values ('interviewer RH', 'http://localhost:8080/ServiceInterviewerRH/Service/interviewerRH?wsdl');
insert into registry (service_name, url) values ('interviewer OP', 'http://localhost:8080/ServiceInterviewerDOP/Service/interviewerDOP?wsdl');
insert into registry (service_name, url) values ('valider', 'http://localhost:8080/ServiceValider/Service/valider?wsdl');


insert into registry (service_name, url) values ('accessdb', 'http://192.168.2.32:8080/ServiceAccessdb/Service/Accessdb?wsdl');
insert into registry (service_name, url) values ('rediger', 'http://192.168.2.39:8080/ServiceRediger/Service/rediger?wsdl');
insert into registry (service_name, url) values ('publier', 'http://milonas.cloudapp.net/ServiceWebPublication.svc?wsdl');
insert into registry (service_name, url) values ('selectionner', 'http://192.168.2.203:8080/ServiceSelectionner/Service/selectionner?wsdl');
insert into registry (service_name, url) values ('interviewer RH', 'http://192.168.2.39:8080/ServiceInterviewerRH/Service/interviewerRH?wsdl');
insert into registry (service_name, url) values ('interviewer OP', 'http://192.168.2.201:8080/ServiceInterviewerDOP/Service/interviewerDOP?wsdl');
insert into registry (service_name, url) values ('valider', 'http://192.168.2.203:8080/ServiceValider/Service/valider?wsdl');


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




