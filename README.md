# Banking-Transactions-API
This project implements a RESTful API for a simple banking transaction API . The API supports functionalities such as:  User account creation , Fund transfers between given accounts and Retrieving transaction history

 **Use Case 1:** 
 
     * Account creation requires basic details like the account holder's first name , last name , email address,  phone number, account number and initial balance, and it is assumed that the input will be validated (e.g., balance should not be negative, account number should be only numeric).
     * End Point : http://localhost:8080/bankingApp/user-account . Method : Post
     * Sample Request Payload : 
     {
        "firstName": "Rose",
        "lastName": "Jasmine",
        "email": "apple12@gmail.com",
        "phoneNumber": 9876543456,
        "accountNumber": 78654,
        "initialBalance": 10000.00
      }

**Use Case 2:**

      * It is assumed that fund transfers can only occur between two valid and existing accounts.
      * This endpoint takes the source account number, destination account number and the transfer amount in the request body.
      * End Point : http://localhost:8080/bankingApp/amount-transfer . Method :Post
      * Sample Request Payload :
      {
        "sourceAccount": 112233,
        "destinationAccount": 445566,
        "amount": 2000.00,
        "id": 2345,
        "transferDate" : "2024-10-10"
     } 

**Use Case 3:**

    * The transaction history for a specific account is retrieved 
    * The system stores the transaction details such as the amount, source account, destination account and timestamp.
    * End Point : http://localhost:8080/bankingApp/transaction/{accountNumber} . Method : Get

