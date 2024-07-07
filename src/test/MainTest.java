package test;

import main.Main;
import main.dto.UserDto;
import main.service.ProviderService;
import main.service.ServiceTypeService;

import java.io.*;

public class MainTest {

    public static void main(String[] args) throws IOException {
        UserDto userDto = new UserDto();
        ProviderService.loadProviders();
        ServiceTypeService.loadServices();

        // Simulate user input
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);
        BufferedReader reader = new BufferedReader(new InputStreamReader(pis));

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        // Redirect System.out to capture outputs
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        // Start the application in a new thread
        Thread appThread = new Thread(() -> {
            try {
                runApp(userDto, reader, printStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        appThread.start();

        // Send simulated inputs and assert outputs
        sendInput(pos, "CASH_IN 1000\n");
        assertOutputContains(outputStream, "Your available balance: 1000");

        sendInput(pos, "EXIT\n");

        // Stop the application
        appThread.interrupt();

        // Restore original System.out
        System.setOut(originalOut);
    }

    private static void sendInput(PipedOutputStream pos, String input) throws IOException {
        pos.write(input.getBytes());
        pos.flush();
        sleepFor(100); // Wait for the application to process the command
    }

    private static void sleepFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void assertOutputContains(ByteArrayOutputStream outputStream, String expected) {
        try {
            outputStream.flush(); // Ensure all data is written to the stream
            String output = outputStream.toString(); // Convert byte array to string
            if (!output.contains(expected)) {
                throw new AssertionError("Expected output to contain: " + expected + " but was: " + output);
            }
            System.out.println("Assertion passed: " + expected);
            outputStream.reset(); // Reset the stream to capture new outputs
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runApp(UserDto userDto, BufferedReader reader, PrintStream printStream) throws IOException {
        // Use your actual runApp method
        Main.runApp(userDto, reader, printStream);
    }
}
