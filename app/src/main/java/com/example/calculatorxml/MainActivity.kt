package com.example.calculatorxml

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorxml.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.tvOne.setOnClickListener{setTextFields("1")}
        binding.tvTwo.setOnClickListener{setTextFields("2")}
        binding.tvThree.setOnClickListener{setTextFields("3")}
        binding.tvFour.setOnClickListener{setTextFields("4")}
        binding.tvFive.setOnClickListener{setTextFields("5")}
        binding.tvSix.setOnClickListener{setTextFields("6")}
        binding.tvSeven.setOnClickListener{setTextFields("7")}
        binding.tvEight.setOnClickListener{setTextFields("8")}
        binding.tvNine.setOnClickListener{ setTextFields("9")}
        binding.tvZero.setOnClickListener{setTextFields("0")}

        binding.tvOpen.setOnClickListener{setTextFields("(")}
        binding.tvClose.setOnClickListener{setTextFields(")")}
        binding.tvAdd.setOnClickListener{setTextFields("+")}
        binding.tvMinus.setOnClickListener{setTextFields("-")}
        binding.tvMultiplication.setOnClickListener{setTextFields("*")}
        binding.tvDivision.setOnClickListener{setTextFields("/")}
        binding.tvDot.setOnClickListener{setTextFields(".")}
        binding.tvClear.setOnClickListener{
            binding.mathOperation.text = ""
            binding.mathResult.text =  ""
        }
        binding.tvBack.setOnClickListener{
            val str = binding.mathOperation.text.toString()
            if(str.isNotEmpty()) {
                binding.mathOperation.text = str.substring(0,str.length-1)
                binding.mathResult.text = ""
            }
        }
        binding.tvEquals.setOnClickListener{
            try {
                val ex = ExpressionBuilder(binding.mathOperation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    binding.mathResult.text = longRes.toString()
                else
                    binding.mathResult.text = result.toString()

            }catch (e:Exception){
                Log.d("Ошибка", "Сообщение: ${e.message}")

            }
        }


    }

    fun setTextFields(str: String){
        binding.mathOperation.append(str)



    }
}