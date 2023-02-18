# (1) Codez votre propre calcultrice

Dans ce TP, il est demandé de réaliser une application qui permet de mettre en pratique la gestion des événements avec une interface graphique un peu complexe. 

## Partie 1 : L’interface graphique de l’application
   L'organisation générale demandée peut se décomposer en un texte en haut de l'écran et un tableau de boutons en bas. En utilisant le LinearLayout avec une orientation verticale, on peut donc placer un TextView en haut de l'écran sur l'intégralitéde la largeur avec un texte aligné à droite ainsi qu’un TableLayout en bas.
![](images/0.jpg)

1. Arborescence des composants
![](images/1.jpg)
2. activity_main
      * Interface
      ![](images/2.jpg)
      * Code
      ![](images/4.jpg)
      
## Partie 2 : Code JAVA
      Au niveau du comportement, on se rend compte que pour faire des opérations binaires (avec deux opérandes), il faudra mémoriser deux opérandes et l’opération effectuée. L'action du bouton égal (=) sera celle qui fera le calcul. Il faut aussi mémoriser si on est en train de saisir le premier ou le second opérande. Ainsi, lancer le calcul ne correspondra qu'à faire l'opération demandée entre les 2 opérandes en mémoire, stocker le résultat en premier opérande et mettre à jour l'affichage.
![](images/3.jpg)

Et Finalement 🤗
![](images/5.jpg)
      ![image](https://user-images.githubusercontent.com/92756846/219903025-4092e01c-7139-461b-a093-2bf739201b3c.png)
