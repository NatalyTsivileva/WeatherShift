package ru.civilea.weathershift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import ru.civilea.core.model.Navigator
import ru.civilea.weathershift.model.City
import ru.civilea.weathershift.ru.civilea.weathershift.MainNavigatorImpl

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}