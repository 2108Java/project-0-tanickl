--Creating tables
--bsim_users, bsim_accounts,  maybe bsim_log, maybe bsim_acct_owners 

select * from bsim_log



---------------------------------------------------------------------
---------------------------------------------------------------------
---------------------------------------------------------------------

--customer's view of transactions
	--ideas: using a union, a join, a subquery

select * from bsim_log where deb_acct in (select acct_num from bsim_accounts where user_id=19) 
union
select * from bsim_log where cred_acct in (select acct_num from bsim_accounts where user_id=19);

select * from bsim_log;
select * from bsim_users;

--yes
select trans_num, deb_acct, cred_acct, amount, description, datetime 
from bsim_log inner join bsim_accounts 
on bsim_log.deb_acct = bsim_accounts.acct_num where user_id=40
union
select trans_num, deb_acct, cred_acct, amount, description, datetime 
from bsim_log inner join bsim_accounts 
on bsim_log.cred_acct = bsim_accounts.acct_num where user_id=40;



select acct_num from bsim_accounts where user_id = ? returning 

select * from bsim_log where deb_acct ((select acct_num from bsim_accounts where user_id = 5) 
union all
select * from bsim_log where cred_acct = (select acct_num from bsim_accounts where user_id = 5));

select acct_num from bsim_accounts where user_id = 5;


in (
	select acct_num from bsim_accounts where user_id = 
) union all (select cred_acct in (select acct_num from bsim_accounts where user_id = )
));

select * from bsim_log;

select * from bsim_log --
bsim_accounts.user_id = 


----test data for query of bsim_log

select * from bsim_log;

insert into bsim_log (deb_acct, cred_acct, amount, description, datetime) values (1,8,10,'1 this is a test', now());
insert into bsim_log (deb_acct, cred_acct, amount, description, datetime) values (3,11,21,'2 this is a test', now());
insert into bsim_log (deb_acct, cred_acct, amount, description, datetime) values (8,5,32,'3 this is a test', now());
insert into bsim_log (deb_acct, cred_acct, amount, description, datetime) values (11,44,43,'4 this is a test', now());
insert into bsim_log (deb_acct, cred_acct, amount, description, datetime) values (5,17,54,'5 this is a test', now());
insert into bsim_log (deb_acct, cred_acct, amount, description, datetime) values (44,18,65,'6 this is a test', now());
insert into bsim_log (deb_acct, cred_acct, amount, description, datetime) values (17,19,76,'7 this is a test', now());
insert into bsim_log (deb_acct, cred_acct, amount, description, datetime) values (18,20,87,'8 this is a test', now());
insert into bsim_log (deb_acct, cred_acct, amount, description, datetime) values (19,22,98,'9 this is a test', now());
insert into bsim_log (deb_acct, cred_acct, amount, description, datetime) values (25,20,82,'10 this is a test', now());
insert into bsim_log (deb_acct, amount, description, datetime) values (26,82,'11 this is a test', now());
insert into bsim_log (cred_acct, amount, description, datetime) values (27,101,'12 this is a test', now());
insert into bsim_log (deb_acct, amount, description, datetime) values (28,82,'13 this is a test', now());
insert into bsim_log (cred_acct, amount, description, datetime) values (28,82,'14 this is a test', now());
insert into bsim_log (deb_acct, description, datetime) values (30, '15, this is test of account approved', now());

---------------------------------------------------------------------
---------------------------------------------------------------------




select * from bsim_accounts;
---
SELECT
	c.customer_id,
	c.first_name customer_first_name,
	c.last_name customer_last_name,
	s.first_name staff_first_name,
	s.last_name staff_last_name,
	amount,
	payment_date
FROM
	customer c
INNER JOIN payment p 
    ON p.customer_id = c.customer_id
INNER JOIN staff s 
    ON p.staff_id = s.staff_id
ORDER BY payment_date;

---
--join as nested query
SELECT
	film_id,
	title
FROM
	film
WHERE
	film_id IN (
		SELECT
			inventory.film_id
		FROM
			rental
		INNER JOIN inventory ON inventory.inventory_id = rental.inventory_id
		WHERE
			return_date BETWEEN '2005-05-29'
		AND '2005-05-30'
	);


--bsim_log table

create table bsim_log (
	trans_num serial primary key,
	deb_acct int,
	cred_acct int,
	amount numeric check (amount >= 0),
	description varchar not null,
	datetime timestamp
);

select * from bsim_log;
--
--TESTS
--yes, WITHDRAW
insert into bsim_log (deb_acct, cred_acct, amount, description, datetime)
	values (998,null,142.36,'this is a SECOND test of WITHDRAWAL', now());
--yes, DEPOSIT
insert into bsim_log (deb_acct, cred_acct, amount, description, datetime)
	values (null,996,514.12,'this is a test of DEPOSIT', now());
--yes, transfer
insert into bsim_log (deb_acct, cred_acct, amount, description, datetime)
	values (993,992,213.00,'this is a SECOND test of TRANSFER', now());
--yes, pending
insert into bsim_log (deb_acct, description, datetime)
	values (990,'this is a SECOND test of REJECT or APPROVE PENDING', now());






select * from bsim_log;



---------------------------------------------------------------------
---------------------------------------------------------------------
---------------------------------------------------------------------





--for demo
select * from bsim_users;
select * from bsim_accounts;



select * bsim_accounts where is_approved = false;



--yes
alter table bsim_users alter column is_emp drop default;
	
--To reset the data
delete from bsim_accounts where user_id >= 20;
delete from bsim_users where user_id >= 20;
select * from bsim_users;
select * from bsim_accounts;

drop table bsim_users; 
--yes
create table bsim_users (
	user_id serial primary key, 
	username varchar(20) unique not null,
	pword varchar(20) not null,
	is_emp boolean default false not null
	);

--START SETUP FOR USERS
--yes --for register user
insert into bsim_users (username, pword) values ('johndoe', 'pass');
insert into bsim_users (username, pword) values ('cindyjones', 'pass');
insert into bsim_users (username, pword) values ('miguelgarcia', 'pass');
insert into bsim_users (username, pword) values ('kateoliver', 'pass');
insert into bsim_users (username, pword) values ('customer1', 'pass1');
insert into bsim_users (username, pword) values ('customer2', 'pass2');
insert into bsim_users (username, pword) values ('customer3', 'pass3');
insert into bsim_users (username, pword) values ('customer4', 'pass4');
insert into bsim_users (username, pword) values ('customer5', 'pass5');

--yes --for register emp user
insert into bsim_users (username, pword, is_emp) values ('zedanderson', 'pass', true);
insert into bsim_users (username, pword, is_emp) values ('sarahmiller', 'pass', true);
insert into bsim_users (username, pword, is_emp) values ('mitchjones', 'pass', true);
insert into bsim_users (username, pword, is_emp) values ('roypowell', 'pass', true);
insert into bsim_users (username, pword, is_emp) values ('janedoe', 'pass', true);
insert into bsim_users (username, pword, is_emp) values ('emp1', 'pass1', true);
insert into bsim_users (username, pword, is_emp) values ('emp2', 'pass2', true);
insert into bsim_users (username, pword, is_emp) values ('emp3', 'pass3', true);
insert into bsim_users (username, pword, is_emp) values ('emp4', 'pass4', true);
insert into bsim_users (username, pword, is_emp) values ('emp5', 'pass5', true);

select * from bsim_users;
		--CUSTOMERS: user_id's 1 thru 9
			--begin test cases at "customer6" 
		--EMPS: user_id's 10 thru 19
			--begin test cases 
--END SETUP FOR USERS

select * from bsim_users;
select username, bsim_accounts from bsim_accounts inner join bsim_users
	on bsim_accounts.user_id = bsim_users.user_id where bsim_users.username = ?;

select * from bsim_accounts inner join bsim_users on bsim_accounts.user_id = bsim_users.user_id where bsim_users.username = ;
select * from bsim_accounts;
select * from bsim_accounts;

--passed test for unique constraint
insert into bsim_users (username, pword, is_emp) values ('emp1', 'pass1', true);

--yes -- returned only employee users when true; customers when false
select * from bsim_users where is_emp = false;

--see whole table
select * from bsim_users;

select bsim_users.username, bsim_accounts.acct_num, bsim_accounts.type_of from bsim_users inner join bsim_accounts on bsim_users.user_id = bsim_accounts.user_id 
	where bsim_users.is_emp = false;

drop table bsim_accounts;
create table bsim_accounts (
	acct_num serial primary key,
	is_approved boolean default false,
	balance numeric check (balance >= 0) default 0.0,
	type_of varchar(10),
	user_id int,
	constraint fk_user foreign key (user_id) references bsim_users(user_id)
	);



alter table bsim_accounts add column type_of type varchar(10);

--yes, for inserting parameterized new account
	--for sake of organization, bsim_users.user_id is odd for is_approved = true; even for false;
insert into bsim_accounts (is_approved, balance, type_of, user_id) values (true, 550, 'checking', 9);
--yes
insert into bsim_accounts (is_approved, balance, type_of, user_id) values (false, 2450, 'savings', 8);

insert into bsim_accounts (is_approved, balance, type_of, user_id) values (true, 4415, 'checking', 7);
insert into bsim_accounts (is_approved, balance, type_of, user_id) values (false, 0, 'checking', 6);
insert into bsim_accounts (is_approved, balance, type_of, user_id) values (true, 788, 'savings', 5);
insert into bsim_accounts (is_approved, balance, type_of, user_id) values (false, 0, 'checking', 4);

--yes, check constraint works, no illegal insertion
insert into bsim_accounts (is_approved, balance, type_of, user_id) values (true, -50, 'checking', 3);

--yes, secondary account
insert into bsim_accounts (is_approved, balance, type_of, user_id) values (true, 1200, 'savings', 3);
insert into bsim_accounts (is_approved, balance, type_of, user_id) values (true, 900, 'checking', 3);

--
insert into bsim_accounts (is_approved, balance, type_of, user_id) values (false, 1200, 'savings', 2);
insert into bsim_accounts (is_approved, balance, type_of, user_id) values (true, 1200, 'savings', 1);

--dropped bsim_acct_owners bc no time
--yes
--drop table bsim_acct_owners;
--create table bsim_acct_owners (
--	fk_acct int references bsim_accounts(acct_num),
--	fk_user int references bsim_users(user_id)
--);
select * from bsim_accounts where user_id = 9;

select * from bsim_users;
select * from bsim_accounts;

update bsim_accounts set balance 

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

