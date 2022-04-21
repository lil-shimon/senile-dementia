package com.example.seniledementia

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.seniledementia.databinding.ActivityMainBinding

class MainActivity : Activity() {

    /**
     * lateinit: 初期化関数の呼び出しの段階まで変数の初期化ができないことがある時にvalの代わりに使用。
     * onCreate()の呼び出しまで遅延させている
     * 変数を lateinit 宣言することにより、non-null な初期化済みの変数として参照することができる
     * ただし、参照する前に必ず初期化（代入）されていることが条件
     * 初期化前に lateinit 変数を参照すると、UninitializedPropertyAccessException が発生
     */
    private lateinit var binding: ActivityMainBinding

    // 返信したメッセージ
    private lateinit var reply: TextView

    // 対応ボタン
    private lateinit var sureButton: Button

    // 応援ボタン
    private lateinit var cheerButton: Button

    /**
     * 基底クラスMainActivityのonCreateメソッドをoverrideしている
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * super
         * 親クラスを継承した子供クラスのメソッドを実行する際に
         * その場所で親クラスでのメソッド定義で呼び出す場合に使う
         * override fun [onCreate] (savedInstanceState: Bundle?) {
         *  super. [onCreate] (savedInstanceState)
         */
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        reply = findViewById(R.id.reply)
        sureButton = findViewById(R.id.sure_button)
        cheerButton = findViewById(R.id.cheer_button)

        reply.text = ""
        sureButton.text = "対応"
        cheerButton.text = "応援"
    }
}