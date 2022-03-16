package com.zharfan.kalkulatorzed.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.zharfan.kalkulatorzed.databinding.FragmentCalculatorHomeBinding
import net.objecthunter.exp4j.ExpressionBuilder


class OnCalculatorClickListenerHomeFragment : Fragment() {

    private var _binding: FragmentCalculatorHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentCalculatorHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setActionClickListener()
    }

    private fun setActionClickListener() {
        binding.apply {
            btnHistory.setOnClickListener {

            }

            btnDelete.setOnClickListener {
                val resultAfterDel: String = tvCalculation.text.toString()
                if (resultAfterDel.isNotEmpty()) {
                    tvCalculation.text = resultAfterDel.dropLast(n = 1)
                } else tvCalculation.text = "0"
            }

            btnClear.setOnClickListener {
                tvResult.text = "0"
            }

            btnKurung.setOnClickListener {
                val resultBeforeKurung: String = tvCalculation.text.toString()
                if (resultBeforeKurung.isBlank()) {
                    tvCalculation.text = "("
                } else {
                    tvCalculation.text = resultBeforeKurung + ")"
                }
            }

            btnPercent.setOnClickListener {
                tvCalculation.append("${(btnPercent).text}")
            }

            btnDivide.setOnClickListener {
                tvCalculation.append("${(btnDivide).text}")
            }

            btnSeven.setOnClickListener {
                if (tvCalculation.text.toString().trim() == "0") tvCalculation.text = ""
                tvCalculation.append((btnSeven).text.toString())
            }

            btnEight.setOnClickListener {
                if (tvCalculation.text.toString().trim() == "0") tvCalculation.text = ""
                tvCalculation.append((btnEight).text.toString())
            }

            btnNine.setOnClickListener {
                if (tvCalculation.text.toString().trim() == "0") tvCalculation.text = ""
                tvCalculation.append((btnNine).text.toString())
            }

            btnMultiply.setOnClickListener {
                tvCalculation.append("${(btnMultiply).text}")
            }

            btnFour.setOnClickListener {
                if (tvCalculation.text.toString().trim() == "0") tvCalculation.text = ""
                tvCalculation.append((btnFour).text.toString())
            }

            btnFive.setOnClickListener {
                if (tvCalculation.text.toString().trim() == "0") tvCalculation.text = ""
                tvCalculation.append((btnFive).text.toString())
            }

            btnSix.setOnClickListener {
                if (tvCalculation.text.toString().trim() == "0") tvCalculation.text = ""
                tvCalculation.append((btnSix).text.toString())
            }

            btnMin.setOnClickListener {
                tvCalculation.append("${(btnMin).text}")
            }

            btnOne.setOnClickListener {
                if (tvCalculation.text.toString().trim() == "0") tvCalculation.text = ""
                tvCalculation.append((btnOne).text.toString())
            }

            btnTwo.setOnClickListener {
                if (tvCalculation.text.toString().trim() == "0") tvCalculation.text = ""
                tvCalculation.append((btnTwo).text.toString())
            }

            btnThree.setOnClickListener {
                if (tvCalculation.text.toString().trim() == "0") tvCalculation.text = ""
                tvCalculation.append((btnThree).text.toString())
            }

            btnPlus.setOnClickListener {
                tvCalculation.append("${(btnPlus).text}")
            }

            btnPlusMin.setOnClickListener {
                tvCalculation.append("${(btnPlusMin).text}")
            }

            btnZero.setOnClickListener {
                if (tvCalculation.text.toString().trim() == "0") tvCalculation.text = ""
                tvCalculation.append((btnZero).text.toString())
            }

            btnDot.setOnClickListener {
                tvCalculation.append(".")
            }

            btnEquals.setOnClickListener {
                try {
                    val expression = ExpressionBuilder(tvCalculation.text.toString()).build()
                    val result = expression.evaluate()
                    tvCalculation.text = (if (result % 1 > 0) result else result.toInt()).toString()
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(requireActivity(), "Operator tidak dapat di jalankan", Toast.LENGTH_SHORT).show()

                }
                }
            }
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}