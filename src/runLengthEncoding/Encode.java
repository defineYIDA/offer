package runLengthEncoding;

public class Encode {

  public static byte[] encode(byte[] readBytes) {
    byte[] writeBytes = new byte[readBytes.length];

    //Repition count of current byte
    int count = 0;

    //Keep track of smaller index
    int writeCount=0;

    for (int i = 0; i < readBytes.length ; i++) {
      //Exit the program if the file is going to be larger than the original
      if(writeCount > readBytes.length - 3){
        System.out.println("File cannot be compressed with this algorithm");
        System.exit(1);
      }

      //Check we arent tring to access outside array
      if (i!=readBytes.length-1 && readBytes[i] == readBytes[i+1]) {
        count = 2;

        while (i < readBytes.length - 2) {
          //Move to next byte
          i++;
          //Max size for signed int in a byte is 127
          if (readBytes[i] == readBytes[i+1] && count < 127) {
            count++;
          }
          else {
            break;
          }

        }
        //Write count of byte to array
        writeBytes[writeCount]=(byte)count;
        writeCount++;
        //Write the byte to array
        writeBytes[writeCount]=readBytes[i];
        writeCount++;
      }
      //Write a byte alone
      else {
        writeBytes[writeCount]=(byte)1;
        writeCount++;
        writeBytes[writeCount]=readBytes[i];
        writeCount++;
      }
    }
    //Remove null values at end of byte array
    byte[] cleanBytes = new byte[writeCount];
    for(int i=0;i<writeCount;i++){
      cleanBytes[i] = writeBytes[i];
    }
    return cleanBytes;
  }
}
