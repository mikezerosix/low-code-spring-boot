    CREATE INDEX ix_book_title 
       on book (title);

ALTER TABLE if exists author 
       add constraint FKceqd7orxfq4psjxye5xpen88q 
       foreign key (publisher_id) 
       references publisher;
ALTER TABLE if exists author_aud 
       add constraint FK4gh4hava2an2qfcslwass6ds 
       foreign key (rev) 
       references revinfo;
ALTER TABLE if exists book 
       add constraint FKklnrv3weler2ftkweewlky958 
       foreign key (author_id) 
       references author;
ALTER TABLE if exists book_aud 
       add constraint FK2u9iq76nh69r6f989ae7xft9 
       foreign key (rev) 
       references revinfo;
ALTER TABLE if exists publisher_aud 
       add constraint FK1aqwbaqlrgnro4koxt92at8tg 
       foreign key (rev) 
       references revinfo;
