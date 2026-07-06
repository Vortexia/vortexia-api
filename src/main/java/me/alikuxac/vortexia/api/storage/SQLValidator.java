// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.storage;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLValidator {

    // Block stacked queries (multiple statements) using semicolon outside of string literals
    private static final Pattern SEMICOLON_PATTERN = Pattern.compile(";(?=(?:[^\']*\'[^\']*\')*[^\']*$)");

    // Find table names following common SQL keywords
    private static final Pattern TABLE_NAME_PATTERN = Pattern.compile(
        "(?i)\\b(from|join|into|update|table|truncate|desc|describe)\\s+([a-zA-Z0-9_`\"\\.]+)"
    );

    /**
     * Validates whether an Addon's SQL statement is valid and secure.
     * 
     * @param sql The SQL statement to check
     * @param namespace The Addon's namespace (e.g., "maid")
     * @throws SQLException If the SQL statement is invalid or violates security policies
     */
    public static void validate(String sql, String namespace) throws SQLException {
        if (sql == null || sql.trim().isEmpty()) {
            throw new SQLException("SQL statement cannot be null or empty");
        }

        String cleanedSql = sql.trim();

        // 1. Check for Stacked Queries (SQL Injection block using ;)
        if (SEMICOLON_PATTERN.matcher(cleanedSql).find()) {
            throw new SQLException("Security violation: Multiple SQL statements separated by ';' are not allowed to prevent SQL Injection.");
        }

        // Required prefix name for this addon
        String requiredPrefix = "vortexia_" + namespace.toLowerCase() + "_";

        // 2. Verify all words starting with "vortexia_" belong to this namespace.
        // Prevents the addon from intentionally accessing core system tables (vortexia_identities) or other addons' tables.
        Pattern vortexPrefixPattern = Pattern.compile("(?i)\\bvortexia_([a-zA-Z0-9_]+)\\b");
        Matcher prefixMatcher = vortexPrefixPattern.matcher(cleanedSql);
        while (prefixMatcher.find()) {
            String foundWord = prefixMatcher.group(0).toLowerCase();
            if (!foundWord.startsWith(requiredPrefix)) {
                throw new SQLException("Security violation: Addon '" + namespace + "' is not allowed to access or modify table/identifier '" + prefixMatcher.group(0) + "'.");
            }
        }

        // 3. Analyze table names after keywords and enforce the vortexia_<namespace>_ prefix
        Matcher tableMatcher = TABLE_NAME_PATTERN.matcher(cleanedSql);
        while (tableMatcher.find()) {
            String rawTableName = tableMatcher.group(2);
            // Remove table wrapper characters such as `, ", [ ]
            String tableName = rawTableName.replace("`", "").replace("\"", "").replace("[", "").replace("]", "").trim();
            
            // Skip if it is a subquery or parenthesis expression (e.g., FROM (SELECT ...))
            if (tableName.isEmpty() || tableName.startsWith("(")) {
                continue;
            }

            // Enforce that all specified tables must start with requiredPrefix
            String lowerTableName = tableName.toLowerCase();
            if (!lowerTableName.startsWith(requiredPrefix)) {
                throw new SQLException("Data Isolation violation: Table '" + rawTableName + "' must be prefixed with '" + requiredPrefix + "' to prevent conflict or data overwrite.");
            }
        }
    }
}
