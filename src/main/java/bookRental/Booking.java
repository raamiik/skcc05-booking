package bookRental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Booking_table")
public class Booking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bookingId;
    private String bookName;
    private Long customerId;
    private String bookingStatus;

    @PostPersist
    public void onPostPersist(){
        Booked booked = new Booked();
        BeanUtils.copyProperties(this, booked);
        booked.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        bookRental.external.Confirm confirm = new bookRental.external.Confirm();

        confirm.setBookingId(this.getBookingId());
        confirm.setConfirmStatus("plz confirm book rental");

        System.out.println("=====Booking.java===========================================================");
        System.out.println("booking onPost에서 bookingId= " +this.getBookingId());
        System.out.println("================================================================");

        // mappings goes here
        BookingApplication.applicationContext.getBean(bookRental.external.ConfirmService.class)
            .makeConfirm(confirm);


    }

    @PostUpdate
    public void onPostUpdate(){

        System.out.println("================================================================");
        System.out.println("onPostUpdate " +this.getBookingId());
        System.out.println("================================================================");


        UnBooked unBooked = new UnBooked();
        BeanUtils.copyProperties(this, unBooked);
        System.out.println("unBooked========> " + unBooked.getBookingId());
        unBooked.publishAfterCommit();
        System.out.println("asdfasdfasdfasdfasdfasdfasdfunBooked========> " + unBooked.getBookingId());


    }


    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }




}
