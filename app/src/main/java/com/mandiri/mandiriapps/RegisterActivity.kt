package com.mandiri.mandiriapps

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.mandiriapps.databinding.ActivityRegisterBinding

class RegisterActivity:AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener{
            handleRegister()
        }
    }

    private fun handleRegister(){
        with(binding){
            val nameValue = binding.etName.text.toString()
            val gendervalue = binding.etGender.text.toString()
            val alamatValue = binding.etAlamat.text.toString()
            val umurValue = binding.etUmur.text.toString()

            if (nameValue.isEmpty()||gendervalue.isEmpty()||alamatValue.isEmpty()||umurValue.isEmpty()){
                Toast.makeText(applicationContext, "Tolong isi dengan lengkap", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this@RegisterActivity, ProfilActivity::class.java)

                intent.putExtra(KEY_NAME_VALUE,nameValue)
                intent.putExtra(KEY_GENDER_VALUE, gendervalue)
                intent.putExtra(KEY_ALAMAT_VALUE, alamatValue)
                intent.putExtra(KEY_UMUR_VALUE, umurValue)
                startActivity(intent)
            }
        }

    }
    companion object{
        const val KEY_NAME_VALUE = "key_name_value"
        const val KEY_GENDER_VALUE = "key_gender_value"
        const val KEY_ALAMAT_VALUE = "key_alamat_value"
        const val KEY_UMUR_VALUE = "key_umur_value"
    }
}