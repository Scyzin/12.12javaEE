package b_di;

public class BookServiceImpl implements BookService {

	//��ʽ1  ֮ǰʵ��
	//private BookDao bookDao = new BookDaoImpl();
	//��ʽ2 �ӿ�+setter
	private BookDao bookDao;
	
	public void setAddBook(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public void addBook() {
		this.bookDao.addBook();
	}

}
