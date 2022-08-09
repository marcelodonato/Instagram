package com.marcelodonato.instagram.search.view

import android.app.SearchManager
import android.content.Context
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcelodonato.instagram.R
import com.marcelodonato.instagram.common.base.BaseFragment
import com.marcelodonato.instagram.common.base.DependencyInjector
import com.marcelodonato.instagram.common.model.UserAuth
import com.marcelodonato.instagram.databinding.FragmentSearchBinding
import com.marcelodonato.instagram.search.Search
import com.marcelodonato.instagram.search.presentation.SearchPresenter
import com.marcelodonato.instagram.search.view.adapter.SearchAdapter

class SearchFragment : BaseFragment<FragmentSearchBinding, Search.Presenter>(
    R.layout.fragment_search, FragmentSearchBinding::bind
), Search.View {

    override lateinit var presenter: Search.Presenter
    private val adapter = SearchAdapter()


    override fun setupViews() {

        binding?.searchRv?.layoutManager = LinearLayoutManager(requireContext())
        binding?.searchRv?.adapter = adapter
    }

    override fun setupPresenter() {
        val repository = DependencyInjector.searchRepository()
        presenter = SearchPresenter(this, repository)
    }

    override fun getMenu() = R.menu.menu_search

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        val searchManager =
            requireActivity().getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = (menu.findItem(R.id.menu_search).actionView as SearchView)
        searchView.apply {
            setSearchableInfo(searchManager.getSearchableInfo(requireActivity().componentName))
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText?.isNotEmpty() == true) {
                        presenter.fetchUser(newText)
                        return true
                    }
                    return false
                }
            })
        }
    }

    override fun showProgress(enabled: Boolean) {
        binding?.searchProgress?.visibility = if (enabled) View.VISIBLE else View.GONE
    }

    override fun displayFullUsers(users: List<UserAuth>) {
        binding?.searchTxtEmpty?.visibility = GONE
        binding?.searchRv?.visibility = VISIBLE
        adapter.items = users
        adapter.notifyDataSetChanged()

    }

    override fun displayEmptyUsers() {
        binding?.searchTxtEmpty?.visibility = VISIBLE
        binding?.searchRv?.visibility = GONE
    }
}