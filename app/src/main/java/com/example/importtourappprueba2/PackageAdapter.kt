package com.example.importtourappprueba2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.content.Context
import android.widget.ImageView
//import com.squareup.picasso.Picasso

import androidx.recyclerview.widget.RecyclerView
import data.TourPackage

class PackagesAdapter(private val context: Context, private val packages: List<TourPackage>) : RecyclerView.Adapter<PackagesAdapter.PackageViewHolder>() {
    inner class PackageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewPackageName)
        val transportTextView: TextView = itemView.findViewById(R.id.textViewTransport)
        val durationTextView: TextView = itemView.findViewById(R.id.textViewDuration)
        val starsRatingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        val priceTextView: TextView = itemView.findViewById(R.id.textViewPrice)
        val buyButton: Button = itemView.findViewById(R.id.buttonBuy)
        val imageViewPackage: ImageView = itemView.findViewById(R.id.imageViewPackage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_package, parent, false)
        return PackageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
        val currentPackage = packages[position]

        holder.nameTextView.text = currentPackage.name
        holder.transportTextView.text = currentPackage.transport.toString()
        holder.durationTextView.text = "Duration: ${currentPackage.duration} days"
        holder.starsRatingBar.rating = currentPackage.stars.toFloat()
        holder.priceTextView.text = "Price: $${currentPackage.price}"
        //Picasso.with(context).load(currentPackage.logo).into(holder.imageViewPackage)

        val buyButtonLabel = context.getString(R.string.buy_button_label_template, position + 1)
        holder.buyButton.text = buyButtonLabel

        holder.buyButton.setOnClickListener {
                // Acción al hacer clic en el botón "Buy"
                // Puedes implementar la lógica para comprar aquí
        }
    }

    override fun getItemCount(): Int {
            return packages.size
    }

}