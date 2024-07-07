package main;

import main.dto.UserDto;
import main.exception.ErrorInputException;
import main.request.BaseRequest;
import main.service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        UserDto userDto = new UserDto();
        ProviderService.loadProviders();
        ServiceTypeService.loadServices();
        runApp(userDto, new BufferedReader(new InputStreamReader(System.in)), System.out);
    }

    public static void runApp(UserDto userDto, BufferedReader reader, PrintStream out) throws IOException {
        while (true) {
            // Reading data using readLine
            String input = reader.readLine();
            try {
                BaseRequest baseRequest = HandlerInputService.getRequest(input);
                BaseHandler baseHandler = GetHandlerService.getHandler(baseRequest);
                baseHandler.execute(userDto, baseRequest);
            } catch (ErrorInputException e) {
                out.println(e.getMessage());
            }
        }
    }
}