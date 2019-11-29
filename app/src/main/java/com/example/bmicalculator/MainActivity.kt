package com.example.bmicalculator

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.Gravity
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(){
            try {
                val Height:Double = txtHeight.text.toString().toDouble()
                val Weight:Double = txtWeight.text.toString().toDouble()
                val status : String
                val result:Double = Calculate(Height,Weight)

                if (result < 18.5){
                    imageViewBMI.setImageResource(R.drawable.under)
                    status = "under"
                    textViewBMI.text = "BMI - %.2f(%s)".format(result,status)
                }else  if(result >= 18.5 && result <= 24.9){
                    imageViewBMI.setImageResource(R.drawable.normal)
                    status = "normal"
                    textViewBMI.text = "BMI - %.2f(%s)".format(result,status)
                }else{
                    imageViewBMI.setImageResource(R.drawable.over)
                    status = "overweight"
                    textViewBMI.text = "BMI - %.2f(%s)".format(result,status)
                }
            }catch (e : Exception){
                val toast:Toast = Toast.makeText(this,"Please enter the Height and Weight", Toast.LENGTH_LONG)

                toast.setGravity(Gravity.CENTER, 0,0)
                toast.show()
            }
        }

        btnReset.setOnClickListener(){
            textViewBMI.text = ""
            txtHeight.text.clear()
            txtWeight.text.clear()
            imageViewBMI.setImageResource(R.drawable.empty)
        }
    }

    fun Calculate(Height: Double, Weight: Double):Double{
        val BMI = Weight/((Height)*(Height))
        return BMI
    }

}
