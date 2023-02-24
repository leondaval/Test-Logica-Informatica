# TEST LOGICA INFORMATICA

## Descrizione

Questo software implementa 2 metodi get e 2 metodi post. E' possibile inserire l'anagrafica di un utente sia su di un DB, sia su di un file .txt tramite i metodi POST.
E' possibile visualizzare l'anagrafica di un utente sia leggendo da un DB, sia leggendo da un file .txt tramite i metodi GET.

Lo script MySQL per inserire la tabella anagrafica sul DB e' il seguente: 

CREATE TABLE anagrafica (
id int NOT NULL AUTO_INCREMENT,
nome varchar(255) NOT NULL,
cognome varchar(255) NOT NULL,
telefono varchar(255) NOT NULL,
email varchar(255) NOT NULL,
paese varchar(255) NOT NULL,
cf varchar(255) NOT NULL,
indirizzo varchar(255) NOT NULL,
PRIMARY KEY (id));
