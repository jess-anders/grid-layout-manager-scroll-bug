package com.example.gridlayoutmanagerbug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = GridLayoutManager(this, 1)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = Adapter()

        findViewById<Button>(R.id.scroll_button).setOnClickListener {
            layoutManager.let {
                val smoothScroller = object : LinearSmoothScroller(this) {
                    override fun getVerticalSnapPreference(): Int {
                        return SNAP_TO_START
                    }

                    override fun onStart() {
                        super.onStart()
                    }

                    override fun onStop() {
                        super.onStop()
                    }
                }
                smoothScroller.targetPosition = 30
                it.startSmoothScroll(smoothScroller)
            }
        }
    }
}