-- 用户表
create table user
(
    id bigint not null primary key comment '主键',
    user_name varchar(256) not null comment '用户名',
    nickname varchar(256) null comment '用户名',
    password varchar(256) not null comment '密码',
    avatar varchar(256) null comment '用户头像',
    follow_count int not null default 0 comment '关注数',
    followed_count int not null default 0 comment '被关注数',
    daily_count int not null default 0 comment '每日一题打卡数',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
    ) comment '用户表';

-- 个人笔记表
create table user_note
(
    id bigint not null primary key comment '主键',
    url varchar(512) not null comment '笔记链接',
    title varchar(256) not null comment '笔记标题',
    word_num int not null comment '笔记字数',
    collect boolean not null default false comment '是否收藏',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
    ) comment '个人笔记表';

-- 题目表
create table question
(
    id bigint not null primary key comment '主键',
    title varchar(256) not null comment '题目标题',
    description varchar(256) not null comment '题目描述',
    input_list varchar(512) null comment '输入列表',
    output_list varchar(512) not null comment '输出列表',
    time_limit bigint not null comment '时间限制',
    space_limit bigint not null comment '内存限制',
    star_count int not null comment '收藏数',
    difficulty int not null comment '难度（1-简单，2-中等，3-困难）',
    tags varchar(256) not null comment '标签集合',
    ac_count int not null comment '通过数',
    commit_count int not null comment '提交数',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
    ) comment '题目表';

-- 题目标签表
create table question_tag
(
    id bigint not null primary key comment '主键',
    title varchar(256) not null comment '标签标题',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
    ) comment '题目标签表';

-- 用户答题表
create table user_question
(
    id bigint not null primary key comment '主键',
    user_id bigint not null comment '用户id',
    question_id bigint not null comment '题目id',
    language int not null comment '答题语言(后面用枚举类)',
    status int not null comment '答题状态(后面用枚举类)',
    code varchar(512) not null comment '答题代码',
    msg varchar(512) not null comment '答题信息',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
    ) comment '用户答题表';

-- 用户题目收藏表
create table user_question_like
(
    id bigint not null primary key comment '主键',
    user_id bigint not null comment '用户id',
    question_id bigint not null comment '题目id',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
) comment '用户题目收藏表';

-- 题解表
create table solution
(
    id bigint not null primary key comment '主键',
    user_id bigint not null comment '用户id',
    question_id bigint not null comment '题目id',
    url varchar(512) not null comment '笔记链接',
    title varchar(256) not null comment '笔记标题',
    word_num int not null comment '笔记字数',
    star_count int not null comment '点赞数',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
    ) comment '题解表';

-- 帖子表
create table post
(
    id bigint not null primary key comment '主键',
    user_id bigint not null comment '用户id',
    title varchar(256) not null comment '帖子标题',
    content varchar(256) not null comment '帖子内容',
    comment_count int not null comment '评论数',
    star_count int not null comment '点赞数',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
    ) comment '帖子表';

-- 话题表
create table topic
(
    id bigint not null primary key comment '主键',
    user_id bigint not null comment '用户id',
    title varchar(256) not null comment '帖子标题',
    content varchar(256) not null comment '帖子内容',
    hot int not null comment '热度',
    star_count int not null comment '点赞数',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
    ) comment '话题表';

-- 竞赛表
create table competition
(
    id             bigint                             not null comment '主键'
        primary key,
    competition_name      varchar(256)                       not null comment '竞赛名称',
    start_time       datetime                       null comment '开始时间',
    end_time       datetime                       not null comment '结束时间',
    subscribe_count   bigint      default 0                 not null comment '被订阅数',
    join_count        bigint      default 0                 not null comment '参加人数',
    average_score        bigint      default 0                 not null comment '平均分数',
    average_time        bigint      default 0                 not null comment '平均作答时间(min)',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除'
) comment '竞赛表';


-- 竞赛题目表(目前暂定是只能四道)
create table competition_question
(
    id             bigint                             not null comment '主键'
        primary key,
    competition_id      bigint                       not null comment '竞赛id',
    question_id      bigint                       not null comment '第一道题目id',
    question_score      bigint                       not null comment '第一道题目分数',
    question_pass_rate      bigint                       not null comment '第一道题目通过率',
    question_difficulty_score      bigint                       not null comment '第一道题目难度分',
    competition_question_num      bigint                       not null comment '在竞赛中的题号',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除'
) comment '竞赛题目表';

-- 用户竞赛订阅表（用于 websocket 发送通知）
create table user_competition_description
(
    id             bigint                             not null comment '主键'
        primary key,
    user_id        bigint                             not null comment '用户id',
    competition_id        bigint                             not null comment '竞赛id',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除'
) comment '用户竞赛订阅表';

-- 用户竞赛表（成绩）
create table user_competition
(
    id             bigint                             not null comment '主键'
        primary key,
    user_id        bigint                             not null comment '用户id',
    competition_id        bigint                             not null comment '竞赛id',
    score        varchar(256)                             not null comment '用户成绩列表',
    cost_time        varchar(256)                             not null comment '用户完成时间列表',
    score_rank        bigint                             not null comment '排名',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除'
) comment '用户竞赛表';

-- 话题帖子表
create table post_topic
(
    id bigint not null primary key comment '主键',
    post_id bigint not null comment '帖子id',
    topic_id bigint not null comment '话题id',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
) comment '话题帖子表';

-- 评论表
create table oj_db.comment
(
    id                bigint primary key  comment '主键',
    user_id           bigint                             not null comment '用户id',
    parent_comment_id bigint   default -1                not null comment '回复评论id(没有则-1)',
    content           varchar(256)                       not null comment '内容',
    `like`            int      default 0                 not null comment '点赞数',
    create_time       DATETIME default CURRENT_TIMESTAMP null comment '创建时间',
    update_time       Datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted        int      default 0                 not null comment '是否删除'
)
    comment '评论表';