/**
 * Copyright (C) 2018 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mirek.architecture.ui.platform
import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mirek.architecture.di.ApplicationComponent
import com.mirek.architecture.ui.MirekApplication
import com.mirek.architecture.ui.application.Navigator
import javax.inject.Inject

/**
 * Base Fragment class with helper methods for handling views and back button events.
 *
 * @see Fragment
 */
abstract class BaseFragment : Fragment() {

    abstract fun layoutId(): Int

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (activity?.application as MirekApplication).appComponent
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigator : Navigator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflateView( container)

    private fun LayoutInflater.inflateView(container: ViewGroup?): View {
        return inflate(layoutId(), container, false)
    }

    open fun onBackPressed() {}

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null
}
