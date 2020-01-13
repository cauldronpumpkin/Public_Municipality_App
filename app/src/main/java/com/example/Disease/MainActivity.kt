package com.example.Disease

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(this.toolbar)
        toolbar.subtitle = "Changing lifes"
        toolbar.setLogo(R.drawable.logo)

        submit.setOnClickListener {
            val dialog = ProgressDialog(this)
            dialog.setMessage("Please Wait ...")
            dialog.setCancelable(false)
            dialog.show()
            val Email:String = txvEmail.text.toString()
            val Ailment:String = txvDisease.text.toString()
            val Locality:String = txvLocality.text.toString()
            val instance = Object (Email, Ailment, Locality)
            val db = FirebaseFirestore.getInstance()
            db.collection("Model").add(instance)
                .addOnSuccessListener(OnSuccessListener<DocumentReference>() {
                    dialog.dismiss()
                    Toast.makeText(this, "Your Info has been Added.", Toast.LENGTH_SHORT).show()
                    txvEmail.text.clear()
                    txvDisease.text.clear()
                    txvLocality.text.clear()
                })
                .addOnFailureListener(OnFailureListener() {
                    Toast.makeText(this, "Your Info was not added.", Toast.LENGTH_SHORT).show()
                });

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
