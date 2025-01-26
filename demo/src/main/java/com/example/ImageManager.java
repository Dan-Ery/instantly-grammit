package com.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class ImageManager {
    public BufferedImage getSourceImage() throws IOException{
        String sourcePath = getSrcImagePath();
        return ImageIO.read(new File(sourcePath));
    }
    public void saveTargetImage(BufferedImage targetImage) throws IOException{
        String targetPath = getTargetImagePath();
        File outputFile = new File(targetPath);
        ImageIO.write(targetImage, "png", outputFile);
    }

    private String getSrcImagePath(){
        JFileChooser j = new JFileChooser();
        int r = j.showOpenDialog(null);

        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION)
 
        {
            // set the label to the path of the selected file
            return (j.getSelectedFile().getAbsolutePath());
        }
        // if the user cancelled the operation
        else{
            return null;
        }
    }

    private String getTargetImagePath(){
        
        JFileChooser j = new JFileChooser();
        int r = j.showSaveDialog(null);
        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION)
        
        {
            // set the label to the path of the selected file
            return (j.getSelectedFile().getAbsolutePath());
        }
        // if the user cancelled the operation
        else{
            return null;
        }

    }
}
