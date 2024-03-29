package com.example.scorematchstatistics.util

import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.databinding.AlertDialogMessagesBinding

class AlertDialogMessages(
    private val kindOfMessage: Int = 0,
    private val messageBody: String
) :
    DialogFragment() {

    private lateinit var binding: AlertDialogMessagesBinding

    companion object {
        const val SUCCES_MESSAGE = R.color.succes
        const val WARNING_MESSAGE = R.color.waring
        const val ERROR_MESSAGE = R.color.danger
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AlertDialogMessagesBinding.inflate(layoutInflater, container, false)
        setUpUi()
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        isCancelable = false
        return dialog
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }


    private fun setUpUi() {
        with(binding) {
            buttonAceptar.setOnClickListener {
                dialog?.dismiss()
            }
            binding.bodyMessage.text = messageBody
        }
        setKindOfMessage()
    }

    private fun setKindOfMessage() {
        when (kindOfMessage) {
            0 -> {
                binding.headerDialog.setCardBackgroundColor(resources.getColor(SUCCES_MESSAGE))
                binding.titleHeader.text = "Succes"
            }
            1 -> {
                binding.headerDialog.setCardBackgroundColor(resources.getColor(WARNING_MESSAGE))
                binding.titleHeader.text = "Warning"
            }
            2 -> {
                binding.headerDialog.setCardBackgroundColor(resources.getColor(ERROR_MESSAGE))
                binding.titleHeader.text = "Error"
            }
        }
    }

}