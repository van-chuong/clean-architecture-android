package com.example.clean_chitecture.presentation.views.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.clean_chitecture.R
import com.example.clean_chitecture.databinding.ActivityMainBinding
import com.example.clean_chitecture.presentation.base.BaseActivity

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onStart() {
        super.onStart()
        startRouter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    private fun startRouter() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment?
        navHostFragment?.navController?.setGraph(R.navigation.nav_graph)
    }

    /**
     * Called to process touch screen events.
     *
     * @param event the touch screen event
     * @return boolean Return true if this event was consumed.
     */
    @SuppressWarnings("ComplexCondition")
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        val v = currentFocus
        if (v is EditText) {
            val scoops = IntArray(2)
            v.getLocationOnScreen(scoops)
            val x = event.rawX + v.getLeft() - scoops[0]
            val y = event.rawY + v.getTop() - scoops[1]
            if (event.action == MotionEvent.ACTION_UP &&
                (x < v.getLeft() || x >= v.getRight() || y < v.getTop() || y > v.getBottom())
            ) {
                v.clearFocus()
                hideSoftKeyboard(v)
            }
        }
        return super.dispatchTouchEvent(event)
    }

    private fun hideSoftKeyboard(view: View) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}