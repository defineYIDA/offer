package rle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
/**
 * @Author: zl
 * @Date: 2019/6/9 20:13
 */
public class ImageProcessingFunctions {
    private ImageProcessingFunctions() {
    }

    public static void RLE(BufferedImage image) throws IOException {
        // get bytes from image
        byte[] original = Utility.imageToByteArray(image);

        // Encode the bytes using Run Length Encoding
        long encodingStart = System.nanoTime();
        byte[] encoded = RLEEncode(original);
        FileOutputStream out = new FileOutputStream("F:\\tmp\\666.t");

        out.write(encoded);
        long encodingEnd = System.nanoTime();

        // Decode the encoded bytes
        long decodingStart = System.nanoTime();
        byte[] decoded = RLEDecode(encoded);
        //FileOutputStream out1 = new FileOutputStream("F:\\tmp\\667.jpg");

        long decodingEnd = System.nanoTime();

        // Get the compression ratio
        double compressionRatio = original.length / (double) encoded.length;

        // Print metrics - RLE
        System.out.println("Run Length Encoding Metrics");
        System.out.println("---------------------------");
        System.out.println("Original Image Bit Size: " + original.length * 8);
        System.out.println("Encoded Image Bit Size: " + encoded.length * 8);
        System.out.println("Compression Ratio: " + compressionRatio + "\n");
        System.out.println("Encoding Time: " + (encodingEnd - encodingStart) / 1000000000.0 + " seconds");
        System.out.println("Decoding Time: " + (decodingEnd - decodingStart) / 1000000000.0 + " seconds\n");
    }

    public static byte[] RLEEncode(byte[] imageByteArray) {
        // create new byte stream
        ByteArrayOutputStream runLengthEncoding = new ByteArrayOutputStream();

        // get the first byte of the array
        byte lastByte = imageByteArray[0];

        // represents the number of consecutive, identical symbols
        int runningCount = 1;

        // loop through the byte array
        for (int i = 1; i < imageByteArray.length; i++) {
            // grab the current byte
            byte thisByte = imageByteArray[i];

            // last byte and current byte are the same
            if (lastByte == thisByte) {
                // increment count since we have identical symbols
                runningCount++;
            } else {
                // the last byte and the current byte are not the
                // same therefore we no longer have consecutive
                // symbols (a symbol run) so write the count
                // and the previous byte
                runLengthEncoding.write((byte) runningCount);
                runLengthEncoding.write((byte) lastByte);

                // reset count and shift current byte
                runningCount = 1;
                lastByte = thisByte;
            }
        }
        // write the final running count and previous byte
        // not afforded by the loop
        runLengthEncoding.write((byte) runningCount);
        runLengthEncoding.write((byte) lastByte);

        return runLengthEncoding.toByteArray();
    }

    public static byte[] RLEDecode(byte[] encoding) {
        // create new stream representing the decoded bytes
        ByteArrayOutputStream decoding = new ByteArrayOutputStream();

        // loop through the encoded byte array by indices of 2 since
        // the first index is the amount of the symbol at the second index
        for (int i = 0; i < encoding.length; i += 2) {
            for (int j = 0; j < encoding[i]; j++) {
                // write appropriate number of symbols using a loop
                decoding.write(encoding[i + 1]);
            }
        }
        return decoding.toByteArray();
    }

    public static void LZW(BufferedImage image) throws IOException {
        // get bytes from image
        int[] imageBytes = Utility.imageToIntegerArray(image);

        // transform bytes into a string
        StringBuilder tempInput = new StringBuilder();
        for (int i = 0; i < imageBytes.length; i++) {
            tempInput.append((char) imageBytes[i]);
        }
        String input = new String(tempInput);

        // perform encoding
        long encodingStart = System.nanoTime();
        ArrayList<BitSet> encoding = LZWEncode(input);
        long encodingEnd = System.nanoTime();

        // grab total encoding bits
        int totalBits = 0;
        for (int i = 0; i < encoding.size(); i++) {
            BitSet temp = encoding.get(i);
            totalBits += temp.length();
        }

        // perform decoding
        long decodingStart = System.nanoTime();
        String decoding = LZWDecode(encoding);
        long decodingEnd = System.nanoTime();

        // get the compression ratio
        double compressionRatio = (imageBytes.length * 8) / (double) totalBits;

        // Print metrics - LZW
        System.out.println("LZW Encoding/Decoding Metrics");
        System.out.println("-----------------------------");
        System.out.println("Original Image Bit Size: " + imageBytes.length * 8);
        System.out.println("Encoded Image Bit Size: " + totalBits);
        System.out.println("Compression Ratio: " + compressionRatio + "\n");
        System.out.println("Encoding Time: " + (encodingEnd - encodingStart) / 1000000000.0 + " seconds");
        System.out.println("Decoding Time: " + (decodingEnd - decodingStart) / 1000000000.0 + " seconds\n");
    }

    public static ArrayList<BitSet> LZWEncode(String input) {
        // number of possible single character symbols
        int symbols = (int) Math.pow(2, 8);

        // table for associating symbols to codewords
        HashMap<String, BitSet> table = new HashMap<String, BitSet>();

        // generate initial table using the corresponding character and value
        for (int i = 0; i < symbols; i++) {
            BitSet value = Utility.convert(i);
            table.put("" + (char) i, value);
        }

        // initial string
        String s = "";

        // codewords to be transmitted of our original string
        ArrayList<BitSet> result = new ArrayList<BitSet>();

        // loop through our input string
        for (char p : input.toCharArray()) {
            // add current character to running string
            String sp = s + p;

            // check if the table has this particular running string
            if (table.containsKey(sp)) {
                s = sp;
            } else {
                // if not add the previous string's
                // codeword to the result
                result.add(table.get(s));

                // add the new string to the table and add a new codeword to it
                table.put(sp, Utility.convert(symbols++));

                // restart the running string
                s = "" + p;
            }
        }

        // if the string isn't empty
        if (!s.equals("")) {
            // add the remaining codeword to the result
            result.add(table.get(s));
        }
        return result;
    }

    public static String LZWDecode(ArrayList<BitSet> encoding) {
        // number of possible single character symbols
        int symbols = (int) Math.pow(2, 8);

        // table for associating symbols to codewords
        HashMap<BitSet, String> table = new HashMap<BitSet, String>();

        // generate initial table using the corresponding
        // character and value but reversed
        for (int i = 0; i < symbols; i++) {
            table.put(Utility.convert(i), "" + (char) i);
        }

        // initialize the string with the first codeword
        String s = "" + (char) Utility.convert(encoding.remove(0));
        StringBuffer result = new StringBuffer(s);

        // loop through all of the BitSet's in our codeword list
        for (BitSet k : encoding) {
            String entry = null;

            // if table has this BitSet then grab the corresponding
            // string associated with this codeword
            if (table.containsKey(k)) {
                entry = table.get(k);
            } else if (Utility.convert(k) == symbols) {
                // if the BitSet is equal to the
                // current number of symbols
                // let the entry be the running string with the character
                // (reversing the process)
                entry = s + s.charAt(0);
            }
            // add the symbol to the result string
            result.append(entry);

            // add new string pattern incremented to the table
            table.put(Utility.convert(symbols++), s + entry.charAt(0));

            // assign the string to the current entry
            s = entry;
        }
        return result.toString();
    }

    public static void DPCM(BufferedImage image) throws IOException {
        // grab the integer array representing the gray values of the image
        int[] imageIntegerArray = Utility.imageToIntegerArray(image);

        // start the encoding process returning a list of BitSets'
        long encodingStart = System.nanoTime();
        ArrayList<BitSet> encoding = DPCMEncode(imageIntegerArray);
        long encodingEnd = System.nanoTime();

        // grab total encoding bits
        int totalBits = 0;
        for (int i = 0; i < encoding.size(); i++) {
            // get this bit set
            BitSet temp = encoding.get(i);

            // get the number of bits for this BitSet
            totalBits += temp.length();
        }

        // perform decoding returning a list of integers representing
        // the decoded gray values
        long decodingStart = System.nanoTime();
        int[] decoding = DPCMDecode(encoding);
        long decodingEnd = System.nanoTime();

        // get the compression ratio
        double compressionRatio = (imageIntegerArray.length * 8) / (double) totalBits;

        // Print metrics - DPCM
        System.out.println("DPCM Encoding/Decoding Metrics");
        System.out.println("-----------------------------");
        System.out.println("Original Image Bit Size: " + imageIntegerArray.length * 8);
        System.out.println("Encoded Image Bit Size: " + totalBits);
        System.out.println("Compression Ratio: " + compressionRatio + "\n");
        System.out.println("Encoding Time: " + (encodingEnd - encodingStart) / 1000000000.0 + " seconds");
        System.out.println("Decoding Time: " + (decodingEnd - decodingStart) / 1000000000.0 + " seconds\n");
    }

    public static ArrayList<BitSet> DPCMEncode(int[] imageIntegerArray) {
        // create new array to hold the BitSet's
        ArrayList<BitSet> dpcmArray = new ArrayList<BitSet>();

        // add the first integer value from the image array to the BitSet,
        // this is the control/base value that starts the encoding process
        dpcmArray.add(Utility.convertSigned(imageIntegerArray[0]));

        // loop through each gray value in the image
        // except the first (the control)
        for (int i = 1; i < imageIntegerArray.length; i++) {
            // grab the first value
            int first = imageIntegerArray[i - 1];

            // grab the second value
            int second = imageIntegerArray[i];

            // calculate the difference which will be added to
            // the preceeding value during the decoding process
            int difference = second - first;

            // add the difference to the array of BitSets'
            dpcmArray.add(Utility.convertSigned(difference));
        }
        return dpcmArray;
    }

    public static int[] DPCMDecode(ArrayList<BitSet> encoding) {
        // initialize array of decoded gray values
        int[] decoding = new int[encoding.size()];

        // set the first decoded value to be the first encoded value
        // since it is the control
        decoding[0] = Utility.convertSigned(encoding.get(0));

        // loop through the encoded BitSet except for the first index (the
        // control)
        for (int i = 1; i < encoding.size(); i++) {
            // grab the difference which is the encoded
            // BitSet at this current index
            int difference = Utility.convertSigned(encoding.get(i));

            // set the gray value to be the previous gray value
            // plus the difference, this reverses the process and
            // decodes the value into plaintext
            decoding[i] = decoding[i - 1] + difference;
        }
        return decoding;
    }

    public static void Huffman(BufferedImage image) throws IOException {
        // grab the integer array representing the gray values of the image
        int[] imageIntegerArray = Utility.imageToIntegerArray(image);

        // start the encoding process returning a list of BitSets'
        long encodingStart = System.nanoTime();
        ArrayList<BitSet> encoding = HuffmanEncode(imageIntegerArray);
        long encodingEnd = System.nanoTime();

        // grab total encoding bits
        int totalBits = 0;
        for (int i = 0; i < encoding.size(); i++) {
            // get this bit set
            BitSet temp = encoding.get(i);

            // get the number of bits for this BitSet
            totalBits += temp.length();
        }

        // perform decoding returning a list of integers representing
        // the decoded gray values
        long decodingStart = System.nanoTime();
        int[] decoding = HuffmanDecode(encoding);
        long decodingEnd = System.nanoTime();

        // get the compression ratio
        double compressionRatio = (imageIntegerArray.length * 8) / (double) totalBits;

        // Print metrics - Huffman
        System.out.println("Huffman Encoding/Decoding Metrics");
        System.out.println("-----------------------------");
        System.out.println("Original Image Bit Size: " + imageIntegerArray.length * 8);
        System.out.println("Encoded Image Bit Size: " + totalBits);
        System.out.println("Compression Ratio: " + compressionRatio + "\n");
        System.out.println("Encoding Time: " + (encodingEnd - encodingStart) / 1000000000.0 + " seconds");
        System.out.println("Decoding Time: " + (decodingEnd - decodingStart) / 1000000000.0 + " seconds\n");
    }

    public static ArrayList<BitSet> HuffmanEncode(int[] imageIntegerArray) {
        return null;
    }

    public static int[] HuffmanDecode(ArrayList<BitSet> encoding) {
        return null;
    }
}