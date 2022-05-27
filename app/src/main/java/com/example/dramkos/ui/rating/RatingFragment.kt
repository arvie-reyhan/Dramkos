package com.example.dramkos.ui.rating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dramkos.databinding.FragmentRatingBinding

class RatingFragment : Fragment() {

private var _binding: FragmentRatingBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val ratingViewModel =
            ViewModelProvider(this).get(RatingViewModel::class.java)

    _binding = FragmentRatingBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textRating
    ratingViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}