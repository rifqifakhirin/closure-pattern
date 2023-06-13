create table generation.transfer_approval
(
    id                  bigserial primary key,
    parent_id           bigint,
    name                varchar(100),
    role_id             bigint,
    is_executor         boolean,
    created_at          timestamp,
    updated_at          timestamp
);