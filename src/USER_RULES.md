# Documentation Utilisateur du Jeu Pierre-Feuille-Ciseaux en Ligne de Commande

## Introduction

Bienvenue dans la documentation utilisateur du jeu Pierre-Feuille-Ciseaux en ligne de commande. Ce jeu simple mais amusant vous permet de jouer contre un adversaire virtuel (le bot) en utilisant les signes classiques de Pierre, Feuille et Ciseaux, ainsi que deux signes additionnels, Lezard et Spock, pour un défi encore plus passionnant.

## Table des Matières

1. **Configuration du Jeu**
   - 1.1 Installation

2. **Comment Jouer**
   - 2.1 Démarrer le Jeu
   - 2.2 Choisir un Nom de Joueur
   - 2.3 Sélection du Mode de Jeu
   - 2.4 Nombre de Manches
   - 2.5 Sélection des Signes

3. **Déroulement du Jeu**
   - 3.1 Affichage des Signes
   - 3.2 Résultat de la Manche
   - 3.3 Score
   - 3.4 Fin du Jeu

4. **Options de Rejeu**
   - 4.1 Rejouer
   - 4.2 Quitter

## 1. Configuration du Jeu

### 1.1 Installation

Pour jouer à ce jeu, aucune installation n'est nécessaire. Vous pouvez l'exécuter directement depuis votre ligne de commande. Assurez-vous d'avoir Java installé sur votre système.

Vous pouvez compiler le projet :

```
javac -d bin/ -sourcepath src/ -classpath src/Bot.java src/Controller.java src/Player.java src/RPS.java
```

Puis le lance :

```
# pour windows
java -classpath "./bin/;res/" RPS

# pour linux
java -classpath "./bin/:res/" RPS
```

## 2. Comment Jouer

### 2.1 Démarrer le Jeu

Pour démarrer le jeu, ouvrez votre ligne de commande et exécutez le programme. Suivez les indications pour configurer le jeu.

### 2.2 Choisir un Nom de Joueur

Lorsque le jeu démarre, il vous demandera de saisir votre nom de joueur. Assurez-vous de choisir un nom de joueur de 20 caractères maximum.

### 2.3 Sélection du Mode de Jeu

Le jeu offre deux modes de jeu : Classique (Pierre-Feuille-Ciseaux) et BBT (Pierre-Feuille-Ciseaux-Lezard-Spock). Sélectionnez le mode de jeu en tapant 'C' pour le mode classique ou 'B' pour le mode étendu.

### 2.4 Nombre de Manches

Indiquez combien de manches vous souhaitez jouer. Le jeu continuera jusqu'à ce que l'un des joueurs atteigne ce nombre de manches gagnées.

### 2.5 Sélection des Signes

Lorsqu'on vous y invite, choisissez l'un des signes disponibles en entrant la première lettre du signe. Par exemple, pour choisir la Pierre, entrez 'P'. Suivez les mêmes étapes pour chaque manche.

## 3. Déroulement du Jeu

### 3.1 Affichage des Signes

Après avoir sélectionné votre signe, le jeu affichera votre choix ainsi que le signe choisi par le bot.

### 3.2 Résultat de la Manche

Le jeu déterminera le résultat de la manche en fonction des règles classiques de Pierre-Feuille-Ciseaux (ou des règles étendues si vous jouez en mode BBT). Le résultat sera affiché à l'écran.

### 3.3 Score

Le score actuel sera affiché après chaque manche. Vous verrez combien de manches vous avez gagnées et combien le bot a gagnées.

### 3.4 Fin du Jeu

Le jeu se poursuivra jusqu'à ce qu'un joueur atteigne le nombre de manches gagnées que vous avez défini. Le jeu se terminera, et le gagnant sera annoncé.

## 4. Options de Rejeu

### 4.1 Rejouer

Après la fin d'une partie, le jeu vous demandera si vous souhaitez rejouer. Si vous répondez 'O' (oui), une nouvelle partie commencera avec les mêmes paramètres que précédemment. Si vous répondez 'N' (non) la partie s'arrete.

### 4.2 Quitter

Si vous décidez de quitter le jeu, le programme se terminera.

Profitez du jeu et amusez-vous bien ! Si vous avez des questions ou des problèmes, n'hésitez pas à le remonter.
