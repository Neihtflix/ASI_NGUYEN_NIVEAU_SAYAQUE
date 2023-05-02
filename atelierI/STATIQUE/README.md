## ATELIER 1

<br>

**Production WEB STATIQUE**

Pour créer un formulaire de saisie d'information pour la création d'une nouvelle carte, nous avons utilisé le HTML pour le front-end et Javascript, AJAX pour le back-end. Les données du formulaire ont été envoyées au Web Service existant via une requête AJAX.

En ce qui concerne la page d'affichage d'une carte, nous avons utilisé le Javascript pour faire une autre requête AJAX au Web Service afin de récupérer les informations de la carte et les afficher sur une page HTML.

<br>

**Production WEB DYNAMIQUE**

Pour réaliser le même formulaire en Web Dynamique, nous avons utilisé Springboot et Thymeleaf. Thymeleaf a été utilisé pour créer la vue (le formulaire HTML), tandis que Springboot a été utilisé pour le contrôleur et le modèle.

De même, pour l'affichage d'une carte, Thymeleaf a été utilisé pour créer la vue. Springboot a été utilisé pour le contrôleur et le modèle, en simulant les données de la carte dans le programme.

<br>

**Respect du pattern MVC**

Dans les deux approches, le pattern Modèle-Vue-Contrôleur (MVC) a été respecté. Dans le cas de l'approche Web Statique + Web Service, la page HTML est la Vue, le Web Service joue le rôle du Modèle, et Javascript sert de Contrôleur. Dans l'approche Web Dynamique, Thymeleaf est utilisé pour la Vue, Springboot pour le Contrôleur, et les données simulées dans le programme sont le Modèle.

