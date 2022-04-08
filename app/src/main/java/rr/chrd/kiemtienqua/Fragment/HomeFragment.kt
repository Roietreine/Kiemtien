package rr.chrd.kiemtienqua.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import rr.chrd.kiemtienqua.R
import rr.chrd.kiemtienqua.databinding.FragmentHomeBinding
import rr.chrd.kiemtienqua.model.ViewModelData


class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binders get() = _binding!!
    private var homeData = ViewModelData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val rootView = binders.root
        homeData = ViewModelProvider (this)[ViewModelData::class.java]
        homeDetails()
        return rootView
    }
    private fun homeDetails(){

        homeData.hDesc.observe(viewLifecycleOwner,binders.homeDesc::setText)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}