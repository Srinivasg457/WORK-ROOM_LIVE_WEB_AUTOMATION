package utilities;

import javax.mail.*;
import javax.mail.search.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailReading {
    public static String getInvitationLink(String host, String user, String password,
                                           String exactSubject, int timeoutSeconds) {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imaps.ssl.trust", "*");
        properties.put("mail.imaps.timeout", "10000");
        properties.put("mail.imaps.connectiontimeout", "10000");
        properties.put("mail.debug", "true");

        String foundLink = null;
        Store store = null;
        Folder inbox = null;

        try {
            System.out.println("Waiting 10 seconds for email delivery...");
            Thread.sleep(10000);

            Session session = Session.getInstance(properties);
            store = session.getStore("imaps");
            store.connect(host, user, password);

            // Open folder in READ_WRITE mode
            inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);  // CHANGED FROM READ_ONLY

            // Search criteria
            Flags seen = new Flags(Flags.Flag.SEEN);
            FlagTerm unseenFlag = new FlagTerm(seen, false);
            SubjectTerm subjectTerm = new SubjectTerm(exactSubject);
            SearchTerm searchTerm = new AndTerm(unseenFlag, subjectTerm);

            Message[] messages = inbox.search(searchTerm);
            System.out.println("Found " + messages.length + " messages with exact subject: '" + exactSubject + "'");

            // Process from newest to oldest
            for (int i = messages.length - 1; i >= 0; i--) {
                Message message = messages[i];
                foundLink = extractWorkroomInvitationLink(message);

                if (foundLink != null) {
                    message.setFlag(Flags.Flag.SEEN, true); // Mark as read
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("Error processing emails: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (inbox != null && inbox.isOpen()) {
                    inbox.close(false);
                }
                if (store != null) {
                    store.close();
                }
            } catch (Exception e) {
                System.err.println("Error closing email connection: " + e.getMessage());
            }
        }

        return foundLink;
    }

    private static String extractWorkroomInvitationLink(Message message) throws Exception {
        String body = getEmailBody(message);

        // Pattern for Workroom-specific invitation links
        Pattern pattern = Pattern.compile(
                "(https?:\\/\\/(?:www\\.)?work-room\\.io\\/accept-invitation\\?token=[a-zA-Z0-9]+)",
                Pattern.CASE_INSENSITIVE
        );

        Matcher matcher = pattern.matcher(body);
        if (matcher.find()) {
            String link = matcher.group(1);
            System.out.println("Extracted invitation link: " + link);
            return link;
        }

        System.out.println("No Workroom invitation link found");
        return null;
    }

    private static String getEmailBody(Message message) throws Exception {
        if (message.isMimeType("text/*")) {
            return (String) message.getContent();
        }

        if (message.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) message.getContent();
            for (int i = 0; i < multipart.getCount(); i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                if (bodyPart.isMimeType("text/html")) {
                    return (String) bodyPart.getContent();
                }
            }
        }
        return "";
    }

    public static void openInBrowser(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
                System.out.println("Opened in default browser: " + url);
            } else {
                System.err.println("Desktop browsing not supported");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
























//public class EmailReading {
//    public static String getInvitationLink(String host, String user, String password,
//                                           String subjectKeyword, int timeoutSeconds) {
//        Properties properties = new Properties();
//        properties.put("mail.store.protocol", "imaps");
//        properties.put("mail.imaps.ssl.trust", "*");
//        properties.put("mail.imaps.timeout", "10000");
//        properties.put("mail.imaps.connectiontimeout", "10000");
//        properties.put("mail.debug", "true");
//
//        try {
//            System.out.println("Attempting to connect to: " + host + " with user: " + user);
//            Session session = Session.getInstance(properties);
//            Store store = session.getStore("imaps");
//
//            store.connect(host, user, password);
//            System.out.println("Successfully connected to email server");
//
//            Folder inbox = store.getFolder("INBOX");
//            inbox.open(Folder.READ_WRITE); // Mark message as read
//
//            Message[] messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
//
//            System.out.println("Found " + messages.length + " unread messages");
//
//            for (int i = 0; i < messages.length; i++) {
//                Message message = messages[i];
//                System.out.println("Processing message with subject: " + message.getSubject());
//
//                if (message.getSubject() != null && message.getSubject().contains(subjectKeyword)) {
//                    String link = extractLinkFromMessage(message);
//                    if (link != null) {
//                        message.setFlag(Flag.SEEN, true); // mark as read
//
//                        // Open the link
//                        openLink(link);
//
//                        inbox.close(false);
//                        store.close();
//                        return link;
//                    }
//                }
//            }
//
//            System.out.println("No invitation link found.");
//            inbox.close(false);
//            store.close();
//
//        } catch (Exception e) {
//            System.err.println("Error accessing email: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    private static String extractLinkFromMessage(Message message) throws Exception {
//        Object content = message.getContent();
//        String body = "";
//
//        if (content instanceof String) {
//            body = (String) content;
//        } else if (content instanceof Multipart) {
//            Multipart multipart = (Multipart) content;
//            for (int i = 0; i < multipart.getCount(); i++) {
//                BodyPart part = multipart.getBodyPart(i);
//                if (part.isMimeType("text/plain")) {
//                    body += part.getContent().toString();
//                } else if (part.isMimeType("text/html")) {
//                    body += part.getContent().toString();
//                }
//            }
//        }
//
//        Pattern pattern = Pattern.compile(
//                "(https?:\\/\\/[^\\s\"'<>]+invite[^\\s\"'<>]*)",
//                Pattern.CASE_INSENSITIVE
//        );
//
//        Matcher matcher = pattern.matcher(body);
//        if (matcher.find()) {
//            String link = matcher.group(1);
//            System.out.println("Found invitation link: " + link);
//            return link;
//        }
//
//        System.out.println("No invitation link pattern found in message body");
//        return null;
//    }
//
//    private static void openLink(String url) {
//        try {
//            if (Desktop.isDesktopSupported()) {
//                Desktop.getDesktop().browse(new URI(url));
//                System.out.println("Opened invitation link in default browser.");
//            } else {
//                System.err.println("Desktop not supported. Cannot open link.");
//            }
//        } catch (Exception e) {
//            System.err.println("Failed to open the link: " + e.getMessage());
//        }
//    }
//}















//public class EmailReading {
//    public static String getInvitationLink(String host, String user, String password,
//                                           String subjectKeyword, int timeoutSeconds) {
//        Properties properties = new Properties();
//        properties.put("mail.store.protocol", "imaps");
//        properties.put("mail.imaps.ssl.trust", "*");
//        properties.put("mail.imaps.timeout", "10000");
//        properties.put("mail.imaps.connectiontimeout", "10000");
//        properties.put("mail.debug", "true");
//
//        try {
//            System.out.println("Attempting to connect to: " + host + " with user: " + user);
//
//            // Add delay before checking emails
//            System.out.println("Waiting 10 seconds for email delivery...");
//            Thread.sleep(10000); // 10 second delay
//
//            Session session = Session.getInstance(properties);
//            Store store = session.getStore("imaps");
//
//            store.connect(host, user, password);
//            System.out.println("Successfully connected to email server");
//
//            Folder inbox = store.getFolder("INBOX");
//            inbox.open(Folder.READ_ONLY);
//
//            // Create search term combining unseen flag and subject filter
//            Flags seen = new Flags(Flags.Flag.SEEN);
//            FlagTerm unseenFlag = new FlagTerm(seen, false);
//            SubjectTerm subjectTerm = new SubjectTerm(subjectKeyword);
//            SearchTerm searchTerm = new AndTerm(unseenFlag, subjectTerm);
//
//            // Search for messages matching both criteria
//            Message[] messages = inbox.search(searchTerm);
//            System.out.println("Found " + messages.length + " unread messages with subject: " + subjectKeyword);
//
//            if (messages.length > 0) {
//                // Process messages from newest to oldest
//                for (int i = messages.length - 1; i >= 0; i--) {
//                    Message message = messages[i];
//                    System.out.println("Processing message with subject: " + message.getSubject());
//
//                    String link = extractLinkFromMessage(message);
//                    if (link != null) {
//                        // Mark as read after processing
//                        message.setFlag(Flags.Flag.SEEN, true);
//                        inbox.close(false);
//                        store.close();
//                        return link;
//                    }
//                }
//            } else {
//                System.out.println("No unread messages found with subject: " + subjectKeyword);
//            }
//
//            inbox.close(false);
//            store.close();
//
//        } catch (Exception e) {
//            System.err.println("Error accessing email: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//
//    private static String extractLinkFromMessage(Message message) throws Exception {
//        Object content = message.getContent();
//        String body = "";
//
//        if (content instanceof String) {
//            body = (String) content;
//        } else if (content instanceof Multipart) {
//            Multipart multipart = (Multipart) content;
//            for (int i = 0; i < multipart.getCount(); i++) {
//                BodyPart part = multipart.getBodyPart(i);
//                if (part.isMimeType("text/html")) {
//                    body = (String) part.getContent();
//
//                    // First try to find the button link
//                    Pattern buttonPattern = Pattern.compile(
//                            "<a[^>]*href=[\"'](https?:\\/\\/work-room\\.io\\/accept-invitation\\?token=[^\"']+)[\"'][^>]*>\\s*Accept Invitation\\s*<\\/a>",
//                            Pattern.CASE_INSENSITIVE
//                    );
//                    Matcher buttonMatcher = buttonPattern.matcher(body);
//                    if (buttonMatcher.find()) {
//                        return buttonMatcher.group(1);
//                    }
//                }
//            }
//        }
//
//        // Fallback to general link pattern
//        Pattern pattern = Pattern.compile(
//                "(https?:\\/\\/work-room\\.io\\/accept-invitation\\?token=[^\\s\"'<>]+)",
//                Pattern.CASE_INSENSITIVE
//        );
//        Matcher matcher = pattern.matcher(body);
//        if (matcher.find()) {
//            return matcher.group(1);
//        }
//
//        return null;
//    }
//    public static void openLink(String url) {
//        try {
//            if (Desktop.isDesktopSupported()) {
//                Desktop.getDesktop().browse(new URI(url));
//                System.out.println("Opened invitation link in default browser.");
//            } else {
//                System.err.println("Desktop not supported. Cannot open link.");
//            }
//        } catch (Exception e) {
//            System.err.println("Failed to open the link: " + e.getMessage());
//        }
//    }
//}


































//public class EmailReading {
//
//    public static String getInvitationLink(String host, String user, String password,
//                                           String subjectKeyword, int timeoutSeconds) {
//        Properties properties = new Properties();
//        properties.put("mail.store.protocol", "imaps");
//        properties.put("mail.imaps.ssl.trust", "*");
//        properties.put("mail.imaps.timeout", "10000");
//        properties.put("mail.imaps.connectiontimeout", "10000");
//
//        try {
//            System.out.println("Attempting to connect to: " + host + " with user: " + user);
//            Session session = Session.getInstance(properties);
//            Store store = session.getStore("imaps");
//
//            // Connect with timeout
//            store.connect(host, user, password);
//            System.out.println("Successfully connected to email server");
//
//            // Rest of your email processing code...
//
//        } catch (AuthenticationFailedException e) {
//            System.err.println("ERROR: Authentication failed. Please verify:");
//            System.err.println("1. You're using the correct email and password");
//            System.err.println("2. For Gmail with 2FA, you must use an App Password");
//            System.err.println("3. IMAP access is enabled in Gmail settings");
//            System.err.println("4. 'Less secure apps' is enabled if not using 2FA");
//            System.err.println("Full error: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("Error accessing email: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private static String extractLinkFromMessage(Message message) throws Exception {
//        Object content = message.getContent();
//        String body = "";
//
//        if (content instanceof String) {
//            body = (String) content;
//        } else if (content instanceof Multipart) {
//            Multipart multipart = (Multipart) content;
//            for (int i = 0; i < multipart.getCount(); i++) {
//                BodyPart part = multipart.getBodyPart(i);
//                if (part.isMimeType("text/plain") || part.isMimeType("text/html")) {
//                    body = (String) part.getContent();
//                    break;
//                }
//            }
//        }
//
//        // Improved regex to match invitation links
//        Pattern pattern = Pattern.compile("https?:\\/\\/[^\\s\"']*invite[^\\s\"']*", Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(body);
//
//        if (matcher.find()) {
//            return matcher.group();
//        }
//        return null;
//    }
//}