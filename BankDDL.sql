--Creating tables
--bank_users, employees, accounts, bank_log, 

create table bank_users (
	user_id serial primary key, 
	username varchar(20) unique not null,
	pword varchar(20) not null
	);
	
create table employees (
	employee_id serial primary key,
	fk_user_id int references bank_users(user_id)
);


create type acct_type as enum ('checking', 'savings');

create table accounts (
	account_num serial primary key,
	is_approved boolean default false,
	balance numeric check (balance > 0) default 0.0 not null,
	account_owner int references bank_users(user_id),
	type_of acct_type
	);
	
create table bank_log (
	action_num serial primary key,
	action_date date,
	action_amt numeric not null,
	credit_acct int references accounts(account_num),
	debit_acct int references accounts(account_num)
);


