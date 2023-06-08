CREATE INDEX ix_book_title
    on book (title);

ALTER TABLE if exists author
    add constraint FKceqd7orxfq4psjxye5xpen88q
        foreign key (publisher_id)
            references publisher;
ALTER TABLE if exists book
    add constraint FKklnrv3weler2ftkweewlky958
        foreign key (author_id)
            references author;
