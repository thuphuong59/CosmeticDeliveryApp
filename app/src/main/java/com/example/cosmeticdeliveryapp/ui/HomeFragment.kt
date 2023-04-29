package com.example.cosmeticdeliveryapp.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.cosmeticdeliveryapp.R
import com.example.cosmeticdeliveryapp.RcvAdapter.RcvCategories
import com.example.cosmeticdeliveryapp.RcvAdapter.SlideShow
import com.example.cosmeticdeliveryapp.data
import com.example.cosmeticdeliveryapp.databinding.FragmentHomeBinding
import com.example.cosmeticdeliveryapp.model.ModelCategory
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoriesArraylist: ArrayList<ModelCategory>
    private lateinit var adapterFood: RcvCategories
    private lateinit var getData :data
    private lateinit var viewPager :ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        getData =data()
        loadCategories(container!!)
        sliderShow()
        // Inflate the layout for this fragment
        return binding.root
    }
    private fun loadCategories(container: ViewGroup) {
        categoriesArraylist = ArrayList()
        categoriesArraylist=   getData.getDataCategory()
        val adapterCategory = RcvCategories(container.context, categoriesArraylist)
        binding.RcvCategory.adapter = adapterCategory

    }
    fun sliderShow(){
        viewPager=binding.viewPager
        val images = listOf(
            R.drawable.item_slide1,
            R.drawable.item_slide2,
            R.drawable.item_slide3,
        )
        viewPager.adapter = SlideShow(images)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.offscreenPageLimit = 1

        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            var currentItem = viewPager.currentItem
            currentItem += 1
            if (currentItem >= images.size) {
                currentItem = 0
            }
            viewPager.currentItem = currentItem
        }
        Timer().schedule(object : TimerTask() {
            override fun run() {
                handler.post(runnable)
            }
        }, 3000, 3000)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}