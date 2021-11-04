package com.gui.antonio.suggesticchallenge.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.gui.antonio.suggesticchallenge.R
import com.gui.antonio.suggesticchallenge.data.model.DayModel
import com.gui.antonio.suggesticchallenge.databinding.ActivityMainBinding
import com.gui.antonio.suggesticchallenge.presentation.adapter.MainAdapter
import com.gui.antonio.suggesticchallenge.presentation.viewmodel.MainViewModel
import com.gui.antonio.suggesticchallenge.presentation.viewmodel.factory.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainAdapter: MainAdapter by lazy { MainAdapter {
        showAlert(it) }
    }
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createViewModel()
        setBinding()
        setContentView(binding.root)
        setView()
        setObservers()
        getDays()
    }

    private fun getDays() {
        mainViewModel.getDays()
    }

    private fun createViewModel() {
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]
    }

    private fun setBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    private fun setObservers() {
        mainViewModel.getDaysLiveData.observe(this) {
            binding.progressIndicator.hide()
            mainAdapter.updateData(it)
        }
    }

    private fun setView() {
        binding.dayRecyclerView.apply {
            adapter = mainAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun showAlert(dayModel: DayModel) {
        AlertDialog.Builder(this).apply {
            setTitle(dayModel.title)
            setMessage(dayModel.subtitle)
            setPositiveButton(getString(R.string.ok), null)
            show()
        }
    }

}