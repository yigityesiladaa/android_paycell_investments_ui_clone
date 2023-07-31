package com.investmentmenuui.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.investmentmenuui.R
import com.investmentmenuui.databinding.CustomToolbarBinding

class CustomToolbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs), LifecycleEventObserver {

    private var _binding: CustomToolbarBinding? = null
    private val binding get() = _binding!!
    private var title: String = ""
    private var iconRes: Drawable? = null

    init {
        initializeToolbarAttributes(context, attrs)
        initView()
    }

    private fun initializeToolbarAttributes(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomToolbar)
        title = typedArray.getString(R.styleable.CustomToolbar_title) ?: ""
        iconRes = typedArray.getDrawable(R.styleable.CustomToolbar_iconResource)
        typedArray.recycle()
    }

    private fun initView() {
        _binding = CustomToolbarBinding.inflate(LayoutInflater.from(context), this, true).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            txtToolbarTitle.text = title
            icToolbar.setImageDrawable(iconRes)
        }
        shouldShowIcon()
    }

    private fun shouldShowIcon() {
        binding.icToolbar.apply {
            setImageDrawable(iconRes)
            visibility = if (iconRes != null) View.VISIBLE else View.GONE
        }
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_DESTROY -> {
                source.lifecycle.removeObserver(this)
                _binding = null
            }
            else -> {}
        }
    }
}

