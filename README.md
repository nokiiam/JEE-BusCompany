## Objectif:

Réaliser une application de gestion pour une société de Transport en Commun.

## Sujet:
Nous souhaitons pouvoir, depuis un site web, gérer notre entreprise de transport en commun.

Pour cela, il est nécessaire de :
* Gérer notre flotte de bus :
  * Un bus est un véhicule caractérisé par :
  * Immatriculation du BUS (Reference Métier Unique de type : AA-123-AA)
  * Marque du BUS (Iveco, Heuliez, EvoBus, DAF, Volvo)
  * Capacité de voyageur (20 – 80)
  * Année de mise en circulation
  * Nombre de kilomètre parcourus


* Gérer notre flotte de conducteur :
  * Un conducteur est caractérisé par : 
  * Code Employé (Reference Métier Unique de type : Max 4 Premières lettres du NOM + 2 Premières lettres du PRENOM)
  * Date de naissance (Min 1990, Max [Annee_courante] – 18)
  * Nom (Min 2 caractères)
  * Prénom (Min 2 caractères)
  * Statut (En activité, En Repos Quotidien, En Repos Hebdomadaire)


* Gérer nos arrêts de bus desservis 
  * Un arrêt de bus est caractérisé par :
  * Nom (Reference Métier Unique)


* Gérer nos de lignes de bus :
  * Une ligne de bus est caractérisé par :
  * Une liste ordonnée d’arrêt


* Gérer le planning d’affectation conducteur -> Bus -> Lignes de transport : 
  * Un créneau dans un planning est caractérisé par :
  * Une Date (YYYY/MM/DD)
  * Une plage horaire (Matin : 6h – 15h / Soir 15h – 00h)
  * La référence du conducteur affecté
  * La référence du bus affecté
  * La ligne de bus


* Gérer les Users et Profils qui se connectent à mon application :
  * Login
  * MDP
  * Code Conducteur (valué si Conducteur – null si Administrateur)
  * Profil : 
    * Conducteur : Consultation de mon planning.
    * Administrateur : Consultation et Modification des différentes informations des bus, conducteurs, arrêts, lignes, plannings…


## Informations complémentaires :
* Un arrêt de bus peut être desservis par plusieurs lignes ;
* Un Conducteur doit 4 jours d’affilés et doit ensuite bénéficier de 2 jours de repos ;
* Un Utilisateur peut être soit Conducteur, soit Administrateur, soit les deux ;
* Il ne doit pas être possible d’affecter un Conducteur/Bus sur deux lignes au même moment.


## Contraintes de réalisation:
* Vous devez réaliser le projet en utilisant Java 11+, et JEE7+, sur une base de données MySQL, aucune autre technologie n'est autorisée sauf accord spécifique.
* Vous porterez une attention particulière aux aspects liés à lisibilité du code (clean code, commentaires...). Dans le doute, posez des questions. Étant donnée la dimension normative de la plateforme JEE, ces aspects seront examinés avec une attention particulière lors de l'évaluation.
* En relation avec le point précédent, développez de manière cohérente.


## Idées de Bonus:
* Automate qui envoie en REST la position des BUS en activité à chaque Arrêt (Cas simple, toutes les 30 secondes – Get la liste des bus en activité sur la plage courante), visualiser l’information sur IHM avec refresh auto (NB : Envoyer le nombre de kilomètres parcourus entre chaque arrêt – Cas simple : Random 1-3).
* Gestion des abonnements : Exposer un WS Rest qui permet de valider ou non la monté d’un usager dans le Bus. (Ajouter la gestion des usagers et leur abonnement dans l’interface d’Admin).
