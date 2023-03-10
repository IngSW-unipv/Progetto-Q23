**Casi D’uso**


UC1
```markdown
Visualizzazione Piste e Voli per una Pista

Scope - AirManager Software
Level - User Goal
Primary Actor - Utente Voli

Stakeholders and Interests- Utente Voli e l’amministratore deve poter visualizzare la lista di piste, l'aeroporto che usa questo software deve poter visualizzare e avere un record corretto delle piste fisiche dell'aeroporto, e quali voli usano quelle piste.

Preconditions - L’utente deve essere autenticato come amministratore o utente Voli.

Success Guarantee- L’utente è autenticato correttamente come uno degli utenti con accesso, e la connessione con il database all’inizio del programma per la creazione della lista pista non deve essere interrotta o scattare un eccezione.

Main Sequenze - 1. L’utente apre la pagina Piste dalla Home Page
2. L’utente visualizza la lista di Piste con le relative
informazioni essenziali.
3. L’utente clicca su una Pista
4. L’utente visualizza la lista di voli per la Pista

Extensions/Alternative Scenarios - B2: L’utente esce dalla pagina Piste
B3: L’utente non è di tipo amministratore o Voli, e non ha  
accesso alla pagina Piste.


Frequency of Occurrence - Dipende dagli utenti, ogni volta che l’utente vuole vedere la lista di Piste.


```
UC2
```markdown
Aggiunta Pista

Scope - AirManager Software
Level - User Goal
Primary Actor - Utente Voli

Stakeholders and Interests - Utente Voli e l’amministratore deve poter aggiungere una Pista, se cambia la struttura fisica dell aeroporto o si vuole adattare il sistema a un nuovo aeroporto.

Preconditions - L’utente deve essere autenticato come amministratore o utente Voli.

Success Guarantee - L’utente è autenticato correttamente come uno degli utenti con accesso, e la connessione con il database all’inizio del programma per la creazione della lista pista non deve essere interrotta o scattare un eccezione.

Main Sequenze - 1. L’utente apre la pagina Piste dalla Home Page
2. L’utente scrive i dati necessari per l’aggiunta di una pista
3. L’aggiunta della pista viene confermata


Extensions/Alternative Scenarios - B2: L’utente esce dalla pagina Piste
B3: L’utente non scrive i dati necessari o scrive in modo  
sbagliato, in tal caso il programma farà apparire un  
errore.


Frequency of Occurrence - Dipende dagli utenti, ogni volta che l’utente vuole aggiungere una pista nuova.



```
UC3
```markdown
Visualizzazione Voli

Scope- Visualizzazione  voli in arrivo e/o partenza da e verso l'aeroporto da perte degli utenti
Level - Obiettivo Utente
Primary Actor and Stakeholders - Utente Bagaglio, l'utente pista sono gli attori primari, . 
Preconditions - L’utente deve essere loggato nel sistema sotto il titolo “Torre”,o "Bagaglio".
Success Guarantee - L’utente è loggato come utente Torre,Bagaglio.



L’utente Torre o Bagaglio clicca sul bottone per voli in arrivo e apre una pagina con la visualizzazione di una lista
che contine i voli in arrivo
L’utente Torre o Bagaglio clicca sul bottone per voli in partenza e apre una pagina con la visualizzazione di una lista
che contine i voli in partenza


Extensions/Alternative Scenarios -

Frequency of Occurrence - Dipende dalla frequenza dei voli in arrivo/partenza, sarà a discrezione dell’utente Torre e/o Bagagli

```
UC4
```markdown
Aggiunta bagaglio per Partenze

Scope - Aggiunta Bagaglio volo in Partenza
Primary Actor - Personale addetto alle Partenze
Preconditions - Condizione necessaria affinché sia possibile svolgere l’operazione è che l’utente abbia effettuato il login, e sia un utente gestore bagagli.
Success Guarantee - L’aereo sul quale dobbiamo imbarcare il bagaglio ha spazio in stiva.
Main Success Scenario - Il bagaglio viene aggiunto alla lista bagagli e viene stampato un messaggio di esito positivo.
Extensions/Alternative Scenarios - La stiva per quel volo ha concluso il posto relativo ai bagagli. Il peso inserito risulta avere un peso uguale a zero. Il volo sul quale vogliamo effettuare un’aggiunta di un bagaglio non è esistente.
Frequency of Occurrence - Ogni volta che abbiamo un volo in partenza.
Open Issues - Cosa accade se non siamo in grado di spedire il bagaglio con l’aereo corretto a seguito di un problema di carico eccessivo?


```
UC5
```markdown
Ricerca ed cambio satto di un bagaglio

Scope - Ricerca e cambio stato di un Bagaglio
Primary Actor - Utente gestore di bagagli, viene utilizzato per reperire tutte le informazione relativa ad un determinato bagaglio ed eventualmente effettuare delle modifiche su di essi.  
Preconditions - Condizione necessaria affinché sia possibile svolgere l’operazione è che l’utente abbia effettuato il login, e sia un utente gestore bagagli.
Success Guarantee - Il bagaglio deve esistere.
Main Success Scenario - Il bagaglio viene visualizzato correttamente e le operazioni di modifica vengono accettate.  
Extensions/Alternative Scenarios - Lista di scenari alternativi dove qualcos’altro succede
Frequency of Occurrence - La frequenza è relativa all’utilizzatore.

```
UC6
```markdown
Inserimento sosta

Scope - Inserimento sosta 
Level - (da specificare)
Primary Actor - Personale addetto alla gestione dei terreni  
Preconditions – L' Hangar deve esistere e i relativi posti non devono essere già assegnati
Main Success Scenario - Il terreno viene assegnato ad un aereo.Viene restituito un risultato.
Extensions/Alternative Scenarios – Special Requirements -  Il terreno è gia stato assegnato
Technology and Data Variation  List - (Da specificare)
Frequency of Occurrence – Quando necessario 


```
UC7 :
```markdown
Ricerca sosta

Scope - Ricerca sosta
Level - (da specificare)
Primary Actor - Personale addetto alla gestione dei terreni
Preconditions -  Il relativo hangar deve esistere all'interno del Db
Main Success Scenario - Stampa delle informazioni riguardanti i terreni e relative associazioni ad aerei
Extensions/Alternative Scenarios – L'Hangar selezionato non è presente all'interno del db
Special Requirements - 
Technology and Data Variation  List - (Da specificare)
Frequency of Occurrence – Quando necessario 


```
UC8
```markdown
Login

Scope -  Effettuare il login all’interno della pagina
Level - Obiettivo Utente
Primary Actor – Il dipendente che deve effettuare l’accesso
Preconditions – Deve esistere almeno una combinazione utente/password all’interno del database
Success Guarantee – L’utente inserisce una combinazione corretta di nome utente e password ovvero una combinazione username e password presente all'interno del database
Main Success Scenario - 
L'utente attende che la schermata di login venga caricata
L'utente inserisce una corretta combinazione di username e password e preme sul bottone "Login"
L’utente riesce ad accedere alla schermata adibita alla sua mansione

Extensions/Alternative Scenarios –

Scenario 1: Viene inserita una combinazione di nome utente e password errata o inesistente
Viene segnalata l'errata combinazione di username e password

Scenario 2: Si tenta di effettuare l'accesso senza avere inserito ne un username ne una password
Viene segnalato e chiesto di inserire username e password

Frequency of Occurrence – Ogni volta che un dipendente necessita di accedere alla piattaforma che gli consente di gestire la mansione o le mansioni di cui si occupa



```
UC9
```markdown
Aggiunta Voli

Scope - AirManager Software
Level - User Goal
Primary Actor - Utente Voli

Stakeholders and Interests - Utente Voli,Utenti Bagagli e l’amministratore deve poter aggiungere una Volo in arrivo e partenza da e verso un aeroporto, se cambia la struttura fisica dell aeroporto o si vuole adattare il sistema a un nuovo aeroporto.

Preconditions - L’utente deve essere autenticato come amministratore,utente Voli o utente bagagli.

Success Guarantee - L’utente è autenticato correttamente come uno degli utenti con accesso, e la connessione con il database all’inizio del programma per la creazione della lista pista non deve essere interrotta o scattare un eccezione.

Main Sequenze -
1. L’utente apre la pagina Voli dalla Home Page
2. L'utente apre la pagina dedicata all'aggiunta di voli
3. L’utente scrive i dati necessari per l’aggiunta di un Volo
4. L’aggiunta della pista viene confermata


Extensions/Alternative Scenarios - B2: L’utente esce dalla pagina Voli
B3: L’utente non scrive i dati necessari o scrive in modo  
sbagliato, in tal caso il programma farà apparire un  
errore.


Frequency of Occurrence - Dipende dagli utenti, ogni volta che l’utente vuole aggiungere un Volo nuova.
