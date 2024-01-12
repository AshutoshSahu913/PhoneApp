package com.example.phoneapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import com.example.phoneapp.RoomDB.DbBuilder
import com.example.phoneapp.RoomDB.Entity.Contact
import com.example.phoneapp.databinding.ActivityAddEditBinding

class AddEditActivity : AppCompatActivity() {
    private val binding: ActivityAddEditBinding by lazy {
        ActivityAddEditBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //open dialog for profile
        binding.profileImg.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog_image)

            //set transparent background of dialog
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            //set profile image in the dialog box show in full length
            val image = dialog.findViewById<ImageView>(R.id.image)
            val imageObject = binding.profileImg.drawable
            image.setImageDrawable(imageObject)


            // set dialog parameter height and width
            val lp = WindowManager.LayoutParams()
            lp.width = WindowManager.LayoutParams.WRAP_CONTENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT

            //blur background of dialog
            lp.flags = WindowManager.LayoutParams.FLAG_BLUR_BEHIND

            //set all attributes to dialog
            dialog.window?.attributes = lp
            dialog.show()
        }

        binding.saveBtn.setOnClickListener {
            // Add data to Contact call by Contact database
            val contact = Contact(
                userName = binding.inputName.text.toString(),
                userPhoneNo = binding.inputPhone.text.toString(),
                userEmail = binding.inputEmail.text.toString()
            )
            val db = DbBuilder.getDB(this)

            val i = db?.contactDAO()?.createContact(contact)
            if (i != null) {
                if (i > 0) {
                    Toast.makeText(
                        this@AddEditActivity,
                        "Save contact successfully $i",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}