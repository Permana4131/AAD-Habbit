package if418028.myfinalapp.ui.akunt

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import if418028.myfinalapp.ui.auth.Login
import if418028.myfinalapp.R

class AkuntFragment : Fragment() {
    private lateinit var preferences : SharedPreferences

    private lateinit var notificationsViewModel: AkuntViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(AkuntViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_akunt, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        preferences = root.context.getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE)
        if (preferences.getBoolean(Login.session_status, false) == false){
            val intent = Intent(root.context, Login::class.java)
            startActivity(intent)
            activity?.finish()
        }

        val log = root.findViewById<Button>(R.id.cirLogoutButton)
        log.setOnClickListener(){
            logout(root.context)
        }

        val nm = root.findViewById<TextView>(R.id.name)
        nm.text = preferences.getString(Login.tag_name, null)
        return root
    }

    fun logout(context: Context){
        val editor = preferences.edit()
        editor.putBoolean(Login.session_status, false)
        editor.putString(Login.tag_email, null)
        editor.commit()
        val intent = Intent(context, Login::class.java)
        startActivity(intent)

    }
}