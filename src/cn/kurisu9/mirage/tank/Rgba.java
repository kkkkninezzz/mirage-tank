package cn.kurisu9.mirage.tank;

/**
 * @author kurisu9
 * @description rgba参数
 * @date 2022/2/16 10:13
 **/
public class Rgba {
     int alpha;

     int red;

     int green;

     int blue;

     public Rgba(int alpha, int red, int green, int blue) {
          this.alpha = alpha;
          this.red = red;
          this.green = green;
          this.blue = blue;
     }

     public Rgba(int red, int green, int blue) {
          this.red = red;
          this.green = green;
          this.blue = blue;
     }

     public int toRGB() {
          int newPixel = 0;
          newPixel += alpha;
          newPixel = newPixel << 8;
          newPixel += red;
          newPixel = newPixel << 8;
          newPixel += green;
          newPixel = newPixel << 8;
          newPixel += blue;

          return newPixel;
     }
}
