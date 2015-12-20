insert into users (first_name, last_name, email, phone_number, password, enabled) VALUES ('Binod', 'Sethi', 'binod.sethi@reverside.co.za', '0744412288','secret', true);

insert into login (user_id, user_name, password, role) VALUES ('1', 'admin', 'secret', 'USER');

insert into loan_types(name, description, image) values('Business Loan', 'An amount given to an individual to use for personal benefit that must be paid off at a specified time', '/img/paisa/personalLoan.jpg');
insert into loan_types(name, description, image) values('Personal Loan', 'Businesses require an adequate amount of capital to fund startup expenses or pay for expansions.','/img/paisa/businessLoan.jpg');