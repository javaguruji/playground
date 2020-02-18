package oodesign.lms;

import oodesign.lms.enums.BookFormat;
import oodesign.lms.enums.BookStatus;

import java.util.Date;

/**
 * @author badrikant.soni
 */
public abstract class Book {

    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    //private List<Author> authors;
}

class BookItem extends Book {

    private String barcode;
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;
}

class Rack {
    private int number;
    private String locationIdentifier;
}

