# SimpleCalculator

### projekti kirjeldus


Antud projektis on loodud lihtne Java Spring Boot 3.1.3 rakendus, mis kahe REST teenusega võimaldab arve liita ja teha päringuid varem tehtud liitmistoimingute hulgast. 
Andmete talletamiseks on kasutatud lihtsat listi, mis peale rakenduse taaskäivitamist on tühi.  

Esimene teenus võimaldab liita kahte täisarvulist liidetavat, vahemikust 0-100 ja tagastab summa.
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
* Meetod: 'GET'  
*  Parameetrid:
* first: Esimene arv (kohustuslik).
* second: Teine arv (kohustuslik).

#### otsi arvutuste hulgast:

* URL: '/operations/search'
* Meetod: 'GET'
* Parameetrid:
* number: Otsitav arv (valikuline).
* order: Sorteerimise järjekord - kas asc või desc.
