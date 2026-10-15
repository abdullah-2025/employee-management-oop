package com.example

class SalariedEmployee(
    firstName: String,
    lastName: String,
    socialSecurityNumber: String,
    weeklySalary: Double,
) : Employee(firstName, lastName, socialSecurityNumber) {
    var weeklySalary: Double = weeklySalary
        set(value) {
            require(value >= 0.0) { "Weekly salary must be non-negative." }
            field = value
        }

    init {
        require(weeklySalary >= 0.0) { "Weekly salary must be non-negative." }
    }

    override fun earnings(): Double = weeklySalary

    override fun toString(): String =
        "Salaried employee: ${super.toString()}, " +
            "weekly salary: $${money(weeklySalary)}"
}
