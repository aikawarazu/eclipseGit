-- Customer
create  table if not exists Customer(
id                  int not null,
name                varchar(20) not null,    --  姓名
birthday            date,           --  生日
age                 varchar(40),    --  姓名
Tel                 varchar(20),    --  电话
Address             varchar(20),    --  地址
Email               varchar(20),    --  邮箱
Sex                 varchar(20),    --  性别
description         varchar(20),    --  描述
PRIMARY KEY (id)
)ENGINE=InnoDB;

-- Seller
create  table if not exists Seller(
id                  int  not null,
name                varchar(20), -- 商家名称
tel                 varchar(20), -- 电话
address             varchar(20), -- 地址
website             varchar(20), -- 网址
star                varchar(2) , -- 评级
business            varchar(40), -- 主营
PRIMARY KEY (id)
)ENGINE=InnoDB;
-- Commodity
create  table if not exists Commodity(
id                  int  not null,
name                varchar(20),    -- 商品名称
description         varchar(50),    -- 描述
price               double     ,    -- 价格
category            varchar(50),    -- 分类
seller              int        ,    -- 商家
PRIMARY KEY (id)
)ENGINE=InnoDB;

-- Order             
create  table if not exists OrderForm(
id                  int  not null,       -- 订单号
customer            int   not null,       -- 顾客
tradedate           Date   ,       -- 交易时间
status              varchar(10) ,       -- 状态
amount              double  ,       -- 单价
PRIMARY KEY (id)
)ENGINE=InnoDB;

-- OrderItem
create  table if not exists OrderItem(
id                  int   not null ,       -- 订单详情编号
orderForm               int    ,       -- 订单号
commodity           int    ,       -- 商品编号
discount            double ,       -- 折扣
actprice            double ,       -- 折后价格
amount              int    ,       -- 数量
PRIMARY KEY (id)
)ENGINE=InnoDB;

