# Airport Management Software
### Gruppo The Runtime Terror(Q23)
![Java](https://img.shields.io/badge/Backend-Java-orange)
![JavaFX](https://img.shields.io/badge/Frontend-JavaFX-blue)
![MySql](https://img.shields.io/badge/Database-MySQL-purple)

 <p align="left">
  <img width="300" style= alt="logo" src="https://github.com/IngSW-unipv/Progetto-Q23/blob/main/src/main/resources/com/example/testingproject/view/Logo.png">
</p>
 
## INTRODUZIONE

Il nostro Software consiste in un gestionale in grado di automatizzare e semplificare i principali task di una holding aeroportuale. Il sistema è rivolto a tutto il personale all’interno di un aeroporto dal controllore di torre agli addetti aeroportuali. Principalmente si occupa della gestione di piste, territori, voli e relativi bagagli. 




## Piste 

L’utente una volta effettuato il login come utente Torre avrà accesso alla pagina piste. La pagina piste avrà le informazioni sui voli più recenti per ogni pista e andando sulla pagina di una pista specifica si potranno vedere i voli con le informazioni varie per quella pista. Nella pagina specifica di ogni volo si possono vedere le informazioni e cancellare il volo. Nella pagina precedente, si può aggiungere un nuovo volo, dove si dovranno mettere in input le informazioni del volo. L’algoritmo calcolerà le piste e gate migliori, e l’utente dovrà scegliere cliccando su una delle opzioni per la pista (e gate associato), e quella scelta verrà poi aggiunta nel database, aggiornando tutte le liste relative ai voli in arrivo. Questa funzione può essere usata in modo simile per i voli che partono dall'aeroporto e arrivano in un altro. 



## Bagagli

L’utente per bagagli accede dalla schermata di login. L’utenza a cui è destinata questa interfaccia riguarda sia il personale addetto alle partenze (Hostess) che agli arrivi (operatore di bagagli). L’utente può vedere lo stato dei voli (orari di partenza, pista, disponibilità bagagli) e per ogni volo ha la possibilità di inserire un nuovo bagaglio. (Info/database per ogni bagaglio?)



## Account 

L’utente accede alla schermata di accesso, nella quale vi sono 3 combinazioni utente/password corrette:
Una per accedere alla schermata riguardante la gestione dei bagagli, una per accedere alla gestione dei terreni dell’aeroporto, dei parcheggi scoperti e degli hangar e una accedere all’utenza della torre di controllo (che si occupa della gestione ed organizzazione dei tempi affinché tutto sia organizzato in maniera corretta, sicura ed efficiente)
VOLI
La sezione “voli” ha come scopo quello di fornire un riepilogo dei voli in partenza e in arrivo dall'aeroporto con annesso il codice identificativo (codice che identifica univocamente un volo) la tratta con i relativi orari, la durata del viaggio e una sezione “status” che tiene conto di eventuali ritardi e indica lo stato attuale. Questa sezione è fondamentale sia per l’addetto aeroportuale che per il controllore di torre, i quali hanno necessità di essere sempre aggiornati sullo stato dei vari voli. Inoltre gli utenti possono applicare dei filtri di ricerca sul riepilogo dei voli in modo da rendere più fruibile tutto il sistema. 

## Terreni

Per quanto riguarda la sezione terreni il software permette di gestire il relativo database permettendo agli utenti di eseguire una serie di azioni , ovvero: assegnare/rimuovere l'uso di un determinato terreno(Hangar) ad un determinato veivolo, consultare la lista terreni e le varie associazioni sull'uso dei posti e monitorare le scadenze delle assegnazioni . ll sistema si occupa anche di inviare notifiche in prossimità delle scadenze.


### Tecnologie Usate
- Java JDK 19
- JavaFX 19
- MySQL 8
- Google Cloud Platform
