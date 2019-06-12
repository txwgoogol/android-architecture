package top.txwgoogol.weather.todomvp.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Dialog工具类
 * https://blog.csdn.net/new_one_object/article/details/56672315  Dialog使用
 */
public class DialogUtils {

    private Context mContext;

    public DialogUtils(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 显示Dialog
     *
     * @return
     */
    public void show() {
        new AlertDialog.Builder(mContext)
                .setTitle("标题")
                .setMessage("内容")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .create().show();
    }

    /**
     * 隐藏Dialog
     *
     * @return
     */
    public void disMiss() {
        new AlertDialog.Builder(mContext)
                .setTitle("标题")
                .setMessage("内容")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .create().dismiss();
    }
}