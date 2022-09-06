package com.example.BookingApp.email.service;

import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.model.Reservation;
import com.example.BookingApp.users.model.BoatOwner;
import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.model.CottageOwner;
import com.example.BookingApp.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Service
public class EmailSenderService {

        @Autowired
        private JavaMailSender mailSender;
    public static int noOfQuickServiceThreads = 20;

    /**
     * this statement create a thread pool of twenty threads
     * here we are assigning send mail task using ScheduledExecutorService.submit();
     */
    private ScheduledExecutorService quickService = Executors.newScheduledThreadPool(noOfQuickServiceThreads);

        @Async
        public void sendComplaintEmail(String body, Client client, RentingItem rentingItem) {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(client.getEmail());
            message.setTo("timesheetjoksi@gmail.com");
            message.setText("Dear,\nclient "+ client.getName() + " " + client.getSurname() +  " " +
                    "made complaint on renting item " + rentingItem.getName() + ", " + rentingItem.getAddress() +
                    "\n\n Description: "+ body);
            message.setSubject("Complaint about renting item");
            quickService.submit(new Runnable() {
                @Override
                public void run() {
                    try{
                        mailSender.send(message);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }

    @Async
    public void sendComplaintReplyEmail(String body, Client client, RentingItem rentingItem) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("timesheetjoksi@gmail.com");
        message.setTo(client.getEmail(),"timesheetjoksi@gmail.com");
        message.setText("Dear,\nsystem admin answered your complaint " +
                "made on renting item " + rentingItem.getName() + ", " + rentingItem.getAddress() +
                "\n\n Answer: "+ body);
        message.setSubject("Complaint reply");
        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    mailSender.send(message);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Async
    public void sendAccountDeletionRequest(String body, Client client) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(client.getEmail());
        message.setTo("timesheetjoksi@gmail.com");
        message.setText("Dear,\nclient "+ client.getName() + " " + client.getSurname() +  " " +
                "wants to delete his/her acount" +  "\n\n Explanation: "+ body);
        message.setSubject("Account deletion request");
        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    mailSender.send(message);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
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
        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    mailSender.send(message);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Async
    public void sendRegistrationConfirmationEmailForBO(BoatOwner b) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("timesheetjoksi@gmail.com");
        message.setTo(b.getEmail());
        String url = "http://localhost:4200/login?token=" + b.getVerificationCode();
        String content="<a href='"+url+"'>link</a>";
        message.setText("Dear \n "+ b.getName() + ", \n"+
                "Please confirm your registration by clicking on this  " + url);
        message.setSubject("Registration confirmation");
        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    mailSender.send(message);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Async
    public void sendRegistrationConfirmationEmailForCO(CottageOwner c) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("timesheetjoksi@gmail.com");
        message.setTo(c.getEmail());
        String url = "http://localhost:4200/login?token=" + c.getVerificationCode();
        String content="<a href='"+url+"'>link</a>";
        message.setText("Dear \n "+ c.getName() + ", \n"+
                "Please confirm your registration by clicking on this  " + url);
        message.setSubject("Registration confirmation");
        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    mailSender.send(message);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Async
    public void sendReservationConfirmationEmail( Reservation reservation) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("timesheetjoksi@gmail.com");
        message.setTo(reservation.getClient().getEmail());
        message.setText("Dear "+ reservation.getClient().getName() + ", \n"+
                "We announce you that you are successfully reserved  " + reservation.getRentingItem().getName() + ", "+ reservation.getRentingItem().getAddress()+" from date "+reservation.getStartTime() + " - " + reservation.getEndTime());
        message.setSubject("Reservation confirmation");
        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    mailSender.send(message);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Async
    public void sendQuickReservationConfirmationEmail( QuickReservation reservation) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("timesheetjoksi@gmail.com");
        message.setTo(reservation.getClient().getEmail());
        message.setText("Dear "+ reservation.getClient().getName() + ", \n"+
                "We announce you that you are successfully reserved  action" + reservation.getAction().getRentingItem().getName() + ", "+ reservation.getAction().getRentingItem().getAddress()+" from date "+reservation.getAction().getStartTime() + " - " + reservation.getAction().getEndTime());
        message.setSubject("Action reservation confirmation");
        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    mailSender.send(message);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    @Async
    public void sendAccountDeletionDenyReplyRequest(String body, Client client) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(client.getEmail());
        message.setTo("timesheetjoksi@gmail.com");
        message.setText("Dear "+ client.getName() + " " + client.getSurname() +  ",\n " +
                "Admin denied your request for account deletion" +  "\n\n Explanation: "+ body);
        message.setSubject("Account deletion request reply");
        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    mailSender.send(message);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Async
    public void sendAccountDeletionApproveReplyRequest(Client client) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(client.getEmail());
        message.setTo("timesheetjoksi@gmail.com");
        message.setText("Dear "+ client.getName() + " " + client.getSurname() +  ",\n " +
                "Admin approved your request for account deletion, your account is deleted and you are no longer available to login with your old credentials.");
        message.setSubject("Account deletion request reply");
        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    mailSender.send(message);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }


}
