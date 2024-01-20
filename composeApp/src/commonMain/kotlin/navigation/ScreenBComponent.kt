package navigation

import com.arkivanov.decompose.ComponentContext

class ScreenBComponent(
    componentContext: ComponentContext,
    val text: String,
    private val onGoBack: () -> Unit
) : ComponentContext by componentContext {

    fun goBack() {
        onGoBack()
    }

}