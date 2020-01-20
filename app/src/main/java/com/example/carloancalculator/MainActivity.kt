package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Currency
import java.util.Locale
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

import java.util.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonCalculate.setOnClickListener() {
            calculateInput()

            //Get user input

        }


    }

    fun calculateInput() {

        if (editTextCarPrice.text.isEmpty()) {
            editTextCarPrice.setError(getString(R.string.error))
            return
        }





        val carPrice = editTextCarPrice.text.toString().toInt()
        val carDownPayment = editTextDownPayment.text.toString().toInt()
        val carLoanPeriod = editTextLoanPeriod.text.toString().toInt()
        val carInterest = editTextInterestRate.text.toString().toInt()


        var loan = carPrice - carDownPayment
        var interest = carLoanPeriod * carInterest * carLoanPeriod
        var monthlyRepayment = (carLoanPeriod + carInterest) / carLoanPeriod / 12

        //var currency = Currency.getInstance(Locale.)
        val defaultLocale = Locale.getDefault()
       

        //To DO display the output
        textViewLoan.setText((getString(R.string.loan) + "${loan}"))
        textViewInterest.setText((getString(R.string.interest) + "${interest}"))
        textViewMonthlyRepayment.setText(/*currency*/  (getString(R.string.monthly_repayment) + "${monthlyRepayment}"))


    }

    fun resetinput(view: View) {
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextLoanPeriod.setText("")
        editTextInterestRate.setText("")
        textViewInterest.setText(getString(R.string.interest))
        textViewLoan.setText(getString(R.string.loan))
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment))


    }


}
