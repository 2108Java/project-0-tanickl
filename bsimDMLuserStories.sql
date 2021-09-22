--bsimDMLuserStories

--+ As a user, I can register for a customer account (checking or savings or both!).* 3 points
	--inserting
	insert into bsim_users (username, pword) values ('fourthcustomer', '123casa');
	--checking unique username
	select * from bsim_users where username = 'testtest';
			--I think it will return a null result set




--+ •As a user, I can login.* 2 points


--	* 
--+ •As a customer, I can apply for a new bank account with a starting balance.* 3 points
--	* add starting balance to this


--+ •As a customer, I can view the balance of a specific account (that belongs to me).* 1 point
--	* 
--+ •As a customer, I can make a withdrawal or deposit to a specific account (that belongs to me).* 2 points
--	* 
--+ •As a customer, I can post a money transfer to another account.* 3 points
--	* 
--+ •As a customer, I can accept a money transfer from another account.* 2 points
--	* 
--+ •As the system, I reject invalid transactions.* Ex:* A withdrawal that would result in a negative balance.* A deposit or withdrawal of negative money.* 2 points
--	* 
--+ •As an employee, I can approve or reject an account registration by a user.* 2 points
--	* 
--+ •As an employee, I can view a customer's bank accounts.* 1 point
--	* 
--+ •An employee, I can view a log of all transactions.* 2 points
--	* 
--+ •(Stretch goal) As a user, I can apply for a joint account* 3 points

