--SQL SCripts for P0-Bank

--EXTRA FEATURE IDEAS
--[] could add a joint_holders table to give other users access
		--to existing accounts, but that was stretch goal
--[] pword hash and separate pword into separate table,

--random notes from 09.16.1230
create role random_login LOGIN password 'p4ssw0rd';
grant select on table public.super_important_table to java_login;
revoke select on table public.super_important_table from java_login;
--an example of using the DCL commands


--Users
	--primary key serial unique	
	--username 
	--full name
	--usertype (employee or customer)
	--password
create table users (
	userId serial primary key, --IS there a way TO GET a random string instead?
	username varchar(20) unique not null,
--	firstname varchar(20) not null,
--	lastname varchar(20) not null,
	pword varchar(20) not null,
)
 
create table customers (
	customer_id int references users(userId),
	)
	
create table employees (
	emp_id int references users(userId),
)	

--not gonna use
create table credentials (
	foreign key userId from table users,
	pword varchar(20) not null
)


--setting up a foreign key in a
create table --and then the rest
fk_user_id int references users_table(user_id)

	
--Accounts
	--primarykey serial unique
	--account status (pending, or approved)	
	--type; check or saving
	--balance
	--acct_owner (customer primary key as foreign key)
create type acct_type as enum ('checking', 'savings');
create table accounts (
	account_num integer primary key serial,
	isApproved boolean default false,
	current_bal money check, --value > 0; --money is a datatype
	account_owner foreign key userId from table users --check syntax
	acct_type 
	)



--transactions
	-- primary key serial unique
	-- date
	-- fromAcct (accounts primary as foreign key)
	-- toAcct (accounts primary as foreign key)
		--but what about withdrawals?

create type account_action as enum ('deposit', 'withdraw', 'transfer', 'approval');

create table transaction_log (
	transact_id integer primary key serial,
	current_timestamp [(p)], --what's [] field?
	transact_type enum account_action, --check syntax
	credit_acct foreign key accounts.account_num,
	debit_acct foreign key accounts.account_num
	action_amount number --I could write a constraint to comparison to check 
						--that the amount isn't greater than account bal
)
	

