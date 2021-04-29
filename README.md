# spring_boot_cv_rest

Les fichiers http dans request permettent de tester les routes.

## Liste des requêtes 

- GET /authors : Affiche tous les auteurs 
- POST /authors : Ajoute un auteur
  
- GET / : Affiche le premier projet de la BDD
- POST / : Ajoute un projet

- GET /resume : Renvoie la liste des Cv au format XML
- GET /cv?id=<id> : Renvoie le Cv d'id <id> au format XML
- GET /htmlcv?id=<i> : Renvoie le Cv d'id <id> au format HTML

- POST /insert : Ajouter un Cv
- DELETE /delete?id=<id> : Supprime le Cv d'id <id>
- UPDATE /update?id=<id>
