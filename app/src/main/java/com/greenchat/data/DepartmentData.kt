package com.greenchat.data

import com.greenchat.R

data class DepartmentData(
    var name: String = "",
    var employees: List<EmployeeData> = emptyList(),
    var subDepartments: List<DepartmentData> = emptyList()
){
    companion object{
        //organization test data
        val organizationDepartment = DepartmentData(
            name = "GreenChat",
            employees = listOf(
                EmployeeData(id = "green@green.com", name = "Green", position = "CEO", phone = "010-1234-5678", imageRes = R.drawable.profile, department= "GreenChat"),
            ),
            subDepartments = listOf(
                DepartmentData(
                    name = "Engineering",
                    employees = listOf(
                        EmployeeData(id = "Accountant1@green.com", name = "Accountant1", position = "Accountant", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "Engineering"),
                        EmployeeData(id = "Accountant2@green.com", name = "Accountant2", position = "Accountant", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "Engineering")
                    ),
                    subDepartments = listOf(
                        DepartmentData(
                            name = "Backend Team",
                            employees = listOf(
                                EmployeeData(id = "Accountant1@green.com", name = "Accountant1", position = "Accountant", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "Backend Team")
                            )
                        ),
                        DepartmentData(
                            name = "Frontend Team",
                            employees = listOf(
                                EmployeeData(id = "Accountant1@green.com", name = "Accountant1", position = "Accountant", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "Frontend Team")
                            )
                        )
                    )
                ),
                DepartmentData(
                    name = "Finance",
                    employees = listOf(
                        EmployeeData(id = "Accountant1@green.com", name = "Accountant1", position = "Accountant", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "Finance"),
                        EmployeeData(id = "Accountant2@green.com", name = "Accountant2", position = "Accountant", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "Finance")
                    )
                )
            )
        )

        //organization test data
        val organizationBuddy = DepartmentData(
            name = "1TEAM",
            subDepartments = listOf(
                DepartmentData(
                    name = "AUMC",
                    employees = listOf(
                        EmployeeData(id = "Dev1@green.com", name = "Dev1", position = "AOS Developer", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "AUMC"),
                        EmployeeData(id = "Dev2@green.com", name = "Dev2", position = "Backend Developer", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "AUMC"),
                        EmployeeData(id = "Dev3@green.com", name = "Dev3", position = "Frontend Developer", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "AUMC"),
                    ),
                    subDepartments = listOf(
                        DepartmentData(
                            name = "AUMC 1TEAM",
                            employees = listOf(
                                EmployeeData(id = "Dev1@green.com", name = "Dev1", position = "Backend Developer", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "AUMC 1TEAM"),
                                EmployeeData(id = "Dev2@green.com", name = "Dev2", position = "Backend Developer", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "AUMC 1TEAM"),
                            )
                        ),
                        DepartmentData(
                            name = "AUMC 2TEAM",
                            employees = listOf(
                                EmployeeData(id = "Dev1@green.com", name = "Dev1", position = "Frontend Developer", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "AUMC 2TEAM"),
                                EmployeeData(id = "Dev2@green.com", name = "Dev2", position = "Frontend Developer", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "AUMC 2TEAM"),

                            )
                        )
                    )
                ),
                DepartmentData(
                    name = "SAMSUNG",
                    subDepartments = listOf(
                        DepartmentData(
                            name = "SAMSUNG 1TEAM",
                            employees = listOf(
                                EmployeeData(id = "1t@green.com", name = "1TEAM MASTER", position = "Backend Developer", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "SAMSUNG 1TEAM"),
                            ),
                            subDepartments = listOf(
                                DepartmentData(
                                    name = "CLIENT 1TEAM",
                                    employees = listOf(
                                        EmployeeData(id = "d1@green.com", name = "Dev1", position = "PC Developer", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "CLIENT 1TEAM"),
                                        EmployeeData(id = "d2@green.com", name = "Dev2", position = "Frontend Developer", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "CLIENT 1TEAM"),
                                        EmployeeData(id = "d3@green.com", name = "Dev3", position = "AOS Developer", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "CLIENT 1TEAM"),
                                        EmployeeData(id = "d4@green.com", name = "Dev4", position = "IOS Developer", phone = "010-0000-0000", imageRes = R.drawable.profile, department= "CLIENT 1TEAM"),
                                    )
                                )
                            )
                        )
                    )
                ),
                DepartmentData(
                    name = "HANTA",
                    employees = listOf(
                        )
                ),
            )
        )
    }
}