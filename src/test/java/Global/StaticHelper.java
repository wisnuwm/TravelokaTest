//package Global;
//
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class StaticHelper {
//    public static ChromeOptions GenerateDriverChrome(){
//        final String checkOS = System.getProperty("os.name").toLowerCase();
//        System.out.println("current OS = " + checkOS);
//        final String dir = System.getProperty("user.dir");
//        System.out.println("current dir = " + dir);
//        if (checkOS.contains("linux") || checkOS.contains("nix") || checkOS.contains("nux")) {
//            System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver_linux_88");
//        } else if (checkOS.contains("windows")) {
//            System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver_windows_91.exe");
//        } else if (checkOS.contains("mac")) {
//            System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver");
//        } else {
//            System.out.println("Your OS is not support!!");
//        }
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--single-process", "--ignore-ssl-errors=yes",
//                "--ignore-certificate-errors"
//                , "headless"
//        );
//        return options;
//    }
//}
