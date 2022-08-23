# Oblig 2 – 

* the big 5 (gruppe 7): *Andreas Spilde, Asif Amin, Jon Vegard Lokøy, Thorbjørn Melheim*

### Referat av teammøter:

#### 24.02.2022
Tilstede: Alle
Hva ble diskutert:
- Nytt tileset
- Ny karakter som hovedfigur (grønt romvesen)

Arbeidsfordeling av MVP krav:
- Andreas på 11
- Jon på 5 eller 9
- Asif på 6
- Thorbjørn på 4

Tid: ca 120min

#### 17.03.2022

Tilstede: Alle

Arbeidsfordeling: 
- Asif jobber videre med 6
- Andreas med 10
- Jon på 5
- Thorbjørn med 7 og 10

Tid: ca 120min

#### 23.03.2022

Tilstede: Andreas, Asif, Thorbjørn

Diskuterte:
- MVP krav
- Problemer
- Testing

Tid: ca 120min

#### 24.03.2022

Tilstede: Alle

Diskuterte:
- MVP krav
- Brukerhistorier, akseptansekriterier og arbeidsoppgaver knyttet til MVP krav
- Hvordan ting kan implementeres
- Arbeidsfordeling av det som gjenstår
- Når vi møtes igjen

Tid: 120-140min

# Deloppgave 1
Så langt har rollene fungert veldig bra.
For nå ser vi ingen nødvendighet for å endre/legge til flere roller.

Prosjektlederen har hovedansvaret for styringen av prosjektet, 
og skal styre det slik at vi ender opp med det beste sluttproduktet.

Tester skal teste koden, for å finne feil slik at vi kan løse opp i de raskt, slik at de
ikke blir værende i koden og muligens skaper flere problemer videre.

Utvikler skal utvikle spillet etter kravene vi setter.

Kundebehandler skal ta krav og ønsker fra kunden og passe på at produktet (spillet) passer 
kundene. Det er de som passer på å dele ønskene til kunden.

Designer skal designe spillet, enten vi snakker grafisk designer eller spill designer, 
så må de komme opp med ideer og planlegge hvordan ting skal fungere, og løse problemer som kan oppstå rundt ideer.

Vi har ikke noe særlig å nevne rundt prosjektmetodikk, vi synes dette fungere ganske bra for oss, men selvsagt 
er det nok noe vi kommer til å merke over tid at vi kanskje må endre på for å få en bedre flyt i arbeidet.
Gruppen fungerer veldig bra, har vært null problemer så langt, folk tar opp problemene de har for at vi skal 
kunne løse de i gruppen, f.eks. vi måtte snu på oppsettet av koden for å legge opp for bruk av Screen-grensesnittet i LibGdx.
Som nevnt over så er det veldig godt samarbeid og hvis noen sitter fast spør vi om hjelp og hjelper hverandre for å løse problemene.

Sånn generelt sett synes vi at vi har gjrot en ganske god jobb, men selvsagt har vi forbedringer. 
Når vi har jobbet, har vi jobbet hardt og der har vært god kommunikasjon, men vi kunne gjerne ha 
jobbet mye gjevnere og komt tidligere igang, istedet for å ta det i skippertak. I tillegg kunne vi 
kommunisert bedre i de periodene vi jobbet mindre med oppgaven.

Vi mener at folk har jobber greit, og vi tenker ikke det har vært noen skeivfordeling av oppgaver, 
selvfølgelig så har kanskje noen committ-et litt mere enn andre, men de har kanskje gjort en annen bit 
av prosjektet som veier opp for dette.

Det vi ønsker å forbedre er da altså kommunikasjonen underveis og det å jobbe jevnere med oppgaven.

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

Vi har jobbet med MVP kravene 4-11 siden forrige innlevering ble levert. Vi er helt ferdig med enkelte av de, mens andre har en del mangler som vi dessverre ikke fikk unnagjort i tide. Vi er altså ikke forbi MVP på dette tidspunktet. Vi prioriterer MVP utifra hvilke som må til for at spillet skal være gøy for brukeren og hva funksjonalitet som er mulig/lett å implementere. 

### diverse mangler
På dette tidspunktet kan vi ikke bytte fra bane 1 til bane 2 (vi har 2 baner, men bane 2 har en del mangler dvs kollisjon lag for objekter) og vi har ikke implemenert metode for å skifte bane når spiller er ferdig med første bane. Spiller kan heller ikke drepe monstre. GameMenu har knapper med samme navn, men den øverste "Start"-knappen starter singleplayer og nederste "Start"-knappen starter multiplayer.

Mangler en del brukerhistorier (for krav 8-11) disse blir skrevet for neste innlevering

### ting som fungerer (ikke fullstending liste)
- Singleplayer
- Multiplayer
- Spiller dør ved kontakt mellom fiende og pigger (blir deretter ikke tegnet på skjermen)
- Spiller kan sanke diamanter (gems), som også forsvinner når de har blitt sanket.


# Brukerhistorier
- [1. Vise et spillebrett](#brukerhistorie-1)
- [2. Vise spiller på spillebrett](#brukerhistorie-2)
- [3. Flytte spiller](#brukerhistorie-3)  
- [4. Spiller interagerer med terreng](#brukerhistorie-4)
- [5. Spiller har poeng og interagerer med poenggjenstander](#brukerhistorie-5)
- [6. Vise fiender/monstre; de skal interagere med terreng og spiller](#brukerhistorie-6)
- [7. Spiller kan dø (ved kontakt med fiender, eller ved å falle utfor skjermen)](#brukerhistorie-7)

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

Brukerhistorie 8:

Brukerhistorie 9:

Brukerhistorie 10

Brukerhistorie 11:

# Deloppgave 3: Produkt og kode

- Readme.md inneholder link til tutorial for spillet (helt øverst i filen)
- Til nå har vi en automatisk test og ingen manuelle tester
- klassediagram er å finne i deliverables mappen

Credits:<br>
Innholdet i resources/Tiles, resources/BG.png fra https://opengameart.org/content/free-platformer-game-tileset<br>
A.png laget av Asif fra gruppen vår<br>
Monster_l.png endret av Asif orginal: https://opengameart.org/content/little-mummy<br>
Tileset:<br>
https://opengameart.org/content/2d-cave-platformer-tileset-16x16<br>

Knapper:<br>
https://opengameart.org/content/free-ui-asset-pack-1
