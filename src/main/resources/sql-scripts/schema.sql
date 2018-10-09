CREATE  TABLE credentials (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  disabled BOOLEAN NOT NULL DEFAULT FALSE,
  PRIMARY KEY (username));

CREATE TABLE roles (
  id int(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL ,
  role varchar(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uni_credential_role (role,username),
  KEY fk_credentials_idx (username),
  CONSTRAINT fk_credentials FOREIGN KEY (username) REFERENCES credentials (username));
  
 CREATE TABLE authorities (
	  id int(11) NOT NULL AUTO_INCREMENT,
	  username VARCHAR(45) NOT NULL ,
	  authority varchar(45) NOT NULL,
	  PRIMARY KEY (id),
	  UNIQUE KEY uni_credential_authority (authority,username),
	  KEY fk_credentials_auth_idx (username),
	  CONSTRAINT fk_credentials_auth FOREIGN KEY (username) REFERENCES credentials (username));