create table generation.cashout_approval_closure
(
    id                  bigserial primary key,
    ancestor            bigint,
    descendant          bigint,
    depth               int
);