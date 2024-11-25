package com.example.homework2511
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
    val students: MutableList<StudentModel>,
    private val onEditClick: (StudentModel, Int)->Unit,
    private val onRemoveClick: (StudentModel, Int)->Unit
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    var contextMenuPosition: Int = -1

    inner class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnCreateContextMenuListener {
        val textStudentName: TextView = itemView.findViewById(R.id.text_student_name)
        val textStudentId: TextView = itemView.findViewById(R.id.text_student_id)
//        val imageEdit: ImageView = itemView.findViewById(R.id.image_edit)
//        val imageRemove: ImageView = itemView.findViewById(R.id.image_remove)

        init {
            // Register the ViewHolder item for Context Menu
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
            // Inflate the context menu
            menu.setHeaderTitle("Options")
            menu.clear()
//            menu.add(adapterPosition, R.id.context_edit, 0, "Edit")
//            menu.add(adapterPosition, R.id.context_remove, 1, "Remove")
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_student_item,
            parent, false)
        return StudentViewHolder(itemView)
    }

    override fun getItemCount(): Int = students.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]

        holder.textStudentName.text = student.studentName
        holder.textStudentId.text = student.studentId

//        // Click listeners for Edit and Remove actions
//        holder.imageEdit.setOnClickListener {
//            onEditClick(student, position)
//        }
//
//        holder.imageRemove.setOnClickListener {
//            onRemoveClick(student, position)
//        }

        // Long-click listener for Context Menu
        holder.itemView.setOnClickListener {
            contextMenuPosition = position // Set the context menu position
            false // Return false to allow further processing of the long-click event
        }
    }
}