package com.greenchat.data

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
                EmployeeData(name = "Green", position = "CEO"),
            ),
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
                        EmployeeData(name = "Dev1", position = "AOS Developer"),
                        EmployeeData(name = "Dev2", position = "Backend Developer"),
                        EmployeeData(name = "Dev3", position = "Frontend Developer"),
                    ),
                    subDepartments = listOf(
                        DepartmentData(
                            name = "AUMC 1TEAM",
                            employees = listOf(
                                EmployeeData(name = "Dev1", position = "Backend Developer"),
                                EmployeeData(name = "Dev2", position = "Backend Developer"),
                            )
                        ),
                        DepartmentData(
                            name = "AUMC 2TEAM",
                            employees = listOf(
                                EmployeeData(name = "Dev1", position = "Frontend Developer"),
                                EmployeeData(name = "Dev2", position = "Frontend Developer"),

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
                                EmployeeData(name = "1TEAM MASTER", position = "Backend Developer"),
                            ),
                            subDepartments = listOf(
                                DepartmentData(
                                    name = "CLIENT 1TEAM",
                                    employees = listOf(
                                        EmployeeData(name = "Dev1", position = "PC Developer"),
                                        EmployeeData(name = "Dev2", position = "Frontend Developer"),
                                        EmployeeData(name = "Dev3", position = "AOS Developer"),
                                        EmployeeData(name = "Dev4", position = "IOS Developer"),
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