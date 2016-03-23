public class ImageDriver {
	public static void main(String[] args) {


		//take input a file name from the user
		ImageManipulator image1 = new ImageManipulator(args[0]);

		//passes the file name into each in order to edit/change
		//the picture
		//so cool right Rubin?!
		image1.makeNegative();
		image1.flipVertical();
		image1.flipHorizontal();
		image1.lighten(0.4);
		image1.darken(0.6);
		image1.scrollHorizontal(100);
		image1.scrollVertical(50);
		image1.makeGreyscale();
		image1.rotate();
		image1.swapCorners();
		image1.blur();
		image1.scaleLarger(5);
		image1.eightSquares();

	}
}