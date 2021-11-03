package com.gui.antonio.suggesticchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.gui.antonio.suggesticchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel.getDays()

        mainViewModel.getDaysLiveData.observe(this) {
            setView(it)
        }
    }

    private fun setView(items: List<DayModel>) {
        val mainAdapter = MainAdapter(items) {
            Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
        }
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

}