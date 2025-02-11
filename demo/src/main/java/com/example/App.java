package com.example;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Starting Instantly-Grammit..." );
        MainFrame.main(new String[0]);
    }

    public static void gram(){
        BufferedImage src;
        ImageManager imageMan = new ImageManager();
        try {
            src = imageMan.getSourceImage();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        var targetImage = addBars(src);
        try {
            imageMan.saveTargetImage(targetImage);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Add vertical or horizontal bars to make the image square
     * @param source
     * @return
     */
    private static BufferedImage addBars(BufferedImage source) {
        int width = source.getWidth();
        int height = source.getHeight();
        if (width == height) {
            // Width and height equal, no need for bars
            return source;
        } else if (width>height) {
            return addHorizontalBars(source);
        } else {
            return addVerticalBars(source);
        }
    }

    private static BufferedImage addHorizontalBars(BufferedImage source){
        int width = source.getWidth();
        int height = source.getHeight();
        BufferedImage borderedImg = new BufferedImage(width, width, BufferedImage.TYPE_3BYTE_BGR);
        borderedImg.createGraphics();
                    
        Graphics2D g = (Graphics2D) borderedImg.getGraphics();
        g.setColor(Color.black);

        g.drawImage(source, 0, (width-height)/2, null);
        return borderedImg;
    }
    
    private static BufferedImage addVerticalBars(BufferedImage source){
        int width = source.getWidth();
        int height = source.getHeight();
        BufferedImage borderedImg = new BufferedImage(height, height, BufferedImage.TYPE_3BYTE_BGR);
        borderedImg.createGraphics();
                    
        Graphics2D g = (Graphics2D) borderedImg.getGraphics();
        g.setColor(Color.black);

        g.drawImage(source, (height-width)/2, 0, null);
        return borderedImg;
    }
}
