import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.realmtargetsapp.TargetTask

@Composable
fun TargetTaskList(
    list: List<TargetTask>,
    modifier: Modifier = Modifier,
    onCloseTask: (TargetTask) -> Unit,
) {
    LazyColumn(modifier = modifier){
        items(list) {task ->
            TargetTaskItem(taskName = task.targetName, onClose = { onCloseTask(task) })
        }
    }
}