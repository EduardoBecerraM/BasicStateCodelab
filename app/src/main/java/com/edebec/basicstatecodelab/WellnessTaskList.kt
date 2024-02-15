package com.edebec.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = emptyList(),
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(items = list, key = { wellnessTask ->
            wellnessTask.id
        }) { wellnessTask ->
            WellnessTaskItem(taskName = wellnessTask.label, checked = wellnessTask.checked, onCheckedChange = { newValue ->
                onCheckedTask(wellnessTask, newValue)
            }, onClose = { onCloseTask(wellnessTask) })
        }
    }
}