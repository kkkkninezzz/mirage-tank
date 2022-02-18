package cn.kurisu9.mirage.tank;

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
    public Rgba[][] toPixels(BufferedImage image, Function<Rgba, Rgba> rgbHandler) {
        int w = image.getWidth();
        int h = image.getHeight();

        Rgba[][] pixels = new Rgba[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int color = image.getRGB(j, i);
                final int r = (color >> 16) & 0xff;
                final int g = (color >> 8) & 0xff;
                final int b = color & 0xff;
                Rgba rgbData = new Rgba(r, g, b);
                pixels[i][j] = rgbHandler.apply(rgbData);
            }
        }

        return pixels;
    }

    /**
     * 将图片转换位像素点
     * */
    public Rgba[][] toPixels(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        Rgba[][] pixels = new Rgba[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int color = image.getRGB(j, i);
                final int r = (color >> 16) & 0xff;
                final int g = (color >> 8) & 0xff;
                final int b = color & 0xff;
                pixels[i][j] = new Rgba(r, g, b);
            }
        }

        return pixels;
    }

    public BufferedImage toImage(Rgba[][] pixels) {
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
}
