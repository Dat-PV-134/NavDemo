package com.example.navdemo2

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.navdemo2.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {
    private lateinit var binding: FragmentEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmailBinding.inflate(inflater, container, false)

        val name = requireArguments().getString("name")
        binding.apply {
            btnSubmit.setOnClickListener {
                if (!TextUtils.isEmpty(etEmail.text.toString())) {
                    val bundle = Bundle()
                    val array = arrayOf(name, etEmail.text.toString())
                    bundle.putStringArray("user", array)
                    it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)
                } else {
                    Toast.makeText(activity, "Please enter email", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }
}