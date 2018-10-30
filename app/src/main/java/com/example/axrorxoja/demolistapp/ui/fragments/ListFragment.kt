package com.example.axrorxoja.demolistapp.ui.fragments


import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.example.axrorxoja.demolistapp.R
import com.example.axrorxoja.demolistapp.adapter.UserAdapter
import com.example.axrorxoja.demolistapp.entity.main.MainResponse
import com.example.axrorxoja.demolistapp.extension.changeVisibility
import com.example.axrorxoja.demolistapp.presentation.main.IPresenterMain
import com.example.axrorxoja.demolistapp.presentation.main.IViewMain
import com.example.axrorxoja.demolistapp.ui.global.BaseDaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class ListFragment : BaseDaggerFragment(),
    IViewMain<MainResponse> {
    override val layoutRes: Int = R.layout.fragment_main

    @Inject lateinit var presenter: IPresenterMain

    private val adapter by lazy { UserAdapter(context!!, mutableListOf()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadList()
        rv.adapter = adapter
    }

    override fun onSuccess(data: MainResponse) = adapter.updateData(data.users)

    override fun onFail(stringRes: Int) {
        onShowProgress(false)
        val snack = Snackbar.make(
            activity!!.findViewById(android.R.id.content),
            stringRes,
            Snackbar.LENGTH_SHORT
        )
        if (stringRes == R.string.network_not_available) {
            snack.setAction(R.string.retry) { presenter.loadList() }
            snack.duration = Snackbar.LENGTH_INDEFINITE
        }
        snack.show()
    }

    override fun onShowProgress(isShow: Boolean) = pb.changeVisibility(isShow)

    override fun lifeCycle(): LifecycleOwner = this
}
