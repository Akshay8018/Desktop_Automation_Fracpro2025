//package com.agentic.windows_automation_ai.manager;
//
//import java.net.Socket;
//
//public class WinAppDriverManager {
//
//    private static Process winAppDriverProcess;
//
//    public static void startWinAppDriver() {
//        try {
//            ProcessBuilder builder = new ProcessBuilder(
//                "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"
//            );
//            builder.redirectErrorStream(true);
//            winAppDriverProcess = builder.start();
//
//            // Wait until WinAppDriver is listening on port 4723
//            int retries = 10;
//            while (retries-- > 0) {
//                if (isPortOpen("127.0.0.1", 4723)) {
//                    System.out.println("WinAppDriver is ready on port 4723");
//                    return;
//                }
//                Thread.sleep(1000);
//            }
//
//            throw new RuntimeException("WinAppDriver did not start on port 4723");
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to start WinAppDriver", e);
//        }
//    }
//    
//    private static boolean isPortOpen(String host, int port) {
//        try (Socket socket = new Socket(host, port)) {
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//
//    public static void stopWinAppDriver() {
//        if (winAppDriverProcess != null) {
//            winAppDriverProcess.destroy();
//            System.out.println("WinAppDriver stopped");
//        }
//    }
//}
