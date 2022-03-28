package cn.kurisu9.mirage.tank;

/**
 * @author kurisu9
 * @description rgba参数
 * @date 2022/2/16 10:13
 **/
public class RgbData {
     double alpha;

     double red;

     double green;

     double blue;

     public RgbData(double red, double green, double blue) {
          this.red = red;
          this.green = green;
          this.blue = blue;
     }

     public RgbData(double alpha, double red, double green, double blue) {
          this.alpha = alpha;
          this.red = red;
          this.green = green;
          this.blue = blue;
     }

     public int toRGB() {
          int newPixel = 0;
          newPixel += (int) alpha;
          newPixel = newPixel << 8;
          newPixel += (int) red;
          newPixel = newPixel << 8;
          newPixel += (int) green;
          newPixel = newPixel << 8;
          newPixel += (int) blue;

          return newPixel;
     }
}
