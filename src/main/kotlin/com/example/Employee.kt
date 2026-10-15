package com.example

import java.util.Locale

abstract class Employee(
    firstName: String,
    lastName: String,
    socialSecurityNumber: String,
) {
    var firstName: String = firstName
        set(value) {
            require(value.isNotBlank()) { "First name must not be blank." }
            field = value
        }

    var lastName: String = lastName
        set(value) {
            require(value.isNotBlank()) { "Last name must not be blank." }
            field = value
        }

    var socialSecurityNumber: String = socialSecurityNumber
        set(value) {
            require(value.isNotBlank()) { "Social security number must not be blank." }
            field = value
        }

    init {
        require(firstName.isNotBlank()) { "First name must not be blank." }
        require(lastName.isNotBlank()) { "Last name must not be blank." }
        require(socialSecurityNumber.isNotBlank()) {
            "Social security number must not be blank."
        }
    }

    abstract fun earnings(): Double

    fun tax(): Double = calculateTax(earnings())

    fun netEarnings(): Double = earnings() - tax()

    protected fun money(amount: Double): String =
        String.format(Locale.US, "%.2f", amount)

    override fun toString(): String =
        "$firstName $lastName (SSN: $socialSecurityNumber)"

    companion object {
        fun calculateTax(income: Double): Double {
            require(income >= 0.0) { "Income must be non-negative." }

            return when {
                income <= 500.0 -> income * 0.10
                income <= 1_000.0 -> 50.0 + (income - 500.0) * 0.15
                else -> 125.0 + (income - 1_000.0) * 0.20
            }
        }
    }
}
