# 🧪 Testing Guide - Currency Converter

## Test Plan Overview

This guide provides comprehensive testing strategies for the Currency Converter application.

---

## 🎯 Test Scenarios

### 1. Authentication Testing

#### 1.2 Login Functionality

| Test Case         | Steps                                                 | Expected Result                                        | Status |
| ----------------- | ----------------------------------------------------- | ------------------------------------------------------ | ------ |
| Valid Login       | Enter registered credentials → Click Login            | Redirect to home page                                  | ✅     |
| Invalid Username  | Enter non-existent username → Click Login             | Error message: "Invalid username or password"          | ✅     |
| Wrong Password    | Enter correct username, wrong password → Click Login  | Error message shown, password field cleared            | ✅     |
| Empty Username    | Leave username empty → Click Login                    | Error message: "Username and password cannot be empty" | ✅     |
| Empty Password    | Leave password empty → Click Login                    | Error message: "Username and password cannot be empty" | ✅     |
| Pre-loaded User 1 | Username: `Ainul10222` Password: `ainul10222`         | Should login successfully                              | ✅     |
| Pre-loaded User 2 | Username: `rafisarkar0128` Password: `rafisarkar0128` | Should login successfully                              | ✅     |
| Pre-loaded User 3 | Username: `123` Password: `123456789`                 | Should login successfully                              | ✅     |

#### 1.3 Guest Access

| Test Case      | Steps                         | Expected Result                              | Status |
| -------------- | ----------------------------- | -------------------------------------------- | ------ |
| Guest Login    | Click "Guest User" button     | Redirect to home page with "Welcome, Guest!" | ✅     |
| Guest Features | Use all features in home page | All features work without login              | ✅     |
| Guest Logout   | Logout from guest account     | Return to welcome page                       | ✅     |

---

### 2. Currency Conversion Testing

#### 2.1 Basic Conversion

| Test Case      | Steps                              | Expected Result                  | Status |
| -------------- | ---------------------------------- | -------------------------------- | ------ |
| USD to EUR     | Amount: 100, From: USD, To: EUR    | Result shows ~92.00 EUR          | ✅     |
| EUR to USD     | Amount: 100, From: EUR, To: USD    | Result shows ~108.70 USD         | ✅     |
| Same Currency  | Amount: 50, From: USD, To: USD     | Result shows 50.00 USD           | ✅     |
| Large Amount   | Amount: 999999, From: USD, To: GBP | Correct calculation displayed    | ✅     |
| Decimal Amount | Amount: 10.50, From: USD, To: JPY  | Correct conversion with decimals | ✅     |
| Zero Amount    | Amount: 0, From: USD, To: EUR      | Result shows 0.00 EUR            | ✅     |

#### 2.3 Negative and Invalid Input

| Test Case          | Steps                               | Expected Result                            | Status |
| ------------------ | ----------------------------------- | ------------------------------------------ | ------ |
| Negative Amount    | Amount: -100, currencies selected   | Error message: "Amount cannot be negative" | ✅     |
| Non-numeric Input  | Type "abc" in amount field          | Error message: "Invalid amount entered"    | ✅     |
| Special Characters | Type "@#$" in amount field          | Error message: "Invalid amount entered"    | ✅     |
| Empty Amount       | Leave amount empty, change currency | Shows "Result: 0.00"                       | ✅     |

#### 2.4 Exchange Rate Display

| Test Case       | Steps                         | Expected Result                          | Status |
| --------------- | ----------------------------- | ---------------------------------------- | ------ |
| USD to GBP Rate | Amount: 1, From: USD, To: GBP | Shows "Exchange Rate: 1 USD = ~0.79 GBP" | ✅     |
| High Rate       | Amount: 1, From: JPY, To: USD | Shows rate with correct decimals         | ✅     |
| Low Rate        | Amount: 1, From: USD, To: JPY | Shows rate ~150.50                       | ✅     |

```

```
