# Les directives Structurelles ngIf et ngFor
Les directives sont des instructions intégrées dans le DOM* utililsées dans la conception d'application Angular. Quand Angular lit un template et rencontre une directive qu'il reconnait, il suit les instructions correspondantes<br/>
Les directives structurelles, comme leur nom l'indique, modifient la structure du document.<br/>

## *ngIf

Un component auquel on ajoute la directive  *ngIf="condition"  ne s'affichera que si la condition est "true", comme un statement  if  classique.

```html
<a *ngIf="this.userService.isLoggedIn()" 
class="btn btn-danger" (click)="onDel(article.id)">Delete</a>
```
Extrait de code tiré de article-list.component.html<br/>
Dans cet exemple, le *ngIf nous permet de ne faire apparaitre les boutons permettant de publier, modifier et supprimer un article, seulement si l'utilisateur est connecté.<br/>

```html
<div class="card mb-3" *ngIf="selectedEvent && !formVisible">
  <h4 class="card-header bg-info">Détails</h4>
  <img src={{selectedEvent.imageUrl}} class="card-img-top">
  <div class="card-body">
    <h5 class="card-title">{{selectedEvent.nom}}</h5>
    <p class="card-text">Date : {{selectedEvent.date | date: 'shortDate'}}</p>
    <p class="card-text">{{selectedEvent.type}}</p>
    <p class="card-text">Description : {{selectedEvent.description}}</p>
    <p class="card-text"><small class="text-muted">Lieu : {{selectedEvent.lieu}}</small></p>
    <a class="btn btn-danger text-white" (click)="onDel(selectedEvent.id)">Supprimer l'événement</a>
    <button type="button" class="btn btn-success" (click)="devientForm()">Modifier l'événement</button>
    <a routerLink="/evenements" class="btn btn-info" (click)="goBack()">Retour à la liste</a>
  </div>
</div>
```
Autre exemple tiré de evenement-list.component.html<br/>
Dans cet extrait, le *ngIf permet d'afficher les détails d'un événement sélectionné dans la liste au dessus : "selectedEvent". Et à la condition que l'utilisateur n'ait pas cliqué sur le bouton "Modifier l'évenement" qui fera apparaitre le formulaire de modification : c'est le : "&& !formVisible".

## *ngFor

Lorsque l'on ajoute la directive  *ngFor="let obj of myArray"  à un component, Angular itérera l'array  "myArray"  et affichera un component par objet  "obj" .<br/>

```html
  <div *ngFor="let rbService of rbServices" class="card mb-3" id="affiche" style="width: 18rem;">
    <img src="{{rbService.image_url}}" class="card-img-top">
    <div class="card-body">
      <h5 class="card-title">{{rbService.nom | uppercase}}</h5>

{...}

  </div>
  ```
  Exemple de code tiré de rb-service-menu.component.html<br/>
  Ce code nous permet d'afficher la liste des services présents dans la base de données, et de les afficher dans des cards. 

  # Formulaire angular

En Angular, il y a deux grandes méthodes pour créer des formulaires :

* la méthode template : vous créez votre formulaire dans le template, et Angular l'analyse pour comprendre les différents inputs et pour en mettre à disposition le contenu.

* la méthode réactive : vous créez votre formulaire en TypeScript et dans le template, puis vous en faites la liaison manuellement — cette approche est plus complexe, mais elle permet beaucoup plus de contrôle et une approche dynamique.<br/>

Nous avons utilisé la méthode template. Voici deux extrait de code pour l'illustrer: <br/>
<br>
Extrait de code tiré de article-form.component.html

  ```html
  <!--Formulaire pour création d'article-->

<div class="container">
  <div class="card col-8">
    <form #articleForm="ngForm" (ngSubmit)="onFormSubmit(articleForm)">
      <h3>Publier un article</h3>
      <div class="form-group">
        <label>Titre</label>
        <input type="text"
               ngModel
               required
               name="titre"
               id="titre"
               class="form-control">
        <label>Description</label>
        <input type="text"
               ngModel
               name="description"
               id="description"
               class="form-control">
        <label>Contenu</label>
        <textarea rows="5" cols="70"
                  ngModel
                  name="texte"
                  id="texte"
                  class="form-control"></textarea>
        <label>Tags</label>
        <input type="text"
               ngModel
               name="tag"
               id="tag"
               class="form-control">
        <label>Ajouter une image</label>
        <input type="text"
               ngModel
               name="image_url"
               id="image_url"
               class="form-control">
        <p *ngIf="isValidForm">Formulaire validé</p>
        <br>
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
    </form>
  </div>
</div>
```


Angular parcourt le template et trouve la balise  "form" , créant ainsi un objet qui sera utilisable depuis le code TypeScript.

Avant de passer à la soumission du formulaire, il faut signaler à Angular quels inputs correspondront à des  controls. On ajoute des attributs aux inputs en question : 
* Un attribut name, qui correspondra à la clef de la paire clef-valeur qui sera rendu.

* Un attribut  ngModel qui signale à Angular qu'on souhaite enregistrer ce contrôle.

```html
<input type="text"
               ngModel
               required
               name="titre"
               id="titre"
               class="form-control">
```

Déclarer le bouton de type submit à l'intérieur du  "form"  déclenche le comportement de soumission classique de HTML. 
```html
<button type="submit" class="btn btn-primary">Submit</button>
```


 En ajoutant l'attribut  (ngSubmit) , on reçoit cette soumission et on exécute la méthode  onFormSubmit().

```html
<form #articleForm="ngForm" (ngSubmit)="onFormSubmit(articleForm)">
```

Voici la fonction correspondante, tirée de article-form.component.ts :

```ts
// Formulaire pour la création d'article
  onFormSubmit(articleForm: NgForm) {
    this.isValidForm = false;
    if (articleForm.valid) {
      this.isValidForm = true;
    } else {
      return;
    }
    let articleTitre = articleForm.controls['titre'].value;
    let articleDesc = articleForm.controls['description'].value;
    let articleTexte = articleForm.controls['texte'].value;
    let articleTag = articleForm.controls['tag'].value;
    let articleImgUrl = articleForm.controls['image_url'].value;

    let newArticle = new Article();
    newArticle.titre = articleTitre;
    newArticle.description = articleDesc;
    newArticle.texte = articleTexte;
    newArticle.tag = articleTag;
    newArticle.date_publication = this.now;
    newArticle.nb_vue = 0;

    newArticle.auteur = JSON.parse(sessionStorage.getItem('currentSessionUser')); 

    newArticle.image_url = articleImgUrl;
    this.articleService.createArticle(newArticle).subscribe();
    console.log(newArticle);
    this.goToList();
  }
  ```

  # router (décrire la navigation du site grace au routeur)

  L'un des énormes avantages d'utiliser Angular est de pouvoir créer des "single page application" (SPA). Sur le Web, ces applications sont rapides et lisses : il n'y a qu'un seul chargement de page au début, et même si les données mettent parfois du temps à arriver, la sensation pour l'utilisateur est celle d'une application native.  Au lieu de charger une nouvelle page à chaque clic ou à chaque changement d'URL, on remplace le contenu ou une partie du contenu de la page : on modifie les components qui y sont affichés, ou le contenu de ces components.  On accomplit tout cela avec le "routing", où l'application lit le contenu de l'URL pour afficher le ou les components requis.