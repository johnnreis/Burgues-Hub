package com.example.burgershub.presenter.burgers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.burgershub.databinding.BurguerItemBinding
import com.example.burgershub.domain.model.Burger
import com.example.burgershub.utils.formattedValue
import com.squareup.picasso.Picasso

class BurgerAdapter (
    private val burgers: List<Burger>,
    private val burgerClick: (Int) -> Unit
) : RecyclerView.Adapter<BurgerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            BurguerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = burgers.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val burger = burgers[position]

        holder.binding.textName.text = burger.name
        holder.binding.textDescription.text = burger.desc
        holder.binding.textPrice.text = burger.price?.formattedValue()

        // To Load Show image response
        Picasso
            .get()
            .load(burger.images?.get(1)?.lg)
            .into(holder.binding.imageBurger)

        holder.itemView.setOnClickListener { burgerClick(burger.id ?: 0) }

    }

    inner class MyViewHolder(val binding: BurguerItemBinding)
        : RecyclerView.ViewHolder(binding.root)
}