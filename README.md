# SimpleCalculator

### projekti kirjeldus:


Antud projektis on loodud lihtne Java Spring Boot 3.1.3 rakendus, mis kahe REST teenusega võimaldab arve liita ja teha päringuid varem tehtud liitmistoimingute hulgast. 
Andmete talletamiseks on kasutatud lihtsat listi, st peale rakenduse taaskäivitamist on see tühi.  

Esimene teenus võimaldab liita kahte täisarvulist liidetavat, vahemikust 0-100 ja tagastatakse summa.
Teise teenusega on võimalik teostada ühe täisarvu põhist otsingut varasemate liidetavate või summade hulgast ning tulemus väljastatakse summa järgi kas kasvavalt või kahanevalt.

### eeldused:
* Java: vajalik versioon 17.  
* Maven: Projekti ehitamiseks ja sõltuvuste haldamiseks.

### käivitamine:
* Kloonige repositoorium.
* Navigeerige projekti kausta.
* Käivitage mvn spring-boot:run.

### API kirjeldus:

#### sisesta väärtused:  
* URL: '/operations/add'
* Meetod: '__GET__'  
*  Parameetrid:
* _first_: esimene arv (kohustuslik).
* _second_: teine arv (kohustuslik).

#### otsi arvutuste hulgast:

* URL: '/operations/search'
* Meetod: '__GET__'
* Parameetrid:
* _number_: otsitav arv (valikuline).
* _order_: sorteerimise järjekord - kui kasvav, siis sisestada  _asc_ või kahaneva puhul sisestada  _desc_.
