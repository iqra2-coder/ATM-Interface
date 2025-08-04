This project is a Java-based ATM Interface System developed using Object-Oriented Programming (OOP) principles and console-based interaction. It allows a hardcoded user to securely log in and perform essential banking operations like viewing transaction history, withdrawing money, depositing funds, and transferring amounts.

🔐 Key Features:
Secure Login System

User must enter a valid User ID and PIN to access ATM services.

Transaction History

Displays all previous transactions in a readable format.

If no transaction has occurred yet, a message is shown.

Withdraw Functionality

Users can withdraw money by entering a valid amount.

Ensures sufficient balance before proceeding.

Records the transaction with a timestamp-like entry.

Deposit Functionality

Accepts a positive deposit amount.

Updates the balance and logs the transaction.

Funds Transfer

Allows transfer of funds to another user (simulated with User ID entry).

Verifies available balance before completing the transaction.

Adds transaction log including receiver ID.

User-Friendly Menu

Menu-driven system using do-while and switch statements.

Allows multiple operations until the user chooses to quit.

💻 Technical Details:
Language Used: Java

Environment: Console-based (can be run in any Java IDE or terminal)

Packages Used: java.util.* (for Scanner and ArrayList)

Classes Used:

User: To store user credentials, balance, and transaction history

ATMOperations: Contains all banking-related methods

ATMInterface: Main class handling user interaction and login

