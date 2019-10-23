package com.filmfy.app.ui.search

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.EditorInfo
import androidx.annotation.Nullable
import androidx.annotation.VisibleForTesting
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.IdlingResource
import com.filmfy.R
import com.filmfy.app.base.GenericActivity
import com.filmfy.app.idlingResource.SimpleIdlingResource
import com.filmfy.app.navigator.Navigator
import com.filmfy.app.ui.search.adapter.SearchFilmAdapter
import com.filmfy.app.utils.hideSoftKeyboard
import com.filmfy.app.utils.showToast
import com.filmfy.app.widget.RxBus
import com.filmfy.app.widget.RxEvent
import com.filmfy.domain.entitites.Film
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.view_movie_list.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class SearchActivity : GenericActivity(), SearchContract.View {

    private lateinit var scrollListener: RecyclerView.OnScrollListener
    private val presenter: SearchContract.Presenter by inject { parametersOf(this) }

    private var updatedFilms: Boolean = false
    private var adapter : SearchFilmAdapter? = null
    private var film: ArrayList<Film> = ArrayList()

    @Nullable
    var mIdlingResource: SimpleIdlingResource = SimpleIdlingResource()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        getIdlingResource()
        configureSearchInputListeners()
        initRecyclerView()
        listenEvents()
    }

    private fun listenEvents(){
        eventListener = RxBus.listen(RxEvent.UpdateFilmFavourite::class.java).subscribe {
            updateFilStatus(it)
        }
    }

    private fun updateFilStatus(event: RxEvent.UpdateFilmFavourite){
        film.forEachIndexed { index, element ->
            if(element.id == event.film.id){
                element.favourite = event.isSave
                film[index] = element
                adapter?.updateFavaoriteFilm(index)
            }
        }
    }

    private fun initRecyclerView(){
        recyclerViewMovieList?.layoutManager = GridLayoutManager(this, 2)
        setRecyclerViewScrollListener()
        adapter = SearchFilmAdapter(0.0, film) { film, isSave, clickDetail ->
            presenter.onItemSave(film, isSave = isSave, clickDetail = clickDetail)
        }

        recyclerViewMovieList?.adapter = adapter
    }

    private fun setRecyclerViewScrollListener() {
        scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val totalItemCount = recyclerView.layoutManager?.itemCount
                val layoutManager = recyclerViewMovieList?.layoutManager as GridLayoutManager
                val lastItem = layoutManager.findLastCompletelyVisibleItemPosition()

                if (totalItemCount == lastItem + 1) {
                    updatedFilms = true
                    presenter.sumPagination()
                    callPresenterDoSearch(editTextSearch?.text.toString(), gettingNewGenre = false, idlingResource = mIdlingResource)
                    recyclerViewMovieList.removeOnScrollListener(scrollListener)
                }
            }
        }
        recyclerViewMovieList.addOnScrollListener(scrollListener)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_favorite -> {
                Navigator.Search.openFavourite(this)
            }
        }
        return true
    }

    private fun configureSearchInputListeners() {
        editTextSearch.setOnEditorActionListener { textView, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                presenter.resetPagination()
                callPresenterDoSearch(textView?.text.toString(), gettingNewGenre = true, idlingResource = mIdlingResource)
            }
            false
        }

        buttonSearch.setOnClickListener {
            buttonSearch.text?.toString()?.let {
                presenter.resetPagination()
                callPresenterDoSearch(editTextSearch?.text.toString(), gettingNewGenre = true, idlingResource = mIdlingResource)
                hideSoftKeyboard()
            }
        }
    }

    fun callPresenterDoSearch(textToSearch: String, gettingNewGenre: Boolean, @Nullable idlingResource: SimpleIdlingResource?){
        presenter.doSearch(textToSearch, gettingNewGenre = gettingNewGenre, idlingResource = idlingResource)
    }

    override fun genreSearchError() {
        editTextSearch?.text?.clear()
        showToast(this@SearchActivity, getString(R.string.search_error))
    }

    override fun showFilms(films: ArrayList<Film>, media: Double) {
        if(updatedFilms){
            recyclerViewMovieList.addOnScrollListener(scrollListener)
        }

        this.film.addAll(films.toMutableList())
        adapter?.update(media)
    }

    override fun doVisibleFilmItems() {
        recyclerViewMovieList?.visibility = VISIBLE
        textViewMovieListCallToAction?.visibility = GONE
    }

    override fun openDetail(film: Film) {
        Navigator.Search.openDetail(this@SearchActivity, film)
    }

    override fun resetFilms() {
        if(film.isNotEmpty()){
            film.clear()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    @VisibleForTesting
    fun getIdlingResource(): IdlingResource {
        return mIdlingResource
    }
}
