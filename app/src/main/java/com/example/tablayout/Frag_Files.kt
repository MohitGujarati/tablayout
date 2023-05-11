package mohit.dev.digitalsoc.code.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayout.R


class Frag_Files() : Fragment() {

    lateinit var profile_recview:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_media, container, false)

        profile_recview = view.findViewById(R.id.profile_complain)



        return view
    }




}

