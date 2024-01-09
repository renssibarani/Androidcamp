package com.mandiri.mandiriapps.module

import android.content.Context
import android.content.SharedPreferences
import com.mandiri.mandiriapps.helper.SharedPrefHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SharePreferenceModule {
    private const val PREF_NAME = "my_preference"
    @Provides
    fun provideSharedPreference(@ApplicationContext  context: Context):SharedPreferences{
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    fun provideSharedPreferenceHelper(sharedPreferences: SharedPreferences):SharedPrefHelper{
        return SharedPrefHelper(sharedPreferences)
    }

}
