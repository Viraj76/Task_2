package com.example.tasktwo.ui.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import androidx.viewpager2.widget.ViewPager2
import com.example.tasktwo.R
import com.example.tasktwo.adapters.AdapterViewPager
import com.example.tasktwo.databinding.FragmentHomeBinding
import com.example.tasktwo.models.Post
import com.example.tasktwo.utils.Constant

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapterViewPager: AdapterViewPager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        showPost()
        binding.apply {
            tvRandom.setOnClickListener {  Constant.showToast(requireContext() , "Going to implement it soon!") }
            llMic.setOnClickListener {  Constant.showToast(requireContext() , "Going to implement it soon!") }
        }
        return binding.root
    }

    private fun showPost() {
        val postList = arrayListOf<Post>()
        postList.add(Post(image = R.drawable.q1))
        postList.add(Post(image = R.drawable.q2))
        postList.add(Post(image = R.drawable.q3))
        postList.add(Post(image = R.drawable.q4))
        postList.add(Post(image = R.drawable.q5))
        postList.add(Post(image = R.drawable.q6))
        postList.add(Post(image = R.drawable.q7))
        postList.add(Post(image = R.drawable.q8))
        postList.add(Post(image = R.drawable.q9))
        postList.add(Post(image = R.drawable.q10))
        postList.add(Post(image = R.drawable.q11))

        adapterViewPager = AdapterViewPager(requireContext() , ::findMajorColor)
        binding.viewPager.adapter = adapterViewPager
        adapterViewPager.differ.submitList(postList)
        binding.viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

    }
    fun findMajorColor(imageView: Int ,) {
        // Get the drawable from ImageView
        val bitmap = BitmapFactory.decodeResource(resources, imageView)

        val palette = Palette.from(bitmap).generate()
        val d = palette.getDominantColor(ContextCompat.getColor(requireContext(), R.color.blue))
        binding.cl.setBackgroundColor(d)

    }
//    private fun setMutedPalette(palette: Palette) {
//        binding.ll.apply {
//            val color = palette.vibrantSwatch?.population
//            if (color != null) {
//                setBackgroundColor(color)
//            }
//
//            val psVibrant: Palette.Swatch = palette.vibrantSwatch!!
//            val color1: Int = psVibrant.rgb
//            val population: Int = psVibrant.population
//            val hsl: FloatArray = psVibrant.hsl
//            val bodyTextColor: Int = psVibrant.bodyTextColor
//            val titleTextColor: Int = psVibrant.titleTextColor
//        }
//
//    }

//    private fun setVibrantPalette(view: View, palette: Palette) {
//        view.findViewById<ShapeableImageView>(R.id.vibrant_image_view).apply {
//            val color = palette.getVibrantColor(defaultColor)
//            setBackgroundColor(color)
//        }
//        view.findViewById<ShapeableImageView>(R.id.light_vibrant_image_view).apply {
//            val color = palette.getLightVibrantColor(defaultColor)
//            setBackgroundColor(color)
//        }
//        view.findViewById<ShapeableImageView>(R.id.dark_vibrant_image_view).apply {
//            val color = palette.getDarkVibrantColor(defaultColor)
//            setBackgroundColor(color)
//        }
//    }




}


