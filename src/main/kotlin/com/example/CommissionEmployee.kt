package com.example

open class CommissionEmployee(
    firstName: String,
    lastName: String,
    socialSecurityNumber: String,
    grossSales: Double,
    commissionRate: Double,
) : Employee(firstName, lastName, socialSecurityNumber) {
    var grossSales: Double = grossSales
        set(value) {
            require(value >= 0.0) { "Gross sales must be non-negative." }
            field = value
        }

    var commissionRate: Double = commissionRate
        set(value) {
            require(value in 0.0..1.0) {
                "Commission rate must be between 0.0 and 1.0."
            }
            field = value
        }

    init {
        require(grossSales >= 0.0) { "Gross sales must be non-negative." }
        require(commissionRate in 0.0..1.0) {
            "Commission rate must be between 0.0 and 1.0."
        }
    }

    override fun earnings(): Double = grossSales * commissionRate

    override fun toString(): String =
        "Commission employee: ${super.toString()}, " +
            "gross sales: $${money(grossSales)}, " +
            "commission rate: ${money(commissionRate * 100)}%"
}
