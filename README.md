# CR7_Bank
  CR7_Bank este un sistem de gestionare a cardurilor bancare pentru utilizatori. Utilizatorii se pot autentifica în conturile lor si pot interactiona cu diferite tipuri de carduri bancare, inclusiv carduri standard, carduri premium și carduri junior.
## Clase:

### 1. User
- **Rol:** Reprezinta un utilizator al aplicației bancare. Acesta detine o lista cu carduri.De precizat este ca utilizatorul are voie sa detina un singur card de un anume tip.
- **Metode principale:**
  - `authenticate(String username, String password)`: Autentifica un utilizator cu un nume de utilizator și o parolă.
  - `addCard(Card card)`: Adaugă un nou card la lista de carduri a utilizatorului.
  - `removeCard(Card card)`: Sterge un card existent din lista de carduri a utilizatorului.
  - `interactWithCard(int index)`: Permite utilizatorului să interactioneze cu un card specific din lista sa.
  - `displayCards()` : Afiseaza cardurile asociate ale utilizatorului.
    

### 2. Card
- **Rol:** Reprezintă un card bancar.(Coincide cu cardul Standard in proiect)
- **Metode principale:**
  - `deposit(double amount)`: Realizeaza o depunere pe cardul curent.Exista o suma minima de depunere.Nu se pot adauga bani pe un card ce este blocat.
  - `withdraw(double amount)`: Efectuează o retragere de pe cardul curent.Nu se pot retrage bani pe un card ce este blocat.
  - `performTransfer(Card destinationCard, double amount)`: Transferă bani către un alt card.
  - `displayCardInfo()`: Afișează informațiile detaliate despre card.
  - `displayTransactions()`: Afișează istoricul tranzacțiilor cardului.
  - `displayTransfers()`: Afișează istoricul transferurilor cardului.
  - `generateCardNumber()`: Functie ce ajuta la generarea unui numar pentru card.
  - `generateCvv()`: Functie ce ajuta la generarea unui CVV pentru card.
 
    
### 3. PremiumCard - mosteneste clasa Card
- **Rol:** Reprezintă un card bancar premium, cu caracteristici și avantaje suplimentare față de un card standard. Acest tip de card cuprinde 2 balante diferite una pentru sumele in Ron si una pentru sumele in Euro.De asemenea, acest tip de card ofera o balanta pentru economii(savings).Pentru acest card, exista o functionalitate care atunci cand depui o suma de bani ce nu este una fixa, de exemplu 12.5 , rotunjeste suma la numamrul intreg mai mic, si diferenta de bani o transfera in balanta de economii.
- **Metode principale:**
  -  `addToSavings()`: Adauga bani in balanta pentru economii.
  -  `addToBalanceInEur()`: Adauga bani in contul de Euro.
  -  `transferRONtoEUR`: Realizeaza un transfer al unei sume de bani din contul Ron in contul Euro pentru acelasi card.
  -  `transferEURtoRON`: Realizeaza un transfer al unei sume de bani din contul Euro in contul Ron pentru acelasi card.
  -  `displaySavingsBalance()`: Afiseaza balanta de economii.
  -  `displayBalanceInEUR()`: Afiseaza contul de Euro.
  -  `displayBalanceInRON()`: Afiseaza contul de Ron.
  -  `deposit()`: am suprascris metoda deposit, astfel incat sa creez functionalitatea specifica acestui tip de card.

### 4. JuniorCard - - mosteneste clasa Card
- **Rol:** Reprezintă un card bancar dedicat copiilor sau adolescenților, cu limitari in ceea ce priveste suma maxima de cheltuit.
- **Metode principale:**
  - `makeTransactionWithLimit()`: nu permite transferul in cazul in care suma retrasa este mai mare decat limita impusa.


### 5. Transaction
- **Rol:** Reprezintă o tranzacție.
- **Metode principale:**
  - Constructor, getteri si setteri pentru inițializarea tranzacției si a atributelor.


### 6. Transfer
- **Rol:** Reprezintă un transfer de bani între două carduri.
- **Metode principale:**
  -  Constructor, getteri si setteri pentru inițializarea tranzacției si a atributelor.

