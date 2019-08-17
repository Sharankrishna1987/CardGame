# CardGame

General info:
1) Maven project
2) Slf4j + log4j2 is used for logging. Logs are logged in console and in file (cardgame.log). Log file is present within the project.
3) Mainclass to start the game: org.target.cardgame.main.CardGame
3) User will be prompted to enter the players information and 5 rounds will be played after that by distributing one card each to every player in every round.

Assumptions:
1) 5 rounds
2) 4 players
3) One card distributed to each player in every round
4) Joint winners or Single winner is decided after the 5th round
5) No more than 3 Consecutive cards of the same suit
   a) D1, D2, D3, D4 - Consecutive
   b) D1, D2, D3, D5 - Not Consecutive
   c) D1, D2, D3, A4 - Not Consecutive
6) No pattern repeating, suit wise
   a) D1, D2 - Repeating
   b) A9, A9 - Repeating
   c) S4, A4 - Not Repeating
