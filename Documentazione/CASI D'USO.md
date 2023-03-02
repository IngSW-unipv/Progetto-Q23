**Casi D’uso**


Caso D'uso Visualizzazione Piste:
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
Caso D'uso Visualizzazione Voli:
```markdown

Scope- Visualizzazione ed inserimento di voli in arrivo e/o partenza da e verso l'aeroporto da perte degli utenti
Level - Obiettivo Utente
Primary Actor and Stakeholders - Utente Bagaglio, l'utente pista sono gli attori primari, . 
Preconditions - L’utente deve essere loggato nel sistema sotto il titolo “Torre”,o "Bagaglio".
Success Guarantee - L’utente è loggato come utente Torre,Bagaglio per entrambi i casi d'uso inoltre solo per l'inserimento di voli devono essere corretti i formati dei dati inseriti nella pagina 
di inserimento voli es:(id volo non già esistente e idaereo pista e gate esistenti)



L’utente Torre o Bagaglio clicca sul bottone per voli in arrivo e apre una pagina con la visualizzazione di una lista
che contine i voli in arrivo
L’utente Torre o Bagaglio clicca sul bottone per voli in partenza e apre una pagina con la visualizzazione di una lista
che contine i voli in partenza
L’utente clicca sul bottone “Aggiungere Volo” e selzionando il tasto "voli in partenza" inserisce dei voli in partenza
e cliccando su "voli in arrivo" inserisce nel db dei voli in partenza

Il database viene aggiornato con questi nuovi dati, che poi possono essere visualizzati nel caso in cui siano arrivo o partenza
nelle relative pagine per la visualizzazione

Extensions/Alternative Scenarios -
Scenario 1:  L’utente se non inserisce correttamente i dati avrà un messaggio sullo scherma che li dirà di inserire correttamente i dati

Frequency of Occurrence - Dipende dalla frequenza dei voli in arrivo/partenza, sarà a discrezione dell’utente Torre e/o Bagagli

```
Caso D'uso Bagagli: 

```markdown
Rimozione bagalio per volo in Arrivo .
Aggiunta bagaglio per Partenze.
Ricerca ed amministrazione bagagli. 


Scope - Aggiunta Bagaglio per volo in Arrivo
Primary Actor - Personale addetto all’arrivo dunque il personale di terra che smista i bagagli e li posiziona sui rulli trasportatori.
Preconditions - Condizione necessaria affinché sia possibile svolgere l’operazione è che l’utente abbia effettuato il login, e sia un utente gestore bagagli.
Success Guarantee - Il volo sul quale dobbiamo effettuare l’operazione esiste, il bagaglio esiste e l’etichetta viene inserita nella maniera opportuna.
Main Success Scenario - Il bagaglio viene aggiunto alla lista bagagli e la sua etichetta risulta presente all'interno del database.
Frequency of Occurrence - Ogni qualvolta un aereo atterra e viene effettuata l’operazione di smistaggio.

Scope - Aggiunta Bagaglio volo in Partenza
Primary Actor - Personale addetto alle Partenze
Preconditions - Condizione necessaria affinché sia possibile svolgere l’operazione è che l’utente abbia effettuato il login, e sia un utente gestore bagagli.
Success Guarantee - L’aereo sul quale dobbiamo imbarcare il bagaglio ha spazio in stiva.
Main Success Scenario - Il bagaglio viene aggiunto alla lista bagagli e viene stampato un messaggio di esito positivo.
Extensions/Alternative Scenarios - La stiva per quel volo ha concluso il posto relativo ai bagagli. Il peso inserito risulta avere un peso uguale a zero. Il volo sul quale vogliamo effettuare un’aggiunta di un bagaglio non è esistente.
Frequency of Occurrence - Ogni volta che abbiamo un volo in partenza.
Open Issues - Cosa accade se non siamo in grado di spedire il bagaglio con l’aereo corretto a seguito di un problema di carico eccessivo?


Scope - Ricerca ed Amministrazione per Bagaglio
Primary Actor - Utente gestore di bagagli, viene utilizzato per reperire tutte le informazione relativa ad un determinato bagaglio ed eventualmente effettuare delle modifiche su di essi.  
Preconditions - Condizione necessaria affinché sia possibile svolgere l’operazione è che l’utente abbia effettuato il login, e sia un utente gestore bagagli.
Success Guarantee - Il bagaglio deve esistere.
Main Success Scenario - Il bagaglio viene visualizzato correttamente e le operazioni di modifica vengono accettate.  
Extensions/Alternative Scenarios - Lista di scenari alternativi dove qualcos’altro succede
Frequency of Occurrence - La frequenza è relativa all’utilizzatore.

```

Caso D'uso Terreni:
```markdown

Scope -  Assegnazione di un Hangar 
Level - (da specificare)
Primary Actor - Personale addetto alla gestione dei terreni  
Preconditions – Il Terreno deve esistere e non deve essere già assegnato
Main Success Scenario - il terreno viene assegnato al nuovo affittuario
Extensions/Alternative Scenarios – Special Requirements -  il terreno è gia stato assegnato
Technology and Data Variation  List - (Da specificare)
Frequency of Occurrence – Quando necessario 
Open Issues - 

Scope - Consultazione Hangar e relative associazioni
Level - (da specificare)
Primary Actor - Personale addetto alla gestione dei terreni
Preconditions -  Devono esistere Hangar all'interno del db
Main Success Scenario - Stampa delle informazioni riguardanti i terreni e relative associazioni ad aerei esistenti nel db
Extensions/Alternative Scenarios – non sono presenti terreni all'interno del db
Special Requirements - 
Technology and Data Variation  List - (Da specificare)
Frequency of Occurrence – Quando necessario 
Open Issues - 

```

Caso D'uso schermata di accesso:
```markdown
Login.


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
