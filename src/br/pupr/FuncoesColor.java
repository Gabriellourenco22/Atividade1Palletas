package br.pupr;
import com.sun.javafx.geom.Vec3d;

import java.awt.*;

/**
 * Created by Gabriel on 18/03/2018.
 */
public class FuncoesColor {

        public static float Distance (Color color1, Color color2)
        {
            Vec3d colorVec1 = new Vec3d(color1.getRed(), color1.getGreen(), color1.getBlue());
            Vec3d colorVec2 = new Vec3d(color2.getRed(), color2.getGreen(), color2.getBlue());

            return Distance(colorVec1, colorVec2);
        }
//SQRT((R1-R2^2)+(G1-G2^2)+(B1-B2^2))=distance
    public static float Distance(Vec3d vec1, Vec3d vec2)
    {

        double xPow = Math.pow(vec1.x-vec2.x,2);
        double yPow = Math.pow(vec1.y-vec2.y,2);
        double zPow = Math.pow(vec1.z-vec2.z,2);

        double result = Math.sqrt(xPow+yPow+zPow);

        return (float)result;

    }

    public static Color HexToColor(int hex)
    {
        int r = (hex & 0xFF0000) >> 16;
        int g = (hex & 0xFF00) >> 8;
        int b = (hex & 0xFF);

        return new Color(r,g,b);
    }


    public static Color ColorNear(Color colorRerence , int[] hexPallet)
    {

        float minDistance = Float.MAX_VALUE;
        Color result = new Color(0,0,0);

        for (int hcolor : hexPallet)
        {

            Color colorTarget = HexToColor(hcolor);

            float current_dist = Distance(colorRerence,colorTarget);
            if(minDistance > current_dist)
            {
                minDistance = current_dist;
                result = colorTarget;
            }
        }

        return result;
    }
}




