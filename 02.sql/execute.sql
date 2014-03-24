CREATE TABLE IF NOT EXISTS execute 
(
	ID_execute	int(4) NOT NULL AUTO_INCREMENT,
	ID_workflow	varchar(10),
	step_order	int(4) not null,
	status		int(4) not null,
	date_exec	varchar(64),
	information	varchar(255),

	PRIMARY KEY (ID_execute, ID_workflow)
)ENGINE=InnoDB;
