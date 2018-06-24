package com.example

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.junit.ArchUnitRunner
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.junit.runner.RunWith

@RunWith(ArchUnitRunner::class)
@AnalyzeClasses(packages = ["com.example"])
class KotlinArchTest {
    companion object {
        @ArchTest @JvmField val myRule = classes()
                .that().resideInAPackage("..example..")
                .should().bePrivate()
    }
}


/* What we would want, is this:

class KotlinArchTest {
    @ArchTest val myRule = classes()
        .that().resideInAPackage("..example..")
        .should().bePrivate()
}

*/