--create database springit

drop table if exists link cascade;

CREATE TABLE link (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  created_by VARCHAR(255),
  creation_date timestamp,
  last_modified_by VARCHAR(255),
  last_modified_date timestamp,
  title VARCHAR(255),
  url VARCHAR(255)
);


drop table if exists comment;

CREATE TABLE comment (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  created_by VARCHAR(255),
  creation_date timestamp,
  last_modified_by VARCHAR(255),
  last_modified_date timestamp,
  body VARCHAR(255),
  link_id BIGINT REFERENCES link (id)
);




