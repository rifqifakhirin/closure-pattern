create table generation.transfer_approval_closure
(
    id                  bigserial primary key,
    ancestor            bigint,
    descendant          bigint,
    depth               int,
    created_at          timestamp,
    updated_at          timestamp
);