package com.greenchat.data

data class DepartmentData(
    var name: String = "",
    var employees: List<EmployeeData> = emptyList(),
    var subDepartments: List<DepartmentData> = emptyList()
){
    companion object{
        //organization test data
        val organizationDepartment = DepartmentData(
            name = "UCWARE",
            subDepartments = listOf(
                DepartmentData(
                    name = "Engineering",
                    employees = listOf(
                        EmployeeData(name = "Accountant1", position = "Accountant"),
                        EmployeeData(name = "Accountant2", position = "Accountant")
                    ),
                    subDepartments = listOf(
                        DepartmentData(
                            name = "Backend Team",
                            employees = listOf(
                                EmployeeData(name = "Accountant1", position = "Accountant")
                            )
                        ),
                        DepartmentData(
                            name = "Frontend Team",
                            employees = listOf(
                                EmployeeData(name = "Accountant1", position = "Accountant")
                            )
                        )
                    )
                ),
                DepartmentData(
                    name = "Finance",
                    employees = listOf(
                        EmployeeData(name = "Accountant1", position = "Accountant"),
                        EmployeeData(name = "Accountant2", position = "Accountant")
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
                        EmployeeData(name = "Dev1", position = "Developer"),
                        EmployeeData(name = "Dev2", position = "Developer")
                    ),
                    subDepartments = listOf(
                        DepartmentData(
                            name = "AUMC 1TEAM",
                            employees = listOf(
                                EmployeeData(name = "Dev1", position = "Backend Developer")
                            )
                        ),
                        DepartmentData(
                            name = "AUMC 2TEAM",
                            employees = listOf(
                                EmployeeData(name = "Dev2", position = "Frontend Developer")
                            )
                        )
                    )
                ),
                DepartmentData(
                    name = "HANTA",
                    employees = listOf(
                        EmployeeData(name = "Dev1", position = "UX Designer"),
                        EmployeeData(name = "Dev2", position = "UX Designer"),
                        EmployeeData(name = "Dev3", position = "UX Designer"),
                        EmployeeData(name = "Dev4", position = "UX Designer"),

                        )
                ),
                DepartmentData(
                    name = "KOREA",
                    employees = listOf(
                    )
                )
            )
        )
    }
}