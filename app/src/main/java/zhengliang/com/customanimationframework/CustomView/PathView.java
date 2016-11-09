package zhengliang.com.customanimationframework.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 时 间: 2016/11/8 0008
 * 作 者: 郑亮
 * Q  Q : 1023007219
 */

public class PathView extends View {

    private Paint paint;


    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //防抖动
        paint.setDither(true);
        //设置画笔未实心
        paint.setStyle(Paint.Style.STROKE);
        //设置颜色
        paint.setColor(Color.GREEN);
        //设置画笔宽度
        paint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        path.moveTo(60,60);
        path.lineTo(460,460);
        path.quadTo(660, 260, 860, 460); //订单
        path.cubicTo(160,660,960,1060,260,1260);
        canvas.drawPath(path,paint);
    }
}
