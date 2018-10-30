package com.example.axrorxoja.demolistapp.ui.fragments


import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import android.view.View
import com.example.axrorxoja.demolistapp.R
import com.example.axrorxoja.demolistapp.presentation.IViewActivity
import com.example.axrorxoja.demolistapp.presentation.main.IPresenterMain
import com.example.axrorxoja.demolistapp.presentation.main.IViewMain
import com.example.axrorxoja.demolistapp.ui.global.BaseDaggerFragment
import javax.inject.Inject

class ListFragment : BaseDaggerFragment(),
    IViewMain {
    override val layoutRes: Int = R.layout.fragment_main
    @Inject lateinit var presenter: IPresenterMain
    @Inject
    lateinit var activityView: IViewActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        btn_forgot.setOnClickListener { onForgot() }
//        ti_login.setOnEditorActionListener { _, actionId, _ -> onAction(actionId, this::onForgot) }
    }

    private fun onForgot() {
//        btn_forgot.hideKeyboard()
//        btn_forgot.isEnabled = false
//        presenter.loadList(
//            ti_first_name.text(),
//            ti_last_name.text(),
//            ti_login.text()
//        )
    }

    override fun onSuccess() {
//        activityView.onReset()
//        btn_forgot.isEnabled = true
    }

    override fun onFail(stringRes: Int) {
        onShowProgress(false)
//        btn_forgot.isEnabled = true
//        parent.showSnackbar(stringRes)
    }

    override fun onShowProgress(isShow: Boolean) {
//        pb.changeVisibility(isShow)
    }

    override fun lifeCycle(): LifecycleOwner = this
}
