--Creating tables
--bsim_users, bsim_accounts,  maybe bsim_log, maybe bsim_acct_owners 


select * bsim_accounts where is_approved = false;

create table bsim2_users (
	user_id serial primary key, 
	username varchar(20) unique not null,
	pword varchar(20) not null,
	is_emp boolean default false not null
	)


select * from bsim_accounts;
insert into bsim_users (username,pword,is_emp) values ('garymcgary','casa123',false);


--yes
create table bsim_users (
	user_id serial primary key, 
	username varchar(20) unique not null,
	pword varchar(20) not null,
	is_emp boolean default false not null
	);

--yes --for register user
insert into bsim_users (username, pword) values ('johndoe', 'casa123');
insert into bsim_users (username, pword) values ('cindyjones', 'casa123');
insert into bsim_users (username, pword) values ('miguelgarcia', 'casa123');
insert into bsim_users (username, pword) values ('kateoliver', 'casa123');
insert into bsim_users (username, pword) values ('firstcustomer', '123casa');
insert into bsim_users (username, pword) values ('secondcustomer', '123casa');
insert into bsim_users (username, pword) values ('thirdcustomer', '123casa');
insert into bsim_users (username, pword) values ('fourthcustomer', '123casa');

--yes --for register emp user
insert into bsim_users (username, pword, is_emp) values ('zedanderson', 'casa123', true);
insert into bsim_users (username, pword, is_emp) values ('sarahmiller', 'casa123', true);
insert into bsim_users (username, pword, is_emp) values ('mitchjones', '123casa', true);
insert into bsim_users (username, pword, is_emp) values ('janedoe', '123casa', true);
insert into bsim_users (username, pword, is_emp) values ('firstemployee', '123casa', true);
insert into bsim_users (username, pword, is_emp) values ('secondemployee', '123casa', true);
insert into bsim_users (username, pword, is_emp) values ('thirdemployee', '123casa', true);

--passed test for unique constraint
insert into bsim_users (username, pword, is_emp) values ('firstemployee', '123casa', true);

--yes -- returned only employee users when true; customers when false
select * from bsim_users where is_emp = false;

--see whole table
select * from bsim_users;




--yes
create type acct_type as enum ('checking', 'savings');
--yes
create table bsim_accounts (
	acct_num serial primary key,
	is_approved boolean default false,
	balance numeric check (balance >= 0) default 0.0,
	type_of acct_type,
	fk_user int references bsim_users(user_id)
	);
select * from bsim_accounts where is_approved = true;

--yes, for inserting parameterized new account
insert into bsim_accounts (is_approved, balance, type_of, fk_user) values (true, 550, 'checking', 18);
--yes
insert into bsim_accounts (is_approved, balance, type_of, fk_user) values (true, 2450, 'savings', 17);

insert into bsim_accounts (is_approved, balance, type_of, fk_user) values (true, 4415, 'checking', 12);
insert into bsim_accounts (is_approved, balance, type_of, fk_user) values (false, 0, 'checking', 11);
insert into bsim_accounts (is_approved, balance, type_of, fk_user) values (true, 788, 'savings', 10);
insert into bsim_accounts (is_approved, balance, type_of, fk_user) values (false, 0, 'checking', 9);

--yes, check constraint works, no illegal insertion
insert into bsim_accounts (is_approved, balance, type_of, fk_user) values (true, -50, 'checking', 6);

--yes, secondary account
insert into bsim_accounts (is_approved, balance, type_of, fk_user) values (true, 1200, 'savings', 12);


--dropped bsim_acct_owners bc no time
--yes
--drop table bsim_acct_owners;
--create table bsim_acct_owners (
--	fk_acct int references bsim_accounts(acct_num),
--	fk_user int references bsim_users(user_id)
--);

select * from bsim_users;


-- I could write multiple statements, let's try that first. 
	--plan is to 
	--register user
	--get user_id from username
	--insert fk_user into bsim_accounts
	--get acct_num from bsim_accounts
	--insert (fk_acct,fk_user) into bsim_accounts 
--test case "testcase"
--
--insert into bsim_users (username, pword) values ('testcase2', '123casa');
--select user_id from bsim_users where username = 'testcase2';
--
--insert into bsim_accounts(type_of) values (acct_type 'checking'); 
--insert into bsim_acct_owners(fk_user) values (17);
--select fk_acct from bsim_acct_owners where fk_user = 17;

select user_id from bsim_users where username = 'johndoe';


select * from bsim_users where username = 'johndoe';


--test of returning
insert into bsim_users (username, pword) values ('lastcustomer', '123casa');


select * from bsim_acct_owners;



--just use log4j instead
--yes
--drop table bsim_log;
--(
--	action_num serial primary key,
--	action_date date,
--	action_amt numeric not null,
--	credit_acct int references bsim_accounts(account_num),
--	debit_acct int references bsim_accounts(account_num)
--);

select * from bsim_users;
