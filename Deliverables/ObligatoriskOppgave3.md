# Oblig 3 – 

* the big 5 (gruppe 7): *Andreas Spilde, Asif Amin, Jon Vegard Lokøy, Thorbjørn Melheim*
* Trello: https://trello.com/invite/b/xVHK3n7B/f32c7a6b17969cc65701fcfc880d2545/assignment-1
### Referat av teammøter:

#### 30.03.2022

Tilstede: Alle

Diskuterte:
- Samarbeidet generelt.
- Kommunikasjon
- Hva vi kan forbedre til neste innlevering.

Tid: 30min

#### 31.03.2022

Tilstede: Alle

Diskuterte:
- Tester
- Kodekvalitet (fokus på å rette opp i duplisering av kode)
- MVP 8-11
- Bruke trello mer. 

Tid: 120min

# Deloppgave 1
 

Ettersom vi var i et senere steg i prosjektprossesen valgte vi å ha åpne roller. Thorbjørn tok mest initiativ og ble dermed en naturlig leder for prosjektet.<br>
Vi jobbet alle som utviklere og delte problemene opp slik at alle fikk noe å jobbe med. 


<br>

Vi har diskutert hvordan vi skal jobbe mer jevnt, stille spørsmål til hverandre om det er noe vi lurer på, samt å
ikke gjøre alt sammen dagen før innleveringsfristen. Alle sammen til nå har vært gode på å kommunisere med hverandre slik at det blir bedre flyt i arbeidet.
Noe vi kan bli bedre på er å holde system med hva alle sammen gjør, slik at det kan bli enda bedre fly i arbeidet vårt,  men ettersom at vi nærmer
oss mål er det ikke så mange oppgaver å fordele rundt til teamet.


Alle sammen i teamet har gjort ganske god jobb,
men vi kan alltid forbedre oss med å jobbe mer jevnere med prosjektet.
Når vi har jobbet sammen har det vært veldig god kommunikasjon rundt ideer for
spillet og hvordan vi skal utføre forskjellige oppgaver, men skulle ha hatt bedre kommunikasjon rundt perioder vi ikke har jobbet så mye med oppgaven.


Vi mener at folk jobber ganske bra, men kan være noen tilfeller der det blir skeivfordeling
av oppgaver, noen har noen flere comitts enn andre, men de har kanskje gjort noen andre
arbeidsoppgaver for prosjektet.

* Gjør et kort retrospektiv hvor dere vurderer hva dere har klart til nå, og hva som kan forbedres. Dette skal handle om prosjektstruktur, ikke kode. Dere kan selvsagt diskutere kode, men dette handler ikke om feilretting, men om hvordan man jobber og kommuniserer.

Mange deler av prosjektet gikk ganske fint, ettersom at vi hadde tildelt rollene ganske åpent til hverandre, har vi tatt i bruk av verktøyet Trello,
der har vi mer oversikt over hvem som jobber på hva.
Andre ting som kan forbedres er å jobbe mer jevnere med prosjektet, slik at ikke alt sammen blir gjort dagen før innlevering,
å implementere nye ting, til neste gang skal vi sette av mer tid for å implementere ny kode.

Alle sammen har gjort oppgaver som de har blitt tildelt, men kan hende at noen ganger at det kan bli skeivfordeling og at noen jobber litt mer jevnere med prosjektet enn andre.
Jon Vegard Lokøy har ved et uhell fire forskjellige brukere og da kan det se ut som at han ikke comitter så mange comitts.
  


  
* Bli enige om maks tre forbedringspunkter fra retrospektivet, som skal følges opp under neste sprint.
    Bedre kommnikasjon 
    Jobbe mer jevnt 
    ta i bruk trello mer 


1. Vise et spillebrett
2. Vise spiller på spillebrett
3. Flytte spiller (vha taster e.l.)
4. Spiller interagerer med terreng
5. Spiller har poeng og interagerer med poenggjenstander
6. Vise fiender/monstre; de skal interagere med terreng og spiller
7. Spiller kan dø (ved kontakt med fiender, eller ved å falle utfor skjermen)
8. Mål for spillbrett (enten et sted, en mengde poeng, drepe alle fiender e.l.)
9. Nytt spillbrett når forrige er ferdig
10. Start-skjerm ved oppstart / game over
11. Støtte flere spillere (enten på samme maskin eller over nettverk)


# Deloppgave 2

## MVP & annet

* Siden sist gang har gjort oss ferdig med MVP 8-11 og skrevet brukerhistorier, akseptansekriterier og arbeidsoppgaver for hver av dem. Det er nå mulig å gå videre til spillbrett 2 når vi er ferdige med spillbrett 1. Og når spiller er ferdig med spillbrett 2, havner vi tilbake til spillmenyen. Vi har også løst en bug vi hadde med spillmenyen tidligere (vi manglet viewport til spillmenyen). 

* Vi prioriterer ny funksjonalitet utifra hva som kan gjøre spillet mer attraktivt for brukerne og hva som er mulig å implementere gitt fristen vi har.

* Fremover ønsker vi å bli ferdig med tester, utbedre kodekvalitet og muligens få til SplitScreen eller lignende for multiplayer. Fordi vi mener dette gjøre spillet bedre for brukerne, lettere å teste og utvide spillet. 

* Vi har holdt oss til kravene som er med i MVP.

* Bugs: Kontakt mellom spiller og enkelte andre spillobjekter kan gi spilleren ekstra boost ved hopp (dette skjer ikke ofte, men kan skje). 

### diverse mangler

* Splitscreen eller delt kamera for multiplayer.


# Brukerhistorier
- [1. Vise et spillebrett](#brukerhistorie-1)
- [2. Vise spiller på spillebrett](#brukerhistorie-2)
- [3. Flytte spiller](#brukerhistorie-3)  
- [4. Spiller interagerer med terreng](#brukerhistorie-4)
- [5. Spiller har poeng og interagerer med poenggjenstander](#brukerhistorie-5)
- [6. Vise fiender/monstre; de skal interagere med terreng og spiller](#brukerhistorie-6)
- [7. Spiller kan dø (ved kontakt med fiender, eller ved å falle utfor skjermen)](#brukerhistorie-7)
- [8 Mål for spillbrett (enten et sted, en mengde poeng, drepe alle fiender e.l.)](#brukerhistorie-8)
- [9 Nytt spillbrett når forrige er ferdig](#brukerhistorie-9)
- [10 Start-skjerm ved oppstart / game over](#brukerhistorie-10)
- [11 Støtte flere spillere (enten på samme maskin eller over nettverk)](#brukerhistorie-11)

### Brukerhistorie 1 Vise et spillebrett(<a name="brukerhistorie-1"></a>:

- Som en spiller ønsker jeg en visuell representasjon av spillbrettet slik at jeg kan bevege meg rundt i spillet

  #### Akseptansekrav
  * Når programmet startes skal den vise et vindu med grafikk av spillbrettet

  #### arbeidsoppgaver
  - finne tiles til spillbrettet
  - lage et spillbrett med forskjellige  layers
  
---

### Brukerhistorie 2 Vise spiller på spillebrett <a name="brukerhistorie-2"></a> :

- Som en spiller ønsker jeg en  unik spiller på spillbrettet slik at kan se spilleren på spillbrettet 

  #### Akseptansekrav
  * spilleren skal se unik ut
  * Ha spilleren på riktig layer
  * Alle sammen skal se spilleren på spillbrettet 


#### arbeidsoppgaver
  - Lage spiller figur
---

### Brukerhistorie 3 Flytte spiller <a name="brukerhistorie-3"></a>:

- Som en spiller ønsker jeg å bevege meg rundt spillet slik at jeg kan gå rundt spillbrettet

  #### Akseptansekrav
  * Når man trykker på en piltast skal spilleren bevege seg rundt på spillbrettet
  * Skal kunne bevege seg rundt x-aksen og y-asken 

  #### arbeidsoppgaver
  - Strying av spiller ved hjelp av piltastene

---


### Brukerhistorie 4 spiller interagerer med terreng <a name="brukerhistorie-4"></a>
- Som spiller ønsker jeg å interagere med terrenget fordi da blir jeg mer engasjert i spillet og har det kjekkere. 

#### akseptansekriterier:
- Spiller går ikke gjennom bakken
- Spiller kan hoppe og gravitasjonskraften vil trekke spiller ned
- Spiller faller nedover om ikke spiller har solid underlag under seg

#### arbeidsoppgaver 
- Legg kollisjon rundt de objektene i Tiled som vi ønsker spiller skal interagere med.
- Ta i bruk Box2d biblioteket for gravitasjon, ContactListeners, World.. etc
- Les inn kollisjons-objektene fra Tiled og bruk Box2d til å lage objekter av de og så legg de til World.
---
### Brukerhistorie 5 spiller har poeng og interagerer med poenggjenstander <a name="brukerhistorie-5"></a>

- Som en spiller, Ønsker jeg å kunne samle poeng, Slik at jeg får gleden av å samle ting og gi mestringsfølelse.

  #### Akseptansekrav
  * Kontakt mellom spiller og juveler skal gi poeng
  * Juvelene skal forsvinne når de er tatt

  ### arbeidsoppgaver
  * Lage kollisjon på juvelene
  * Sjekke for kollisjon mellom spiller og juvelene
  * Fjerne juvelene fra spillet
  * Gi spiller poeng

---

### Brukerhistorie 6 Vise monstre de skal interagere med terreng og spiller <a name="brukerhistorie-6">:

- Som et monster ønsker jeg å kunne bevege seg mellom to x-asker punkter, slik at jeg får forskjellige utfordringer fra monsteret.

  #### Akseptansekrav
  * Monsteret skal være på brettet
  * Kun Monsteret skal se collision-punktene sine
  * Monsteret skal bevege motsatt retning når den treffer punktene

  ### arbeidsoppgaver
  - Lage figur for monsteret
  - Lage collision layer for monsteret
  - Stryingen av monsteret skal skje ved kontakt av collision layeret
  
---

### Brukerhistorie 7 spiller interagerer med terreng <a name="brukerhistorie-7"></a>
- Som spiller synes jeg at spiller blir mer utfordrende/interessant om karakteren kan dø ved kontakt med fiende eller andre elementer i spillet.

#### akseptansekriterier:
- Ved kontakt med fiende skal spiller dø
- Ved kontakt med pigger(Spike) skal spiller dø
- Om spiller faller fra stor høyde skal spiller dø

#### arbeidsoppgaver 
- Lag klassen Spikes
- Lag Spike i Tiled, legg kollisjon rundt Spike. 
- Les de inn i programmet og legg de til i World
- Lag sjekker for Spike og fiende i WorldContactListener

### Brukerhistorie 8 Mål for spillbrett (enten et sted, en mengde poeng, drepe alle fiender e.l.) <a name="brukerhistorie-8"></a>

- Som spiller ønsker jeg at det skal et klart mål med spillet, noe som muligens er litt utfordrende slik at jeg blir engasjert og ønsker å spille spillet.

#### Akseptansekriterier:
- Spiller skal kunne samle Gems
- Gems skal være spredt utover spillbrettet, gjerne på steder hvor de er vanskelig å få tak i dem.
- Gems skal forsvinne fra spillet når det har blitt samlet inn (både grafisk og box2d body).

## Arbeidsoppgaver
- Plasser Gems på spillbrettet med Tiled. 
- Gi gems box2d body.
- Fjern grafikken til Gems og box2d body når de har blitt plukket opp. 

### Brukerhistorie 9 Nytt spillbrett når forrige er ferdig <a name="brukerhistorie-9"></a>

Som spiller, ønsker jeg å kunne fortsette med ett nytt spillbrett når målet for forrige spillbrettet er oppnådd. Slik at jeg ikke kjeder meg.

#### Akseptansekriterier:
-Når målet med spillbrettet er oppnådd og spilleren(e) er borti flagget skal spilleren starte med det nye spillbrettet. (diamantene er plukket). 
-Er spilleren(e) borti flagget uten å ha nok diamanter skal ikke spilleren(e) gå videre til neste brett.
-Det holder at en av spillerene er borti flagget.  
-Hvis spilleren(e) har vært borti flagget tidligere uten å ha nok diamanter, må likevel en av spillerne tilbake til flagget for å gå videre. 
 

## Arbeidsoppgaver
-Lag et nytt spillbrett i tiled.
-Implementer sjekk for «winning-condition» I GameScreen.
-Legg på kollisjon og fixture på flagget.
-Implementer metoder i WorldContactListener for å sjekke når spilleren(e) er på/av flagget. 



### Brukerhistorie 10 Start-skjerm ved oppstart / game over <a name="brukerhistorie-10"></a>

Som spiller vil jeg kunne starte spillet fra en meny, slik at jeg kan velge hvilken mode jeg vil spille i.<br>

### Akseptansekriterier:
-Når programmet kjøres, kommer det opp en main menu.<br>
-Menyen har knapper som gjør at man kan starte spillet<br>
-Evt ekstra modes skal ligge tilgjengelig i knapp<br>

## Arbeidsoppgaver
 -Lage knapper som kan brukes til main menu.<br>
 -Designe menyen.<br>
 -Lage knapper som starter spillet.<br>  
 -Legge menyen som første screen.<br>
 -Vise menyen igjen når ønskelig i spillet.<br> 
 -Fjerne spillbrettet fra skjermen.<br>
 
### Brukerhistorie 11 Støtte flere spillere (enten på samme maskin eller over nettverk) <a name="brukerhistorie-11"></a>

Som bruker vil jeg kunne spille med en venn.<br>

### Akseptansekriterer:
 -Mulighet for å velge flerspiller modus.<br>
 -To spillere vises på skjermen og kan interagere med brettet.<br>
 -Spillet skal virke på samme måte for to spillere som for en spiller(i.e. man samler gems og finner målposten).<br>

## Arbeidsoppgave
 -Legge inn en ekstra spiller og ekstra spawn punkt. <br>
 -Legge inn mulighet for å kunne registrerer innput fra en spiller 2.<br>
 -Endre end game funksjonaliteten slik at en spiller kan spille videre om en annen dør.<br>
 
# Deloppgave 3: Produkt og kode

- Readme.md inneholder link til tutorial for spillet (helt øverst i filen)
- Til nå har vi en automatisk test og ingen manuelle tester
- klassediagram er å finne i deliverables mappen


# Manuelle tester

## Manuel test for brukerhistorie 1
    -Se at spillbrett vises når man kjører spillet
    1) Start programmet
    2) Trykk første startknapp
### Forventet resultat
    -Spillet skal starte og spillbrettet skal komme opp i skjermen
  
## Manuel test for brukerhistorie 2
    -Se at spillfiguren vises når man kjører spillet
    1) Start programmet
    2) Trykk første startknapp
### Forventet resultat
    -Spiller skal vises midt på skjermen
 
## Manuiel test for brukerhistorie 2 for 2 spillere
    -Se at begge spillfigurenee vises når man kjører spillet i flerspillermodus
    1) Start programmet
    2) Trykk på andre startknappen
### Forventet resultat
    - To spillfigurer skal vises på skjermen

## Manuell test for brukerhistorie 3
    -Få spilleren til å bevege seg ved bruk av piltastene

    1) Start programmet
    2) Velg Singleplayer
    3) Trykk på venstre og høyre piltast for å se at spilleren beveger seg
    4) Trykk piltast-opp for å se at spilleren hopper
### Forventet resultat
    - Spiler beveger seg sidelengs og hopper

## Manuell test for brukerhistorie 3 for 2 spillere
    -Få spillerene til å bevege seg ved bruk av piltastene og wad

    1) Start programmet
    2) Velg Multiplayer
    3) Trykk på venstre og høyre piltast for å se at spiller 1 beveger seg venstre og høyre
    4) Trykk piltast-opp for å se at spiller 1 hopper
    5) Trykk på a og d for å se at spiller 2 beveger seg til venstre og høyre
    6) Trykk w for å se at spiller 2 hopper
### Forventet resultat
    - Spiller 1 og spiller 2 beveger seg sidelengs og hopper

## Manuell test for brukerhistorie 4
    -Sjekke at spilleren interagerer med terreng

	  1) Start programmet
	  2) Velg enten Singleplayer eller Multiplayer
	  3) Beveg spiller(ne) rundt på brettet og se at de kan stå på bakken og ikke faller igjennom
	  4) Hopp og se at spiller faller ned på bakken igjen
     5) Gå av en kant og se at spiller faller ned mot bakken
### Forventet resultat
    - Spiller faller ikke igjennom brettet
    - Spiller faller ned mot bakken når de er i luften

## Manuell test for brukerhistorie 5
	- Se at spiller kan samle juvelene
	
	1) Start programmet
	2) Velg enten Singleplayer eller Multiplayer
	3) Beveg karakteren bort til en juvel, til det blir kontakt
### Forventet resultat
	- Juvelen skal forsvinne fra brettet når spiller har samlet de
	
## Manuell test for brukerhistorie 6
	- Se at fienden beveger seg i et fast område og interagerer med terreng
	
	1) Start programmet
	2) Velg enten Singleplayer eller Multiplayer
	3) Beveg karakteren bort mot fienden (høyre fra start) slik at den kommer på skjermen
	4) Se at den oppfører seg som den skal
### Forventet resultat
	- Fienden beveger seg frem og tilbake i et fast område, og den faller ikke igjennom bakken

## Manuell test for brukerhistorie 7
	- Se at spiller dør ved kontakt av pigger og fiender
	
	1) Start programmet
	2) Velg enten Singleplayer eller Multiplayer
	3) Beveg spiller mot en av piggene og se at spiller forsvinner ved kontakt
	4) Gjenta steg 1. og 2. og beveg spiller mot en fiende og se at spiller forsvinner ved kontakt
### Forventet resultat
	- Spiller dør og forsvinner fra skjermen ved kontakt med fiende/pigger og man begynner forfra igjen
	
## Manuell test for brukerhistorie 8 og 9 (de passer greit som en felles test)
	- Se at man kan fullføre brettet
	
	1) Start programmet
	2) Velg enten Singleplayer eller Multiplayer
	3) Beveg spiller rundt på brettet og samle alle juvelene, mens du unngår fiender/pigger
	4) Når du har samlet alle juvelene, gå til slutt punktet (skiltet)
### Forventet resultat
	- Brettet blir fullført og du laster inn neste brett

## Manuell test for brukerhistorie 10 og 11 (igjen fungerer disse testene godt ilag da de sjekker ganske lik logikk)
	- Se at vi har en fungerende start-skjerm
	
	1) Start programmet
	2) Velg enten Singleplayer eller Multiplayer
	3) Se at spillet lastes inn i den versjonen av singe-/multiplayer du valgte
	4) Gjenta for den av de to du ikke valgte i steg 2.
	5) Start så programmet på nytt igjen
	6) Trykk denne gangen på exit, og se at programmet stenger seg
### Forventet resultat
	- Singleplayer og Multiplayer skal laste inn spillet i den versjonen du valgte
	- Exit skal stenge ned programmet

Credits:<br>
Innholdet i resources/Tiles, resources/BG.png fra https://opengameart.org/content/free-platformer-game-tileset<br>
A.png laget av Asif fra gruppen vår<br>
Monster_l.png endret av Asif orginal: https://opengameart.org/content/little-mummy<br>
Tileset:<br>
https://opengameart.org/content/2d-cave-platformer-tileset-16x16<br>

Knapper:<br>
https://opengameart.org/content/free-ui-asset-pack-1

