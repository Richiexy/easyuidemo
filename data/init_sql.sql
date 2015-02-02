drop table S_PRIV cascade constraints;

drop table S_ROLE cascade constraints;

drop table S_ROLE_PRIV cascade constraints;

drop table S_USER cascade constraints;

drop table S_USER_ROLE cascade constraints;

drop table T_CLASS cascade constraints;

drop table T_COURSE cascade constraints;

drop table T_REG_COURSE cascade constraints;

drop table T_SCHOOL cascade constraints;

drop table T_STUDENT cascade constraints;

drop table S_DICINFO cascade constraints;

/*==============================================================*/
/* Table: S_PRIV                                                */
/*==============================================================*/
create table S_PRIV  (
   K_ID                 INTEGER                         not null,
   PRIVID               VARCHAR2(20),
   PRIVNAME             VARCHAR2(200),
   REC_STAT             CHAR(1),
   CREATE_TIME          VARCHAR2(20),
   CREATE_USER          VARCHAR2(10),
   MODIFY_TIME          VARCHAR2(20),
   MODIFY_USER          VARCHAR2(10),
   constraint PK_S_PRIV primary key (K_ID)
);

comment on table S_PRIV is
'�û�Ȩ�ޱ�';

comment on column S_PRIV.K_ID is
'�������';

comment on column S_PRIV.PRIVID is
'Ȩ��ID';

comment on column S_PRIV.PRIVNAME is
'Ȩ������';

comment on column S_PRIV.REC_STAT is
'��¼״̬';

comment on column S_PRIV.CREATE_TIME is
'����ʱ��';

comment on column S_PRIV.CREATE_USER is
'������';

comment on column S_PRIV.MODIFY_TIME is
'�޸�ʱ��';

comment on column S_PRIV.MODIFY_USER is
'�޸���';

/*==============================================================*/
/* Table: S_ROLE                                                */
/*==============================================================*/
create table S_ROLE  (
   K_ID                 INTEGER                         not null,
   ROLEID               VARCHAR2(20),
   ROLENAME             VARCHAR2(100),
   REC_STAT             CHAR(1),
   CREATE_TIME          VARCHAR2(20),
   CREATE_USER          VARCHAR2(10),
   MODIFY_TIME          VARCHAR2(20),
   MODIFY_USER          VARCHAR2(10),
   constraint PK_S_ROLE primary key (K_ID)
);

comment on table S_ROLE is
'�û���ɫ��';

comment on column S_ROLE.K_ID is
'����ID';

comment on column S_ROLE.ROLEID is
'��ɫID';

comment on column S_ROLE.ROLENAME is
'��ɫ����';

comment on column S_ROLE.REC_STAT is
'��¼״̬';

comment on column S_ROLE.CREATE_TIME is
'����ʱ��';

comment on column S_ROLE.CREATE_USER is
'������';

comment on column S_ROLE.MODIFY_TIME is
'�޸�ʱ��';

comment on column S_ROLE.MODIFY_USER is
'�޸���';

/*==============================================================*/
/* Table: S_ROLE_PRIV                                           */
/*==============================================================*/
create table S_ROLE_PRIV  (
   K_ID                 INTEGER                         not null,
   ROLEID               VARCHAR2(20),
   PRIVID               VARCHAR2(20),
   REC_STAT             CHAR(1),
   CREATE_TIME          VARCHAR2(20),
   CREATE_USER          VARCHAR2(10),
   MODIFY_TIME          VARCHAR2(20),
   MODIFY_USER          VARCHAR2(10),
   constraint PK_S_ROLE_PRIV primary key (K_ID)
);

comment on table S_ROLE_PRIV is
'��ɫȨ�޹�����';

comment on column S_ROLE_PRIV.K_ID is
'�������';

comment on column S_ROLE_PRIV.ROLEID is
'��ɫ���';

comment on column S_ROLE_PRIV.PRIVID is
'Ȩ�ޱ��';

comment on column S_ROLE_PRIV.REC_STAT is
'��¼״̬';

comment on column S_ROLE_PRIV.CREATE_TIME is
'����ʱ��';

comment on column S_ROLE_PRIV.CREATE_USER is
'������';

comment on column S_ROLE_PRIV.MODIFY_TIME is
'�޸�ʱ��';

comment on column S_ROLE_PRIV.MODIFY_USER is
'�޸���';

/*==============================================================*/
/* Table: S_USER                                                */
/*==============================================================*/
create table S_USER  (
   K_ID                 INTEGER                         not null,
   USERID               VARCHAR2(10),
   USERNAME             VARCHAR2(40),
   USERPWD              VARCHAR2(20),
   REC_STAT             CHAR(1),
   CREATE_TIME          VARCHAR2(20),
   CREATE_USER          VARCHAR2(10),
   MODIFY_TIME          VARCHAR2(20),
   MODIFY_USER          VARCHAR2(10),
   constraint PK_S_USER primary key (K_ID)
);

comment on table S_USER is
'ϵͳ�û���';

comment on column S_USER.K_ID is
'�������';

comment on column S_USER.USERID is
'�û�ID';

comment on column S_USER.USERNAME is
'�û���';

comment on column S_USER.USERPWD is
'�û�����';

comment on column S_USER.REC_STAT is
'��¼״̬';

comment on column S_USER.CREATE_TIME is
'����ʱ��';

comment on column S_USER.CREATE_USER is
'������';

comment on column S_USER.MODIFY_TIME is
'�޸�ʱ��';

comment on column S_USER.MODIFY_USER is
'�޸���';

/*==============================================================*/
/* Table: S_USER_ROLE                                           */
/*==============================================================*/
create table S_USER_ROLE  (
   K_ID                 INTEGER                         not null,
   USERID               VARCHAR2(10),
   ROLEID               VARCHAR2(20),
   REC_STAT             CHAR(1),
   CREATE_TIME          VARCHAR2(20),
   CREATE_USER          VARCHAR2(10),
   MODIFY_TIME          VARCHAR2(20),
   MODIFY_USER          VARCHAR2(10),
   constraint PK_S_USER_ROLE primary key (K_ID)
);

comment on table S_USER_ROLE is
'�û���ɫ������';

comment on column S_USER_ROLE.K_ID is
'�������';

comment on column S_USER_ROLE.USERID is
'�û�ID';

comment on column S_USER_ROLE.ROLEID is
'��ɫID';

comment on column S_USER_ROLE.REC_STAT is
'��¼״̬';

comment on column S_USER_ROLE.CREATE_TIME is
'����ʱ��';

comment on column S_USER_ROLE.CREATE_USER is
'������';

comment on column S_USER_ROLE.MODIFY_TIME is
'�޸�ʱ��';

comment on column S_USER_ROLE.MODIFY_USER is
'�޸���';

/*==============================================================*/
/* Table: T_CLASS                                               */
/*==============================================================*/
create table T_CLASS  (
   K_ID                 INTEGER                         not null,
   CL_CODE              VARCHAR2(20),
   CL_NAME              VARCHAR2(200),
   SC_CODE              VARCHAR2(20),
   REC_STAT             CHAR(1),
   CREATE_TIME          VARCHAR2(20),
   CREATE_USER          VARCHAR2(10),
   MODIFY_TIME          VARCHAR2(20),
   MODIFY_USER          VARCHAR2(10),
   constraint PK_T_CLASS primary key (K_ID)
);

comment on table T_CLASS is
'�༶��Ϣ��';

comment on column T_CLASS.K_ID is
'�������';

comment on column T_CLASS.CL_CODE is
'�༶���';

comment on column T_CLASS.CL_NAME is
'�༶����';

comment on column T_CLASS.SC_CODE is
'����ѧУ';

comment on column T_CLASS.REC_STAT is
'��¼״̬';

comment on column T_CLASS.CREATE_TIME is
'����ʱ��';

comment on column T_CLASS.CREATE_USER is
'������';

comment on column T_CLASS.MODIFY_TIME is
'�޸�ʱ��';

comment on column T_CLASS.MODIFY_USER is
'�޸���';

/*==============================================================*/
/* Table: T_COURSE                                              */
/*==============================================================*/
create table T_COURSE  (
   K_ID                 INTEGER                         not null,
   CO_CODE              VARCHAR2(20),
   CO_NAME              VARCHAR2(200),
   P_K_ID               INTEGER,
   REC_STAT             CHAR(1),
   CREATE_TIME          VARCHAR2(20),
   CREATE_USER          VARCHAR2(10),
   MODIFY_TIME          VARCHAR2(20),
   MODIFY_USER          VARCHAR2(10),
   constraint PK_T_COURSE primary key (K_ID)
);

comment on table T_COURSE is
'�γ���Ϣ��';

comment on column T_COURSE.K_ID is
'�������';

comment on column T_COURSE.CO_CODE is
'�γ̺�';

comment on column T_COURSE.CO_NAME is
'�γ���';

comment on column T_COURSE.P_K_ID is
'���пγ̺�';

comment on column T_COURSE.REC_STAT is
'��¼״̬';

comment on column T_COURSE.CREATE_TIME is
'����ʱ��';

comment on column T_COURSE.CREATE_USER is
'������';

comment on column T_COURSE.MODIFY_TIME is
'�޸�ʱ��';

comment on column T_COURSE.MODIFY_USER is
'�޸���';

/*==============================================================*/
/* Table: T_REG_COURSE                                          */
/*==============================================================*/
create table T_REG_COURSE  (
   K_ID                 INTEGER                         not null,
   ST_CODE              VARCHAR2(20),
   CO_CODE              VARCHAR2(20),
   GRADE                NUMBER(5,2),
   REC_STAT             CHAR(1),
   CREATE_TIME          VARCHAR2(20),
   CREATE_USER          VARCHAR2(10),
   MODIFY_TIME          VARCHAR2(20),
   MODIFY_USER          VARCHAR2(10)
);

comment on table T_REG_COURSE is
'ѡ����Ϣ��';

comment on column T_REG_COURSE.K_ID is
'�������';

comment on column T_REG_COURSE.ST_CODE is
'ѧ��';

comment on column T_REG_COURSE.CO_CODE is
'�γ̺�';

comment on column T_REG_COURSE.GRADE is
'�ɼ�';

comment on column T_REG_COURSE.REC_STAT is
'��¼״̬';

comment on column T_REG_COURSE.CREATE_TIME is
'����ʱ��';

comment on column T_REG_COURSE.CREATE_USER is
'������';

comment on column T_REG_COURSE.MODIFY_TIME is
'�޸�ʱ��';

comment on column T_REG_COURSE.MODIFY_USER is
'�޸���';

/*==============================================================*/
/* Table: T_SCHOOL                                              */
/*==============================================================*/
create table T_SCHOOL  (
   K_ID                 INTEGER                         not null,
   SC_CODE              INTEGER,
   SC_NAME              VARCHAR2(200),
   SC_ADDR              VARCHAR2(1000),
   REC_STAT             CHAR(1),
   CREATE_TIME          VARCHAR2(20),
   CREATE_USER          VARCHAR2(10),
   MODIFY_TIME          VARCHAR2(20),
   MODIFY_USER          VARCHAR2(10),
   constraint PK_T_SCHOOL primary key (K_ID)
);

comment on table T_SCHOOL is
'ѧУ��Ϣ��';

comment on column T_SCHOOL.K_ID is
'�������';

comment on column T_SCHOOL.SC_CODE is
'ѧУID';

comment on column T_SCHOOL.SC_NAME is
'ѧУ����';

comment on column T_SCHOOL.SC_ADDR is
'ѧУ��ַ';

comment on column T_SCHOOL.REC_STAT is
'��¼״̬';

comment on column T_SCHOOL.CREATE_TIME is
'����ʱ��';

comment on column T_SCHOOL.CREATE_USER is
'������';

comment on column T_SCHOOL.MODIFY_TIME is
'�޸�ʱ��';

comment on column T_SCHOOL.MODIFY_USER is
'�޸���';

/*==============================================================*/
/* Table: T_STUDENT                                             */
/*==============================================================*/
create table T_STUDENT  (
   K_ID                 INTEGER                         not null,
   ST_CODE              VARCHAR2(20),
   ST_NAME              VARCHAR2(40),
   ST_AGE               INTEGER,
   ST_SEX               CHAR(1),
   CL_CODE              INTEGER,
   REC_STAT             CHAR(1),
   CREATE_TIME          VARCHAR2(20),
   CREATE_USER          VARCHAR2(10),
   MODIFY_TIME          VARCHAR2(20),
   MODIFY_USER          VARCHAR2(10),
   constraint PK_T_STUDENT primary key (K_ID)
);

comment on table T_STUDENT is
'ѧ����Ϣ��';

comment on column T_STUDENT.K_ID is
'�������';

comment on column T_STUDENT.ST_CODE is
'ѧ��';

comment on column T_STUDENT.ST_NAME is
'����';

comment on column T_STUDENT.ST_AGE is
'����';

comment on column T_STUDENT.ST_SEX is
'�Ա�';

comment on column T_STUDENT.CL_CODE is
'�����༶';

comment on column T_STUDENT.REC_STAT is
'��¼״̬';

comment on column T_STUDENT.CREATE_TIME is
'����ʱ��';

comment on column T_STUDENT.CREATE_USER is
'������';

comment on column T_STUDENT.MODIFY_TIME is
'�޸�ʱ��';

comment on column T_STUDENT.MODIFY_USER is
'�޸���';

/*==============================================================*/
/* Table: S_DICINFO                                             */
/*==============================================================*/
create table S_DICINFO  (
   FIELDNAME            VARCHAR2(30)                    not null,
   CODE                 VARCHAR2(30)                    not null,
   CONTANT              VARCHAR2(50),
   MEMO                 VARCHAR2(200),
   constraint PK_S_DICINFO primary key (FIELDNAME, CODE)
);

comment on table S_DICINFO is
'�ֵ��';

comment on column S_DICINFO.FIELDNAME is
'�ֶ���';

comment on column S_DICINFO.CODE is
'�ֶα���';

comment on column S_DICINFO.CONTANT is
'�ֶ�ֵ';

comment on column S_DICINFO.MEMO is
'��ע';
