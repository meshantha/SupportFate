package com.kalum.wheel.ui.schedules

import com.kalum.wheel.data.remote.response.Response
import com.kalum.wheel.data.remote.response.Status
import com.kalum.wheel.domain.model.Schedule
import com.kalum.wheel.domain.repository.ScheduleRepository
import com.kalum.wheel.ui.base.BaseViewModel
import com.kalum.wheel.util.schedulers.BaseScheduler
import com.kalum.wheel.util.SchedulePlannerUtil
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Kalum Fernando on 11/1/2018.
 */

class ScheduleViewModel
@Inject constructor(
        private val scheduler: BaseScheduler,
        private val engineerRepository: ScheduleRepository
) : BaseViewModel<List<Schedule>>() {

    lateinit var composite: Disposable

    override fun loadData() {
        composite = engineerRepository.getSchedules()
                .map({
                    SchedulePlannerUtil(it).schedules
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