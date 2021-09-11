package ru.netology.data;

import java.io.IOException;

public class Launcher {
    public static void launch() {

        String filePath = "./artifacts/app-deadline.jar ";
        String url = " -P:jdbc.url=jdbc:mysql://localhost:3306/db_app ";
        String user = " -P:jdbc.user=app ";
        String password = " -P:jdbc.password=pass ";

        Runtime re = Runtime.getRuntime();
        try {
            re.exec("java -jar " + filePath + url + user + password);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
