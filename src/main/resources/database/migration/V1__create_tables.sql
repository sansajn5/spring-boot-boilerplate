CREATE TABLE users (
  id            bigint(20) NOT NULL AUTO_INCREMENT,
  email         varchar(120) NOT NULL,
  first_name    varchar(50) NOT NULL,
  last_name     varchar(50) NOT NULL,
  active        boolean DEFAULT false,
  hash_password varchar(255) NOT NULL,
  deleted       boolean DEFAULT false,
  created_at    timestamp  NOT NULL,
  updated_at    timestamp  NOT NULL,
  CONSTRAINT pk_users PRIMARY KEY (id),
  CONSTRAINT uk_users_email UNIQUE (email)
);

CREATE INDEX idx_users ON users (email);

CREATE TABLE authority (
    name        varchar(50) NOT NULL,
    created_at    timestamp  NOT NULL,
    updated_at    timestamp  NOT NULL,
    CONSTRAINT pk_authority PRIMARY KEY (name)
);

CREATE TABLE users_authority (
    user_id         bigint(20) NOT NULL,
    authority_name  varchar(50) NOT NULL,
    PRIMARY KEY ( user_id, authority_name ),
    CONSTRAINT fk_users_authority FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_users_authority1 FOREIGN KEY (authority_name) REFERENCES authority(name)
);
