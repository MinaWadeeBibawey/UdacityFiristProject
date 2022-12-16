package android.example.com.udacityfirstproject.ui.login

import android.example.com.udacityfirstproject.databinding.LoginFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(layoutInflater)

        binding.loginModel = viewModel.loginModel
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.login.observe(viewLifecycleOwner) { loginClicked ->
            if (loginClicked) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment())
                viewModel.onLoginTransactionFinished()
            }
        }

        return binding.root
    }

}