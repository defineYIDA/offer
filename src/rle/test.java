package rle;

/**
 * @Author: zl
 * @Date: 2019/6/9 21:34
 */
import java.awt.Color;
        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;
        import java.net.URISyntaxException;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import javax.imageio.ImageIO;



/**
 *
 * @author Ayoub MOUSTAID
 */
public class test {
    BufferedImage image,newImage;
    int width,height;
    final int MAX_IMAGE_HEIGHT=5000;

    public test() throws IOException
    {
        Initializer("rle.png");
        algorithme();

    }


    //application of the algorithme
    private void algorithme()
    {

        Color c;
        int i,j,k=2;//k: used to verify even the pixel is pair or impair
        int cursorWidth=0,cursorHeight=0;

        for(i=0;i<height;i++)
        {
            for(j=0;j<width;j++)
            {
                //to ignore the two first pixels
                if((i==0 && j<2)){
                    System.out.println("unverified");
                }
                else{
                    c=new Color(image.getRGB(j, i));
                    //executed only if it's an impair pixel
                    if(k%2==0)
                    {
                        for(int z=0;z<c.getBlue();z++)
                        {
                            //if we attend the width of the image
                            if(j+1>width)
                            {
                                newImage.setRGB(cursorWidth, cursorHeight, image.getRGB(0, i+1));
                            }
                            else
                            {
                                newImage.setRGB(cursorWidth, cursorHeight, image.getRGB(j+1, i));
                            }
                            cursorWidth++;
                            //if we attend the width we add new line (we increment height)
                            if(cursorWidth>=width)
                            {
                                cursorHeight++;
                                cursorWidth=0;
                            }
                        }
                    }
                    k++;
                }
            }
        }
        //retrievng the exact image
        newImage=newImage.getSubimage(0, 0, width, cursorHeight);
        //creating the image
        createImage("decompressedPicture",newImage,"png");
    }

    //method to initialize the image, width and the height and the new image
    private void Initializer(String url)
    {

        try {
            image = ImageIO.read(new File("F:\\tmp\\doraemon.jpg"));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /*catch (URISyntaxException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        height=image.getHeight();
        width=image.getWidth();
        newImage=new BufferedImage(width,MAX_IMAGE_HEIGHT,BufferedImage.TYPE_INT_RGB);
    }

    //method to create the new image
    private void createImage(String name,BufferedImage img,String format) {
        try {
            System.out.println("creating img");
            File ff=new File("F:\\tmp\\"+name+"."+format);
            System.out.println(ImageIO.write(img, format,ff ));
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        new test();

    }

}