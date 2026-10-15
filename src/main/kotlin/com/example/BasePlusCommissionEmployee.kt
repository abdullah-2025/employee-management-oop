package com.example

class BasePlusCommissionEmployee(
    firstName: String,
    lastName: String,
    socialSecurityNumber: String,
    grossSales: Double,
    commissionRate: Double,
    baseSalary: Double,
) : CommissionEmployee(
    firstName,
    lastName,
    socialSecurityNumber,
    grossSales,
    commissionRate,
) {
    var baseSalary: Double = baseSalary
        set(value) {
            require(value >= 0.0) { "Base salary must be non-negative." }
            field = value
        }

    init {
        require(baseSalary >= 0.0) { "Base salary must be non-negative." }
    }

    override fun earnings(): Double = baseSalary + super.earnings()

    override fun toString(): String =
        "Base-plus-commission employee: " +
            "${firstName} ${lastName} (SSN: $socialSecurityNumber), " +
            "gross sales: $${money(grossSales)}, " +
            "commission rate: ${money(commissionRate * 100)}%, " +
            "base salary: $${money(baseSalary)}"
}
