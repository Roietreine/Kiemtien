package rr.chrd.kiemtienqua.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import rr.chrd.kiemtienqua.R
import rr.chrd.kiemtienqua.adapter.GuideAdapter
import rr.chrd.kiemtienqua.databinding.FragmentGuideBinding
import rr.chrd.kiemtienqua.model.ViewModelData

class GuideFragment : Fragment() {


    private var _binding : FragmentGuideBinding? = null
    private val binders get() = _binding!!
    private var guideData = ViewModelData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentGuideBinding.inflate(inflater,container,false)
        val rootView = binders.root
        guideData = ViewModelProvider (this)[ViewModelData::class.java]

        guideData.guideFun()
        val adpts = GuideAdapter()
        guideData.gdNf.observe(viewLifecycleOwner){
            if (it != null){
                adpts.setAdapter(it)
                binders.guideRecycler.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager (context)
                    adapter = adpts
                }
            }
        }
        return rootView
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}