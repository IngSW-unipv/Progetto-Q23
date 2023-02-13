**Casi D’uso**


Requisito Piste:
```markdown

Scope- Gestione Voli da Utente Torre
Level - Obiettivo Utente
Primary Actor and Stakeholders - Utente Torre è l’attore primario, con Stakeholder anche gli altri utenti possibili che possono interagire con la pagina Voli. 
Preconditions - L’utente deve essere loggato nel sistema sotto il titolo “Torre”.
Success Guarantee - L’utente è loggato come utente Torre, il volo che si vuole aggiungere ha le condizioni necessarie per essere accettato, ossia che il modello dell’aereo sia accettato, che la direzione del vento non sia nella stessa esatta direzione dell’arrivo dell’aereo, e se c’è lo spazio per parcheggiare l’aereo.

Main Success Scenario - 


L’utente Torre clicca sul bottone per Pista X e apre la pagina per questa pista
L’utente clicca sul bottone “Aggiungere Volo”
L’utente mette in input i dati necessari per il volo, che vengono collaudati dal software, e l’algoritmo di controllo voli mette in output una lista di piste alternative se la pista X non è la scelta migliore. 
L’utente clicca sulla pista dove preferisce aggiungere il Volo.
Il volo viene aggiunto a una pista.
Il database viene aggiornato con questi nuovi dati, e la pagina “Dashboard” dove si visualizzano i voli in arrivo/partenza aggiorna la visualizzazione dei dati.

Extensions/Alternative Scenarios -
Scenario 1:  L’utente sceglie un'altra pista dove far atterrare l’aereo
Il Database verrà aggiornato ora non per aggiornare i dati di pista X, ma i dati della pista che ha scelto l’utente
La pagina “Dashboard” verrà aggiornata con il nuovo volo in arrivo, e anche la pagina visualizzazione voli per la pista che aveva scelto l’utente

Scenario 2: La direzione del vento combacia con la direzione di arrivo dell’aereo
In questo caso la pista non è disponibile per essere scelta come pista di atterraggio/partenza del volo, l’utente potrà o chiudere la pagina e provare con un'altra pista, oppure scegliere una delle 3 opzioni listate dall’algoritmo di selezione piste.

Scenario 3: Non c’è spazio nel Hangar dove parcheggiare l’aereo (se rimane all'aeroporto per più di tre ore)
In questo caso il volo non può essere aggiunto, le soluzioni per l’utente Torre sono di aggiungere il volo su pista X ma con orari che combaciano con la disponibilità dei Hangar associati ad aziende aeree che non hanno spazi permanenti nel Hangar.

Frequency of Occurrence - Dipende dalla frequenza dei voli in arrivo/partenza, sarà a discrezione dell’utente Torre
Open Issues - Se il volo non viene accettato, ci potrebbe essere la possibilità di consigliare una lista di aeroporti vicini per fare atterrare questo aereo?

```
Requisito Bagagli: 
Aggiunta bagaglio per Arrivo .
Aggiunta bagaglio per Partenze.
Ricerca ed amministrazione bagagli. 


Scope - Aggiunta Bagaglio volo in Arrivo
Level - (da specificare)
Primary Actor - Personale addetto allo smistamento bagagli sulla lista 
Preconditions – Il volto risulta concluso e atterrato e parcheggiato ad un Gate
Success Guarantee – Il volo deve presentare almeno un bagaglio stivato
Main Success Scenario - Il bagaglio viene aggiunto alla lista bagagli presenti in aeroporto.
Extensions/Alternative Scenarios –
Special Requirements - 
Technology and Data Variation  List - (Da  specificare)
Frequency of Occurrence – Al momento dell’atterraggio di un volo. 
Open Issues - Cosa accade se non siamo in grado di identificare l’etichetta del bagaglio. 

Scope - Aggiunta Bagaglio volo in Partenza
Level - (da specificare)
Primary Actor - Personale addetto alle Partenze 
Preconditions - Imbarco di un Volo
Success Guarantee - L’aereo sul quale dobbiamo imbarcare il bagaglio ha spazio in stiva
Main Success Scenario - Il bagaglio viene aggiunto alla lista bagagli e viene stampata la relativa etichetta. 
Extensions/Alternative Scenarios - Stiva ha concluso il posto relativo ai bagagli
Special Requirements - 
Technology and Data Variation List - (Da specificare)
Frequency of Occurrence - Check-in del volo.
Open Issues - Cosa accade se non siamo in grado di spedire il bagaglio con l’aereo corretto?

Scope -Ricerca di un Bagaglio 
Level - (da specificare)
Primary Actor - Personale addetto alle partenze e agli arrivi  
Preconditions – Il bavaglio deve esistere e deve essere stato inserito correttamente
Success Guarantee -La ricerca restituisce delle informazioni sul bagaglio 
Main Success Scenario -Stampa delle informazioni, etichetta volo al quale è assegnato è stato del bagaglio
Extensions/Alternative Scenarios – Il bagaglio non esiste 
Special Requirements - 
Technology and Data Variation  List - (Da specificare)
Frequency of Occurrence – Quando necessario 
Open Issues - Cosa accade se non viene specificato lo stato o alcuni campi?


Requisito Terreni:

Scope -  Assegnazione di un terreno 
Level - (da specificare)
Primary Actor - Personale addetto alla gestione dei terreni  
Preconditions – Il Terreno deve esistere e  non deve essere già assegnato
Main Success Scenario - il terreno viene assegnato al nuovo affittuario
Extensions/Alternative Scenarios – Special Requirements -  il terreno è gia stato assegnato
Technology and Data Variation  List - (Da specificare)
Frequency of Occurrence – Quando necessario 
Open Issues - 

Scope - Consultazione terreni
Level - (da specificare)
Primary Actor - Gli utenti abilitati alla visualizzazione di questa schermata, ovvero le compagnie aeree e chiunque altro si sia registrato al sito e  voglia consultare i terreni disponibili
Preconditions -  Devono esistere terreni all'interno del db
Main Success Scenario - Stampa delle informazioni riguardanti i terreni
Extensions/Alternative Scenarios – non sono presenti terreni all'interno del db
Special Requirements - 
Technology and Data Variation  List - (Da specificare)
Frequency of Occurrence – Quando necessario 
Open Issues - 


Requisito schermata di accesso:
```markdown
Login.
Logout.
Eliminazione account.

Scope -  L’utente effettua il login all’interno della pagina
Level - (da specificare)
Primary Actor – Il dipendente che deve effettuare l’accesso
Preconditions – Deve esistere una combinazione utente/password all’interno del database
Success Guarantee – L’utente inserisce la combinazione corretta di nome utente e password
Main Success Scenario - L’utente riesce ad accedere alla schermata adibita alla sua mansione
Extensions/Alternative Scenarios – Viene inserita una combinazione di nome utente e password errata o inesistente
Special Requirements - 
Technology and Data Variation  List - (Da specificare)
Frequency of Occurrence – Ogni volta che un dipendente necessita di accedere alla piattaforma che gli consente di gestire la mansione o le mansioni di cui si occupa
Open Issues - 

Scope – L’utente si scollega dalla piattaforma
Level - (da specificare)
Primary Actor – L’utente che stava lavorando
Preconditions – L’utente deve avere già effettuato l’accesso 
Main Success Scenario – L’utente riesce a scollegarsi dalla piattaforma
Extensions/Alternative Scenarios - 
Special Requirements - 
Technology and Data Variation  List - (Da specificare)
Frequency of Occurrence – Ogni volta che un dipendente ha finito il lavoro di cui si doveva occupare
Open Issues - 

Scope – Viene eliminato un account
Level - (da specificare)
Primary Actor – L’amministratore
Preconditions – L’account deve esistere, chi svolge questa operazione deve essere un account amministratore
Main Success Scenario – L’account selezionato viene eliminato
Extensions/Alternative Scenarios - 
Special Requirements - 
Technology and Data Variation  List - (Da specificare)
Frequency of Occurrence – Quando un utente non fa più parte della gestione aeroportuale
Open Issues -.

```
