package com.kalum.wheel.ui.users


import com.kalum.wheel.data.local.UserDao
import com.kalum.wheel.data.remote.response.Response
import com.kalum.wheel.data.remote.response.Status
import com.kalum.wheel.domain.model.User
import com.kalum.wheel.domain.repository.UserRepository
import com.kalum.wheel.ui.base.BaseViewModel
import com.kalum.wheel.util.schedulers.BaseScheduler
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class UserViewModel
@Inject constructor(
        private val userDao: UserDao,
        private val scheduler: BaseScheduler,
        private val userRepository: UserRepository
) : BaseViewModel<List<User>>() {

    lateinit var composite: Disposable
    override fun loadData() {

        composite = userRepository.getUsers()
                .map({
                    userDao.deleteAll()
                    userDao.insertAll(it.data)
                    (it.data)

                })
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doOnSubscribe { loadingStatus.setValue(true) }
                .doAfterTerminate { loadingStatus.setValue(false) }
                .subscribe({ result ->
                    response.setValue(Response(Status.SUCCESS, result, null))
                }, { throwable ->
                    response.setValue(Response(Status.ERROR, null, throwable))
                })

    }

}