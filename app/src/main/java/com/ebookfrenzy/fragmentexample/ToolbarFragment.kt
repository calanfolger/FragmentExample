package com.ebookfrenzy.fragmentexample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.content.Context
import android.util.Log
import kotlinx.android.synthetic.main.toolbar_fragment.*
import android.widget.Button

/**
 * Created by Calan on 2/20/2018.
 */
class ToolbarFragment : Fragment(), SeekBar.OnSeekBarChangeListener
{
    var seekvalue = 10

    var activityCallBack: ToolbarFragment.ToolbarListener? = null

    interface ToolbarListener
    {
        fun onButtonClick(position: Int, text: String)
    }

    override fun onAttach(context: Context?)
    {
        super.onAttach(context)
        try
        {
            activityCallBack = context as ToolbarListener
        }
        catch (e: ClassCastException)
        {
            throw ClassCastException(context?.toString()
                                      + " must implement ToolbarListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater?.inflate(R.layout.toolbar_fragment, container, false)
//        seekBar1.setOnSeekBarChangeListener(this)
//        button1.setOnClickListener { v: View -> buttonClicked(v)}

        // Inflate the layout for this fragment
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        seekBar1.setOnSeekBarChangeListener(this)

        button1.setOnClickListener { v: View -> buttonClicked(v)}

    }

    private fun buttonClicked(view: View)
    {
        activityCallBack?.onButtonClick(seekvalue,
                editText1.text.toString())
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                   fromUser: Boolean)
    {
        seekvalue = progress
    }

    override fun onStartTrackingTouch(arg0: SeekBar)
    {
    }

    override fun onStopTrackingTouch(arg0: SeekBar)
    {
    }
}