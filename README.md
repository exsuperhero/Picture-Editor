# Picture-Editor
Partly written by an exsuperhero

About the Program:

This program is AWESOME!!! This is how I will edit ALL of the IG pictures now.
All my new selfies will be edited with the program.
This program will increase the number of likes I get per picture.
I WILL FINALLY BE IG FAMOUS!!! NO MORE REASON TO STUDY COMPUTER SCIENCE WOOO WOOOO




There are four classes that make up this program:
Picture.java
Pixel.java
ImageDriver.java
ImageManipulator.java

Picture.java and Pixel.java were written by another programmer and given to me to work with.
In Pixel.java, it gets and sets the pixels of the image. It calculates the values of the red, green,
and blue pixels.
In Picture.java, it calls the methods in Pixel.java in order to save all of the pixels into a picture.

The ImageManipulator.java contains all of the methods that I wrote myself in order to change and edit the picture.
The picture is passed as on argument by the user. Afterwards, the ImageDriver.java calls on each method
and edits the picture. It saves different copies of the edits.
These methods include:
-makeNegative(), which makes a copy of the picture of a negative 
-flipVertical(), which literally flips the picture vertically
-flipHorizontal(), which literally flips the picture horizontally like omgz
-lighten(), takes the picture and makes it a little lighter
-darken(), which does the opposite of lighten.

Part two of ImageManipulator contains the following methods:
-scrollHorizontal(), which shifts the image to the left by an x amount of pixels. It looks like the background of 
crappy webpage made with bad HTML
-scrollVertical(), which shifts the image vertically. Also looks like the background of a crappy
webpage. I don't think I would use this in real life.
-makeGreyScale(), turns the image into a black and white image/grey image. 
-rotate(), rotates the image by 90 degrees. Pretty cool!
-swapCorners(), swaps the opposite corners of the image
- and blur(), which blurs the image by taking the average of the adjacent pixels and sets that as the pixel

-scaleLarger() takes in an integer and makes the picture larger depending on what integer is passed.
-eightSqaures() divides the image into 9 squares and puts them into random locations
