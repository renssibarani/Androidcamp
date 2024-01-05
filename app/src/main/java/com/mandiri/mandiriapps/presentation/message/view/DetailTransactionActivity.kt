package com.mandiri.mandiriapps.presentation.message.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.mandiriapps.databinding.ActivityDetailTransactionBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.model.statusTransaction

class DetailTransactionActivity : AppCompatActivity(){
    private lateinit var binding: ActivityDetailTransactionBinding
    private var data: HistoryTransactionModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.componentToolbar.tvToolbarTitle.text = "Detail History"

        binding.componentToolbar.ivBack.setOnClickListener{
            onBackPressed()
        }
        data = intent?.getParcelableExtra(DATA_TRANSACTION)
        setupViewDetail(data)
    }

    private fun setupViewDetail(data: HistoryTransactionModel?){
        val textDetail = "Transfer ${checkStatusTrasaction()}"
        val dateDetail = "${data?.date} No. Ref. 23132132313123"
        binding.tvDetailTransaction.text = textDetail
        binding.tvDetailDate.text = dateDetail
    }

    private fun checkStatusTrasaction(): String{
        val dataTrans = data?.statusTransaction
        var resultTransaction = ""
        when(dataTrans){
            statusTransaction.Berhasil.value ->resultTransaction = "Berhasil"
            statusTransaction.Gagal.value -> resultTransaction = "Gagal"
            statusTransaction.Pending.value -> resultTransaction = "Pending"
        }
        return resultTransaction
    }

    companion object{
        const val DATA_TRANSACTION = "data_transaction"

        fun navigateToDetailTransaction(activity: Activity, data: HistoryTransactionModel) {
            val intent = Intent(activity, DetailTransactionActivity::class.java)
            intent.putExtra(DATA_TRANSACTION, data)
            activity.startActivity(intent)
        }
    }
}