package com.example.BookingApp.email.service;

import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.users.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

        @Autowired
        private JavaMailSender mailSender;

        public void sendComplaintEmail(String body, Client client, RentingItem rentingItem) {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(client.getEmail());
            message.setTo("timesheetjoksi@gmail.com");
            message.setText("Dear,\nclient "+ client.getName() + " " + client.getSurname() +  " " +
                    "made complaint on renting item " + rentingItem.getName() + ", " + rentingItem.getAddress() +
                    "\n\n Description: "+ body);
            message.setSubject("Complaint about renting item");
            mailSender.send(message);
        }

    public void sendComplaintReplyEmail(String body, Client client, RentingItem rentingItem) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("timesheetjoksi@gmail.com");
        message.setTo(client.getEmail());
        message.setText("Dear,\nsystem admin answered your complaint " +
                "made on renting item " + rentingItem.getName() + ", " + rentingItem.getAddress() +
                "\n\n Answer: "+ body);
        message.setSubject("Complaint reply");
        mailSender.send(message);
    }

    public void sendAccountDeletionRequest(String body, Client client) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(client.getEmail());
        message.setTo("timesheetjoksi@gmail.com");
        message.setText("Dear,\nclient "+ client.getName() + " " + client.getSurname() +  " " +
                "wants to delete his/her acount" +  "\n\n Explanation: "+ body);
        message.setSubject("Account deletion request");
        mailSender.send(message);
    }


}
