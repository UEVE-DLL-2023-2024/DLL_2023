# DLL_2023

Projet utilisé pour pratiquer la contribution à un logiciel libre / open source

# Participation à un projet libre

## Pierre Feuille Ciseaux en Java

Ce projet est libre et implémente le jeu du pierre feuille ciseaux.

### Utilisation

Vous pouvez compiler le projet :

```
javac -d bin/ -sourcepath src/ -classpath src/Bot.java src/Controller.java src/Player.java src/RPS.java
```

Puis le lance :

```
java -classpath ./bin/ RPS
```

### Perspectives

- Tableau de score:
Il serait bien qu'au couss de la partie, ou à la fin de celle-ci, un tableau
des scores soit affiché.

- Fin de partie:
Il pourrait être intéressant de demander à l'utilisateur un nombre de manches à
remporter pour gagner le jeu.

- The big bang theory (Pierre - Feuille - Ciseaux - Lezard - Spock)
Jouer au jeu Pierre - Feuille - Ciseaux - Lezard - Spock. Rappel des regles :
  - La pierre bat le lezard et les ciseaux
  - Le papier bat la pierre et Spock
  - Les ciseaux battent le papier et le lezard
  - Le lezard bat Spock et le papier
  - Spock bat les ciseaux et la pierre

