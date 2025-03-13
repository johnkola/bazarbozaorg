package com.bazarbozorg.loaddatabase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MongoCSVToJSONGenerator {
    public static void main(String[] args) {
        String folderPath = "typelists"; // Folder containing CSV files
        String outputFolder = "json_output"; // Folder where JSON files will be saved

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
            generateMongoJSONFromCSV(csvFile, outputFolder);
        }

        System.out.println("✅ JSON files generated in folder: " + outputFolder);
    }

    private static void generateMongoJSONFromCSV(File csvFile, String outputFolder) {
        String collectionName = csvFile.getName().replace(".csv", ""); // Collection name based on file name
        String jsonFilePath = outputFolder + "/" + collectionName + ".json";

        try {
            List<String> lines = Files.readAllLines(csvFile.toPath());
            if (lines.isEmpty()) {
                System.out.println("⚠️ Skipping empty file: " + csvFile.getName());
                return;
            }

            String[] headers = lines.get(0).split(","); // Column names
            String primaryKeyColumn = headers[0]; // Assume first column is the primary key

            StringBuilder json = new StringBuilder();
            json.append("[\n");

            for (int i = 1; i < lines.size(); i++) { // Skip header row
                String[] values = lines.get(i).split(",");

                // Create filter (Find condition)
                String filter = "{ \"" + primaryKeyColumn + "\": \"" + values[0] + "\" }";

                // Create update document
                StringBuilder updateDoc = new StringBuilder();
                updateDoc.append("{ \"$set\": {");
                for (int j = 1; j < headers.length; j++) {
                    updateDoc.append("\"").append(headers[j]).append("\": \"").append(values[j]).append("\"");
                    if (j < headers.length - 1) {
                        updateDoc.append(", ");
                    }
                }
                updateDoc.append(" } }");

                // Create updateOne JSON
                String updateOne = "{ \"updateOne\": { \"filter\": " + filter + ", \"update\": " + updateDoc + ", \"upsert\": true } }";
                json.append(updateOne);
                if (i < lines.size() - 1) {
                    json.append(",\n");
                }
            }

            json.append("\n]"); // Close JSON array

            // Save JSON script to file
            Files.write(Paths.get(jsonFilePath), json.toString().getBytes());

            System.out.println("✅ Generated JSON file: " + jsonFilePath);
        } catch (IOException e) {
            System.err.println("❌ Error processing file: " + csvFile.getName());
            e.printStackTrace();
        }
    }
}
