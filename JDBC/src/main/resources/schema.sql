drop table if exists log_set;
drop table if exists exercise_log;
drop table if exists exercise;
drop table if exists training_log;

create table training_log
(
    id           bigint auto_increment primary key,
    performed_at date not null,
    finished_at  date null
);

create table exercise
(
    id   bigint auto_increment primary key,
    name varchar(100) unique not null
);

create table exercise_log
(
    id              bigint auto_increment primary key,
    exercise_id     bigint not null,
    training_log_id bigint not null,
    constraint fk_exercise_log_training_log_id foreign key (training_log_id) references training_log (id),
    constraint fk_exercise_log_exercise_id foreign key (exercise_id) references exercise (id)
);

create table log_set
(
    id              bigint auto_increment  primary key,
    reps            int    not null,
    weight          int null,
    exercise_log_id bigint not null,
    constraint fk_log_set_exercise_log_id foreign key (exercise_log_id) references exercise_log (id)
);