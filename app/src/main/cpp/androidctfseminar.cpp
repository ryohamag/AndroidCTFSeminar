// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("androidctfseminar");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("androidctfseminar")
//      }
//    }

#include <jni.h>
#include <string>

// パッケージ名とクラス名に合わせて関数名を定義する必要があります。
// 規則: Java_パッケージ名_クラス名_メソッド名 (ドットはアンダースコアに置換)
extern "C" JNIEXPORT jstring JNICALL
Java_com_websarva_wings_androidctfseminar_MainActivity_getFlagFromJNI(
        JNIEnv* env,
        jobject /* this */) {

    // ここにFlagを記述します。
    // 単純な文字列だとバイナリ解析コマンド(strings)で見えてしまうため、
    // CTF的には一文字ずつ配列に入れる「スタックストリング」などが有効です。
    char flag[] = { 'F', 'L', 'A', 'G', '{', 'H', 'e', 'l', 'l', 'o', '_', 'J', 'N', 'I', '}', 0 };

    return env->NewStringUTF(flag);
}