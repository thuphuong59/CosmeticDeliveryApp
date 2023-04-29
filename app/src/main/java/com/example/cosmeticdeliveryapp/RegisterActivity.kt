package com.example.cosmeticdeliveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.accessibility.AccessibilityEventSource
import android.widget.Toast
import com.example.cosmeticdeliveryapp.databinding.ActivityLoginBinding
import com.example.cosmeticdeliveryapp.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()


        binding.btnRegister.setOnClickListener{
            val email = binding.email.text.toString()
            val pass = binding.password.text.toString()
            val confirm = binding.confirm.text.toString()
            val nphone = binding.phone.text.toString()

        if (email.isNotEmpty() && pass.isNotEmpty() && confirm.isNotEmpty() && nphone.isNotEmpty()){

            if(pass==confirm){
            firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                if (it.isSuccessful){
                   updateUserInfo(email,nphone)
                }else {
                    Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                }
            }
            }else{
                Toast.makeText(this,"Password is not matching !",Toast.LENGTH_SHORT).show()
            }

        }else{
            Toast.makeText(this,"Empty Fields are not allowed !",Toast.LENGTH_SHORT).show()
        }

        }
    }
    private fun updateUserInfo(email:String, phone:String ) {

        val timestamp = System.currentTimeMillis()

        val uid = firebaseAuth.uid!!
        val hashMap: HashMap<String, Any?> =  HashMap()
        hashMap["uid"] = uid
        hashMap["profileImage"] = "" //empty add in edit
        hashMap["username"]=""
        hashMap["userType"] = "user"
        hashMap["phone"]= phone
        hashMap["timestamp"] = timestamp


        // set data to db
        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(uid)
            .setValue(hashMap)
            .addOnSuccessListener {
                Toast.makeText(this, "creating account successfully", Toast.LENGTH_SHORT).show()
                finish()
                startActivity(Intent(this, LoginActivity::class.java))
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed creating account due to ${it.message}", Toast.LENGTH_SHORT).show()
            }

    }
}