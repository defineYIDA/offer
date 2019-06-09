package rle;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.BitSet;
/**
 * @Author: zl
 * @Date: 2019/6/9 20:15
 */
public final class Utility {
    private Utility() {
    }

    public static BufferedImage createBufferedImage(BufferedImage originalImage) {
        // return a new blank BufferedImage with replicate properties from the original image
        return new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), originalImage.getType());
    }

    public static int getGrayscale(int rgb) {
        // grab the color at that position
        Color color = new Color(rgb);

        // separate out the individual colors
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        // simple averaging grayscale conversion
        int gray = (red + green + blue) / 3;

        return gray;
    }

    public static int squash(double gray) {
        // mathematical calculation to squash a value between 0 and 255
        return Math.min(Math.max((int) gray, 0), 255);
    }

    public static double[][] getGaussianKernel(int k, double sigma) {
        // create new kernel of size k
        double[][] kernel = new double[k][k];

        // running total
        double sumTotal = 0;

        // offset for looping through the kernel
        int offset = k / 2;

        // value representing the exponential portion
        double secondGaussianComponent;

        // value representing the multiplying factor to the exponential portion
        double firstGaussianComponent = 1.0 / (2.0 * Math.PI * (sigma * sigma));

        // loop through kernel
        for (int y = -offset; y <= offset; y++) {
            for (int x = -offset; x <= offset; x++) {
                // mathematical formula for second Gaussian component
                secondGaussianComponent = ((x * x) + (y * y)) / (2 * (sigma * sigma));

                // set the kernel at this spot to be the equation first * e^(-second)
                kernel[y+offset][x+offset] = firstGaussianComponent * Math.exp(-secondGaussianComponent);

                // add the kernel value to the running total
                sumTotal += kernel[y+offset][x+offset];
            }
        }

        // loop through the kernel to fix scaling
        for (int y = 0; y < k; y++) {
            for (int x = 0; x < k; x++) {
                // scale the kernel at this position using the sumTotal
                kernel[y][x] = kernel[y][x] * (1.0 / sumTotal);
            }
        }
        return kernel;
    }

    public static int[][] getLaplacianKernel(int k) {
        // create new kernel using the user given size
        int[][] kernel = new int[k][k];

        // offset for looping through the kernel
        int offset = k / 2;

        // loop through the kernel to assign the laplacian values
        for (int y = 0; y < k; y++) {
            for (int x = 0; x < k; x++) {
                // if the center of the kernel
                if (y == offset && x == offset) {
                    // naive laplacian operation -n * n
                    kernel[y][x] = -((k * k));
                } else {
                    // all other kernel values are 1
                    kernel[y][x] = 1;
                }
            }
        }
        return kernel;
    }

    public static byte[] imageToByteArray(BufferedImage image) throws IOException {
        // create new byte array with the dimensions of the image
        // for use by RLE when we assume 2^8 colors so we need all 8 bits
        // for each color such as colors 1 and 2 would be 00000001 and
        // 00000010 vs. a BitSet that would use 01 and 10 for colors 1 and 2
        // and so forth
        byte[] imageByteArray = new byte[image.getWidth() * image.getHeight()];

        // loop through pixels in the image
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                // get the grayscale value at this position
                int gray = getGrayscale(image.getRGB(x, y));

                // assign this grayscale value to the corresponding index
                imageByteArray[y * image.getWidth() + x] = (byte) gray;
            }
        }
        return imageByteArray;
    }

    public static int[] imageToIntegerArray(BufferedImage image) throws IOException {
        // create new integer array with the dimensions of the original image
        int[] imageIntegerArray = new int[image.getWidth() * image.getHeight()];

        // loop through pixels in the image
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                // get the grayscale value at this position
                int gray = getGrayscale(image.getRGB(x, y));

                // assign the grayscale value to the corresponding
                // position in the integer array
                imageIntegerArray[y * image.getWidth() + x] = gray;
            }
        }
        return imageIntegerArray;
    }

    public static int convertSigned(BitSet bits) {
        // initial value
        int value = 0;

        // loop through bits except the sign bit (0)
        for (int i = 1; i < bits.length(); ++i) {
            value += bits.get(i) ? (1 << i - 1) : 0;
        }

        // negate the value if the sign bit is set
        // this allows for negative numbers
        if (bits.get(0)) {
            return -value;
        }
        return value;
    }

    public static BitSet convertSigned(int value) {
        // create new BitSet
        BitSet bits = new BitSet();

        // negative value?
        if (value < 0) {
            // set the sign bit
            bits.set(0);

            // negate so we can work with a positive value
            value = Math.abs(value);
        } else {
            // clear sign bit just in case
            bits.clear(0);
        }
        // set the index and start dividing the value
        int index = 1;
        while (value != 0) {
            // grab binary value
            if (value % 2 != 0) {
                bits.set(index);
            }
            // increment index and divide by 2
            ++index;
            value = value >>> 1;
        }
        return bits;
    }

    public static int convert(BitSet bits) {
        // exact same methods as the above but does not deal
        // with signed values so we use the first index
        int value = 0;

        for (int i = 0; i < bits.length(); ++i) {
            value += bits.get(i) ? (1 << i) : 0;
        }
        return value;
    }

    public static BitSet convert(int value) {
        // exact same methods as the above but does not deal
        // with signed values so we use the first index
        BitSet bits = new BitSet();
        int index = 0;

        while (value != 0) {
            if (value % 2 != 0) {
                bits.set(index);
            }
            ++index;
            value = value >>> 1;
        }
        return bits;
    }
}