
Page du dépôt : https://github.com/AlbanStelzle/DLL_2023/tree/main

# Objectif : retravailler la branche principale et de développement

Par mesure de sécurité vous pouvez faire des "backup"
pour retourner à l'état de certaines branches:

```shell
# Sur la branche main
git switch main
git switch -c main_backup

# Sur la branche avec la nouvelle fonctionnalité
git switch Sauvegarde-du-jeu
git switch -c Sauvegarde-du-jeu_backup
```

Les backups sont là pour vous permettre d'expérimenter
librement et de retourner à des réferences précises si besoin

# Récriture de la branche de développement

## Approche 1 (avec reset hard et cherry-pick) :

```shell
git switch Sauvegarde-du-jeu
git reset --hard 3a20a07
git cherry-pick -m 2 4cde53c7958ee62cea3e3aad95bb0fdd1071d197
git cherry-pick e7dbdd969335cbd26db2e5a227d416c6d341e54d 61573bd5af1face9d2503840f8cf1165a3b7f384 20556d35c9adc984f825e09605cc640d2689187a
```

## Approche 2 (avec reset soft et réécriture en 2 commits)

```shell
git reset --soft 3a20a07
git restore --staged AUTHORS.md
git commit -m "feat: score save and win streak"
git add AUTHORS.md
git commit -m "maint: update contributors"
```

## Approche 3 (avec rebase interactif et suppression ) :

```shell
git rebase -i 3a20a07
delete * 3 + squash + BON COURAGE
```

# Récriture de la branche principale

```shell
git reset --hard 3a20a07
git remote add ueve git@github.com:UEVE-DLL-2023-2024/DLL_2023.git
git pull ueve main
```
