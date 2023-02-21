package com.example.recyclerviewnavigationfragments

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ColorListAdapter : RecyclerView.Adapter<ColorListAdapter.ColorListViewHolder>() {

    private val colorList = listOf(
        Pair("red", R.color.red),
        Pair("orange", R.color.orange),
        Pair("yellow", R.color.yellow),
        Pair("green", R.color.green),
        Pair("blue", R.color.blue),
        Pair("purple", R.color.purple)
    )

    class ColorListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val btn = view.findViewById<Button>(R.id.color)
    }

    override fun getItemCount(): Int {
        return colorList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorListViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        // Setup custom accessibility delegate to set the text read
        layout.accessibilityDelegate = Accessibility
        return ColorListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ColorListViewHolder, position: Int) {
        val colorName = colorList.get(position).first
        val colorValue = colorList.get(position).second

        with(holder.btn) {
            text = colorName
            setBackgroundColor(ContextCompat.getColor(context, colorValue))
            setOnClickListener {
                val action = ColorListFragmentDirections.actionColorListFragmentToHelloFragment(colorName, colorValue)
                holder.view.findNavController().navigate(action)
            }
        }
    }

    companion object Accessibility : View.AccessibilityDelegate() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(
            host: View,
            info: AccessibilityNodeInfo
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            // With `null` as the second argument to [AccessibilityAction], the
            // accessibility service announces "double tap to activate".
            // If a custom string is provided,
            // it announces "double tap to <custom string>".
            val customString = "elo"
            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info.addAction(customClick)
        }
    }
}