package statusbar.demo.zzq.cn.eeepay.com.statusbarfit;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseFitsSystemWindowsActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected String setTitle() {
        return "沉浸式状态栏";
    }

    @Override
    protected void initView() {
//        mToolbar.setBackgroundColor(getResources().getColor(R.color.unify_txt_color_ff7e00));//颜色设置
        mToolbar.setBackgroundResource(R.mipmap.icon_shopping_goods_bg);//图片
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        getTv_rightTitle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "aaaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
