package com.example.noteapp.ui.adapters

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.noteapp.ui.fragments.onboard.PagerFragment
import com.example.noteapp.ui.fragments.onboard.PagerFragment.Companion.ARG_ONBOARD_POSITION

class PagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int) = PagerFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }

    }

    override fun getItemCount(): Int = 3
}