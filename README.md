# Android Application Development – Fall 2026 Assignment

## Overview

This repository contains a Kotlin object-oriented programming assignment focused on employee inheritance, earnings calculations, and salary-based tax calculations.

## Package

All Kotlin classes use the `com.example` package and are located under `src/main/kotlin/com/example`.

## Required Classes

- `Employee`
- `HourlyEmployee`
- `SalariedEmployee`
- `CommissionEmployee`
- `BasePlusCommissionEmployee`
- `EmployeeTest`

## Implemented Functionality

- An abstract `Employee` superclass with shared employee data.
- Polymorphic earnings calculations for salaried, hourly, commission, and base-plus-commission employees.
- Time-and-a-half overtime pay for hourly employees working more than 40 hours per week.
- Input validation for names, identifiers, hours, wages, salaries, sales, and commission rates.
- Progressive tax calculations based on weekly gross earnings.
- Net earnings calculations after tax.
- A runnable `EmployeeTest` demonstration with calculation and validation checks.

## Tax Policy

Tax is calculated progressively from weekly gross earnings:

- 10% on the first `$500`.
- 15% on earnings from `$500.01` through `$1,000`.
- 20% on earnings above `$1,000`.

## Run

Open the project in IntelliJ IDEA or Android Studio and run `EmployeeTest`. If Gradle is installed, it can also be run from a terminal with:

```shell
gradle run
```

The project contains no Android UI, activities, layouts, or external application dependencies.
