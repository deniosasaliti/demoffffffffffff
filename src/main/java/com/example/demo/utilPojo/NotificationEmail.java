package com.example.demo.utilPojo;




public class NotificationEmail {
    private String subject;
    private String recipient;
    private  String  success;



    public NotificationEmail(String subject, String recipient,String success) {
        this.subject = subject;
        this.recipient = recipient;
        this.success = success;

    }

    public NotificationEmail() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSuccessUrl() {
        return success;
    }

    public void setSuccessUrl(String successUrl) {
        success = successUrl;
    }
}
