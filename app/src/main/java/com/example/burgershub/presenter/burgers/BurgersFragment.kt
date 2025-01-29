package com.example.burgershub.presenter.burgers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.burgershub.databinding.FragmentBurguersBinding
import com.example.burgershub.domain.model.Burger
import com.example.burgershub.presenter.burgers.adapter.BurgerAdapter
import com.example.burgershub.utils.StateView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BurgersFragment : Fragment() {

    private var _binding: FragmentBurguersBinding? = null
    private val binding get() = _binding!!

    private val viewModel : BurgersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBurguersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBurgers()
    }

    private fun getBurgers() {
        viewModel.getBurgers().observe(viewLifecycleOwner) {stateView ->
            when(stateView) {
                is StateView.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is StateView.Success -> {
                    binding.progressBar.isVisible = false
                    val burgers = stateView.data ?: emptyList()
                    initRecycler(burgers)

                }
                is StateView.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(
                        requireContext(),
                        stateView.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }

    private fun initRecycler(burgers: List<Burger>) {
        with(binding.rvBurgers) {
            setHasFixedSize(true)
            adapter = BurgerAdapter(burgers) { burgerId ->


            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}