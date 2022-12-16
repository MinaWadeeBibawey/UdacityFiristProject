package android.example.com.udacityfirstproject.ui.instruction

import android.example.com.udacityfirstproject.databinding.InstructionFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

class InstructionFragment : Fragment() {

    private lateinit var binding: InstructionFragmentBinding
    private val viewModel: InstructionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = InstructionFragmentBinding.inflate(layoutInflater)
        binding.instructionViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.agreeInstructionButtonClicked.observe(viewLifecycleOwner) { agreeButtonClicked ->
            if (agreeButtonClicked){
                findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeDetailsFragment())
                viewModel.onResetInstructionFlag()
            }
        }

        return binding.root
    }
}