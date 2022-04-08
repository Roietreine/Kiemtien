package rr.chrd.kiemtienqua.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rr.chrd.kiemtienqua.databinding.TipsviewBinding
import rr.chrd.kiemtienqua.model.TipsModel

class TipsAdapter : RecyclerView.Adapter<TipsAdapter.AdapterHolder>() {
    class AdapterHolder (val adpts : TipsviewBinding): RecyclerView.ViewHolder(adpts.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsAdapter.AdapterHolder = AdapterHolder(
        TipsviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: TipsAdapter.AdapterHolder, position: Int) {
       with (holder){
           with (listNiTips[position]){
               adpts.tipsTitle.text = this.tipsT
               adpts.tipsDesc.text = this.tipsD
           }
       }
    }
    override fun getItemCount(): Int {
        return listNiTips.size
    }
    private var listNiTips = emptyList<TipsModel>()

    fun setAdapter (setAdapt : List<TipsModel>){
        this.listNiTips = setAdapt
    }
}