package com.capstone.peopleconnect.Client.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.capstone.peopleconnect.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class ProfileFragmentClient : Fragment() {

    private var firstName: String? = null
    private var middleName: String? = null
    private var lastName: String? = null
    private var userAddress: String? = null
    private var email: String? = null
    private var profileImageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            firstName = it.getString("FIRST_NAME")
            middleName = it.getString("MIDDLE_NAME")
            lastName = it.getString("LAST_NAME")
            userAddress = it.getString("USER_ADDRESS")
            email = it.getString("EMAIL")
            profileImageUrl = it.getString("PROFILE_IMAGE_URL")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_client, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize UI elements
        val profileImageView: ShapeableImageView = view.findViewById(R.id.ivProfileImage)
        val nameTextView: TextView = view.findViewById(R.id.tvName)
        val emailTextView: TextView = view.findViewById(R.id.tvEmail)
        val locationTextView: TextView = view.findViewById(R.id.tvLocation)
        val bookingCountTextView: TextView = view.findViewById(R.id.tvBookingCount)

        // Set values to UI elements
        val fullName = "$firstName $middleName $lastName"
        nameTextView.text = fullName
        emailTextView.text = email
        locationTextView.text = userAddress

        // Load profile image using Picasso
        profileImageUrl?.let {
            Picasso.get()
                .load(it)
                .placeholder(R.drawable.profile) // Placeholder image
                .error(R.drawable.profile) // Error image
                .into(profileImageView)
        }



        val profileIcons: LinearLayout = view.findViewById(R.id.profileMenuLayout)
        profileIcons.setOnClickListener {
            val profileFragment = MyProfileFragmentClient.newInstance(
                firstName = firstName,
                middleName = middleName,
                lastName = lastName,
                email = email,
                profileImageUrl = profileImageUrl
            )
            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, profileFragment)
                .addToBackStack(null)
                .commit()
        }

        val locationIcons: LinearLayout = view.findViewById(R.id.locationMenuLayout)
        locationIcons.setOnClickListener {
            val locationFragment = LocationFragmentClient()
            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, locationFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(
            firstName: String?,
            middleName: String?,
            lastName: String?,
            userAddress: String?,
            email: String?,
            profileImageUrl: String?
        ) = ProfileFragmentClient().apply {
            arguments = Bundle().apply {
                putString("FIRST_NAME", firstName)
                putString("MIDDLE_NAME", middleName)
                putString("LAST_NAME", lastName)
                putString("USER_ADDRESS", userAddress)
                putString("EMAIL", email)
                putString("PROFILE_IMAGE_URL", profileImageUrl)
            }
        }
    }
}
