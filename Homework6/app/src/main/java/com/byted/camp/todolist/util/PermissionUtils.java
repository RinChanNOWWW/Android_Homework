package com.byted.camp.todolist.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * @author zhongshan
 * 2020-04-19.
 */
public class PermissionUtils {

    private static final String TAG = "PermissionUtils";

    private PermissionUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean hasPermissions(Context context, String... perms) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            Log.w(TAG, "PermissionUtils hasPermissions: API version < M, returning true by default");
            // DANGER ZONE!!! Changing this will break the library.
            return true;
        }
        if (context == null) {
            throw new IllegalArgumentException("Can't check permissions for null context");
        }
        for (String perm : perms) {
            if (ContextCompat.checkSelfPermission(context, perm) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
}
