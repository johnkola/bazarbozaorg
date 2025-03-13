package com.bazarbozorg.loaddatabase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVFolderToSQLGenerator {
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
        String sqlFilePath = outputFolder + "/" + tableName + ".sql";

        try {
            List<String> lines = Files.readAllLines(csvFile.toPath());
            if (lines.isEmpty()) {
                System.out.println("⚠️ Skipping empty file: " + csvFile.getName());
                return;
            }

            String[] headers = lines.get(0).split(","); // Column names
            String primaryKeyColumn = headers[0]; // Assume first column is the primary key

            StringBuilder sql = new StringBuilder();
            sql.append("BEGIN TRANSACTION;\n");

            // Step 1: Check if the table exists, create if not
            sql.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (\n");
            for (String header : headers) {
                sql.append("    ").append(header).append(" TEXT, \n");
            }
            sql.append("    PRIMARY KEY (").append(primaryKeyColumn).append(")\n");
            sql.append(");\n\n");

            for (int i = 1; i < lines.size(); i++) { // Skip header row
                String[] values = lines.get(i).split(",");

                // Generate SET clause for UPDATE
                StringBuilder setClause = new StringBuilder();
                for (int j = 1; j < headers.length; j++) {
                    setClause.append(headers[j]).append(" = '").append(values[j]).append("'");
                    if (j < headers.length - 1) {
                        setClause.append(", ");
                    }
                }

                // Generate UPDATE statement
                String updateSQL = "UPDATE " + tableName + " SET " + setClause +
                        " WHERE " + primaryKeyColumn + " = '" + values[0] + "';";

                // Generate INSERT statement (if the record doesn't exist)
                String insertSQL = "INSERT INTO " + tableName + " (" + String.join(", ", headers) + ") " +
                        "SELECT '" + String.join("', '", values) + "' " +
                        "WHERE NOT EXISTS (SELECT 1 FROM " + tableName +
                        " WHERE " + primaryKeyColumn + " = '" + values[0] + "');";

                // Append to SQL script
                sql.append(updateSQL).append("\n").append(insertSQL).append("\n");
            }

            sql.append("COMMIT;"); // End transaction

            // Save SQL script to file
            Files.write(Paths.get(sqlFilePath), sql.toString().getBytes());

            System.out.println("✅ Generated SQL file: " + sqlFilePath);
        } catch (IOException e) {
            System.err.println("❌ Error processing file: " + csvFile.getName());
            e.printStackTrace();
        }
    }
}
