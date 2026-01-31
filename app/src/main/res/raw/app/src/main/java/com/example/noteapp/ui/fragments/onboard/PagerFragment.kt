package com.example.noteapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardBinding
import com.example.noteapp.databinding.FragmentPagerBinding

class PagerFragment : Fragment() {

    companion object{
        const val ARG_ONBOARD_POSITION ="onBoard"
    }

    private lateinit var binding: FragmentPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagerBinding.inflate(inflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()


    }

    private fun initialize() = with(binding) {
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)){
            0->{
                animationView.setAnimation(R.raw.strategy)
                title.text = "Удобство"
                description.text = "Создавайте заметки в два клика!\nЗаписывайте мысли, идеи и\nважные задачи мгновенно."
            }
            1->{
                animationView.setAnimation(R.raw.organization)
                title.text = "Организация"
                description.text = "Организуйте заметки по папкам\nи тегам. Легко находите нужную\nинформацию в любое время."
            }
            2->{
                animationView.setAnimation(R.raw.synchronization)
                title.text = "Синхронизация"
                description.text = "Синхронизация на всех\nустройствах. Доступ к записям в\nлюбое время и в любом месте."

            }
        }
    }

}