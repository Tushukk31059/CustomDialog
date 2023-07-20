package com.tushar.singaporeassignment

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.tushar.singaporeassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUpdate.setOnClickListener {
            var dialog=Dialog(this)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.getWindow()?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            var btnOk = dialog.findViewById<Button>(R.id.btnOk)
            var etDialogname = dialog.findViewById<EditText>(R.id.etDialogname)
            var etDialogcollagename = dialog.findViewById<EditText>(R.id.etDialogcollagename)
            etDialogname.setText(binding.etName.text.toString())
            etDialogcollagename.setText(binding.etCollage.text.toString())
            btnOk.setOnClickListener {
                if (etDialogname.text.toString().isNullOrEmpty()) {
                    etDialogname.error = "enter you name"
                } else if (etDialogcollagename.text.toString().isNullOrEmpty()) {
                    etDialogname.error = "enter you collage name"
                } else {
                    binding.etName.setText(etDialogname.text.toString())
                    binding.etCollage.setText(etDialogcollagename.text.toString())
                    dialog.dismiss()
                }

            }
            dialog.show()
        }
        binding.btnClear.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("CLEAR")
                .setMessage("Do you want to clear ?")
                .setCancelable(false)
                .setPositiveButton("Yes"){_,_,->
                    binding.etName.setText("")
                    binding.etCollage.setText(" ")

                }
                .setNegativeButton("No"){_,_->
                }
                .show()
        }
    }
}