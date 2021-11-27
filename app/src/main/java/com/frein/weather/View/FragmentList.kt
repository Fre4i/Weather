package com.frein.weather.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.frein.weather.Model.API
import com.frein.weather.R
import com.frein.weather.ViewModel.ViewModelList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

class FragmentList : Fragment() {
    private val viewModel: ViewModelList by viewModels()

    private lateinit var editTownSearch: EditText
    private lateinit var btnSearch: Button
    private lateinit var recyclerTownList: RecyclerView
    private lateinit var test_text: TextView

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
            test_text = findViewById(R.id.test_text)
        }

        //Btn
        btnSearch.setOnClickListener(View.OnClickListener {
            var s = editTownSearch.text.toString()
            viewModel.town.value = s
        })
        viewModel.text.observe(this, {
            test_text.text = it
        })

        return root
    }
}