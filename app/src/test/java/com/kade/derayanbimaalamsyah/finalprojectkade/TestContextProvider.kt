package com.kade.derayanbimaalamsyah.finalprojectkade

import com.kade.derayanbimaalamsyah.finalprojectkade.utils.CoroutineContextProvider
import kotlinx.coroutines.experimental.Unconfined
import kotlin.coroutines.experimental.CoroutineContext

class TestContextProvider : CoroutineContextProvider() {
    override val main: CoroutineContext = Unconfined
}