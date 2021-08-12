DROP TABLE IF EXISTS users;

CREATE TABLE users (
	id serial PRIMARY KEY,
	"name" VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	gender Varchar (10) check (gender in ('female','male')),
	status Varchar (10) check (status in ('active','inactive'))
);

INSERT INTO users VALUES
(2042,'Romeu da Silva','49f763f9@gmail.com','male','active'),
(2051,'neha','sexyneha@gmail.com','female','active'),
(60,'Chaturbhuj Devar','devar_chaturbhuj@veum.net','female','inactive'),
(61,'Ekaparnika Mukhopadhyay','ekaparnika_mukhopadhyay@lueilwitz.org','male','active'),
(63,'Anandamayi Malik','malik_anandamayi@ebert.name','male','active'),
(64,'Ganak Namboothiri IV','namboothiri_iv_ganak@spinka-beier.io','male','inactive'),
(65,'Fr. Suresh Ahluwalia','ahluwalia_fr_suresh@effertz.info','female','inactive'),
(66,'Karthik Iyengar','karthik_iyengar@wiza.co','female','inactive'),
(67,'Brahmdev Rana','brahmdev_rana@kris.com','female','inactive'),
(68,'Kanak Tagore JD','kanak_jd_tagore@rowe-kovacek.info','male','active'),
(69,'Chandra Mehrotra DDS','dds_mehrotra_chandra@funk-effertz.biz','female','inactive'),
(70,'Bala Adiga','adiga_bala@ritchie-howe.org','male','active'),
(71,'Ekdant Patel LLD','patel_lld_ekdant@baumbach.io','male','inactive'),
(72,'Aanandaswarup Nair Jr.','nair_aanandaswarup_jr@senger-stokes.info','female','inactive'),
(73,'Satish Asan','asan_satish@kris.biz','male','inactive'),
(295,'Shiv Dhawan','dhawan_shiv@crooks.net','female','active'),
(1287,'Natasha Romanov','nat50@marvel.com','female','active'),
(6,'New Bhooshan Bhat','new_bhooshan_bhat@hodkiewicz.biz','male','active'),
(8,'Gon Gon','gon@gon.com','female','active'),
(11,'Hisoka Hisoka','hisoka@hisoka.com','female','inactive');