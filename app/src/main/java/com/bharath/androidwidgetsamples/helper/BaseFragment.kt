package com.bharath.androidwidgetsamples.helper

import androidx.fragment.app.Fragment
import com.bharath.androidwidgetsamples.MainActivity

abstract class BaseFragment: Fragment() {

    protected val mainActivity: MainActivity
       get() = activity as MainActivity

    protected fun navigate(actionId: Int){
        mainActivity.navController.navigate(actionId)
    }

}