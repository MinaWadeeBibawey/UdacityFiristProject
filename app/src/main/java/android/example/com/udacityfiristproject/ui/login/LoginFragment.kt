package android.example.com.udacityfiristproject.ui.login

import android.example.com.udacityfiristproject.databinding.LoginFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class LoginFragment : Fragment() {

    lateinit var binding: LoginFragmentBinding
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
                Toast.makeText(requireContext(), "On login clicked", Toast.LENGTH_SHORT).show()
                viewModel.onLoginTransactionFinished()
            }
        }

        return binding.root
    }

}