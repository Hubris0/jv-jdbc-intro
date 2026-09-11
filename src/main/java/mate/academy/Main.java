package mate.academy;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.model.Book;
import mate.academy.service.impl.BookDaoImpl;

public class Main {
    public static void main(String[] args) {
        BookDaoImpl bookDao = new BookDaoImpl();

        BigDecimal price1 = new BigDecimal("120.50");
        String title1 = "Lord of the Rings";

        Book lotr = new Book();
        lotr.setTitle(title1);
        lotr.setPrice(price1);
        Book lotrUpdated = bookDao.create(lotr);

        System.out.println("Created book: " + lotrUpdated);

        BigDecimal price2 = new BigDecimal("59.99");
        String title2 = "Mountains of madness";

        Book mom = new Book();
        mom.setTitle(title2);
        mom.setPrice(price2);
        Book momUpdated = bookDao.create(mom);

        System.out.println("Created book: " + momUpdated);

        List<Book> books = bookDao.findAll();

        for (Book book : books) {
            System.out.println("Found through find all: " + book);
        }

        String updatedTitle = "Lord of the Rings: Fellowship of the Ring";

        lotr.setTitle(updatedTitle);
        Book lotrTitleUpdated = bookDao.update(lotr);

        System.out.println("Book title updated: " + lotrTitleUpdated);

        boolean isDeleted = bookDao.deleteById(lotrUpdated.getId());

        System.out.println("Is deleted? " + isDeleted);
    }
}
