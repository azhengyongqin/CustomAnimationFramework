package zhengliang.com.customanimationframework.AnimatorPath;

/**
 * Created by zhengliang on 2016/10/15 0015.
 * 记录view移动动作的坐标点
 */

public class PathPoint {
    /**
     * 起始点操作
     */
    public static final int MOVE=0;
    /**
     * 直线路径操作
     */
    public static final int LINE=1;
    /**
     * 二阶贝塞尔曲线操作
     */
    public static final int SECOND_CURVE =2;
    /**
     * 三阶贝塞尔曲线操作
     */
    public static final int THIRD_CURVE=3;
    /**
     * View移动到的最终位置
     */
    public float mX,mY;
    /**
     * 控制点
     */
    public float mContorl0X,mContorl0Y;
    public float mContorl1X,mContorl1Y;
    //操作符
    public int mOperation;

    /**
     * Line/Move都通过该构造函数来创建
     */
    public PathPoint(int mOperation,float mX, float mY ) {
        this.mX = mX;
        this.mY = mY;
        this.mOperation = mOperation;
    }

    /**
     * 二阶贝塞尔曲线
     * @param mX
     * @param mY
     * @param mContorl0X
     * @param mContorl0Y
     */
    public PathPoint(float mContorl0X, float mContorl0Y,float mX, float mY) {
        this.mX = mX;
        this.mY = mY;
        this.mContorl0X = mContorl0X;
        this.mContorl0Y = mContorl0Y;
        this.mOperation = SECOND_CURVE;
    }

    /**
     * 三阶贝塞尔曲线
     * @param mContorl0x
     * @param mContorl0Y
     * @param mContorl1x
     * @param mContorl1Y
     * @param mX
     * @param mY
     */
    public PathPoint(float mContorl0x, float mContorl0Y, float mContorl1x, float mContorl1Y,float mX, float mY) {
        this.mX = mX;
        this.mY = mY;
        this.mContorl0X = mContorl0x;
        this.mContorl0Y = mContorl0Y;
        this.mContorl1X = mContorl1x;
        this.mContorl1Y = mContorl1Y;
        this.mOperation = THIRD_CURVE;
    }

    /**
     * 为了方便使用都用静态的方法来返回路径点
     */
    public static PathPoint moveTo(float x, float y){
        return new PathPoint(MOVE,x,y);
    }
    public static PathPoint lineTo(float x,float y){
        return  new PathPoint(LINE,x,y);
    }
    public static PathPoint secondBesselCurveTo(float c0X, float c0Y,float x,float y){
        return new PathPoint(c0X,c0Y,x,y);
    }
    public static PathPoint thirdBesselCurveTo(float c0X, float c0Y, float c1X, float c1Y, float x, float y){
        return new PathPoint(c0X,c0Y,c1X,c1Y,x,y);
    }
}
