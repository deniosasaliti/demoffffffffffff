CREATE TABLE user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)          NULL,
    email    VARCHAR(255)          NULL,
    password VARCHAR(255)          NULL,
    role_id  BIGINT                NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);



CREATE TABLE post
(
    post_id       BIGINT       NOT NULL,
    post_name     VARCHAR(255) NULL,
    url           VARCHAR(255) NULL,
    `description` LONGTEXT     NULL,
    vote_count    INT          NULL,
    user_id       BIGINT       NULL,
    created_date  datetime     NULL,
    image         VARCHAR(255) NULL,
    categories    VARCHAR(255) NULL,
    CONSTRAINT pk_post PRIMARY KEY (post_id)
);

ALTER TABLE post
    ADD CONSTRAINT FK_POST_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

CREATE TABLE comment
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    text         VARCHAR(255)          NULL,
    post_id      BIGINT                NULL,
    created_date datetime              NULL,
    user_id      BIGINT                NULL,
    CONSTRAINT pk_comment PRIMARY KEY (id)
);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_POST FOREIGN KEY (post_id) REFERENCES post (post_id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

CREATE TABLE token
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    token   VARCHAR(255)          NULL,
    user_id BIGINT                NULL,
    CONSTRAINT pk_token PRIMARY KEY (id)
);

ALTER TABLE token
    ADD CONSTRAINT FK_TOKEN_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);


CREATE TABLE vote
(
    vote_id   BIGINT NOT NULL,
    vote_type INT    NULL,
    post_id   BIGINT NULL,
    user_id   BIGINT NULL,
    CONSTRAINT pk_vote PRIMARY KEY (vote_id)
);

ALTER TABLE vote
    ADD CONSTRAINT FK_VOTE_ON_POST FOREIGN KEY (post_id) REFERENCES post (post_id);

ALTER TABLE vote
    ADD CONSTRAINT FK_VOTE_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);


CREATE TABLE  role
(
    role_id        BIGINT AUTO_INCREMENT NOT NULL,
    role_name VARCHAR(255)          NULL,
    CONSTRAINT pk_role PRIMARY KEY (role_id)
);

create table PERMISSIONS (
    role_id bigint,
    permission VARCHAR(255),
    constraint pk_permission_fk_permission_on_role foreign key (role_id) references  role (role_id)
);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_ROLE FOREIGN KEY (role_id) REFERENCES  role (role_id);