package com.example.seniledementia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.seniledementia.databinding.ActivityMainBinding
import android.util.Log
import android.view.View
import com.google.android.gms.common.api.internal.RegisterListenerMethod
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import java.util.SimpleTimeZone

class MainActivity : Activity() {

    /**
     * lateinit: 初期化関数の呼び出しの段階まで変数の初期化ができないことがある時にvalの代わりに使用。
     * onCreate()の呼び出しまで遅延させている
     * 変数を lateinit 宣言することにより、non-null な初期化済みの変数として参照することができる
     * ただし、参照する前に必ず初期化（代入）されていることが条件
     * 初期化前に lateinit 変数を参照すると、UninitializedPropertyAccessException が発生
     */
    private lateinit var binding: ActivityMainBinding

    // 対応ボタン
    private lateinit var sureButton: Button

    // 応援ボタン
    private lateinit var cheerButton: Button

    private lateinit var loginButton: Button

    private lateinit var registerButton: Button

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

        getFirebaseToken()

        sureButton = findViewById(R.id.sure_button)
        cheerButton = findViewById(R.id.cheer_button)
        loginButton = findViewById(R.id.launch_login_button)
        registerButton = findViewById(R.id.launch_register_button)

        sureButton.text = "対応"
        cheerButton.text = "応援"

        loginButton.setOnClickListener {
            var intent = Intent(application, LoginActivity::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            var intent = Intent(application, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * FirebaseのTokenを取得
     */
    private fun getFirebaseToken() {

        var TAG = "MyLog"

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast
            val msg = getString(R.string.msg_token_fmt, token)
            Log.d(TAG, "firebase Token is:")
            Log.d(TAG, msg)
            Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
        })
    }
}