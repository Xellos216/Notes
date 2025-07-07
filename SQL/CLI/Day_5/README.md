# SQL Study - Day 5: Subqueries

## ✅ Summary

Today’s focus was on mastering **subqueries**, which are essential for handling nested logic and advanced filtering in SQL.  
We used `users`, `products`, and `orders_v2` tables for all examples.

---

## 🔍 Topics Covered

1. SELECT clause with subqueries  
   → *Not recommended in MySQL due to alias reference issues. Use JOIN instead.*

2. FROM clause with subqueries  
   → Useful for grouping and aggregating intermediate results.

3. WHERE clause with subqueries  
   → Ideal for filtering using `IN`, `EXISTS`, and `=` with nested SELECTs.

4. Comparison operators with subqueries  
   → Practiced `IN`, `EXISTS`, and scalar `=` subqueries.

5. JOIN vs Subquery comparison  
   → Performance and readability differences were analyzed.

---

## 📁 Files

- `day5_subquery_practice.sql` – All SQL queries used in today’s practice  
- `join_vs_subquery.md` – Summary comparing JOIN and subquery strategies  
- `day5_summary.md` – Full explanation and walkthrough of today’s session

---

## 📌 Notes

> Subqueries can be powerful but should be used wisely.  
> Always consider readability, performance, and use JOINs when dealing with multi-table data.