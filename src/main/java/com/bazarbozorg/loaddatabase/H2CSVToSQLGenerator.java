package com.bazarbozorg.loaddatabase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class H2CSVToSQLGenerator {
    public static void main(String[] args) {
        String folderPath = "typelists"; // Folder containing CSV files
        String outputFolder = "sql_output"; // Folder where SQL files will be saved

        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("❌ Folder does not exist: " + folderPath);
            return;
        }

        File outputDir = new File(outputFolder);
        if (!outputDir.exists()) {
            outputDir.mkdirs(); // Create output directory if it doesn't exist
        }

        File[] csvFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));
        if (csvFiles == null || csvFiles.length == 0) {
            System.out.println("❌ No CSV files found in folder: " + folderPath);
            return;
        }

        for (File csvFile : csvFiles) {
            generateSQLFromCSV(csvFile, outputFolder);
        }

        System.out.println("✅ SQL files generated in folder: " + outputFolder);
    }

    private static void generateSQLFromCSV(File csvFile, String outputFolder) {
        String tableName = csvFile.getName().replace(".csv", ""); // Table name based on file name
        String sqlFilePath = outputFolder + "/H2_" + tableName + ".sql";

        try {
            List<String> lines = Files.readAllLines(csvFile.toPath());
            if (lines.isEmpty()) {
                System.out.println("⚠️ Skipping empty file: " + csvFile.getName());
                return;
            }

            String[] headers = lines.get(0).split(","); // Column names
            String primaryKeyColumn = headers[0]; // Assume first column is the primary key

            StringBuilder sql = new StringBuilder();
            sql.append("BEGIN TRANSACTION;\n\n");

            // Step 1: Check if the table exists, create if not (H2 INFORMATION_SCHEMA.TABLES check)
            sql.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (\n");
            for (int i = 0; i < headers.length; i++) {
                sql.append("    ").append(headers[i]).append(" VARCHAR(255)");
                if (i < headers.length - 1) sql.append(",");
                sql.append("\n");
            }
            sql.append("    ,PRIMARY KEY (").append(primaryKeyColumn).append(")\n");
            sql.append(");\n\n");

            // Step 2: Generate MERGE INTO (Upsert) statements
            for (int i = 1; i < lines.size(); i++) { // Skip header row
                String[] values = lines.get(i).split(",");

                StringBuilder setClause = new StringBuilder();
                StringBuilder valuesClause = new StringBuilder();

                for (int j = 1; j < headers.length; j++) {
                    setClause.append(headers[j]).append(" = '").append(values[j]).append("'");
                    if (j < headers.length - 1) {
                        setClause.append(", ");
                    }
                }

                for (String value : values) {
                    valuesClause.append("'").append(value).append("', ");
                }
                valuesClause.setLength(valuesClause.length() - 2); // Remove trailing comma

                String mergeSQL = "MERGE INTO " + tableName + " USING (SELECT 1) AS DUAL\n" +
                        "ON (" + tableName + "." + primaryKeyColumn + " = '" + values[0] + "')\n" +
                        "WHEN MATCHED THEN\n" +
                        "    UPDATE SET " + setClause + "\n" +
                        "WHEN NOT MATCHED THEN\n" +
                        "    INSERT (" + String.join(", ", headers) + ") VALUES (" + valuesClause + ");\n";

                sql.append(mergeSQL).append("\n");
            }

            sql.append("\nCOMMIT;\n"); // End transaction

            // Save SQL script to file
            Files.write(Paths.get(sqlFilePath), sql.toString().getBytes());

            System.out.println("✅ Generated SQL file: " + sqlFilePath);
        } catch (IOException e) {
            System.err.println("❌ Error processing file: " + csvFile.getName());
            e.printStackTrace();
        }
    }
}
