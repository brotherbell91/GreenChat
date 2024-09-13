package com.greenchat.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greenchat.R
import com.greenchat.data.DepartmentData
import com.greenchat.data.EmployeeData

@Composable
fun DepartmentScreen(onEmployeeSelected: (EmployeeData) -> Unit, department: DepartmentData) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        item {
            DepartmentHierarchy(onEmployeeSelected, department)
        }
    }
}

@Composable
fun DepartmentHierarchy(onEmployeeSelected: (EmployeeData) -> Unit, department: DepartmentData) {
    var expanded by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.padding(start = 20.dp)
    ){
        DepartmentCard(department, expanded,onClick = { expanded = !expanded })
        if (expanded) {
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(4.dp),
            ){
                department.employees.forEachIndexed {index, employee ->
                    EmployeeCard(onEmployeeSelected, employee)
                }
            }
            department.subDepartments.forEach { subDepartment ->
                DepartmentHierarchy(onEmployeeSelected, subDepartment)
            }
            if(department.subDepartments.isEmpty() && department.employees.isEmpty()){
                EmptyCard()
            }
        }
    }
}

@Composable
fun EmptyCard() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp)
            .background(Color.Transparent),
        colors = CardDefaults.cardColors(Color.Transparent),
    ) {
        Text(
            text = "No sub-organizations.",
            fontSize = 14.sp,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )
    }
}

@Composable
fun DepartmentCard(department: DepartmentData, expanded: Boolean, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .background(Color.Transparent),
        colors = CardDefaults.cardColors(Color.Transparent),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(5.dp)
        ) {
            if (!expanded) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_right_24),
                    contentDescription = "Sub Department Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(onClick = onClick)
                )
            }else {
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                    contentDescription = "Sub Department Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(onClick = onClick)
                )
            }
            Text(
                text = department.name,
                fontSize = 16.sp,
                style = MaterialTheme.typography.titleSmall,
//                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
        }
    }
}

@Composable
fun EmployeeCard(onEmployeeSelected: (EmployeeData) -> Unit, employee: EmployeeData) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onEmployeeSelected(employee) }
            .background(Color.Transparent),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileImage(image = painterResource(id = R.drawable.profile))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = employee.name,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodySmall,
//                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = employee.position,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun ProfileImage(image: Painter) {
    Card(
        shape = CircleShape,
        modifier = Modifier
            .size(40.dp)
            .background(Color.Transparent)
    ) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .background(Color.White),
            painter = image,
//            colorFilter = ColorFilter.tint(image_gray),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,

            )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDepartmentScreen() {
    DepartmentScreen(onEmployeeSelected = {}, DepartmentData.organizationDepartment)
}