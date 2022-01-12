package com.example.BookingApp.email.service;

import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.reservations.model.Reservation;
import com.example.BookingApp.users.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

        @Autowired
        private JavaMailSender mailSender;

        @Async
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

    @Async
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

    @Async
    public void sendAccountDeletionRequest(String body, Client client) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(client.getEmail());
        message.setTo("timesheetjoksi@gmail.com");
        message.setText("Dear,\nclient "+ client.getName() + " " + client.getSurname() +  " " +
                "wants to delete his/her acount" +  "\n\n Explanation: "+ body);
        message.setSubject("Account deletion request");
        mailSender.send(message);
    }

    @Async
    public void sendRegistrationConfirmationEmail(Client client) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("timesheetjoksi@gmail.com");
        message.setTo(client.getEmail());
        String url = "http://localhost:4200/login?token=" + client.getVerificationCode();
        String content="<a href='"+url+"'>link</a>";
        message.setText("Dear \n "+ client.getName() + ", \n"+
                "Please confirm your registration by clicking on this  " + url);
        message.setSubject("Registration confirmation");
        mailSender.send(message);
    }

    @Async
    public void sendReservationConfirmationEmail( Reservation reservation) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("timesheetjoksi@gmail.com");
        message.setTo(reservation.getClient().getEmail());
        message.setText("Dear "+ reservation.getClient().getName() + ", \n"+
                "We announce you that you are successfully reserved  " + reservation.getRentingItem().getName() + ", "+ reservation.getRentingItem().getAddress()+" from date "+reservation.getStartTime() + " - " + reservation.getEndTime());
        message.setSubject("Reservation confirmation");
        mailSender.send(message);
    }


}
