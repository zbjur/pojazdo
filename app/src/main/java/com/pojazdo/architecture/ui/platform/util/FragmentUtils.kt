package com.pojazdo.architecture.ui.platform.util

import android.content.Context

import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.NonNull
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.pojazdo.architecture.ui.platform.BaseActivity

import com.pojazdo.architecture.ui.platform.BaseFragment



/**
 * Helper class to manage all operation on [android.support.v4.app.FragmentManager]
 *
 * @author krzysztof.janik
 */
object FragmentUtils {

    private val TAG = FragmentUtils::class.java.name

    /**
     * Add a fragment to the activity state.
     *
     * @param activity        [android.app.Activity] in which context we  are working on.
     * @param fragment        [android.support.v4.app.Fragment] to be added.
     * @param containerViewId sellerId of the fragment container layout.
     * @param addToBackStack  flag indicating whether this fragment should be added to the back stack.
     */
    @JvmOverloads
    fun addFragment(activity: BaseActivity, fragment: BaseFragment?, containerViewId: Int, addToBackStack: Boolean = false) {
        if (fragment == null) {
            throw IllegalArgumentException("Attempt to add invalid fragment (fragment == null")
        }

        if (!checkActivityState(activity)) {
            return
        }

        if (!addToBackStack) {
            activity.supportFragmentManager.beginTransaction()
                    .add(containerViewId, fragment, fragment.javaClass.name)
                    .commit()
        } else {
            activity.supportFragmentManager.beginTransaction()
                    .add(containerViewId, fragment, fragment.javaClass.name)
                    .addToBackStack(null)
                    .commit()
        }
    }

    /**
     * Checks state of the activity on which we are working on.
     *
     * @param activity [android.app.Activity] in which context we are working on.
     * @return The flag which indicate if [android.support.v4.app.FragmentManager] can work in selected activity context;
     */
    private fun checkActivityState(activity: FragmentActivity?): Boolean {
        val activeState = !(activity == null || activity!!.isFinishing)
        if (!activeState) {
            Log.d(TAG, "Cannot add fragment (activity == null || activity.isFinishing()")

        }

        return activeState
    }

    /**
     * Replace a fragment inside view container.
     *
     * @param activity [android.app.Activity] in which context we  are working on.
     * @param fragment [android.support.v4.app.Fragment] to be added.
     * @param containerViewId  Fragment container.
     * @param addToBackStack Flag indicating if the fragment should be added to back stack.
     */
    @JvmOverloads
    fun replaceFragment(activity: BaseActivity, fragment: BaseFragment?, containerViewId: Int, addToBackStack: Boolean = false) {
        if (fragment == null) {
            throw IllegalArgumentException("Attempt to add invalid fragment (fragment == null")
        }

        if (!checkActivityState(activity)) {
            return
        }

        if (!addToBackStack) {
            activity.supportFragmentManager.beginTransaction()
                    .replace(containerViewId, fragment, fragment.javaClass.name)
                    .commit()
        } else {
            activity.supportFragmentManager.beginTransaction()
                    .replace(containerViewId, fragment, fragment.javaClass.name)
                    .addToBackStack(null)
                    .commit()
        }
    }


    /**
     * Change [android.support.v4.app.Fragment] visibility.
     *
     * @param activity [android.app.Activity] in which context we  are working on.
     * @param tag      The tag of the [android.support.v4.app.Fragment] which will have changed visibility.
     * @param show     The flag to determinate visibility of the fragment.
     */
    fun changeFragmentVisibility(activity: BaseActivity, tag: String, show: Boolean) {
        val fragment = getFragmentByTag(activity, tag)
        if (fragment == null) {
            Log.d(TAG, "Cannot process fragment (fragment == null)")
            return
        }

        val transaction = activity.supportFragmentManager.beginTransaction()
        if (show) {
            transaction.show(fragment)
        } else {
            transaction.hide(fragment)
        }
        transaction.commit()
    }

    /**
     * Returns [android.support.v4.app.Fragment] with proper tag.
     *
     * @param activity [android.app.Activity] in which context we  are working on.
     * @param tag      The tag of the [android.support.v4.app.Fragment] which will have changed visibility.
     */
    fun getFragmentByTag(activity: BaseActivity, tag: String): Fragment? {
        if (!checkActivityState(activity)) {
            return null
        }

        val fragment = activity.supportFragmentManager.findFragmentByTag(tag)
        if (fragment == null) {
            Log.d(TAG, "Cannot find fragment with tag = $tag")
            return null
        }

        return fragment
    }

    /**
     * Returns [android.support.v4.app.Fragment] with proper sellerId.
     *
     * @param activity [android.app.Activity] in which context we  are working on.
     * @param id      The sellerId of the [android.support.v4.app.Fragment] which will have changed visibility.
     */
    fun getFragmentById(activity: BaseActivity, id: Int): Fragment? {
        if (!checkActivityState(activity)) {
            return null
        }

        val fragment = activity.getSupportFragmentManager().findFragmentById(id)
        if (fragment == null) {
            Log.d(TAG, "Cannot find fragment with sellerId = $id")
            return null
        }

        return fragment
    }

    /**
     * Change [android.support.v4.app.Fragment] visibility.
     *
     * @param activity [android.app.Activity] in which context we  are working on.
     * @param fragment The [android.support.v4.app.Fragment] which will have changed visibility.
     * @param show     The flag to determinate visibility of the fragment.
     */
    fun changeFragmentVisibility(activity: BaseActivity, fragment: Fragment?, show: Boolean) {
        if (fragment == null) {
            Log.d(TAG, "Cannot process fragment (fragment == null)")
            return
        }

        val transaction = activity.supportFragmentManager.beginTransaction()
        if (show) {
            transaction.show(fragment)
        } else {
            transaction.hide(fragment)
        }
        transaction.commit()
    }

    /**
     * Remove a fragment from the activity state.
     *
     * @param activity [android.app.Activity] in which context we are working on.
     * @param tag      The tag of the [android.support.v4.app.Fragment] to be removed.
     */
    fun removeFragment(activity: BaseActivity, tag: String) {
        val fragment = getFragmentByTag(activity, tag)
        if (fragment == null) {
            Log.d(TAG, "Cannot process fragment (fragment == null)")
            return
        }

        activity.supportFragmentManager.beginTransaction()
                .remove(fragment)
                .commit()
    }

    /**
     * Removes the top fragment added via [addFragment][com.cardiosecur.active.util.FragmentUtils.addFragment] method with `addToBackStack` flag set to true.
     * @param activity [android.app.Activity] in which context we are working on.
     */
    fun popBackStack(activity: FragmentActivity) {
        activity.getSupportFragmentManager().popBackStack()
    }

    /**  Add a [android.support.v4.app.DialogFragment] to the activity state.
     * @param activity [android.app.Activity] in which context we are working on.
     * @param dialogFragment The [android.support.v4.app.DialogFragment] to be added.
     */
/*    fun showDialogFragment(activity: FragmentActivity, dialogFragment: DialogFragment?) {
        if (dialogFragment == null) {
            Log.d(TAG, "Cannot process fragment (fragment == null)")
            return
        }

        if (!checkActivityState(activity)) {
            return
        }
        val tag = dialogFragment!!.getClass().getName()
        if (!isDialogShown(activity.getSupportFragmentManager(), tag)) {
            dialogFragment!!.show(activity.getSupportFragmentManager(), tag)
        }
    }*/

    /**
     * Retrieves the current back stack size.
     * @param activity [android.app.Activity] in which context we are working on.
     * @return back stack size.
     */
    fun getBackStackEntryCount(activity: FragmentActivity): Int {
        return activity.getSupportFragmentManager().getBackStackEntryCount()
    }

    /**
     * Hides the soft keyboard.
     * @param context
     * @param editText
     */
    fun hideSoftKeyboard(context: Context, editText: EditText) {

        val imm = context.getSystemService(
                Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText.windowToken, 0)
    }

    /**
     * Shows soft keyboard for provided edit text.
     * @param context Context.
     * @param editText Focused edit text.
     */
    fun showSoftKeyboard(context: Context, editText: EditText) {
        val imm = context.getSystemService(
                Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
/*
    fun dismissDialogIfShown(fragmentManager: FragmentManager, @NonNull existingDialog: DialogFragment) {
        val isShown = isDialogShown(fragmentManager, existingDialog.getTag())
        if (isShown) {
            existingDialog.dismiss()
        }
    }*/

    fun isDialogShown(fragmentManager: FragmentManager, @NonNull dialogTag: String): Boolean {
        val existingDialog = fragmentManager.findFragmentByTag(dialogTag)
        var isShown = false
        if (existingDialog is DialogFragment) {
            val dialogFragment = existingDialog as DialogFragment
            isShown = dialogFragment.isAdded() && !dialogFragment.isRemoving() && dialogFragment.getDialog() != null && dialogFragment.getDialog().isShowing()
        }
        return isShown
    }
}
/**
 * Add a fragment to the activity state.
 *
 * @param activity [android.app.Activity] in which context we  are working on.
 * @param fragment [android.support.v4.app.Fragment] to be added.
 */
/**
 * Replace a fragment inside view container.
 * @param activity [android.app.Activity] in which context we  are working on.
 * @param fragment [android.support.v4.app.Fragment] to be added.
 * @param containerViewId  Fragment container.
 */
