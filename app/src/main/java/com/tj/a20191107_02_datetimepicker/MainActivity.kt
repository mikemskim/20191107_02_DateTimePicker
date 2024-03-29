package com.tj.a20191107_02_datetimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        selectDateBtn.setOnClickListener {
            var datePickerDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                    var selectedDate = Calendar.getInstance()
                    selectedDate.set(year, month, dayOfMonth)

                    var sdf = SimpleDateFormat("yyyy년 M월 d일")

//                    dateText.text = "${year}년 ${month+1}월 ${dayOfMonth}일"

                    dateText.text = sdf.format(selectedDate.time)

                },2019,Calendar.NOVEMBER,9)

            datePickerDialog.show()
        }

        selectTimeBtn.setOnClickListener {
            var timePickerDialog = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    var selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    selectedTime.set(Calendar.MINUTE, minute)

                    var sdf = SimpleDateFormat("a h:m")
                    timeText.text = sdf.format(selectedTime)
                }, 10, 20, true)

            timePickerDialog.show()
        }
    }

    override fun setValues() {

    }


}
