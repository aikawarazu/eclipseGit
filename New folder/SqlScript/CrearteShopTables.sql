-- Customer
create  table if not exists Customer(
id                  int not null,
name                varchar(20) not null,    --  ����
birthday            date,           --  ����
age                 varchar(40),    --  ����
Tel                 varchar(20),    --  �绰
Address             varchar(20),    --  ��ַ
Email               varchar(20),    --  ����
Sex                 varchar(20),    --  �Ա�
description         varchar(20),    --  ����
PRIMARY KEY (id)
)ENGINE=InnoDB;

-- Seller
create  table if not exists Seller(
id                  int  not null,
name                varchar(20), -- �̼�����
tel                 varchar(20), -- �绰
address             varchar(20), -- ��ַ
website             varchar(20), -- ��ַ
star                varchar(2) , -- ����
business            varchar(40), -- ��Ӫ
PRIMARY KEY (id)
)ENGINE=InnoDB;
-- Commodity
create  table if not exists Commodity(
id                  int  not null,
name                varchar(20),    -- ��Ʒ����
description         varchar(50),    -- ����
price               double     ,    -- �۸�
category            varchar(50),    -- ����
seller              int        ,    -- �̼�
PRIMARY KEY (id)
)ENGINE=InnoDB;

-- Order             
create  table if not exists OrderForm(
id                  int  not null,       -- ������
customer            int   not null,       -- �˿�
tradedate           Date   ,       -- ����ʱ��
status              varchar(10) ,       -- ״̬
amount              double  ,       -- ����
PRIMARY KEY (id)
)ENGINE=InnoDB;

-- OrderItem
create  table if not exists OrderItem(
id                  int   not null ,       -- ����������
orderForm               int    ,       -- ������
commodity           int    ,       -- ��Ʒ���
discount            double ,       -- �ۿ�
actprice            double ,       -- �ۺ�۸�
amount              int    ,       -- ����
PRIMARY KEY (id)
)ENGINE=InnoDB;

