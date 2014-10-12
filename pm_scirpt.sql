CREATE DATABASE `PropertyManagement` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

DROP TABLE IF EXISTS tbl_user;
CREATE TABLE tbl_user(
					UID			varchar(20) NOT NULL,
					UNickname		varchar(10) DEFAULT '' ,
					UPhone		varchar(10) NOT NULL,
					UPassword		varchar(15)	NOT NULL,
					URole			int 		DEFAULT 0,
					URegTime		date		NOT NULL,
					URealName		varchar(10) DEFAULT '',
					UGender		int 		NOT NULL,
					UBirthday		date		NOT NULL,
					UProfession	varchar(6) 	DEFAULT 0,
					UBuilding		int 		DEFAULT 0,
					URoom			varchar(5)	DEFAULT '',
					UFamilyNO		int 		DEFAULT 0,
					UQQNum		varchar(20) DEFAULT	'',
					UCarNums		varchar(20) DEFAULT	'',
					PRIMARY KEY (UID)
					)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
					
					


					
DROP TABLE IF EXISTS tbl_Biotope;
CREATE TABLE tbl_Biotope(
					BiotopeID			varchar(10) NOT NULL,
					BBiotopeName		varchar(10) NOT NULL,
					BPropertyID		varchar(10) ,
					BAddress			varchar(20) ,
					BBeginYear		date		,
					PRIMARY KEY (BiotopeID)
					)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
					
					
DROP TABLE IF EXISTS tbl_Property;
CREATE TABLE tbl_Property(
					PropertyID		varchar(10) NOT NULL,
					PPropertyName		varchar(10) NOT NULL,
					PCity				varchar(10) ,
					PQualification	varchar(20) ,
					PManager			varchar(5)	,
					PManagerPhone		varchar(5)	,
					PRIMARY KEY (PropertyID)
					)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
					
DROP TABLE IF EXISTS tbl_PAdmin;
CREATE TABLE tbl_PAdmin(					
				PAdministratorID	varchar(10) NOT NULL,
				PPassword			varchar(10) NOT NULL,
				PAdminName		varchar(10) NOT NULL,
				PAdminPhone		varchar(10) NOT NULL,
				PIsSuperAdmin		int
				PropertyID		varchar(10) ,
				PStatus			int
				PRIMARY KEY (PAdministratorID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
				
DROP TABLE IF EXISTS tbl_RepairTicket;
CREATE TABLE tbl_RepairTicket(					
				RepairTicketID	varchar(10) NOT NULL,
				RUserID			varchar(10) NOT NULL,
				RTicketSubject	varchar(10) NOT NULL,
				RTicketContent	varchar(10) NOT NULL,
				RContactTime	date,		
				RHandler		varchar(10) NOT NULL,
				RHanderPhone	varchar(10) NOT NULL,
				RResumeTimes	int,
				RStatus			int			DEFAULT 0,
				RComment		varchar(50) DEFAULT '',
				RUpdateTime		date,
				RCount          int,
				PRIMARY KEY (RepairTicketID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
				
				
				
DROP TABLE IF EXISTS tbl_Complaint;
CREATE TABLE tbl_Complaint(				
				ComplaintID			varchar(20) NOT NULL,
				CUserID				varchar(10) NOT NULL,
				CTicketSubject		varchar(20) default 'none',
				CTicketContent		varchar(50) default 'none',
				CContactTimeType	int		    default 0,
				CHandler			varchar(10),
				CHandlerPhone		varchar(10),
				CResumeTimes		int,
				CStatus				int			NOT	NULL  DEFAULT 0,
				CUpdateTime			date,
				PRIMARY KEY (ComplaintID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
				
				
				
DROP TABLE IF EXISTS tbl_PFEE;
CREATE TABLE tbl_PFEE(				
				PMFeeID			varchar(10) NOT NULL,
				FUserID			varchar(10) NOT NULL,
				FeeofPM			float,
				FIsPaid			int,
				FPaidDate		date,
				FComments		varchar(30),
				PRIMARY KEY (PMFeeID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
				
				
DROP TABLE IF EXISTS tbl_Notice;
CREATE TABLE tbl_Notice(				
				NoticeID		varchar(20) NOT NULL,
				NBiotopeID		varchar(10) NOT NULL,
				NPoster			varchar(10) NOT NULL,
				NPubTime		date,
				NExpTime		date,
				NSubject		varchar(10) default 'none',
				NContent		varchar(100) default 'none',
				NLabel			varchar(20) default 'none',
				NIsTop			int,
				NIsDeleted		int,
				UpdateTime		date      ,
				PRIMARY KEY (NoticeID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
				
				

DROP TABLE IF EXISTS tbl_Post;
CREATE TABLE tbl_Post(
				PostID			varchar(20) NOT NULL,
				PPhone		    varchar(10) NOT NULL,
				PSubmitTime		date,
				PIsVadilated	int,
				PSubject		varchar(10) NOT NULL,
				PBodyText		varchar(100) NOT NULL,
				PState			int,
				PRootID			varchar(10) NOT NULL,
				PReplyPostID	varchar(10) NOT NULL,
				PUpdateTime	date,
				PRIMARY KEY (PostID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
				
				
				
DROP TABLE IF EXISTS tbl_PostTitle;
CREATE TABLE tbl_PostTitle(
				PostID			varchar(20) NOT NULL,
				PPhone		    varchar(10) NOT NULL,
				PSubmitTime		date,
				PIsVadilated	int,
				PSubject		varchar(10) NOT NULL,				
				PState			int,
				PLastUpdateTime	date,
				PRIMARY KEY (PostID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;				

DROP TABLE IF EXISTS tbl_Comment;
CREATE TABLE tbl_Comment(
				CommentID		varchar(10) NOT NULL,
				CMainPostID		varchar(10) NOT NULL,
				CUserID			varchar(10) NOT NULL,
				CReplyCont		int,
				CReplyTime		int,
				CState			int,
				PRIMARY KEY (CommentID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
				
				
DROP TABLE IF EXISTS tbl_RepairTicket;
CREATE TABLE tbl_RepairTicket(				
				RepairTicketID varchar(20),
				RUserID varchar(20),
				RTicketSubject varchar(20),
				RTicketContent	varchar(20),
				RContactTime date,
				RHandler varchar(10),
				RHandlerPhone varchar(10),
				RResumeTimes int,
				RStatus varchar(10),
				RComment  varchar(50),
				RUpdateTime date,
				PRIMARY KEY (RepairTicketID)
				)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

				

					
					
					
					