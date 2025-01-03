package com.storyfeet.keyseypeasy

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.storyfeet.keyseypeasy.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.webIntro.loadUrl("file:///android_asset/intro.html")


        binding.buttonEnable.setOnClickListener{
            val imeIntent = Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);


            val kpID = context?.let {
                it1 -> ComponentName(it1,KeyseyPeasy::class.java).flattenToShortString()
            }?: "NO-ID"
            imeIntent.putExtra(Settings.EXTRA_INPUT_METHOD_ID,kpID)

            startActivity(imeIntent);
        }

        binding.buttonSelectIme.setOnClickListener{
            val imeManager =
                requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            imeManager.showInputMethodPicker()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}