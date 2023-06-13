create table generation.manual_one
(
    id                  bigserial primary key,
    price               numeric(19, 2),
    name                varchar(100),
    created_at          timestamp,
    iso             bigint
);

ALTER TABLE generation.manual_one ADD COLUMN inquiry_id int8;