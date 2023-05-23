insert into link(creation_date, last_modified_date, created_by, last_modified_by, title, url)
values(now(), now(), null, null, 'Getting started with Spring Boot 2', 'https://therealdanveag.com/spring-boot-2');

insert into comment (created_by, creation_date, last_modified_date, body, link_id)
values (null, now(), now(), 'What an awesome course!', 1 );

