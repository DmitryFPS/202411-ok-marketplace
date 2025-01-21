@file:Suppress("unused")

package ru.otus.otuskotlin.m2l1

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

// Реализуйте dsl для составления sql запроса, чтобы все тесты стали зелеными.
class Hw1Sql {
    private fun checkSQL(expected: String, sql: SqlSelectBuilder) {
        assertEquals(expected, sql.build())
    }

    class SqlSelectBuilder {
        private var table: String? = null
        private val columns = mutableListOf<String>()
        private val where = mutableListOf<String>()

        fun select(vararg columns: String) {
            this.columns.addAll(columns)
        }

        fun from(table: String) {
            this.table = table
        }

        fun where(init: SqlWhereBuilder.() -> Unit) {
            val whereBuilder = SqlWhereBuilder().apply(init)
            this.where.add(whereBuilder.build())
        }

        fun build(): String {
            this.table ?: throw RuntimeException()
            val columns =
                if (this.columns.isEmpty()) "*" else this.columns.joinToString(", ")
            val where =
                if (this.where.isNotEmpty()) " where ${this.where.joinToString(" and ")}" else ""

            return "select $columns from $table$where"
        }
    }

    private fun query(init: SqlSelectBuilder.() -> Unit): SqlSelectBuilder {
        return SqlSelectBuilder().apply(init)
    }

    @Test
    fun `simple select all from table`() {
        val expected = "select * from table"

        val real = query {
            from("table")
        }

        checkSQL(expected, real)
    }

    @Test
    fun `check that select can't be used without table`() {
        assertFailsWith<Exception> {
            query {
                select("col_a")
            }.build()
        }
    }

    @Test
    fun `select certain columns from table`() {
        val expected = "select col_a, col_b from table"

        val real = query {
            select("col_a", "col_b")
            from("table")
        }

        checkSQL(expected, real)
    }

    @Test
    fun `select certain columns from table 1`() {
        val expected = "select col_a, col_b from table"

        val real = query {
            select("col_a", "col_b")
            from("table")
        }

        checkSQL(expected, real)
    }

    /**
     * __eq__ is "equals" function. Must be one of char:
     *  - for strings - "="
     *  - for numbers - "="
     *  - for null - "is"
     */
    @Test
    fun `select with complex where condition with one condition`() {
        val expected = "select * from table where col_a = 'id'"

        val real = query {
            from("table")
            where { "col_a" eq "id" }
        }

        checkSQL(expected, real)
    }

    /**
     * __nonEq__ is "non equals" function. Must be one of chars:
     *  - for strings - "!="
     *  - for numbers - "!="
     *  - for null - "!is"
     */
    @Test
    fun `select with complex where condition with two conditions`() {
        val expected = "select * from table where col_a != 0"

        val real = query {
            from("table")
            where {
                "col_a" nonEq 0
            }
        }

        checkSQL(expected, real)
    }

    @Test
    fun `when 'or' conditions are specified then they are respected`() {
        val expected = "select * from table where (col_a = 4 or col_b !is null)"

        val real = query {
            from("table")
            where {
                or {
                    "col_a" eq 4
                    "col_b" nonEq null
                }
            }
        }

        checkSQL(expected, real)
    }
}

class SqlWhereBuilder {
    private val conditions = mutableListOf<String>()

    infix fun String.eq(value: Any?) {
        conditions.add(
            if (value == null) "$this is null" else "$this = ${formatValue(value)}"
        )
    }

    infix fun String.nonEq(value: Any?) {
        conditions.add(
            if (value == null) "$this !is null" else "$this != ${formatValue(value)}"
        )
    }

    fun or(init: SqlWhereBuilder.() -> Unit) {
        val orBuilder = SqlWhereBuilder().apply(init)
        conditions.add("(${orBuilder.buildWithOr()})")
    }

    fun build(): String {
        return conditions.joinToString(" and ")
    }

    private fun buildWithOr(): String {
        return conditions.joinToString(" or ")
    }

    private fun formatValue(value: Any?): String {
        return when (value) {
            is String -> "'$value'"
            else -> value.toString()
        }
    }
}
