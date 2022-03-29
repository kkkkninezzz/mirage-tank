package cn.kurisu9.mirage.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author kurisu9
 * @description 入口
 * @date 2022/2/15 17:20
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedImage outside = ImageIO.read(new File("pic/outside.jpg"));
        BufferedImage inside = ImageIO.read(new File("pic/inside.jpg"));

        MirageTank mirageTank = new MirageTank();
        BufferedImage result = mirageTank.outputGrey(outside, inside, GreyParams.getDefault());
        ImageIO.write(result, "png", new File("pic/result.png"));
    }
}
