package rr.chrd.kiemtienqua.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import rr.chrd.kiemtienqua.R
import rr.chrd.kiemtienqua.adapter.TipsAdapter
import rr.chrd.kiemtienqua.databinding.FragmentTipsBinding
import rr.chrd.kiemtienqua.model.ViewModelData

class TipsFragment : Fragment() {

    private var _binding : FragmentTipsBinding? = null
    private val binders get() = _binding!!
    private var tipsData = ViewModelData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentTipsBinding.inflate(inflater,container,false)
        val rootView = binders.root
        tipsData = ViewModelProvider (this) [ViewModelData::class.java]

        tipsData.tipsFun()
        val adpts = TipsAdapter()
        tipsData.tpsNf.observe(viewLifecycleOwner){
            if (it != null){
                adpts.setAdapter(it)
                binders.tipsRecycler.apply {
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