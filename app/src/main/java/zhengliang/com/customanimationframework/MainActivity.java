package zhengliang.com.customanimationframework;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import zhengliang.com.customanimationframework.AnimatorPath.AnimatorPath;
import zhengliang.com.customanimationframework.AnimatorPath.PathEvaluator;
import zhengliang.com.customanimationframework.AnimatorPath.PathPoint;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton fab;
    private AnimatorPath path;//声明动画集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.fab = (FloatingActionButton) findViewById(R.id.fab);

        setPath();

        fab.setOnClickListener(this);
    }
    /*设置动画路径*/
    public void setPath(){
        path = new AnimatorPath();
        path.moveTo(0,0);
        path.lineTo(400,400);
        path.secondBesselCurveTo(600, 200, 800, 400); //订单
        path.thirdBesselCurveTo(100,600,900,1000,200,1200);
    }

    /**
     * 设置动画
     * @param view 使用动画的View
     * @param propertyName 属性名字
     * @param path 动画路径集合
     */
    private void startAnimatorPath(View view, String propertyName, AnimatorPath path) {
        ObjectAnimator anim = ObjectAnimator.ofObject(this, propertyName, new PathEvaluator(), path.getPoints().toArray());
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setDuration(3000);
        anim.start();
    }

    /**
     * 设置View的属性通过ObjectAnimator.ofObject()的反射机制来调用
     * @param newLoc
     */
    public void setFab(PathPoint newLoc) {
        fab.setTranslationX(newLoc.mX);
        fab.setTranslationY(newLoc.mY);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab:
                startAnimatorPath(fab, "fab", path);
                break;
        }
    }
}
