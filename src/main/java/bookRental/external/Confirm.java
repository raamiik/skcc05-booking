package bookRental.external;

public class Confirm {

    private Long confirmId;
    private Long bookingId;
    private String confirmStatus;

    public Long getConfirmId() {
        return confirmId;
    }
    public void setConfirmId(Long confirmId) {
        this.confirmId = confirmId;
    }
    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public String getConfirmStatus() {
        return confirmStatus;
    }
    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

}
