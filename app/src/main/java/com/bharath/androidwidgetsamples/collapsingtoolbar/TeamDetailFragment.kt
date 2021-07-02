package com.bharath.androidwidgetsamples.collapsingtoolbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bharath.androidwidgetsamples.R
import com.bharath.androidwidgetsamples.databinding.FragmentTeamDetailBinding
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 * Use the [TeamDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TeamDetailFragment : Fragment() {

    private var _binding: FragmentTeamDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var teamNames : Array<String>

    private val teamImages = arrayOf(R.drawable.csk_header , R.drawable.dc_header , R.drawable.rcb_header , R.drawable.pbk_header,
        R.drawable.srh_header , R.drawable.rr_header , R.drawable.kkr_header , R.drawable.mi_header
    )

    companion object {

        const val ARG_POSITION = "position"

        fun getInstance(position: Int): Fragment {
            return TeamDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_POSITION, position)
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTeamDetailBinding.inflate(inflater,container ,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        teamNames = requireContext().resources.getStringArray(R.array.teamNames)
        val position = requireArguments().getInt(ARG_POSITION)

        with(binding){
            Picasso.get().load(teamImages[position]).into(teamImageView)
            teamNameTv.text = teamNames[position]
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}