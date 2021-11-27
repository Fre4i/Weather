package com.frein.weather.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.frein.weather.R
import com.frein.weather.ViewModel.ViewModelList

class FragmentList : Fragment() {
    private val viewModel: ViewModelList by viewModels()

    private lateinit var editTownSearch: EditText
    private lateinit var btnSearch: Button
    private lateinit var recyclerTownList: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_list, container, false)

        //Init view el
        with(root) {
            editTownSearch = findViewById(R.id.editTownSearch)
            btnSearch = findViewById(R.id.btnSearch)
            recyclerTownList = findViewById(R.id.recyclerTownList)
        }

        //Btn
        btnSearch.setOnClickListener(View.OnClickListener {
            var s = editTownSearch.text.toString()
//            searchTown(s)
        })

        return root
    }
}