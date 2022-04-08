package rr.chrd.kiemtienqua.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rr.chrd.kiemtienqua.databinding.GuideviewBinding
import rr.chrd.kiemtienqua.model.GuideModel

class GuideAdapter : RecyclerView.Adapter<GuideAdapter.AdapterHolder>() {
    class AdapterHolder (val adpts : GuideviewBinding):RecyclerView.ViewHolder(adpts.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideAdapter.AdapterHolder = AdapterHolder(
        GuideviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: GuideAdapter.AdapterHolder, position: Int) {
       with (holder){
           with (listNiGuide[position]){
               adpts.guideDesc.text = this.guideD
           }
       }
    }
    override fun getItemCount(): Int {
        return listNiGuide.size
    }

    private var listNiGuide = emptyList<GuideModel>()


    fun setAdapter (setAdapt: List<GuideModel>){
        this.listNiGuide = setAdapt
    }
}