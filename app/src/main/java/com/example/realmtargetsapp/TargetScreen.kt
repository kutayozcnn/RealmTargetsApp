import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.example.realmtargetsapp.RealmData


@Composable
fun TargetScreen(modifier: Modifier = Modifier) {
    val dataRealm = RealmData()
    Column(modifier = modifier) {
        TopBarMenu()
        StatefulCounter()
        val list = remember { dataRealm.getAllTarget().toMutableStateList() }
        TargetTaskList(
            list = list,
            onCloseTask = { task ->
                list.remove(task)
                dataRealm.deletePerson(_id =task._id)
            }
        )
    }
}

