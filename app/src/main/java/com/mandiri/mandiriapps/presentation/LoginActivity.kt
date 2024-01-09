package com.mandiri.mandiriapps.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.mandiri.mandiriapps.databinding.ActivityLoginBinding
import com.mandiri.mandiriapps.helper.SharedPrefHelper
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    @Inject
    lateinit var sharedPrefHelper: SharedPrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleLogin()

        if (checkAvailableToken()){
            handleTo(HomeMainActivity::class.java)
        }


    }
    private fun handleLogin(){
        val username = "admin123"
//        val button = findViewById<LinearLayout>(R.id.llLogin)
//        val btnRegister = findViewById<TextView>(R.id.btnRegister)
//        val etInputUsername = findViewById<EditText>(R.id.etInputUsername)
//        val tvErrorPassword = findViewById<TextView>(R.id.tvErrorPassword)
        binding.apply {
            llLogin.setOnClickListener{
                if (etInputUsername.text.toString().equals(username)){
                    showToast("Berhasil")
//                Toast.makeText(applicationContext, "Berhasil", Toast.LENGTH_SHORT).show()
                    handleVisibility(tvErrorPassword, false)
                    handleTo(HomeMainActivity::class.java)

                    //shared preference
                    val dummyToken = UUID.randomUUID().toString()
                    sharedPrefHelper.saveToken(dummyToken)
                }else{
                    showToast("Gagal")
//                Toast.makeText(applicationContext, "Gagal", Toast.LENGTH_SHORT).show()
                    handleVisibility(tvErrorPassword, true)
                }
            }
            btnRegister.setOnClickListener {
                handleTo(RegisterActivity::class.java)
            }
        }




//        val inputDefault = 5
//        val etInputOne = findViewById<EditText>(R.id.etInputNumberOne)
//        val etInputTwo = findViewById<EditText>(R.id.etInputNumberTwo)
//        val button = findViewById<Button>(R.id.btnSubmit)
//        val tvResult = findViewById<TextView>(R.id.tvResult)
//
//        button.setOnClickListener{
//            if (etInputOne.text.isEmpty()||etInputTwo.text.isEmpty()){
//             Toast.makeText(applicationContext, "Inputan tidak boleh kosong", Toast.LENGTH_SHORT).show()
//            }else{
//            val resultInput = etInputOne.text.toString().toInt()*etInputTwo.text.toString().toInt()
////            Toast.makeText(applicationContext, resultInput.toString(), Toast.LENGTH_SHORT).show()
//            tvResult.text = resultInput.toString()
//            }
//        }
//        button.setOnClickListener{
//            Toast.makeText(applicationContext, "ini alert pertama saya", Toast.LENGTH_SHORT).show()
//        }
    }
    private fun checkAvailableToken(): Boolean{
        val token = sharedPrefHelper.getToken()
        return token.isNotEmpty()
    }
    private fun showToast(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
    private fun handleVisibility(view:View,isVisible: Boolean){
        view.isVisible = isVisible
    }
    private fun handleTo(clazz: Class<*>){
        val intent = Intent(this, clazz)
        startActivity(intent)

    }
//    private fun handleNaviagteToHome(){
//        val intent = Intent(this, ProfilActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
    private fun handleNaviagteToRegister(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}