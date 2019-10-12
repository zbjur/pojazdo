package com.pojazdo.mobile.ui.vehiclesummary.view

import com.pojazdo.mobile.R

class TimeLineEventState : TimeLineState {

    enum class TimeLineStateEnum(val state: Int) {

        FIRST_REGISTRATION_ABROAD(1),
        FIRST_REGISTRATION_IN_POLAND(2),
        FIRST_OWNER_IN_POLAND(3),
        TECHNICAL_EXAMINATION(4),
        OWNER_CHANGE(5),
        ADDITIONAL_OF_CO_OWNER(6);
    }

    override fun getTimeLineCircleState(state: Int): Int {
        return when (state) {
            TimeLineStateEnum.FIRST_REGISTRATION_ABROAD.state ->
                R.drawable.time_line_change_first_registration_abroad_img_shape
            TimeLineStateEnum.FIRST_REGISTRATION_IN_POLAND.state ->
                R.drawable.time_line_firts_registration_in_poland_img_shape
            TimeLineStateEnum.FIRST_OWNER_IN_POLAND.state ->
                R.drawable.time_line_firs_owner_in_poland_img_shape
            TimeLineStateEnum.TECHNICAL_EXAMINATION.state ->
                R.drawable.time_line_technical_of_examination_img_shape
            TimeLineStateEnum.ADDITIONAL_OF_CO_OWNER.state ->
                R.drawable.time_line_additional_of_co_owner_img_shape
            else -> R.drawable.time_line_additional_of_co_owner_img_shape
        }
    }

    override fun getTimeLineBarState(state: Int): Int {
        return when (state) {
            TimeLineStateEnum.FIRST_REGISTRATION_ABROAD.state ->
                R.drawable.time_line_change_first_registration_abroad_img_shape
            TimeLineStateEnum.FIRST_REGISTRATION_IN_POLAND.state ->
                R.drawable.time_line_firts_registration_in_poland_img_shape
            TimeLineStateEnum.FIRST_OWNER_IN_POLAND.state ->
                R.drawable.time_line_firs_owner_in_poland_img_shape
            TimeLineStateEnum.TECHNICAL_EXAMINATION.state ->
                R.drawable.time_line_technical_of_examination_img_shape
            TimeLineStateEnum.ADDITIONAL_OF_CO_OWNER.state ->
                R.drawable.time_line_additional_of_co_owner_img_shape
            else -> R.drawable.time_line_additional_of_co_owner_img_shape
        }
    }
}

interface TimeLineState {
    fun getTimeLineCircleState(state: Int): Int
    fun getTimeLineBarState(state: Int): Int
}