package Functions;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import Databases.*;

public class ReadData {

	private final String fileName = "src/Databases/data.xls";
	private String URL;

	/*
	 * Get username and pass base on user
	 * 
	 * Parameter: user
	 * 
	 * Author: Tan Vo
	 */
	public User getUser(String _user) {

		User user = new User();
		Workbook workbook;
		try {
			// create workbook to open file
			workbook = Workbook.getWorkbook(new File(fileName));

			// get sheet want read
			Sheet sheet = workbook.getSheet(0);

			// get number row and col contain data
			int rows = sheet.getRows();
			int cols = sheet.getColumns();

			// read data in each cell
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					Cell cell = sheet.getCell(col, row);

					if (cell.getContents().equals(_user)) {
						Cell user1 = sheet.getCell(1, row);
						Cell pass1 = sheet.getCell(2, row);
						user.setUsername(user1.getContents());
						user.setPassword(pass1.getContents());
					}
				}
			}
			// close
			workbook.close();

		} catch (BiffException e) {
			System.out.println("File not found\n" + e.toString());
		} catch (IOException e) {
			System.out.println("File not found\n" + e.toString());
		}

		return user;
	}

	/*
	 * Get username and pass base on user
	 * 
	 * Parameter: user
	 * 
	 * Author: Tan Vo
	 */
	public Article getArticle(String _number) {

		Article article = new Article();
		Workbook workbook;
		try {
			// create workbook to open file
			workbook = Workbook.getWorkbook(new File(fileName));

			// get sheet want read
			Sheet sheet = workbook.getSheet(0);

			// get number row and col contain data
			int rows = sheet.getRows();
			int cols = sheet.getColumns();

			// read data in each cell
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					Cell cell = sheet.getCell(col, row);

					if (cell.getContents().equals(_number)) {
						Cell title = sheet.getCell(1, row);
						Cell category = sheet.getCell(2, row);
						Cell status = sheet.getCell(3, row);
						Cell content = sheet.getCell(4, row);
						Cell image = sheet.getCell(5,row);
						
						article.setTitle(title.getContents());
						article.setCategory(category.getContents());
						article.setStatus(status.getContents());
						article.setContent(content.getContents());
						article.setImage(image.getContents());
					}
				}
			}
			// close
			workbook.close();

		} catch (BiffException e) {
			System.out.println("File not found\n" + e.toString());
		} catch (IOException e) {
			System.out.println("File not found\n" + e.toString());
		}

		return article;
	}
	
	/*
	 * Get Client
	 * 
	 * Parameter: client
	 * 
	 * Author: Tan Vo
	 */
	public Client getClient(String _client){
		Client client = new Client();
		Workbook workbook;
		try {
			// create workbook to open file
			workbook = Workbook.getWorkbook(new File(fileName));

			// get sheet want read
			Sheet sheet = workbook.getSheet(0);

			// get number row and col contain data
			int rows = sheet.getRows();
			int cols = sheet.getColumns();

			// read data in each cell
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					Cell cell = sheet.getCell(col, row);

					if (cell.getContents().equals(_client)) {
						Cell name = sheet.getCell(1, row);
						Cell contact = sheet.getCell(2, row);
						Cell email = sheet.getCell(3, row);
						Cell status = sheet.getCell(4, row);
						
						client.setName(name.getContents());
						client.setContact(contact.getContents());
						client.setEmail(email.getContents());
						client.setStatus(status.getContents());
					}
				}
			}
			// close
			workbook.close();

		} catch (BiffException e) {
			System.out.println("File not found\n" + e.toString());
		} catch (IOException e) {
			System.out.println("File not found\n" + e.toString());
		}

		return client;
	}
	
	/*
	 * Get Category
	 * 
	 * Author: Tan Vo
	 */
	public Category getCategory(String cate){
		Category category = new Category();
		Workbook workbook;
		try {
			// create workbook to open file
			workbook = Workbook.getWorkbook(new File(fileName));

			// get sheet want read
			Sheet sheet = workbook.getSheet(0);

			// get number row and col contain data
			int rows = sheet.getRows();
			int cols = sheet.getColumns();

			// read data in each cell
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					Cell cell = sheet.getCell(col, row);

					if (cell.getContents().equals(cate)) {
						Cell title = sheet.getCell(1, row);
						
						category.setTitle(title.getContents());
					}
				}
			}
			// close
			workbook.close();

		} catch (BiffException e) {
			System.out.println("File not found\n" + e.toString());
		} catch (IOException e) {
			System.out.println("File not found\n" + e.toString());
		}

		return category;
	}
	
	/*
	 * Get Banner
	 * 
	 * Author: Tan Vo
	 */
	public Banner getBanner(String ban){
		Banner banner = new Banner();
		Workbook workbook;
		try {
			// create workbook to open file
			workbook = Workbook.getWorkbook(new File(fileName));

			// get sheet want read
			Sheet sheet = workbook.getSheet(0);

			// get number row and col contain data
			int rows = sheet.getRows();
			int cols = sheet.getColumns();

			// read data in each cell
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					Cell cell = sheet.getCell(col, row);

					if (cell.getContents().equals(ban)) {
						Cell name = sheet.getCell(1, row);
						Cell category = sheet.getCell(2, row);
						Cell client = sheet.getCell(3, row);
						
						banner.setName(name.getContents());
						banner.setCategory(category.getContents());
						banner.setClient(client.getContents());
					}
				}
			}
			// close
			workbook.close();

		} catch (BiffException e) {
			System.out.println("File not found\n" + e.toString());
		} catch (IOException e) {
			System.out.println("File not found\n" + e.toString());
		}

		return banner;
	}
	
	/*
	 * Get url
	 * 
	 * Parameter: where
	 * 
	 * Author: Tan Vo
	 */
	public String getUrl(String _where) {
		Workbook workbook;
		try {
			// create workbook to open file
			workbook = Workbook.getWorkbook(new File(fileName));

			// get sheet want read
			Sheet sheet = workbook.getSheet(0);

			// get number row and col contain data
			int rows = sheet.getRows();
			int cols = sheet.getColumns();

			// read data in each cell
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					Cell cell = sheet.getCell(col, row);

					if (cell.getContents().equals(_where)) {
						Cell content = sheet.getCell(1, row);
						URL = content.getContents();
					}
				}
			}
			// close
			workbook.close();

		} catch (BiffException e) {
			System.out.println("File not found\n" + e.toString());
		} catch (IOException e) {
			System.out.println("File not found\n" + e.toString());
		}
		return URL;
	}

}
