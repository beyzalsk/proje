package com.beyzalsk.yemektarifleri.view



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.beyzalsk.yemektarifleri.R
import com.beyzalsk.yemektarifleri.adapter.besinRecylerAdapter
import com.beyzalsk.yemektarifleri.viewmodel.BesinListesiViewModel
import kotlinx.android.synthetic.main.fragment_liste.*


@Suppress("DEPRECATION")
class ListeFragment : Fragment() {
    private lateinit var viewModel : BesinListesiViewModel //sonradan değiştirilebilir
    private val recylerBesinAdapter  = besinRecylerAdapter(arrayListOf())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        observeLiveData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_liste, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = androidx.lifecycle.ViewModelProviders.of(this)[BesinListesiViewModel::class.java]

    //BesinListeviewModel ile fragment bağlama
        besinlistrecy.layoutManager = LinearLayoutManager(context)
        besinlistrecy.adapter = recylerBesinAdapter
    }

private fun observeLiveData(){
viewModel.besinler.observe(this, Observer { besinler ->
    besinler?.let {
        besinlistrecy.visibility = View.VISIBLE
        recylerBesinAdapter.BesinListeUpdate(besinler)
    }
})

    viewModel.besinHataMesaji.observe(viewLifecycleOwner, Observer {
        hata ->
        hata?.let {
            if(it){
                besihata.visibility = View.VISIBLE
            }else {
                besihata.visibility = View.GONE
            }
        }
    })
    viewModel.BesinYükleniyorMesaj.observe(viewLifecycleOwner, Observer {
        yukleniyor ->
        yukleniyor?.let {
            if(it){
                besinlistrecy.visibility = View.GONE
                besihata.visibility = View.GONE
                besinyukleme.visibility = View.VISIBLE


            }else{

    println()
            }
        }
    })
}
    }




