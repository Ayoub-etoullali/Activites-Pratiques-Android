# (2) Splash screen & Navigation entre Écrans & Internationalisation

## Exercice 1 :
=> But : Utilisation des Layouts, Ressources, Application Composite et Création d’Evénement

   Dans cet exercice, il est demandé de réaliser une application qui permet de récupérer les données d’un utilisateur (Nom et mot de passe) à partir de la première Activité et les envoyer à la deuxième activité pour les afficher. Le démarrage de l’application se fait en premier lieu avec un écran de d’accueil qui s’appelle un Splash Screen.

---

## 1. Créer l’interface graphique de l’application (Activité 1, 2 et 3)

   ### Activité Splash Screen
   
   * Créer une nouvelle activité "Splash Screen"
   
   ![image](https://user-images.githubusercontent.com/92756846/222574817-c924db12-8ef3-46dd-a87e-20be015b673f.png)
   
   ![image](https://user-images.githubusercontent.com/92756846/222569210-7f8b6b22-1e0c-4a96-a99b-1cc620f35dd8.png)

   * Déclarer que le SplashActivity est dans les activités de démarrage de l'application
   
   ![image](https://user-images.githubusercontent.com/92756846/222759902-a9586a8b-7021-41db-8cb7-f0fe7c1bc891.png)

   ### Activité Main :
   
   * Créer une nouvelle activité "Main" :
   
   ![image](https://user-images.githubusercontent.com/92756846/222758309-f19cfbe4-3e8f-49b4-a95d-bcbd8f6f702b.png)
   
   * Déclarer que le MainActivity est dans les activités de démarrage de l'application
   
   ![image](https://user-images.githubusercontent.com/92756846/222759999-debac869-1bb4-4c88-97b3-046f0044fc3d.png)
   
   ### Activité NewActivity :
   
   * Créer une nouvelle activité "NewActivity"

   ![image](https://user-images.githubusercontent.com/92756846/222762527-786edd52-1ccf-4620-b366-d803286356a7.png)
   
   ![image](https://user-images.githubusercontent.com/92756846/222758806-25af392c-288b-423f-a940-27fa4e718472.png)
   
   * Déclarer que l'Activity2 est dans les activités de démarrage de l'application
   
   ![image](https://user-images.githubusercontent.com/92756846/222759675-a6429565-4a5d-43c0-920b-cc79e884168c.png)
   


## 2. Ajouter une méthode void envoyer(View view) dans la première activité qui sera associée au bouton Envoyer. Elle permet de transférer les informations de l’utilisateur vers la deuxième activité.

![image](https://user-images.githubusercontent.com/92756846/222762729-633b3b25-506e-4b79-844c-54989dae6bb1.png)



## 3. Ajouter une méthode void retour(View view) dans la deuxième activité qui sera associer au bouton Retour afin de retourner à la première activité et réinitialiser les champs du formulaire.

![image](https://user-images.githubusercontent.com/92756846/222762618-b335acad-8242-44c8-a2ee-3188d5c9c4fd.png)


## Exercice 2 :
=> But : Utilisation du fichier string.xml pour une application multilangue

---

## 1. Remplacez toutes les chaînes de caractères en dur de l’application d’exercice 2 par des références à des chaines situées dans le fichier strings.xml.

![image](https://user-images.githubusercontent.com/92756846/222775117-fb0a7aa2-2c7e-4cce-a0b1-b8065daa32f1.png)

## 2. Modifier votre application pour quel supporte, en plus de la langue française, la langue arabe et anglaise.

![image](https://user-images.githubusercontent.com/92756846/222792875-439bbc78-3326-4ad6-9f35-cadafda0fdab.png)

* Arabe

![image](https://user-images.githubusercontent.com/92756846/222793086-c22a5805-d4b6-41da-a46b-dbf0979fadaa.png)

* Français

![image](https://user-images.githubusercontent.com/92756846/222793219-9c165e65-be44-429a-ba51-f238987a3534.png)

* Anglais

![image](https://user-images.githubusercontent.com/92756846/222793161-b00dd1d1-c9fd-4a36-be26-ff81e19264d0.png)

## 3. Testez votre application en changeant la langue de votre Smartphone.

![image](https://user-images.githubusercontent.com/92756846/222793478-8d27c502-32e5-4f04-8916-140268b530b6.png)
![image](https://user-images.githubusercontent.com/92756846/222793563-628d3462-4527-4fcf-afc5-06906173bbf1.png)


## Exercice 3 :
=> But : Mettre en pratique le cycle d’une activité via la classe TOAST.
En utilisant l’application d’exercice 2 :

---

## 1. Implémenter les méthodes onStart, onResume, onPause, onRestart, onStop et onDestroy dans la première activité.

![image](https://user-images.githubusercontent.com/92756846/222762318-13552c69-256c-42f7-a5e9-e56526c47df2.png)

## 2. Utiliser la classe Toast pour afficher un message en bas de l’écran indiquant l’état de l’activité.

![image](https://user-images.githubusercontent.com/92756846/222793727-7ceec15f-c853-44e0-9c59-eeb708f15de9.png)

## 3. Exécuter l’application, basculer à la deuxième activité et fermer l’application à la fin pour afficher les étapes du cycle de vie de l’activité testée.

![Lumii_20230303_193645672](https://user-images.githubusercontent.com/92756846/222800829-e4be4079-d9ea-4fba-8b18-e8cc5e2f4457.jpg)

![Lumii_20230303_194424704](https://user-images.githubusercontent.com/92756846/222802004-408ad167-b519-4667-b087-bd9a7a45f221.jpg)

## Enfin 🤗 vous pouvez voir la simulation ici 
https://drive.google.com/file/d/1uMlIPDN-iPYqsXSSCv83lJQfH-5SjM_a/view?usp=drivesdk
