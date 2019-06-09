package runLengthEncoding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

  public static byte[] readFile(String filename) throws IOException {
    byte[] array={};
    array = Files.readAllBytes(new File(filename).toPath());
    return array;
  }
  public static void writeFile(String filename, byte[] writeBytes) throws IOException{
    try (FileOutputStream stream = new FileOutputStream(filename)) {
      stream.write(writeBytes);
    }
  }

  public static void main(String[] arg) {
    String[] args = {"encode", "F:\\tmp\\t1.bmp", "F:\\tmp\\t2.bmp"};
    if(args.length==3){
      if(args[0].equals("encode")){
        byte[] readBytes = {};
        try{
          readBytes=readFile(args[1]);
        }
        catch (IOException e){
          System.out.println("Cannot open file");
        }
        byte[] encodedBytes = Encode.encode(readBytes);
        try{
          writeFile(args[2],encodedBytes);
        }
        catch (IOException e){
          System.out.println("Cannot open file");
        }
      }
      else if(args[0].equals("decode")){
        byte[] readBytes = {};
        try{
          readBytes=readFile(args[1]);
        }
        catch (IOException e){
          System.out.println("Cannot open file");
        }
        byte[] decodedBytes = Decode.decode(readBytes);
        try{
          writeFile(args[2],decodedBytes);
        }
        catch (IOException e){
          System.out.println("Cannot open file");
        }

      }
      else{
        System.out.println("Usage:java Main decode/encode infile outfile");
      }
    }
    else{
      System.out.println("Usage:java Main decode/encode infile outfile");
      System.exit(1);
    }
  }
}
