CREATE TABLE author (
                        id bigint not null,
                        publisher_id bigint,
                        firstname varchar(255),
                        lastname varchar(255),
                        primary key (id)
);
CREATE TABLE book (
                      author_id bigint,
                      id bigint not null,
                      isbn varchar(13) not null unique,
                      title varchar(255) not null,
                      primary key (id)
);
CREATE TABLE publisher (
                           id bigint not null,
                           vat varchar(9) not null unique,
                           name varchar(255) not null,
                           url varchar(255),
                           primary key (id)
);
