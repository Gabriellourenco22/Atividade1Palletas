package br.pupr;

import com.sun.javafx.geom.Vec3d;
import com.sun.javafx.geom.Vec3f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import br.pupr.FuncoesColor;


/**
 * Created by Gabriel on 17/03/2018.
 */
public class Atividade1 {
    static int[] pallete48 = { //pinterest
            0xD2E3F5, 0x2F401E, 0x3E0A11, 0x4B3316, 0xA5BDE5, 0x87A063, 0x679327, 0x3A1B0F, 0x928EB1, 0xBFE8AC, 0xA4DA65, 0x5A3810, 0x47506D, 0x98E0E8, 0x989721, 0x8E762C, 0x0B205C, 0x55BEd7, 0xB8B366, 0xD8C077, 0x134D9C, 0x2A6E81, 0xE1EAB6, 0xF0DEA6, 0xFFF3D0, 0x610A0A, 0x7D000E, 0x45164B, 0xFFFCCC, 0x6B330F, 0x990515, 0x250D3B, 0xB24801, 0x8B4517, 0xE0082D, 0x50105A, 0xFFF991, 0xB96934, 0xC44483, 0x8E2585, 0xDF5900, 0xF8A757, 0xC44483, 0xD877CF, 0xFFEF00, 0xDF7800, 0xF847CE, 0xF0A6E8};

    public static void main(String[] args) throws IOException {

        File PATH = new File("C:/Users/Gabriel Lourenço/Pictures/img/cor");
        BufferedImage origin = ImageIO.read(new File(PATH,"puppy.jpg"));
        BufferedImage outImage = new BufferedImage(origin.getWidth(), origin.getHeight(), BufferedImage.TYPE_INT_RGB);



        for (int y = 0; y < outImage.getHeight(); y++)
        {
            for (int x = 0; x < outImage.getWidth(); x++)
            {
                //Cor do pixel xy da imagem
                Color pixelColor = new Color(origin.getRGB(x, y));

                double distancia = Float.MAX_VALUE;
                Color result = Color.BLACK;

                for (int a = 0; a< pallete48.length; a++)
                {
                    int hexColor = pallete48[a];
                    Color convertedColor = HexToColor(hexColor);

                    //SQRT((R1-R2^2)+(G1-G2^2)+(B1-B2^2))=distance
                    double dist =  Math.sqrt( Math.pow(convertedColor.getRed()-pixelColor.getRed(),2)
                            +Math.pow(convertedColor.getGreen()-pixelColor.getGreen(),2)
                            +Math.pow(convertedColor.getBlue()-pixelColor.getBlue(),2));

                    if(dist < distancia)
                    {
                        result = convertedColor;
                        distancia = dist;
                    }
                }



                outImage.setRGB(x, y, result.getRGB());                
            }
        }






        ImageIO.write(outImage, "jpg", new File("puppy2.jpg"));
    }

    /**
     * Converte Hexadcimal para Objeto COLOR
     * @param hex Hexadecimal
     * @return Retorna objeto cor
     */
    public static Color HexToColor(int hex)
    {
        int r = (hex & 0xFF0000) >> 16;
        int g = (hex & 0xFF00) >> 8;
        int b = (hex & 0xFF);

        Color color = new Color(r,g,b);

        return color;
    }
}



