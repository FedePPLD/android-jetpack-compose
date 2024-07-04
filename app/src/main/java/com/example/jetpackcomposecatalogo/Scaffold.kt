import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {

    val snackBarHostState = remember {
        SnackbarHostState()
    }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = { MyDrawer { coroutineScope.launch { drawerState.close() } } },
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen
    ) {
        Scaffold(
            snackbarHost = { SnackbarHost(snackBarHostState) },
            topBar = {
                MyTopAppBar(onCLickIcon = { messageFromButton ->
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(messageFromButton)
                    }
                }, onClickDrawer = { coroutineScope.launch { drawerState.open() } })

            },
            bottomBar = { MyBottomNavigation() },
            floatingActionButton = { MyFAB() },
            floatingActionButtonPosition = FabPosition.Center
        ) {
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onCLickIcon: (String) -> Unit, onClickDrawer: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "My first toolbar"
            )
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "back",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { onCLickIcon("Search") }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search",
                    tint = Color.White
                )
            }

            IconButton(onClick = { onCLickIcon("Close") }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "close",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun MyBottomNavigation() {
    var index by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(containerColor = Color.Gray, contentColor = Color.Black) {
        NavigationBarItem(
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color.White
            ),
            selected = index == 0,
            onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            }, label = { Text(text = "Home") }
        )
        NavigationBarItem(
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color.White
            ),
            selected = index == 1,
            onClick = { index = 1 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Home"
                )
            }, label = { Text(text = "Fav") }
        )
        NavigationBarItem(
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color.White
            ),
            selected = index == 2,
            onClick = { index = 2 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Home"
                )
            }, label = { Text(text = "Person") }
        )
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(
        onClick = { },
        containerColor = Color.DarkGray,
        contentColor = Color.White, modifier = Modifier.offset(y = 20.dp)
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    ModalDrawerSheet {
        Text(
            text = "Example I", modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Example II", modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Example III", modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { onCloseDrawer() }
        )
    }
} 