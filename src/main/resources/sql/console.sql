use mkahnDB ;

-- auto-generated definition

create table user
(
    user_id                int auto_increment comment '서비스사용자관리번호' primary key,
    user_email             varchar(100)                          not null comment '비번',
    nick_name             varchar(50)                           not null comment ' 별명',
    token                  varchar(2000)                         null comment '앱토큰',
    refresh_token          varchar(2000)                         null comment '리프레시토큰',
    status                 varchar(20) default '정상'              not null comment '상태코드(정상,삭제)',
    reg_dt                 datetime    default CURRENT_TIMESTAMP not null comment '등록일시',
    update_dt                 datetime    default CURRENT_TIMESTAMP not null comment '등록일시',
    pwd                    varchar(200)                          null comment '비번',

    constraint nick_name
        unique (nick_name),
    constraint user_email
        unique (user_email)

) comment '서비스사용자' charset = utf8;
select * from user ;
select * from user where user_id = 8868;

select * from board ;

        select user0_.user_id as user_id1_1_, user0_.reg_dt as reg_dt2_1_, user0_.update_dt as update_d3_1_, user0_.nick_name as nick_nam4_1_, user0_.pwd as pwd5_1_, user0_.refresh_token as refresh_6_1_, user0_.status as status7_1_, user0_.token as token8_1_, user0_.user_email as user_ema9_1_ from user user0_ where user0_.user_email='mkahn25@gi-vita.io' and user0_.pwd='$2a$10$iEfyGgFnrvhhrR2gMO5sR.SOsqAlJDiZ8gmdaBOT1woI8KyePyLnS' and user0_.status='정상'


select now()