CREATE TABLE IF NOT EXISTS users (
	id serial PRIMARY KEY,
	"name" VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	gender Varchar (10) check (gender in ('female','male')),
	status Varchar (10) check (status in ('active','inactive'))
);

insert into users values
    (2,'Chakravartee Achari','chakravartee_achari@lockman-collins.biz','male','inactive'),
    (3,'Anil Nambeesan','nambeesan_anil@rice-pouros.net','male','inactive'),
    (5,'Darshan Mehra DC','darshan_dc_mehra@bauch-ziemann.biz','male','active'),
    (6,'Vidhya Mukhopadhyay','vidhya_mukhopadhyay@graham.com','female','inactive'),
    (7,'Sarada Kocchar','sarada_kocchar@smitham.info','male','active'),
    (8,'Rati Sethi','sethi_rati@terry.biz','female','inactive'),
    (9,'Bhramar Jha','jha_bhramar@lynch.co','male','inactive'),
    (18,'Mangala Ahuja MD','ahuja_mangala_md@miller.name','female','inactive'),
    (19,'Aditeya Trivedi','trivedi_aditeya@ruecker.org','male','inactive'),
    (20,'Chidananda Achari','achari_chidananda@russel.co','female','inactive'),
    (21,'Chandira Iyer Esq.','esq_chandira_iyer@bartell.com','female','active'),
    (23,'Guru Adiga DDS','guru_dds_adiga@schimmel-stehr.biz','female','active'),
    (24,'Gemine Verma','verma_gemine@christiansen-pollich.io','female','active'),
    (25,'Naveen Nambeesan','nambeesan_naveen@herzog.co','male','active'),
    (26,'Bhooshit Talwar','talwar_bhooshit@wolff.net','male','inactive'),
    (27,'Kanti Devar','kanti_devar@bogisich.net','female','active'),
    (28,'Vaishvi Malik','vaishvi_malik@corwin.name','female','inactive'),
    (29,'Trilok Patel','trilok_patel@douglas.biz','male','active'),
    (30,'Trilok Bhat','bhat_trilok@kutch.biz','female','inactive'),
    (31,'Aadrika Dubashi','dubashi_aadrika@corkery.name','male','inactive')
    ON CONFLICT DO NOTHING;
