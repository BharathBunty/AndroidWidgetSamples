package com.bharath.androidwidgetsamples.collapsingtoolbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.bharath.androidwidgetsamples.R
import com.bharath.androidwidgetsamples.databinding.FragmentCollapsingToolBarBinding
import com.bharath.androidwidgetsamples.helper.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.withContext


/**
 * A simple [Fragment] subclass.
 * Use the [CollapsingToolBarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CollapsingToolBarFragment : BaseFragment() {

    private var _binding : FragmentCollapsingToolBarBinding? = null
    private val binding get() = _binding!!

    private lateinit var teamNames : Array<String>

    var teamPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCollapsingToolBarBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()

    }

    private fun initialize(){

        teamNames = requireContext().resources.getStringArray(R.array.teamNames)

        val teamAdapter = ViewPagerAdapter(mainActivity,teamNames.size)

        with(binding){

            viewPager.apply {
                adapter = teamAdapter
                registerOnPageChangeCallback(teamPageChangeCallback)
                orientation = ViewPager2.ORIENTATION_VERTICAL
            }

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                //To get the first name of teams
                tab.text = teamNames[position].substringBefore(' ')
            }.attach()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.viewPager.unregisterOnPageChangeCallback(teamPageChangeCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}