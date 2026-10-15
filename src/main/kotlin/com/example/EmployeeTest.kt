package com.example

import kotlin.math.abs

object EmployeeTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val employees = listOf(
            SalariedEmployee("Ada", "Lovelace", "111-11-1111", 1_000.0),
            HourlyEmployee("Grace", "Hopper", "222-22-2222", 20.0, 45.0),
            CommissionEmployee("Alan", "Turing", "333-33-3333", 10_000.0, 0.06),
            BasePlusCommissionEmployee(
                "Katherine",
                "Johnson",
                "444-44-4444",
                5_000.0,
                0.10,
                300.0,
            ),
        )

        verifyCalculations(employees)

        println("Employee payroll summary")
        println("========================")
        employees.forEach { employee ->
            println(employee)
            println("Gross earnings: $${format(employee.earnings())}")
            println("Tax:            $${format(employee.tax())}")
            println("Net earnings:   $${format(employee.netEarnings())}")
            println()
        }

        println("All employee calculations passed.")
    }

    private fun verifyCalculations(employees: List<Employee>) {
        val expectedEarnings = listOf(1_000.0, 950.0, 600.0, 800.0)
        val expectedTaxes = listOf(125.0, 117.5, 65.0, 95.0)

        employees.zip(expectedEarnings).forEach { (employee, expected) ->
            checkClose(employee.earnings(), expected, "earnings for ${employee.firstName}")
        }

        employees.zip(expectedTaxes).forEach { (employee, expected) ->
            checkClose(employee.tax(), expected, "tax for ${employee.firstName}")
        }

        checkClose(Employee.calculateTax(500.0), 50.0, "first tax boundary")
        checkClose(Employee.calculateTax(1_000.0), 125.0, "second tax boundary")

        requireFails("negative weekly salary") {
            SalariedEmployee("Test", "User", "000-00-0000", -1.0)
        }
        requireFails("invalid commission rate") {
            CommissionEmployee("Test", "User", "000-00-0000", 100.0, 1.01)
        }
        requireFails("weekly hours greater than 168") {
            HourlyEmployee("Test", "User", "000-00-0000", 10.0, 169.0)
        }
    }

    private fun checkClose(actual: Double, expected: Double, label: String) {
        check(abs(actual - expected) < 0.000_001) {
            "Unexpected $label: expected $expected, got $actual."
        }
    }

    private fun requireFails(label: String, block: () -> Unit) {
        check(runCatching(block).isFailure) { "Expected validation failure for $label." }
    }

    private fun format(value: Double): String = "%.2f".format(java.util.Locale.US, value)
}
