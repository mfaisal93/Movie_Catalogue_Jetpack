package com.faisal.moviecataloguesubmission3.utils

import androidx.annotation.VisibleForTesting
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors  @VisibleForTesting constructor(
    private val diskIO: Executor,
    private val networkIO: Executor
) {

    companion object {
        private const val COUNT = 2
    }

    constructor() : this(
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(COUNT)
    )

    fun diskIO(): Executor = diskIO

    fun networkIO(): Executor = networkIO

}