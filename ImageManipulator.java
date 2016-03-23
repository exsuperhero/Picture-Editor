import java.util.ArrayList; 


public class ImageManipulator{

	Picture inputImage;
	int width;
	int height;
	int red;
	int blue;
	int green;


	ImageManipulator(String filename){

		//takes the name of the file instead of the dimensions of the file
		inputImage = new Picture(filename);

	}

	//save a life called copy.gif
	public void copy(){
		width = inputImage.getWidth();
		height = inputImage.getHeight();
		Picture copyPicture = new Picture(width, height);

		//need a for loop 
		for (int i = 0; i < width ; i++){
			for (int j = 0; j < height; j++){

				Pixel originalPixel = inputImage.getPixel(i, j);

				red = originalPixel.getRed();
				green = originalPixel.getGreen();
				blue = originalPixel.getBlue();

				red = 0;
				green = 255;
				blue = blue * 2;


				originalPixel.setRed(red);
				originalPixel.setGreen(green);
				originalPixel.setBlue(blue);

				copyPicture.setPixel(i, j, originalPixel);
			}
		}

		//saves the file into copy.gif
		copyPicture.store("copy.gif");
		System.out.println("Done copying the input image");

	}



	// public void makeNegative() - creates an inversion of the original image 
	// by setting the red value for each pixel to be 255 minus the original red value, 
	// and the same for green and blue. The new image will be saved to a file called negative.gif.

	public void makeNegative(){

		//gets dimensions of the picture
		//and saves it for the new picture
		width = inputImage.getWidth();
		height = inputImage.getHeight();	
		Picture newPicture = new Picture(width, height);

		for (int i = 0; i < width ; i++){
			for (int j = 0; j < height; j++){

				Pixel originalPixel = inputImage.getPixel(i, j);

				red = originalPixel.getRed();
				green = originalPixel.getGreen();
				blue = originalPixel.getBlue();

				red = 255 - red;
				green = 255 - green;
				blue = 255 - blue;


				originalPixel.setRed(red);
				originalPixel.setGreen(green);
				originalPixel.setBlue(blue);

				newPicture.setPixel(i, j, originalPixel);
			}
		}

		newPicture.store("negative.gif");
		System.out.println("Done making the image into a negative");


	}



		//flips the image vertically
		public void flipVertical(){

		//gets dimensions of the picture
		//and saves it for the new picture
		width = inputImage.getWidth();
		height = inputImage.getHeight();	
		Picture verticalPicture = new Picture(width, height);

		for (int i = 0; i < width ; i++){
			for (int j = 0; j < height; j++){

				Pixel originalPixel = inputImage.getPixel(i, j);

				red = originalPixel.getRed();
				green = originalPixel.getGreen();
				blue = originalPixel.getBlue();


				originalPixel.setRed(red);
				originalPixel.setGreen(green);
				originalPixel.setBlue(blue);

				verticalPicture.setPixel(i, height-j-1, originalPixel);
			}
		}

		verticalPicture.store("verticalflip.gif");
		System.out.println("Done flipping the image vertically");


	}

	//flips the image horizontally
	//pretty straightforward
	public void flipHorizontal(){

		//gets dimensions of the picture
		//and saves it for the new picture
		width = inputImage.getWidth();
		height = inputImage.getHeight();	
		Picture horizontalPicture = new Picture(width, height);

		for (int i = 0; i < width ; i++){
			for (int j = 0; j < height; j++){

				Pixel originalPixel = inputImage.getPixel(i, j);

				red = originalPixel.getRed();
				green = originalPixel.getGreen();
				blue = originalPixel.getBlue();


				originalPixel.setRed(red);
				originalPixel.setGreen(green);
				originalPixel.setBlue(blue);

				horizontalPicture.setPixel(width-i-1, j, originalPixel);
			}
		}

		horizontalPicture.store("horizontalflip.gif");
		System.out.println("Done flipping the image horizontally");


	}

		//takes as input a floating point number between 0 and 1 that indicates 
		//by how much the image should be lightened. For each pixel, it will set its new 
		//red value to be (1-amount)oldred + amount*255, doing the same 
		//for green and blue. The new image will be saved to a file lighter.gif.
		public void lighten(double amount){

			double newAmount = 1 - amount;

			//gets dimensions of the picture
			//and saves it for the new picture
			width = inputImage.getWidth();
			height = inputImage.getHeight();	
			Picture lightenPicture = new Picture(width, height);

			for (int i = 0; i < width ; i++){
				for (int j = 0; j < height; j++){

					Pixel originalPixel = inputImage.getPixel(i, j);

					red = originalPixel.getRed();
					green = originalPixel.getGreen();
					blue = originalPixel.getBlue();

					red = (int)(newAmount * red + amount * 255);
					green = (int)(newAmount * green + amount * 255);
					blue = (int)(newAmount * blue + amount * 255);


					originalPixel.setRed(red);
					originalPixel.setGreen(green);
					originalPixel.setBlue(blue);

					lightenPicture.setPixel(i, j, originalPixel);
				}
			}

			lightenPicture.store("lighter.gif");
			System.out.println("Done lightening the image");
		}


		//darkens the image
		//opposite of lightening
		public void darken(double amount){

			double newAmount = 1 - amount;

			//gets dimensions of the picture
			//and saves it for the new picture
			width = inputImage.getWidth();
			height = inputImage.getHeight();	
			Picture darkPicture = new Picture(width, height);

			for (int i = 0; i < width ; i++){
				for (int j = 0; j < height; j++){

					Pixel originalPixel = inputImage.getPixel(i, j);

					red = originalPixel.getRed();
					green = originalPixel.getGreen();
					blue = originalPixel.getBlue();

					red = (int)(newAmount * red);
					green = (int)(newAmount * green);	
					blue = (int)(newAmount * blue);


					originalPixel.setRed(red);
					originalPixel.setGreen(green);
					originalPixel.setBlue(blue);

					darkPicture.setPixel(i, j, originalPixel);
				}
			}
			
			darkPicture.store("darker.gif");
			System.out.println("Done darkening the image");
		}



	//scroll horizontally
	//part of the image is on the other side
	public void scrollHorizontal(int numpixels){

		//gets dimensions of the picture
		//and saves it for the new picture
		width = inputImage.getWidth();
		height = inputImage.getHeight();	
		Picture newPicture = new Picture(width, height);

		for (int i = 0; i < width ; i++){

			//if the pixel is to the left of the numpixels, then
			//it goes into this if statement and gets saved to the right
			//of the picture
			if (i < numpixels){
				for (int j = 0; j < height; j++){

					Pixel originalPixel = inputImage.getPixel(i, j);

					red = originalPixel.getRed();
					green = originalPixel.getGreen();
					blue = originalPixel.getBlue();

					originalPixel.setRed(red);
					originalPixel.setGreen(green);
					originalPixel.setBlue(blue);

					newPicture.setPixel(width - numpixels + i, j, originalPixel);
			}

			}

			else{

				for (int j = 0; j < height; j++){

					Pixel originalPixel = inputImage.getPixel(i, j);

					red = originalPixel.getRed();
					green = originalPixel.getGreen();
					blue = originalPixel.getBlue();

					originalPixel.setRed(red);
					originalPixel.setGreen(green);
					originalPixel.setBlue(blue);

					newPicture.setPixel(i - numpixels, j, originalPixel);
			}
				
			}

		}

		newPicture.store("scrollhorizontal.gif");
		System.out.println("Done making the image scroll horizontal");


	}


	//scroll vertically
	//part of the image is above/below
	public void scrollVertical(int numpixels){

		//gets dimensions of the picture
		//and saves it for the new picture
		width = inputImage.getWidth();
		height = inputImage.getHeight();	
		Picture newPicture = new Picture(width, height);

		for (int i = 0; i < width ; i++){

			for (int j = 0; j < height; j++){

				if (j < numpixels){

					Pixel originalPixel = inputImage.getPixel(i, j);

					red = originalPixel.getRed();
					green = originalPixel.getGreen();
					blue = originalPixel.getBlue();

					originalPixel.setRed(red);
					originalPixel.setGreen(green);
					originalPixel.setBlue(blue);

					newPicture.setPixel(i, height - numpixels + j, originalPixel);
			}

				else{

					Pixel originalPixel = inputImage.getPixel(i, j);

					red = originalPixel.getRed();
					green = originalPixel.getGreen();
					blue = originalPixel.getBlue();

					originalPixel.setRed(red);
					originalPixel.setGreen(green);
					originalPixel.setBlue(blue);

					newPicture.setPixel(i, j - numpixels, originalPixel);
			}

			}
		}

		newPicture.store("scrollvertical.gif");
		System.out.println("Done making the image scroll vertical");


	}

		//makes the image grey
		public void makeGreyscale(){

		//gets dimensions of the picture
		//and saves it for the new picture
		width = inputImage.getWidth();
		height = inputImage.getHeight();	
		Picture newPicture = new Picture(width, height);

		for (int i = 0; i < width ; i++){
			for (int j = 0; j < height; j++){

				Pixel originalPixel = inputImage.getPixel(i, j);

				red = originalPixel.getRed();
				green = originalPixel.getGreen();
				blue = originalPixel.getBlue();

				//casts into int so that it can go into the set red method
				int newRed = (int)(red * 0.30 + green * 0.59 + blue * 0.11);

				originalPixel.setRed(newRed);
				originalPixel.setGreen(newRed);
				originalPixel.setBlue(newRed);

				newPicture.setPixel(i, j, originalPixel);
			}
		}

		newPicture.store("greyscale.gif");
		System.out.println("Done making the image into greyscale");


	}

	//rotates the image 90 degrees
	public void rotate(){

		//gets dimensions of the picture
		//and saves it for the new picture
		width = inputImage.getWidth();
		height = inputImage.getHeight();	
		Picture newPicture = new Picture(height, width);

		for (int i = 0; i < width ; i++){
			for (int j = 0; j < height; j++){

				Pixel originalPixel = inputImage.getPixel(i, j);

				red = originalPixel.getRed();
				green = originalPixel.getGreen();
				blue = originalPixel.getBlue();

				originalPixel.setRed(red);
				originalPixel.setGreen(green);
				originalPixel.setBlue(blue);


				//this is where the image gets rotated
				newPicture.setPixel(height - j - 1, i, originalPixel);
			}
		}

		newPicture.store("rotate.gif");
		System.out.println("Done rotating the image 90 degrees");


	}


	//swaps the four corners of the image opposite of each other
	public void swapCorners(){

		//gets dimensions of the picture
		//and saves it for the new picture
		width = inputImage.getWidth();
		height = inputImage.getHeight();

		int halfWidth = width / 2;
		int halfHeight = height / 2;	
		Picture newPicture = new Picture(width, height);

		for (int i = 0; i < width ; i++){

			if (i < halfWidth){

				for (int j = 0; j < height; j++){

					if (j < halfHeight){
						Pixel originalPixel = inputImage.getPixel(i, j);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(i + halfWidth, j + halfHeight, originalPixel);

					}
					else{
						Pixel originalPixel = inputImage.getPixel(i, j);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(i + halfWidth, j - halfHeight, originalPixel);

					}


			}

			}


			else{

				for (int j = 0; j < height; j++){

					if (j < halfHeight){
						Pixel originalPixel = inputImage.getPixel(i, j);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(i - halfWidth, j + halfHeight, originalPixel);

					}
					else{
						Pixel originalPixel = inputImage.getPixel(i, j);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(i - halfWidth, j - halfHeight, originalPixel);

					}
				}


			}
		}

		newPicture.store("cornerswap.gif");
		System.out.println("Done swapping the corners");


	}


	//blurs the image by taking the average of adjacent pixels
	//why so long :|
	//es muy complicado.
	public void blur(){

		//gets dimensions of the picture
		//and saves it for the new picture
		width = inputImage.getWidth();
		height = inputImage.getHeight();	
		Picture newPicture = new Picture(width, height);

		for (int x = 0; x < width; x++){


			for (int y = 0; y < height; y++){


				//goes into if statement
				//if the pixel is not one of the four edges
				//or not on the side (this prevents an error message)
				if ((x > 0) && (x < width - 1) && (y>0) && (y < height - 1)){
	
					int redSum = 0;
					int greenSum = 0;
					int blueSum = 0;

					ArrayList<Pixel> ninePixels = new ArrayList<Pixel>();

					//goes through the eight pixels surrounded by the pixel and puts them
					//into an array list

					for (int count = 0; count<3; count++){

						Pixel originalPixel = inputImage.getPixel(x-1, y-1+count);
						redSum = redSum + originalPixel.getRed();
						greenSum = greenSum + originalPixel.getGreen();
						blueSum = blueSum + originalPixel.getBlue();


						Pixel originalPixel1 = inputImage.getPixel(x, y-1+count);
						redSum = redSum + originalPixel1.getRed();
						greenSum = greenSum + originalPixel1.getGreen();
						blueSum = blueSum + originalPixel1.getBlue();

						Pixel originalPixel2 = inputImage.getPixel(x + 1, y-1+count);
						redSum = redSum + originalPixel2.getRed();
						greenSum = greenSum + originalPixel2.getGreen();
						blueSum = blueSum + originalPixel2.getBlue();

					originalPixel.setRed(redSum/9);
					originalPixel.setGreen(greenSum/9);
					originalPixel.setBlue(blueSum/9);

					newPicture.setPixel(x, y, originalPixel);


				}



				}

				//the next four if statements take care of the four corners
				//upper lefthand corner
				if ((x == 0) && (y == 0)){
					int redSum = 0;
					int greenSum = 0;
					int blueSum = 0;


					for (int count = 0; count<2; count++){

						Pixel originalPixel = inputImage.getPixel(x, y + count);
						redSum = redSum + originalPixel.getRed();
						greenSum = greenSum + originalPixel.getGreen();
						blueSum = blueSum + originalPixel.getBlue();

						Pixel originalPixel1 = inputImage.getPixel(x + 1, y + count);
						redSum = redSum + originalPixel1.getRed();
						greenSum = greenSum + originalPixel1.getGreen();
						blueSum = blueSum + originalPixel1.getBlue();

						originalPixel.setRed(redSum/4);
						originalPixel.setGreen(greenSum/4);
						originalPixel.setBlue(blueSum/4);

						newPicture.setPixel(x, y, originalPixel);
				}
				}

				//upper right hand corner
				if ((x == width -1) && (y == 0)){
					int redSum = 0;
					int greenSum = 0;
					int blueSum = 0;


					for (int count = 0; count<2; count++){

						Pixel originalPixel = inputImage.getPixel(x, y + count);
						redSum = redSum + originalPixel.getRed();
						greenSum = greenSum + originalPixel.getGreen();
						blueSum = blueSum + originalPixel.getBlue();

						Pixel originalPixel1 = inputImage.getPixel(x - 1, y + count);
						redSum = redSum + originalPixel1.getRed();
						greenSum = greenSum + originalPixel1.getGreen();
						blueSum = blueSum + originalPixel1.getBlue();

						originalPixel.setRed(redSum/4);
						originalPixel.setGreen(greenSum/4);
						originalPixel.setBlue(blueSum/4);

						newPicture.setPixel(x, y, originalPixel);
				}
				}	

				//lower left hand corner			
				if ((x == 0) && (y == height - 1)){
					int redSum = 0;
					int greenSum = 0;
					int blueSum = 0;


					for (int count = 0; count<2; count++){

						Pixel originalPixel = inputImage.getPixel(x, y - count);
						redSum = redSum + originalPixel.getRed();
						greenSum = greenSum + originalPixel.getGreen();
						blueSum = blueSum + originalPixel.getBlue();

						Pixel originalPixel1 = inputImage.getPixel(x + 1, y - count);
						redSum = redSum + originalPixel1.getRed();
						greenSum = greenSum + originalPixel1.getGreen();
						blueSum = blueSum + originalPixel1.getBlue();

						originalPixel.setRed(redSum/4);
						originalPixel.setGreen(greenSum/4);
						originalPixel.setBlue(blueSum/4);

						newPicture.setPixel(x, y, originalPixel);
				}
				}



				//lower right hand corner
				if ((x == width - 1) && (y == height - 1)){
					int redSum = 0;
					int greenSum = 0;
					int blueSum = 0;


					for (int count = 0; count<2; count++){

						Pixel originalPixel = inputImage.getPixel(x, y - count);
						redSum = redSum + originalPixel.getRed();
						greenSum = greenSum + originalPixel.getGreen();
						blueSum = blueSum + originalPixel.getBlue();

						Pixel originalPixel1 = inputImage.getPixel(x - 1, y - count);
						redSum = redSum + originalPixel1.getRed();
						greenSum = greenSum + originalPixel1.getGreen();
						blueSum = blueSum + originalPixel1.getBlue();

						originalPixel.setRed(redSum/4);
						originalPixel.setGreen(greenSum/4);
						originalPixel.setBlue(blueSum/4);

						newPicture.setPixel(x, y, originalPixel);
				}
				}

				//next four if statements take care of each 
				//of the four sides

				//left side
				if ((x == 0) && (y > 0) && (y < height-1-1)){
					int redSum = 0;
					int greenSum = 0;
					int blueSum = 0;


					for (int count = 0; count<3; count++){

						Pixel originalPixel = inputImage.getPixel(x, y - 1 + count);
						redSum = redSum + originalPixel.getRed();
						greenSum = greenSum + originalPixel.getGreen();
						blueSum = blueSum + originalPixel.getBlue();

						Pixel originalPixel1 = inputImage.getPixel(x + 1, y - 1 + count);
						redSum = redSum + originalPixel1.getRed();
						greenSum = greenSum + originalPixel1.getGreen();
						blueSum = blueSum + originalPixel1.getBlue();

						originalPixel.setRed(redSum/6);
						originalPixel.setGreen(greenSum/6);
						originalPixel.setBlue(blueSum/6);

						newPicture.setPixel(x, y, originalPixel);
				}
				}

				//right side
				if ((x == width - 1) && (y > 0) && (y < height-1)){
					int redSum = 0;
					int greenSum = 0;
					int blueSum = 0;


					for (int count = 0; count<3; count++){

						Pixel originalPixel = inputImage.getPixel(x, y - 1 + count);
						redSum = redSum + originalPixel.getRed();
						greenSum = greenSum + originalPixel.getGreen();
						blueSum = blueSum + originalPixel.getBlue();

						Pixel originalPixel1 = inputImage.getPixel(x - 1, y - 1 + count);
						redSum = redSum + originalPixel1.getRed();
						greenSum = greenSum + originalPixel1.getGreen();
						blueSum = blueSum + originalPixel1.getBlue();

						originalPixel.setRed(redSum/6);
						originalPixel.setGreen(greenSum/6);
						originalPixel.setBlue(blueSum/6);

						newPicture.setPixel(x, y, originalPixel);
				}
				}

				//top side of the picture
				if ((x > 0) && (x < width - 1-1) && (y ==0 )){
					int redSum = 0;
					int greenSum = 0;
					int blueSum = 0;


					for (int count = 0; count<3; count++){

						Pixel originalPixel = inputImage.getPixel(x - 1 + count, y);
						redSum = redSum + originalPixel.getRed();
						greenSum = greenSum + originalPixel.getGreen();
						blueSum = blueSum + originalPixel.getBlue();

						Pixel originalPixel1 = inputImage.getPixel(x - 1 + count, y + 1);
						redSum = redSum + originalPixel1.getRed();
						greenSum = greenSum + originalPixel1.getGreen();
						blueSum = blueSum + originalPixel1.getBlue();

						originalPixel.setRed(redSum/6);
						originalPixel.setGreen(greenSum/6);
						originalPixel.setBlue(blueSum/6);

						newPicture.setPixel(x, y, originalPixel);
				}
				}


				//bottom side
				if ((x > 0) && (x < width - 1-1) && (y == height - 1 )){
					int redSum = 0;
					int greenSum = 0;
					int blueSum = 0;


					for (int count = 0; count<3; count++){

						Pixel originalPixel = inputImage.getPixel(x - 1 + count, y);
						redSum = redSum + originalPixel.getRed();
						greenSum = greenSum + originalPixel.getGreen();
						blueSum = blueSum + originalPixel.getBlue();

						Pixel originalPixel1 = inputImage.getPixel(x - 1 + count, y - 1);
						redSum = redSum + originalPixel1.getRed();
						greenSum = greenSum + originalPixel1.getGreen();
						blueSum = blueSum + originalPixel1.getBlue();

						originalPixel.setRed(redSum/6);
						originalPixel.setGreen(greenSum/6);
						originalPixel.setBlue(blueSum/6);

						newPicture.setPixel(x, y, originalPixel);
				}
				}				
					

				}

			}

		newPicture.store("blur.gif");
		System.out.println("Done blurring the image");
	}







	//makes the picture larger and saves it as another picture
	public void scaleLarger(int factor){

		//gets dimensions of the picture
		//and saves it for the new picture
		width = inputImage.getWidth();
		height = inputImage.getHeight();	

		int newWidth = width * factor;
		int newHeight = height * factor;
		Picture newPicture = new Picture(newWidth, newHeight);



		for (int x = 0, newX = 0; x < width; x++, newX = newX + factor){
			for (int y = 0, newY = 0; y < height; y++, newY = newY + factor){

			// for (; newX < newWidth; newX = newX + factor){
			// for ( = 0; newY < newHeight; newY = newY + factor){

				Pixel originalPixel = inputImage.getPixel(x, y);

				red = originalPixel.getRed();
				green = originalPixel.getGreen();
				blue = originalPixel.getBlue();


				originalPixel.setRed(red);
				originalPixel.setGreen(green);
				originalPixel.setBlue(blue);


					for (int count = 0; count < factor ; count++){

						for (int count2 = 0; count2 < factor; count2++){

							newPicture.setPixel(newX, newY + count, originalPixel);
							newPicture.setPixel(newX + count2, newY + count, originalPixel);

							newPicture.setPixel(newX + count2, newY + count, originalPixel);

							newPicture.setPixel(newX + count, newY + count, originalPixel);

						}

						}


			}
		}

		newPicture.store("scaled.gif");
		System.out.println("Done making the image scale larger");


	}


		public void eightSquares(){

		//gets dimensions of the picture
		//and saves it for the new picture
		width = inputImage.getWidth();
		height = inputImage.getHeight();

		int thirdWidth = width / 3;
		int thirdHeight = height / 3;	
		Picture newPicture = new Picture(width, height);

		for (int x = 0; x < width ; x++){

			if (x < thirdWidth){

				for (int y = 0; y < height; y++){

					//these are for the pixels on the left of the image

					if (y < thirdHeight){
						Pixel originalPixel = inputImage.getPixel(x, y);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(x + thirdWidth * 2, y + thirdHeight * 2, originalPixel);

					}
					else if ((y > thirdHeight) && (y < thirdHeight * 2)){

						Pixel originalPixel = inputImage.getPixel(x, y);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(x + thirdWidth, y + thirdHeight, originalPixel);

					}
					else{

						Pixel originalPixel = inputImage.getPixel(x, y);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(x, y, originalPixel);


					} 

			}

			}

			else if ((x >= thirdWidth) && (x < thirdWidth * 2)) {

				for (int y = 0; y < height; y++){



					//these are for the pixels on the middle of the image

					if (y < thirdHeight ){
						Pixel originalPixel = inputImage.getPixel(x, y);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(x - thirdWidth, y, originalPixel);

					}
					else if ((y > thirdHeight) && (y < thirdHeight * 2)){

						Pixel originalPixel = inputImage.getPixel(x, y);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(x, y, originalPixel);

					}

					else{

						Pixel originalPixel = inputImage.getPixel(x, y);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(x + thirdWidth, y - thirdHeight, originalPixel);


			} 

	 }


				
			}


			else{

				for (int y = 0; y < height; y++){

					//these are for the pixels on the right of the image

					if (y <= thirdHeight ){
						Pixel originalPixel = inputImage.getPixel(x, y);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(x - thirdWidth * 2 , y + thirdHeight, originalPixel);

					}

					else if ((y >= thirdHeight) && (y < thirdHeight * 2)){

						Pixel originalPixel = inputImage.getPixel(x, y);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(x - thirdWidth, y - thirdHeight, originalPixel);

					}

					else{

						Pixel originalPixel = inputImage.getPixel(x, y);

						red = originalPixel.getRed();
						green = originalPixel.getGreen();
						blue = originalPixel.getBlue();

						originalPixel.setRed(red);
						originalPixel.setGreen(green);
						originalPixel.setBlue(blue);

						newPicture.setPixel(x, y - thirdHeight * 2, originalPixel);


			} 

			 }
			
			}

		}

		newPicture.store("eightsqaures.gif");
		System.out.println("Done making the random eight squares");


	}


}