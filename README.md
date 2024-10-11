# Banking-Transactions-API
This project implements a RESTful API for a simple banking transaction API . The API supports functionalities such as:  User account creation , Fund transfers between given accounts and Retrieving transaction history

 **Use Case 1:** 
     - Account creation requires basic details like the account holder's first name , last name , email address,  phone number, account number and initial balance, and it is assumed that the input will be validated (e.g., balance should not be negative, account number should be only numeric).
     - End Point : http://localhost:8080/bankingApp/user-account.
  ```- Sample Request Payload : 
      {
        "firstName": "Rose",
        "lastName": "Jasmine",
        "email": "apple12@gmail.com",
        "phoneNumber": 9876543456,
        "accountNumber": 78654,
        "initialBalance": 10000.00
      }```
