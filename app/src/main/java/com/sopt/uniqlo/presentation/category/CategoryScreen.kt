package com.sopt.uniqlo.presentation.category

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.presentation.category.component.CategoryContent
import com.sopt.uniqlo.presentation.category.component.CategoryList
import com.sopt.uniqlo.presentation.category.state.CategorySideEffect
import com.sopt.uniqlo.presentation.category.state.CategoryUiState
import kotlinx.collections.immutable.ImmutableList
import timber.log.Timber

@Composable
fun CategoryRoute(
    paddingValues: PaddingValues,
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.sideEffect.flowWithLifecycle(lifecycleOwner.lifecycle)
            .collect {
                when (it) {
                    is CategorySideEffect.ShowToast -> {
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }

    CategoryScreen(
        paddingValues = paddingValues,
        tabList = viewModel.tabList,
        uiState = uiState,
        selectedTabIndex = selectedTabIndex,
        onTabSelected = { selectedTabIndex = it },
        onClickCategory = {
            if (it != "아우터") {
                viewModel.showToast(it)
            }
        },
        onClickCategoryContent = {
            if (it == 3) {
                Timber.d("3번 눌림")
                //navigateToDetail()
            }
        }
    )
}

@Composable
fun CategoryScreen (
    paddingValues: PaddingValues,
    tabList: ImmutableList<String>,
    uiState: CategoryUiState,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    onClickCategory: (String) -> Unit,
    onClickCategoryContent: (Int) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        SecondaryTabRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = UniqloTheme.colors.white
                ),
            selectedTabIndex = selectedTabIndex,
            indicator = {
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(
                        selectedTabIndex = selectedTabIndex
                    ),
                    color = Color.Black
                )
            }
        ) {
            tabList.forEachIndexed { index, title ->
                Tab (
                    selected = index == selectedTabIndex,
                    onClick = { onTabSelected(index) },
                    text = {
                        Text(
                            text = title,
                            style = UniqloTheme.typography.reddit.caption_m_12,
                            color = if (index == selectedTabIndex) {
                                UniqloTheme.colors.black
                            } else {
                                UniqloTheme.colors.gray400
                            }
                        )
                    }
                )
            }
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CategoryList(
                categoryList = uiState.categoryList,
                onClickCategory = onClickCategory,
                modifier = Modifier
                    .weight(0.25f)
            )

            CategoryContent(
                categoryContentList = uiState.categoryContentList,
                onClickCategoryContent = onClickCategoryContent,
                modifier = Modifier
                    .weight(0.75f)
            )
        }
    }
}