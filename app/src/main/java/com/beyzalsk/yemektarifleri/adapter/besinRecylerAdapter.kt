package com.beyzalsk.yemektarifleri.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beyzalsk.yemektarifleri.R
import com.beyzalsk.yemektarifleri.model.Besin
import kotlinx.android.synthetic.main.besinrecylow.view.*

class besinRecylerAdapter (val besinListesi: ArrayList<Besin>): RecyclerView.Adapter<besinRecylerAdapter.BesinViewHolder> () {

class BesinViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {



}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view  = inflater.inflate(R.layout.besinrecylow,parent,false)
        return BesinViewHolder(view)

    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
       holder.itemView.besinisim.text = besinListesi.get(position).besinIsim
        holder.itemView.besinkalori.text = besinListesi.get(position).besinKalori
        // gorsel
    }

    override fun getItemCount(): Int {
         return besinListesi.size
    }
fun BesinListeUpdate(yeniBesinListe: List <Besin>){
    besinListesi.clear()
    besinListesi.addAll(yeniBesinListe)
    notifyDataSetChanged()


}

}