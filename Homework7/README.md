# 2020/4/27 作业六

## 一个简单的视频播放器

**基础版要求：**

1. 播放、暂停功能；

2. 播放进度条展示（包括时间显示）、点击/滑动跳转到指定位置。

3. 横竖屏切换、横屏时展示全屏模式。

**Pro 版要求：**

1. 将app注册为播放器类型(Action为 ACTION_VIEW，Data为 Uri，Type 为其 MIME 类型)，点击打开系统视频文件时，可以选择使用自制播放器；
2. 手机相册中，录制视频列表展示，点击调起播放器。

**实现方法与注意要点**：

- 使用 VideoView + MediaController 来实现，因为其可以自己处理横屏的情况。
- VideoView 的会在 onSaveInstanceState 之前就清零，保存进度需要在 onPause 时进行（先利用生命周期更长成员变量保存，再将此变量传入 saveInstance）。
- Pro 版本在基础版本的基础上利用 Intent 获取打开视频的地址（可以是网络或者本地的）。
- Pro 版本中需要将 intent-filter 中的 category 设置为 BROWSABLE，并设置 data 的 scheme 为 file（以及 http 等）。

**演示效果：**

- 基础版本演示

  <img src="pics/1.gif" Height=500/>

- Pro 版本演示

  <img src="pics/2.gif" width=300>