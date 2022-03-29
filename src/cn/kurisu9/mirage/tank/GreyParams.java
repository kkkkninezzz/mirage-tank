package cn.kurisu9.mirage.tank;

/**
 * 灰色幻影坦克的参数
 *
 * @author knine
 * @date 2022/3/29 21:29
 **/
public class GreyParams {
    /**
     * 表图的亮度比例
     * */
    float outsideLight = 1.0f;

    /**
     * 里图的亮度比例
     * */
    float insideLight = 0.3f;

    private static final GreyParams DEFAULT = new GreyParams();

    public static GreyParams getDefault() {
        return DEFAULT;
    }
}
