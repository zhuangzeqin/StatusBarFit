package statusbar.demo.zzq.cn.eeepay.com.statusbarfit;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

 /**
  * 描述：沉浸式状态栏抽象类
  * 作者：zhuangzeqin
  * 时间: 2018/6/27-0:39
  * 邮箱：zzq@eeepay.cn
  */
public abstract class BaseFitsSystemWindowsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //4.4 以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setHeight(mToolbar);
        }
    }

    /**
     * 以ToolBar为例,动态设置ToolBar的高度,并且设置一个padding，top为状态栏的高度，
     * @param view
     */
    public void setHeight(View view) {
        // 获取actionbar的高度
        TypedArray actionbarSizeTypedArray = obtainStyledAttributes(new int[]{
                android.R.attr.actionBarSize
        });
        float height = actionbarSizeTypedArray.getDimension(0, 0);
        // ToolBar的top值
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        double statusBarHeight = getStatusBarHeight(this);
        lp.height = (int) (statusBarHeight + height);
        view.setPadding(0,(int) statusBarHeight,0, 0);
        mToolbar.setLayoutParams(lp);
    }

    private double getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
