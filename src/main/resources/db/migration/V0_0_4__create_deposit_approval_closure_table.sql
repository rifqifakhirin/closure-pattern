create table generation.deposit_approval_closure
(
    id                  bigserial primary key,
    ancestor            bigint,
    descendant          bigint,
    depth               int
);