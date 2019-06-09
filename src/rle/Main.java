package rle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

class Main {
	public static void main(String [] args) throws IOException {
		BufferedImage image = ImageIO.read(new File("F:\\tmp\\doraemon.jpg"));
		ImageProcessingFunctions.RLE(image);
    }
}
