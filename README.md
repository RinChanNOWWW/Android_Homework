# 移动互联网技术及应用 Android 开发

## 2020/3/16 作业一

1. 使用至少五种视图控件。
2. 实现简单交互。

	**解题过程**：我使用了 `ImageView`, `Switch`, `TextView`, `RadioGroup`, `RadioButton`, `Button`。

## 2020/3/23 作业二

1. Logcat在屏幕旋转的时候 `onStop()` 和 `onDestroy()` 会展示出来，但UI界面我们看不到，在今天课程基础上想办法补全它，让其跟 Logcat 的展示一样。

	**解题过程**：本题使用比 `Acitivity` 生命周期更长的 `Application` 来保存 `onSaveInstanceState()` 之后的 Log，并在重启之后将 Log 字符串返回给 `TextView`。

2. 一个抖音笔试题：统计页面所有 view 的个数。ViewGroup 中的 API: `getChildCount()`, `getChildAt()`。

	**解题过程**：整个 `ViewGroup` 其实就是一个广义表，`ViewGroup` 中可以继续有 `ViewGroup` 或 `View`（当然也可以为空）。所以要遍历广义表（或者可以称之为多叉树，因为一开始有一个根），可以采用广度优先搜索或深度优先搜索。在这里我不想用递归，所以采用了广度优先搜索。

3. 实现一个类似抖音消息页面，并且点击每个 `RecycleView` 的 item，能够跳转到一个新的界面，并且在新的页面显示出他是第几个 item。