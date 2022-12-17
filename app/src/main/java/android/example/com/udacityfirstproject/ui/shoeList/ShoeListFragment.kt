package android.example.com.udacityfirstproject.ui.shoeList

import android.example.com.udacityfirstproject.R
import android.example.com.udacityfirstproject.databinding.ShoeListFragmentBinding
import android.example.com.udacityfirstproject.models.ShowDetailsModel
import android.example.com.udacityfirstproject.ui.shoeDetails.SharedViewModel
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController


class ShoeListFragment : Fragment() {

    lateinit var binding: ShoeListFragmentBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ShoeListFragmentBinding.inflate(layoutInflater)
        binding.sharedViewModel = viewModel

        viewModel.savedNewShowInTheList.observe(viewLifecycleOwner) { newItemIsAdded ->
            if (newItemIsAdded.isNotEmpty())
                for (i in newItemIsAdded) {
                    addNewItem(i)
                }
        }

        binding.addNewItemFloatingButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    private fun logOutAction() {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> logOutAction()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addNewItem(model: ShowDetailsModel) {
        val shoeName = TextView(requireContext())
        val company = TextView(requireContext())
        val shoeSize = TextView(requireContext())
        val description = TextView(requireContext())
        val space = TextView(requireContext())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            shoeName.setTextColor(requireContext().getColor(R.color.black))
            company.setTextColor(requireContext().getColor(R.color.black))
            shoeSize.setTextColor(requireContext().getColor(R.color.black))
            description.setTextColor(requireContext().getColor(R.color.black))
        }

        binding.shoeListLayout.addView(shoeName)
        binding.shoeListLayout.addView(company)
        binding.shoeListLayout.addView(shoeSize)
        binding.shoeListLayout.addView(description)
        binding.shoeListLayout.addView(space)

        shoeName.text =
            requireContext().getString(R.string.shoeName_format, model.ShoeName)
        company.text =
            requireContext().getString(R.string.company_format, model.Company)
        shoeSize.text =
            requireContext().getString(R.string.shoe_size_format, model.ShoeSize.toString())
        description.text =
            requireContext().getString(R.string.description_format, model.Description)
    }
}