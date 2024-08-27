package com.capstone.peopleconnect.Client.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.capstone.peopleconnect.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyProfileFragmentClient : Fragment() {

    private var firstName: String? = null
    private var middleName: String? = null
    private var lastName: String? = null
    private var email: String? = null
    private var profileImageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            firstName = it.getString("FIRST_NAME")
            middleName = it.getString("MIDDLE_NAME")
            lastName = it.getString("LAST_NAME")
            email = it.getString("EMAIL")
            profileImageUrl = it.getString("PROFILE_IMAGE_URL")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_profile_client, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profilePicture: ShapeableImageView = view.findViewById(R.id.profilePicture)
        val etFirstName: EditText = view.findViewById(R.id.etFirstName)
        val etMiddleName: EditText = view.findViewById(R.id.etMiddleName)
        val etLastName: EditText = view.findViewById(R.id.etLastName)
        val etEmail: EditText = view.findViewById(R.id.etEmail)
        val btnSave: Button = view.findViewById(R.id.btnSave)
        val btnBackClient: ImageButton = view.findViewById(R.id.btnBackClient)

        // Set the values to the views
        etFirstName.setText(firstName)
        etMiddleName.setText(middleName)
        etLastName.setText(lastName)
        etEmail.setText(email)

        profileImageUrl?.let {
            Picasso.get()
                .load(it)
                .placeholder(R.drawable.profile)
                .error(R.drawable.profile)
                .into(profilePicture)
        }

        btnSave.setOnClickListener {
            // Handle save action here
        }

        btnBackClient.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(
            firstName: String?,
            middleName: String?,
            lastName: String?,
            email: String?,
            profileImageUrl: String?
        ) = MyProfileFragmentClient().apply {
            arguments = Bundle().apply {
                putString("FIRST_NAME", firstName)
                putString("MIDDLE_NAME", middleName)
                putString("LAST_NAME", lastName)
                putString("EMAIL", email)
                putString("PROFILE_IMAGE_URL", profileImageUrl)
            }
        }
    }
}
