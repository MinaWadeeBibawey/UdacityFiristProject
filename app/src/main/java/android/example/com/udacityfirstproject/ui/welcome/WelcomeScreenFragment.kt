package android.example.com.udacityfirstproject.ui.welcome

import android.example.com.udacityfirstproject.databinding.WelcomeScreenFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

class WelcomeScreenFragment : Fragment() {

    lateinit var binding: WelcomeScreenFragmentBinding
    private val viewModel: WelcomeScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = WelcomeScreenFragmentBinding.inflate(layoutInflater)
        binding.welcomeViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.navigationClicked.observe(viewLifecycleOwner) { navigationClicked ->
            if (navigationClicked) {
                findNavController().navigate(
                    WelcomeScreenFragmentDirections
                        .actionWelcomeScreenFragmentToInstructionFragment()
                )
                viewModel.resetNavigationFlag()
            }
        }

        return binding.root
    }
}