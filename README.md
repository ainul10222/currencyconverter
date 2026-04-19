# 💱 Currency Converter Application

A modern, user-friendly currency conversion application built with **Java**, **Maven**, and **JavaFX**. This application provides real-time currency conversion with user authentication and conversion history tracking.

## 🌟 Features

### 1. **User Authentication**

- **Sign Up**: Create a new account with username, email, and password
- **Login**: Access your account with credentials
- **Guest Access**: Use the app without registration
- Input validation and error handling

### 2. **Currency Conversion**

- **22 Currency Support**: USD (US dollar), EUR (Euro), GBP (Pound sterling), JPY (Japanese yen), CZK (Czech koruna), DKK (Danish krone), HUF (Hungarian forint), PLN (Polish zloty), RON (Romanian leu), SEK (Swedish krona), CHF (Swiss franc), ISK (Icelandic krona), NOK (Norwegian krone), TRY (Turkish lira), AUD (Australian dollar), BRL (Brazilian real), CAD (Canadian dollar), CNY (Chinese yuan renminbi), HKD (Hong Kong dollar), IDR (Indonesian rupiah), INR (Indian rupee), BDT (Bangladeshi taka)
- **Real-time Conversion**: Automatic calculation as you type
- **Swap Currencies**: Quick swap button to reverse conversion
- **Exchange Rates**: View current exchange rates between selected currencies
- **Decimal Precision**: Results formatted to 2 decimal places

### 3. **Conversion History**

- Track all conversions performed in the session
- Add conversions to history manually
- Clear history with one click
- View full conversion details

### 4. **User-Friendly Interface**

- Clean, modern UI design
- Intuitive navigation
- Color-coded elements for better UX
- Professional styling

---

## 📋 Project Structure

```
currencyconverter/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── module-info.java                    # Module declarations
│   │   │   └── com/ainul/currencyconverter/
│   │   │       ├── App.java                        # Main application entry point
│   │   │       ├── models/
│   │   │       │   ├── User.java                   # User model
│   │   │       │   └── Currency.java               # Currency model
│   │   │       ├── services/
│   │   │       │   ├── AuthenticationService.java  # User authentication logic
│   │   │       │   └── CurrencyConversionService.java  # Conversion logic
│   │   │       └── controllers/
│   │   │           ├── WelcomeController.java      # Login/Signup controller
│   │   │           └── HomeController.java         # Main app controller
│   │   └── resources/
│   │       └── com/ainul/currencyconverter/
│   │           ├── welcome.fxml                    # Welcome page UI
│   │           └── home.fxml                       # Home page UI
│   └── test/                                        # Test directory
└── pom.xml                                          # Maven configuration
```

---

## 🚀 Getting Started

### Prerequisites

- **Java 21 LTS** or higher
- **Maven 3.9.12** or higher
- **JavaFX SDK 26**

### Installation

1. **Clone the Repository**

    ```bash
    git clone <repository-url>
    cd currencyconverter
    ```

2. **Build the Project**

    ```bash
    mvn clean install
    ```

3. **Run the Application**
    ```bash
    mvn javafx:run
    ```

---

## 💻 Usage Guide

### Welcome Page

1. **To Sign Up**:
    - Click the "Sign Up" tab
    - Enter username, email, and password (min 6 characters)
    - Click "Sign Up" button
    - Account created successfully!

2. **To Login**:
    - Click the "Login" tab
    - Enter your username and password
    - Click "Login" button
    - You'll be directed to the home page

3. **To Use as Guest**:
    - Click "Guest User" button at the bottom
    - Access all features without registration

### Home Page

1. **Enter Amount**:
    - Type the amount you want to convert in the "Amount" field
    - Clear button available to reset the field

2. **Select Currencies**:
    - Select "From Currency" (your current currency)
    - Select "To Currency" (currency to convert to)
    - Use the "⇄" swap button to reverse the conversion

3. **View Results**:
    - Result displays automatically as you type
    - Exchange rate shown for reference
    - All values formatted to 2 decimal places

4. **Manage History**:
    - Click "Add to History" to save the conversion
    - View all saved conversions in the history section
    - Click "Clear History" to reset

5. **Logout**:
    - Click "Logout" button in top-right to return to welcome page

---

## 📊 Supported Currencies

| Code | Currency          | Region         |
| ---- | ----------------- | -------------- |
| BDT  | Bangladeshi Taka  | Bangladesh     |
| USD  | US Dollar         | United States  |
| EUR  | Euro              | European Union |
| GBP  | British Pound     | United Kingdom |
| JPY  | Japanese Yen      | Japan          |
| CZK  | Czech Koruna      | Czech Republic |
| DKK  | Danish Krone      | Denmark        |
| HUF  | Hungarian Forint  | Hungary        |
| PLN  | Polish Zloty      | Poland         |
| RON  | Romanian Leu      | Romania        |
| SEK  | Swedish Krona     | Sweden         |
| CHF  | Swiss Franc       | Switzerland    |
| ISK  | Icelandic Krona   | Iceland        |
| NOK  | Norwegian Krone   | Norway         |
| TRY  | Turkish Lira      | Turkey         |
| AUD  | Australian Dollar | Australia      |
| BRL  | Brazilian Real    | Brazil         |
| CAD  | Canadian Dollar   | Canada         |
| CNY  | Chinese Yuan      | China          |
| HKD  | Hong Kong Dollar  | Hong Kong      |
| IDR  | Indonesian Rupiah | Indonesia      |
| INR  | Indian Rupee      | India          |

---
