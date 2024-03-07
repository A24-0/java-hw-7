import java.io.*;
import java.time.LocalDate;
import java.util.*;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "events.txt";
        String outputFileName = "sortedEvents.txt";

        //чтение из файла
        List<Event> events = readEventsFromFile(inputFileName);

        //сортировка по дате
        events.sort(comparing(Event::getDate));

        //запись отсортированных данных в файл
        writeEventsToFile(events, outputFileName);
    }

    private static List<Event> readEventsFromFile(String fileName) {
        List<Event> events = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                LocalDate date = LocalDate.parse(parts[1], java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                String name = parts[3];
                String description = parts[5];
                events.add(new Event(date, name, description));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }

    private static void writeEventsToFile(List<Event> events, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Event event : events) {
                String formattedDate = event.getDate().format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                String formattedLine = String.format("date: %s name: %s description: %s%n", formattedDate, event.getName(), event.getDescription());
                writer.write(formattedLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}