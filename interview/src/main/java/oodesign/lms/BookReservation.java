package oodesign.lms;

import oodesign.lms.enums.ReservationStatus;

import java.util.Date;

/**
 * @author badrikant.soni
 */
class BookReservation {

    private Date creationDate;
    private ReservationStatus status;
    private String bookItemBarcode;
    private String memberId;

    static BookReservation fetchReservationDetails(String barcode){
        return null;
    }

}
