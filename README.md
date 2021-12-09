# Paint-Program---in-Java
Recreation of the Microsoft's Paint application in Java

## Features
-can draw various shapes - by default- Line, after clicking buttons- Rectangle, Ellipse, Line, Star  
-drawing is done by pressing and releasing the mouse button  
-check box decides whether Rectangle and Ellipse will be filled  
-while holding a shift key - draws regular Rectangle or Ellipse  
-it changes the style of drawing depending on which direction the mouse button is released  
-Star - the first click of the mouse determines the centre of the star, releasing determines the outer radius of the star  
-by entering an integer number greater than two and clicking apply button, it changes the number of the star points (5 default)  
-contains colour chooser to pick a colour of the shapes  
-implements undo and redo button in the menu - in Edit  
To run the program - run DrawMain  


<div align='center'>
<img src="https://user-images.githubusercontent.com/81230042/145408009-9a12fa66-19f6-4c48-a498-05dc88774092.PNG" />
	
Picture 1: 	Main window
</div> 

## JUnit tests
-To run the test suite:  
from src compile:  
javac -cp ./junit.jar:./src/hamcrest.jar:./src/:. src/tests/*.java  
to run:  
java -cp ./junit.jar:./src/hamcrest.jar:./src/:. org.junit.runner.JUnitCore tests.ModelTestSuite  

<div align='center'>

<img src="https://user-images.githubusercontent.com/81230042/145408967-42a135d5-5448-4d20-aec3-35ee5108e656.PNG" />
	
Picture 2: 	Pick colour
</div> 

<div align='center'>
<img src="https://user-images.githubusercontent.com/81230042/145409063-2a70937f-4015-4a22-8620-748d7d8014bd.png" />
	
Picture 3: 	Undo redo buttons
</div> 
