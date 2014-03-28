use `computer-database-db`;
drop table if exists log_table;
create table log_table (
  id                        bigint not null auto_increment,
  request                   varchar(512),
  constraint pk_company primary key (id))
;