--Bank DML

--table names
		--transaction_log
		--accounts
		--users





--EMPLOYEE DML commands

	--approve an account
select * table accounts where isApproved=false;
	--then display to console
	--then ask scanner.nextln input to
		--approve all pending
update accounts where isApproved is false and set isApproved true;

		--approve single account
update accounts where account_num = "?" and set isApproved true; 
	--scanner object to receive "?" for account_num
	--view transactions
select * table transaction_log;
		--options? or just one?



--49STOREdata40$16


--CUSTOMER DML commands
	
	--APPLY FOR ACCOUNT
			--
insert into table users (
	firstname, lastname, username, pword
	) values ()--get these one at a time with different scanner objects,
		--then pass them into the table all at once
		--userId and isEmployee should be set automatically
				--if I put the usernames and pwords in separate tables,
				-- I could make the pword foreign key match userId
				-- primary key, then I could just authenticate user login
				-- by matching the keys
						--maybe even hash the pword?

	--MAKE DEPOSIT
update table accounts column current_bal where account_num == 
			--and then the second part of the query will match
			--account_owner with something like == userId 
			--where username = this.username
				--I might need a PreparedStatement?
		--I'll need to add the amount to the query
		--then check if the deposit was successful, or do this after
		--the record is added to transaction_log?

	--after the deposit gets made, it should be added to transaction log
insert into table transaction_log (
transact_type, credit_acct, amount
) values (--get enum type from scanner, get credit_acct from:
			--"where account_owner ==" or somesuch written above

) --transact_id, current_timestamp, should be added automatically



	--MAKE WITHDRAWAL
update table accounts column current_bal where account_num ==
			--see above logic for deposit; copy
			-- still need to find specific syntax for setting new value
			-- of the balance column

	--after the withdrawal gets made, add record to transaction log
insert into table transaction_log (
transact_type, debit_acct, amount
) values ('withdraw', get credit_acct from:
			--"where account_owner ==" or somesuch written above
) --transact_id, current_timestamp, should be added automatically


	--TRANSFER WITHIN SINGLE USER
			--get scanner objects for the preparedstatement stuff
					--one statement for the debited account
update table accounts column current_bal where 
	debit_acct == accounts.account_num
					--another query for the credited account
update table accounts column current_bal where credit_acct ==

			--after complete, add record to transaction log
insert into table transaction_log ( 
transact_type, debit_acct, credit_acct, amount
) values ('transfer', --grab the rest of the query info from above
)



	--TRANSFER BETWEEN USERS
				--gonna look similar to the above
			--get scanner objects for the preparedstatement stuff
				--debiting user can specify by account_num;
				--they'll identify by account_num
						--account_num is simplest, but could
						--query by username/acct_type is more user-friendly
					--one statement for the debited account
update table accounts column current_bal where 
	accounts.account_num == debit_acct --is there more to this query?
					--another query for the credited account
update table accounts column current_bal where accounts.account_num == credit_acct;


			--after complete, add record to transaction log
insert into table transaction_log ( 
transact_type, debit_acct, credit_acct, amount
) values ('transfer', --grab the rest of the query info from above
)
						--you'll have to know the username for transfer