package cn.kurisu9.mirage.tank;

import cn.kurisu9.mirage.tank.miragetank.MirageTank;

import java.awt.image.BufferedImage;
import java.util.function.Function;

/**
 * @author kurisu9
 * @description 图片工具类
 * @date 2022/2/16 10:18
 **/
public enum ImageUtils {
    INSTANCE;

    /**
     * 将图片转换位像素点
     * */
    public RgbData[][] getPixels(BufferedImage image, Function<RgbData, RgbData> rgbHandler) {
        int w = image.getWidth();
        int h = image.getHeight();

        RgbData[][] pixels = new RgbData[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int color = image.getRGB(j, i);
                final int r = (color >> 16) & 0xff;
                final int g = (color >> 8) & 0xff;
                final int b = color & 0xff;
                RgbData rgbData = new RgbData(r, g, b);
                pixels[i][j] = rgbHandler.apply(rgbData);
            }
        }

        return pixels;
    }

    /**
     * 将像素点转换为图片
     * */
    public static BufferedImage toImage(RgbData[][] pixels) {
        int h = pixels.length;
        int w = pixels[0].length;

        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                image.setRGB(j, i, pixels[i][j].toRGB());
            }
        }

        return image;
    }

    /**
     * 将图片转换位像素点
     * */
    public RgbData[][] toPixels(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        RgbData[][] pixels = new RgbData[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int color = image.getRGB(j, i);
                final int r = (color >> 16) & 0xff;
                final int g = (color >> 8) & 0xff;
                final int b = color & 0xff;
                pixels[i][j] = new RgbData(r, g, b);
            }
        }

        return pixels;
    }
}
