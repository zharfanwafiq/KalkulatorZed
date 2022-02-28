package com.zharfan.kalkulatorzed.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.zharfan.kalkulatorzed.R
import com.zharfan.kalkulatorzed.data.Calculator
import com.zharfan.kalkulatorzed.databinding.FragmentCalculatorHomeBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class CalculatorHomeFragment : Fragment(), Calculator {

    private lateinit var binding: FragmentCalculatorHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCalculatorHomeBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onEqual(view: View) {
        binding.apply {
            try {
                val expression = ExpressionBuilder(tvResult.text.toString()).build()
                val result = expression.evaluate()
                tvResult.text = (if (result % 1 > 0) result else result.toInt()).toString()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(activity, "Operator tidak dapat di jalankan", Toast.LENGTH_SHORT).show()

            }
        }

    }

    override fun onPlusMin(view: View) {
        binding.apply {
            tvResult.append("${(view as Button).text}")
        }

    }

    override fun onDot(view: View) {
        binding.apply {
            tvResult.append(".")
        }
    }

    override fun onPlus(view: View) {
        binding.apply {
            tvResult.append("${(view as Button).text}")
        }
    }

    override fun onMin(view: View) {
        binding.apply {
            tvResult.append("${(view as Button).text}")
        }
    }

    override fun onMultiply(view: View) {
        binding.apply {
            tvResult.append("${(view as Button).text}")
        }
    }

    override fun onClear(view: View) {
        binding.apply {
            tvResult.text = "0"
        }
    }

    override fun onBrackets(view: View) {
        binding.apply {
            val resultBeforeKurung: String =tvResult.text.toString()
            if (resultBeforeKurung.isBlank()){
                tvResult.text = "("
            }else{
                tvResult.text = resultBeforeKurung + ")"
            }
        }
    }

    override fun onPercent(view: View) {
        binding.apply {
            tvResult.text = "%"
        }
    }

    override fun onDivide(view: View) {
        binding.apply {
            tvResult.append("${(view as Button).text}")
        }
    }



    override fun onDelete(view: View) {
        binding.apply {
            val resultAfterDel: String = tvResult.text.toString()
            if (resultAfterDel.isNotEmpty()) {
                tvResult.text = resultAfterDel.dropLast(n = 1)
            } else tvResult.text = "0"
        }
    }

    override fun onDigit(view: View) {
        binding.apply {
            if (tvResult.text.toString().trim() == "0") tvResult.text = ""
            tvResult.append((view as Button).text.toString())
        }

    }
}