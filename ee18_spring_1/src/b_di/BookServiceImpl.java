package b_di;

public class BookServiceImpl implements BookService {

	//方式1  之前实现
	//private BookDao bookDao = new BookDaoImpl();
	//方式2 接口+setter
	private BookDao bookDao;
	
	public void setAddBook(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public void addBook() {
		this.bookDao.addBook();
	}

}
