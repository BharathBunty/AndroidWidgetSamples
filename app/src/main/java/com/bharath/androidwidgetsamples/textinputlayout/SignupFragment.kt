package com.bharath.androidwidgetsamples.textinputlayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bharath.androidwidgetsamples.R
import com.bharath.androidwidgetsamples.databinding.FragmentSignupBinding
import com.bharath.androidwidgetsamples.helper.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [SignupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupFragment : BaseFragment() {

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){

            buttonCreate.setOnClickListener {

                val name = nameEditText.text.toString().trim()
                val mobileNumber = numberEditText.text.toString().trim()
                val email = emailEditText.text.toString().trim()
                val password = passwordEditText.text.toString().trim()
                val cnfmPassword = cnfmPasswordEditText.text.toString().trim()

                if (name.isEmpty()){
                    Toast.makeText(mainActivity, " please enter the valid name ", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if(mobileNumber.isEmpty() || mobileNumber.length != 10){
                    Toast.makeText(mainActivity, " please enter the valid mobile number ", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if(email.isEmpty()){
                    Toast.makeText(mainActivity, " please enter the valid email ", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if(password.isEmpty() || cnfmPassword.isEmpty() || !password.equals(cnfmPassword)){
                    Toast.makeText(mainActivity, " password is not matched ", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                Toast.makeText(mainActivity, " Account created Successfully ", Toast.LENGTH_SHORT).show()

            }

        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}