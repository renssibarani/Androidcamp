package com.mandiri.mandiriapps.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.databinding.DialogLayoutBinding

class ConfirmationDialogUtil(private val context: Context) {

    fun showConfirmationDialog(
        title: String,
        icon: Int? = null,
        onConfirm: ()-> Unit,
        onCancle: ()-> Unit
    ){
        val dialogBuilder = AlertDialog.Builder(context)
        val alertDialog = dialogBuilder.create()

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null)
        val dialogBinding = DialogLayoutBinding.bind(dialogView)
        //set judul dan pesan
        dialogBinding.tvTitle.text = title

        if (icon!=null){
            dialogBinding.ivIconDialog.visibility = View.VISIBLE
            dialogBinding.ivIconDialog.setImageResource(icon)
        }else{
            dialogBinding.ivIconDialog.visibility = View.GONE
        }
        alertDialog.setView(dialogView)
        //menambahkan fungsi onclicklistener untuk tombol "YA"
        dialogBinding.btnPositive.setOnClickListener{
            onConfirm.invoke()//panggil aksi oncancle
            alertDialog.dismiss()
        }
        //menambahkan fungsi onclicklistener untuk tombol "TIDAK"
        dialogBinding.btnNegative.setOnClickListener{
            onCancle.invoke() //panggil aksi oncalcle
            alertDialog.dismiss()
        }
        alertDialog.show()
    }
}