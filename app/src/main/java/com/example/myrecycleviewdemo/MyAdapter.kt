package com.example.myrecycleviewdemo

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val studentList: List<Student>,
                 private val listener: OnItemClickListener): RecyclerView.Adapter<MyAdapter.MyViewHolder> () {
    inner class MyViewHolder(view: View)
        : RecyclerView.ViewHolder(view), View.OnClickListener {
        val tvId:TextView = view.findViewById(R.id.tv_studId)
        val tvName:TextView = view.findViewById(R.id.tv_studName)
        val tvProg:TextView = view.findViewById(R.id.tv_studProg)
        val imgProf:ImageView = view.findViewById(R.id.img_studProf)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val position = bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.itemClick(position)
            }
        }
    }

    interface OnItemClickListener{
        fun itemClick(position:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentStudent = studentList[position]
        holder.tvId.text = currentStudent.id
        holder.tvName.text = currentStudent.name
        holder.tvProg.text = currentStudent.programme

        if (currentStudent.gender == "F"){
            holder.imgProf.setImageResource(R.drawable.ic_female)
        }
        else{
            holder.imgProf.setImageResource(R.drawable.ic_male)
        }
    }

    override fun getItemCount(): Int {
        return  studentList.size
    }
}