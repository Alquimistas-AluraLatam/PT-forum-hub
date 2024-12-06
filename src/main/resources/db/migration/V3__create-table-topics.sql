create table topics(

    id bigint not null auto_increment,
    title varchar(200) not null,
    message varchar(2000) not null,
    creationDate datetime not null,
    status varchar(20) not null,
    course_id bigint not null,
    user_id bigint not null,

    primary key(id),
    constraint fk_topics_course_id foreign key(course_id) references courses(id),
    constraint fk_topics_user_id foreign key(user_id) references users(id)
);