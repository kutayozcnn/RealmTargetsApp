import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.realmtargetsapp.AddTargetActivity


@Composable
fun StatelessCounter(count : Int,onIncrement: () -> Unit,modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
     if (count > 0){
         Text(text = "Şuana kadar gerçekleştirilen hedef sayısı = $count")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp)) {
            Text(text = "Arttır")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}


@Composable
fun TopBarMenu(modifier: Modifier =Modifier) {
    var mDisplayMenu by remember { mutableStateOf(false) }
    val context = LocalContext.current
    TopAppBar(
        title = { Text("Target Realm App", color = Color.White,) },
        modifier = Modifier.fillMaxWidth(3f),
        actions = {
            IconButton(onClick = { mDisplayMenu = !mDisplayMenu }) {
                Icon(Icons.Default.MoreVert, "")
            }
            DropdownMenu(
                expanded = mDisplayMenu,
                onDismissRequest = { mDisplayMenu = false }
            ) {
                DropdownMenuItem(onClick = {
                    context.startActivity(Intent(context, AddTargetActivity::class.java))
                }) {
                    Text(text = "Add Target")
                }
            }
        }
    )
}