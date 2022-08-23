# Oblig 4 –

* the big 5 (gruppe 7): *Andreas Spilde, Asif Amin, Jon Vegard Lokøy, Thorbjørn Melheim*
* Trello: https://trello.com/invite/b/xVHK3n7B/f32c7a6b17969cc65701fcfc880d2545/assignment-1
### Referat av teammøter:

#### 21.04.2022

Tilstede: Alle

Diskuterte:
- Hva funksjoner vi kunne rekke å implementere
- Fordelte oppgaver
- retteskjema for innlevering 3
- Sonarqube

Tid: 120min

#### 26.04.2022

Tilstede: Alle

Diskuterte:
- Presentasjonen

Tid: 45min


# Deloppgave 1

Jon har vært syk uken før levering, derfor har er det lite commits fra hans side.

De fleste punktene i deloppgave 1 er uendret fra [forrige innleveing](ObligatoriskOppgave3.md)

Retrospektiv:


Gjør et retrospektiv hvor dere vurderer prosjektet har gått. Hva har dere gjort bra, hva hadde dere gjort annerledes hvis dere begynte på nytt?

Mange deler av prosjektet har gått bra, vi har klart å holde ganske god kommunikasjon gjennom discord og samarbeidet godt sammen.
Under hele prosjektet har vi hatt ganske åpne roller der alle sammen har jobbet tvers med hverandre. Ting som vi hadde gjort anderledes om vi hadde begynt på nytt er å jobbe 
mer jevnere med prosjektet fra starten og ha litt bedre kommunikasjon på starten slik at det ikke ble skeivfordeling av oppgaver.  


Vi ser også at vi gjerne skulle vært flinkere til å bruke trello eller andre eksterne verktøy for å forbedre workflowen vår.
Dette hadde også gjort det lettere å fordele oppgaver mellom prosjektdeltagerne samt gjort kommunikasjon bedre.




# Deloppgave 2

Vi har fungerende multiplayer på samme maskin. Til denne innleveringen har vi også fått til en løsning slik at vi kan se spiller 2 hele tiden.
Poenget er at kameraet følger spiller 1, men med to spillere kunne vi ikke se spiller 2 dersom spiller 2 gikk utenfor kameraet. Løsningen er at spiller 2 blir teleportert til spiller 1 (dersom spiller 1 er i livet) om spiller 2 beveger seg utenfor kameraet. Også om vi spiller multiplayer og spiller 1 dør før spiller 2, så vil kameraet følge spiller 2.

# Brukerhistorier
Vi har ikke lagt til noen nye funksjoner i spillet, så derfor heller ingen nye brukerhistorier<br>
[Se ObligatoriskOppgave3.md](ObligatoriskOppgave3.md)

# Deloppgave 3: Produkt og kode

#### Utbredring av feil:
- Fjernet apptest
- Tatt i bruk Sonarqube


####Sonarqube:
Under prosjektet har vi brukt verktøyet SonarQube for å ta statiske analyser av prosjektet, 
det har vært veldig nyttig for å finne og fikse feil, sårbarheter og code smells. Uten sonarqube hadde vi ikke lagt merke til disse forskjellige
feilene, som videre kunne ha utviklet seg til større problemer. 


Før: <br>
<img src="https://i.imgur.com/YYvB7LW.png" alt="drawing" width="600"/> <br>
Etter<br>
<img src="https://i.imgur.com/q0YUaWs.png" alt="drawing" width="600"/> 

## Manuell test for flerspiller kamera nr. 1
	- Se at kamera flytter seg etter spiller 2 når spiller 1 dør
	
	1) Start programmet
	2) velg flerspiller modus
	3) flytt spiller 1 inn i pigger eller monster
	4) Se at kamera flytter seg til spiller 2 og holder seg der
	
### Forventet resultat
	- Kameraet skal flyttes til spiller 2 når spiller 1 dør
	
## Manuell test for flerspiller kamera nr. 2
	- Se at spiller to blir flyttet til spiller 1 når spiller 2 går utenfor kamera
	
	1) Start programmet
	2) velg flerspiller modus
	3) flytt spiller 2 slik at figuren havner utenfor skjermen
	4) flytt spiller en slik at spiller 2 havner utenfor skjermen

### Forventet resultat
	-  Spiller 2 skal bli "teleportert" til spiller 1 når spiller 2 ikke er synlig i kameraet

Credits:<br>
Innholdet i resources/Tiles, resources/BG.png fra https://opengameart.org/content/free-platformer-game-tileset<br>

A.png, B.png og player_jump.png laget av Asif orginal: https://old.reddit.com/r/PixelArt/comments/aebzuf/occc_32x32_character_practice_still_a_beginner/ <br>

Monster_l.png endret av Asif orginal: https://opengameart.org/content/little-mummy<br>

Tileset:<br>

https://opengameart.org/content/2d-cave-platformer-tileset-16x16<br>

Knapper:<br>
https://opengameart.org/content/free-ui-asset-pack-1

