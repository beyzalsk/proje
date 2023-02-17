package com.beyzalsk.yemektarifleri.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beyzalsk.yemektarifleri.model.Besin

class BesinListesiViewModel: ViewModel() {
    val besinler = MutableLiveData<List<Besin>> ()
    val besinHataMesaji = MutableLiveData<Boolean>()
    val BesinYükleniyorMesaj =MutableLiveData<Boolean>()


    fun refreshData(){
        val besin1 = Besin("Elma","100","50","0","www","ww")
        val besin2 = Besin("Armut","200","50","0","www","ww")
        val besin3 = Besin("Muz","120","50","0","www","ww")
        val besin4 = Besin("Çilek","100","50","0","www","ww")
        val besinListesi = arrayListOf<Besin>(besin1,besin2,besin3,besin4)

        besinler.value = besinListesi
        besinHataMesaji.value = false
        BesinYükleniyorMesaj.value = false


    }



}