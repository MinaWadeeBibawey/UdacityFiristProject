package android.example.com.udacityfirstproject.ui.shoeDetails

import android.example.com.udacityfirstproject.databinding.ShoeDetailsFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class ShoeDetailsFragment : Fragment() {

    lateinit var binding: ShoeDetailsFragmentBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ShoeDetailsFragmentBinding.inflate(layoutInflater)
        binding.sharedViewModel = viewModel
        binding.lifecycleOwner = this
        binding.showDetailsModel = viewModel.detailsModel


        viewModel.savedButtonClicked.observe(viewLifecycleOwner) { savedButtonClicked ->
            if (savedButtonClicked) {
                viewModel.resetSavedButtons()
                /*Toast.makeText(
                    requireContext(),
                    "${viewModel.savedNewShowInTheList.value}",
                    Toast.LENGTH_SHORT
                ).show()*/
                findNavController().popBackStack()
            }
        }

        viewModel.cancelButtonClicked.observe(viewLifecycleOwner) { cancelButtonClicked ->
            if (cancelButtonClicked) {
                viewModel.resetSavedButtons()
                findNavController().popBackStack()
            }
        }


        return binding.root
    }

}