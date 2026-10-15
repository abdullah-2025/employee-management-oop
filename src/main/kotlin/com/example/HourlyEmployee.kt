package com.example

class HourlyEmployee(
    firstName: String,
    lastName: String,
    socialSecurityNumber: String,
    wage: Double,
    hours: Double,
) : Employee(firstName, lastName, socialSecurityNumber) {
    var wage: Double = wage
        set(value) {
            require(value >= 0.0) { "Hourly wage must be non-negative." }
            field = value
        }

    var hours: Double = hours
        set(value) {
            require(value in 0.0..168.0) { "Hours must be between 0 and 168." }
            field = value
        }

    init {
        require(wage >= 0.0) { "Hourly wage must be non-negative." }
        require(hours in 0.0..168.0) { "Hours must be between 0 and 168." }
    }

    override fun earnings(): Double =
        if (hours <= STANDARD_HOURS) {
            wage * hours
        } else {
            wage * STANDARD_HOURS +
                wage * OVERTIME_RATE * (hours - STANDARD_HOURS)
        }

    override fun toString(): String =
        "Hourly employee: ${super.toString()}, " +
            "wage: $${money(wage)}, hours: ${money(hours)}"

    companion object {
        private const val STANDARD_HOURS = 40.0
        private const val OVERTIME_RATE = 1.5
    }
}
