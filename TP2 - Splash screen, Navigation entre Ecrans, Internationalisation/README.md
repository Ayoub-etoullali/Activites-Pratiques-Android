# (1) Codez votre propre calcultrice

Dans ce TP, il est demandé de réaliser une application qui permet de mettre en pratique la gestion des événements avec une interface graphique un peu complexe. 

## Partie 1 : L’interface graphique de l’application
   L'organisation générale demandée peut se décomposer en un texte en haut de l'écran et un tableau de boutons en bas. En utilisant le LinearLayout avec une orientation verticale, on peut donc placer un TextView en haut de l'écran sur l'intégralitéde la largeur avec un texte aligné à droite ainsi qu’un TableLayout en bas.

![image](https://user-images.githubusercontent.com/92756846/219903328-b803229d-719e-44cd-a8d4-1170af43c2ce.png)

1. Arborescence des composants

![image](https://user-images.githubusercontent.com/92756846/219903422-870b26df-2105-4b59-9858-617adccf886a.png)

2. activity_main

      * Interface
      
      ![image](https://user-images.githubusercontent.com/92756846/219903385-b2ca7924-3f33-4e41-9e6d-fdabe0aacfb9.png)
      
      * Code
      
      ![image](https://user-images.githubusercontent.com/92756846/219903335-7ceef4c0-d21e-4a2d-85c6-ce81a0d21617.png)
      
## Partie 2 : Code JAVA
      Au niveau du comportement, on se rend compte que pour faire des opérations binaires (avec deux opérandes), il faudra mémoriser deux opérandes et l’opération effectuée. L'action du bouton égal (=) sera celle qui fera le calcul. Il faut aussi mémoriser si on est en train de saisir le premier ou le second opérande. Ainsi, lancer le calcul ne correspondra qu'à faire l'opération demandée entre les 2 opérandes en mémoire, stocker le résultat en premier opérande et mettre à jour l'affichage.

![image](https://user-images.githubusercontent.com/92756846/219903434-dea244f6-371b-42d8-91be-62938ea53573.png)

## Et Finalement 🤗
![IMG_20230219_002333](https://user-images.githubusercontent.com/92756846/219903873-26576f7e-9eef-47ea-9033-0b0e9dcfdb05.jpg)
