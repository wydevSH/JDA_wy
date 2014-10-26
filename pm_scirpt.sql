CREATE DATABASE `PropertyManagement` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

USE PropertyManagement;

DROP TABLE IF EXISTS tbl_user;
CREATE TABLE tbl_user(
					UID			varchar(20) NOT NULL,
					UBiotopeID  varchar(20) NOT NULL,
					UNickname		varchar(20) DEFAULT '',
					UPhone		varchar(15) NOT NULL,
					UPassword		varchar(20)	NOT NULL,
					URole			int 		DEFAULT 0,
					URegTime		date		NOT NULL,
					URealName		varchar(20) DEFAULT '',
					UGender		int 		NOT NULL,
					UBirthday		date		,
					UProfession	varchar(20) 	DEFAULT 0,
					UBuilding		int 		DEFAULT 0,
					URoom			varchar(15)	DEFAULT	'',
					UFamilyNO		int 		DEFAULT 0,
					UQQNum		varchar(20) DEFAULT	'',
					UCarNums		varchar(20) DEFAULT	'',
					PRIMARY KEY (UID)
					)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

					
DROP TABLE IF EXISTS tbl_Biotope;
CREATE TABLE tbl_Biotope(
					BiotopeID			varchar(20) NOT NULL,
					BBiotopeName		varchar(20) NOT NULL,
					BPropertyID		varchar(20) ,
					BAddress			varchar(30) ,
					BBeginYear		date		,
					PRIMARY KEY (BiotopeID)
					)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;					
					
DROP TABLE IF EXISTS tbl_Property;
CREATE TABLE tbl_Property(
					PropertyID		varchar(15) NOT NULL,
					PPropertyName		varchar(20) NOT NULL,
					PCity				varchar(20) ,
					PQualification	varchar(20) ,
					PManager			varchar(20)	,
					PManagerPhone		varchar(15)	,
					PRIMARY KEY (PropertyID)
					)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
					
DROP TABLE IF EXISTS tbl_PAdmin;
CREATE TABLE tbl_PAdmin(					
				PAdministratorID	varchar(20) NOT NULL,
				PPassword			varchar(20) NOT NULL,
				PAdminName		varchar(20) NOT NULL,
				PAdminPhone		varchar(15) NOT NULL,
				PIsSuperAdmin		int,
				PropertyID		varchar(15),
				PStatus			int,
				PRIMARY KEY (PAdministratorID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
				
DROP TABLE IF EXISTS tbl_RepairTicket;
CREATE TABLE tbl_RepairTicket(					
				RepairTicketID	varchar(20 ) NOT NULL,
				RUserID			varchar(20) NOT NULL,
				RTicketSubject	varchar(50) DEFAULT '',
				RTicketContent	varchar(140) DEFAULT '',
				RContactPeople  varchar(50) DEFAULT '',
				RContactPhone   varchar(50) DEFAULT '',
				RContactTime	date,		
				RHandler		varchar(20) DEFAULT '',
				RHandlerPhone	varchar(15) DEFAULT '',
				RResumeTimes	int,
				RStatus			int			DEFAULT 0,
				RComment		varchar(100) DEFAULT '',
				RUpdateTime		date,
				RCount          int,
				RTicketCommitTime  date,
				RTicketHandleTime  date,
				PRIMARY KEY (RepairTicketID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;				
				
DROP TABLE IF EXISTS tbl_Complaint;
CREATE TABLE tbl_Complaint(				
				ComplaintID			varchar(20) NOT NULL,
				CUserID				varchar(20) NOT NULL,
				CTicketSubject		varchar(50) default 'none',
				CTicketContent		varchar(140) default 'none',
				CContactPeople      varchar(50) DEFAULT '',
				CContactPhone       varchar(50) DEFAULT '',
				CContactTime	    date,		
				CContactTimeType	int		     default 0,
				CHandler			varchar(20),
				CHandlerPhone		varchar(15),
				CResumeTimes		int,
				CStatus				int			NOT	NULL  DEFAULT 0,
				CUpdateTime			date,
				CTicketCommitTime  date,
				CTicketHandleTime  date,
				PRIMARY KEY (ComplaintID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;				
				
DROP TABLE IF EXISTS tbl_PFEE;
CREATE TABLE tbl_PFEE(				
				PMFeeID			varchar(20) NOT NULL,
				FUserID			varchar(20) NOT NULL,
				FeeofPM			float,
				FIsPaid			int,
				FPaidDate		date,
				FComments		varchar(100),
				PRIMARY KEY (PMFeeID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;				
				
DROP TABLE IF EXISTS tbl_Notice;
CREATE TABLE tbl_Notice(				
				NoticeID		varchar(20) NOT NULL,
				NBiotopeID		varchar(20) NOT NULL,
				NPoster			varchar(20) NOT NULL,
				NPubTime		date,
				NExpTime		date,
				NSubject		varchar(50) default 'none',
				NContent		varchar(400) default 'none',
				NLabel			varchar(50) default 'none',
				NIsTop			int,
				NIsDeleted		int,
				UpdateTime		date      ,
				PRIMARY KEY (NoticeID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;				

DROP TABLE IF EXISTS tbl_Post;
CREATE TABLE tbl_Post(
				PostID			varchar(20) NOT NULL,
				PPhone			varchar(20) NOT NULL,
				PSubmitTime		date,
				PIsVadilated	int,
				PSubject		varchar(50) NOT NULL,
				PBodyText		varchar(300) NOT NULL,
				PState			int,
				PLastReplierID	varchar(20) NOT NULL,
				PLastRepTime	date,
				PRIMARY KEY (PostID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
				
DROP TABLE IF EXISTS tbl_PostTitle;
CREATE TABLE tbl_PostTitle(
				PostID			varchar(20) NOT NULL,
				PPhone		    varchar(20) NOT NULL,
				PSubmitTime		date,
				PIsVadilated	int,
				PSubject		varchar(20) NOT NULL,				
				PState			int,
				PLastUpdateTime	date,
				PRIMARY KEY (PostID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;					