# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table bairro (
  id                            bigserial not null,
  nome                          varchar(255),
  constraint pk_bairro primary key (id)
);

create table esquina (
  id                            bigserial not null,
  bairro_id                     bigint,
  rua1_id                       bigint,
  rua2_id                       bigint,
  longitude                     float,
  latitude                      float,
  constraint pk_esquina primary key (id)
);

create table esquina_csv (
  id                            bigserial not null,
  bairro                        varchar(255),
  rua1                          varchar(255),
  rua2                          varchar(255),
  longitude                     float,
  latitude                      float,
  constraint pk_esquina_csv primary key (id)
);

create table rua (
  id                            bigserial not null,
  nome                          varchar(255),
  constraint pk_rua primary key (id)
);

alter table esquina add constraint fk_esquina_bairro_id foreign key (bairro_id) references bairro (id) on delete restrict on update restrict;
create index ix_esquina_bairro_id on esquina (bairro_id);

alter table esquina add constraint fk_esquina_rua1_id foreign key (rua1_id) references rua (id) on delete restrict on update restrict;
create index ix_esquina_rua1_id on esquina (rua1_id);

alter table esquina add constraint fk_esquina_rua2_id foreign key (rua2_id) references rua (id) on delete restrict on update restrict;
create index ix_esquina_rua2_id on esquina (rua2_id);


# --- !Downs

alter table if exists esquina drop constraint if exists fk_esquina_bairro_id;
drop index if exists ix_esquina_bairro_id;

alter table if exists esquina drop constraint if exists fk_esquina_rua1_id;
drop index if exists ix_esquina_rua1_id;

alter table if exists esquina drop constraint if exists fk_esquina_rua2_id;
drop index if exists ix_esquina_rua2_id;

drop table if exists bairro cascade;

drop table if exists esquina cascade;

drop table if exists esquina_csv cascade;

drop table if exists rua cascade;

