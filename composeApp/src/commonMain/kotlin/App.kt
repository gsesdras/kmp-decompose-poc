import androidx.compose.animation.core.tween
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.RootComponent
import screens.ScreenA
import screens.ScreenB

@Composable
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        val childStack by rootComponent.childStack.subscribeAsState()

        Children(
            stack = childStack,
            animation = stackAnimation(slide(animationSpec = tween(durationMillis = 150)))
        ) { child ->
            when(val instance = child.instance) {
                is RootComponent.Child.ScreenA -> ScreenA(instance.component)
                is RootComponent.Child.ScreenB -> ScreenB(instance.component.text, instance.component)
            }
        }
    }
}