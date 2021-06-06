# Les Amis de l'escalade

Projet #6 du parcours "Développeur d'Application - Java"

### Réalisé avec:

* Apache Maven
* Spring (Context, Web MVC)
* Twitter Bootstrap
* Servlet API
* Hibernate
* JSP API
* JSTL

## Prise en main

Ces instructions vont vous permettre de télécharger une copie des fichiers sources et les exécuter sur votre machine locale.

### Prérequis

[Java](https://www.oracle.com/java/technologies/javase/jdk12-archive-downloads.html) - JDK 12.0.1 ou plus

[Apache Maven](https://maven.apache.org/download.cgi)

[Apache Tomcat](https://tomcat.apache.org/download-90.cgi) -  9.0.x

[MySQL](https://downloads.mysql.com/archives/community/) - 5.6.15 ou plus


### Import
#### Projet
Afin d'importer l'ensemble des fichiers sources depuis le répertoire Github, vous pouvez:

- Télécharger l'archive zip via Github et la décompresser

- Ou ouvrir un terminal de commande et clonez le répertoire en local:

```
git clone https://github.com/Hogwai/les-amis-de-l-escalade.git
```
#### Base de données
Exécutez les fichiers sql suivants sur votre serveur MySQL pour mettre en place la base de données:
- `lesamisdelescalade/sql/mpc_oc_escalade.sql` : modèle physique de données
- `lesamisdelescalade/sql/insert_bdd.sql` : jeu de données


### Installation

#### Configuration

Ouvrez le ficher `lesamisdelescalade/src/main/resources/META-INF/persistence.xml` et modifiez les propriétés suivantes en fonction des paramètres de votre serveur MySQL:

`hibernate.connection.url`: URL de votre serveur MySQL

`hibernate.connection.username`: pseudo de votre serveur MySQL

`hibernate.connection.password`: mot de passe de votre serveur MySQL


#### Déploiement
Vous pouvez déployer le projet via votre environnement de développement.

Ou vous pouvez le faire en ligne de commande:

Positionnez-vous à la racine du projet et commencez par télécharger les dépendances requises:
```
$ mvn clean install
```
Générez le war:
```
$ mvn package
```
Déplacez le war précédemment dans le répertoire tomcat `webapps`:

../tomcat/apache-tomcat-9.0.XX/webapps


Rendez-vous dans le dossier `bin` et lancez votre serveur tomcat:

Shell:
```
$ sh startup.sh
```

Batch:
```
> startup.bat
```

Le site sera alors accessible à cette adresse [http://localhost:8080/lesamisdelescalade/](http://localhost:8080/lesamisdelescalade/)


## JavaDoc
La JavaDoc est accessible via le lien suivant: [Documentation](https://hogwai.github.io/les-amis-de-l-escalade/doc/)

## Auteur

* **Lilian Wernert** - Hogwai

## Licence

Voir [LICENSE.md](LICENSE.md) pour plus de détails.