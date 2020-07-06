package businesscomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Login_Reservation {

	static WebDriver driver;
	static HashMap<String, String> testdata ;


	static By OriginLocation =  By.xpath("//input[@id='BE_flight_origin_city']");
	static By ArrivalLocation =  By.xpath("//input[@id='BE_flight_arrival_city']");

	static By OriginLocationValue;
	static By ArrivalLocationValue;
	static By date;
	static By SearchFlights =  By.xpath("//input[@id='BE_flight_flsearch_btn' and @value='Search Flights']");

	static By filter =  By.xpath("//p[@class='font-lightgrey bold' and contains(text(),'0')]");

	static By durationlist = By.xpath("//p[@autom='durationLabel']");
	static By pricelist = By.xpath("//div[@autom='priceLabel']");


	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\driver\\chromedriver.exe");
		driver=new ChromeDriver(options);		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void launchUrl() {

		driver.get("https://www.yatra.com");
	} 


	public void chooseLocations() throws IOException, InterruptedException {


		testdata = testdata();

		OriginLocationValue =  By.xpath("//p[contains(text(),'"+testdata.get("Origin")+"')]/parent::div/parent::li");
		ArrivalLocationValue =  By.xpath("//p[contains(text(),'"+testdata.get("Arrival")+"')]/parent::div/parent::li");
		date =  By.xpath("//td[@id='"+TmrwDate()+"']");
		System.out.println(date);
		driver.findElement(OriginLocation).click();
		Thread.sleep(2000);
		driver.findElement(OriginLocationValue).click();

		driver.findElement(ArrivalLocation).click();
		Thread.sleep(2000);
		driver.findElement(ArrivalLocationValue).click();
		Thread.sleep(2000);
		driver.findElement(SearchFlights).click();
		driver.findElement(date).click();
		driver.findElement(SearchFlights).click();
		Thread.sleep(2000);

	}

	public void bookFlightTicket() throws Exception {

		WebElement ele = driver.findElement(filter);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele);
		ele.click();
		Thread.sleep(2000);
		List<WebElement> li = driver.findElements(durationlist);
		List lDurationTime = new ArrayList<Integer>();
		List lPrice = new ArrayList<Integer>();
		for(int i=0;i<li.size();i++) {
			lDurationTime.add(convertintominutes(li.get(i).getText().trim()));			
		}
		Collections.sort(lDurationTime);

		int ifastestflightTime = (int) lDurationTime.get(0);
		System.out.println(ifastestflightTime);



		if(NumofFastestTrains(ifastestflightTime,lDurationTime)) {
			System.out.println("There is only one fastest flight. Hence we cannot go for price validation");
			List<WebElement> durationlistele = driver.findElements(durationlist);

			for(int i=0;i<durationlistele.size();i++) {
				if(convertintominutes(durationlistele.get(i).getText().trim()) == ifastestflightTime) {
					By booknow = By.xpath("(//button[@autom='booknow'])["+(i+1)+"]");
					WebElement ele1 = driver.findElement(booknow);
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele1);
					ele1.click();
					break;
				}

			}

		}else {
			System.out.println("There are multiple fastest flights");

			List<WebElement> durationlistele = driver.findElements(durationlist);
			By pricelistI;
			int iCheapestFlight = 0;


			for(int i=0;i<durationlistele.size();i++) {
				if(convertintominutes(durationlistele.get(i).getText().trim()) == ifastestflightTime) {

					pricelistI = By.xpath("(//div[@autom='priceLabel'])["+(i+1)+"]");
					String actprice = driver.findElement(pricelistI).getText().toString().trim();
					String splitprice = actprice.replaceAll(",", "");
					lPrice.add(Integer.parseInt(splitprice));


				}

			}

			Collections.sort(lPrice);

			iCheapestFlight = (int) lPrice.get(0);

			for(int i=0;i<durationlistele.size();i++) {
				if(convertintominutes(durationlistele.get(i).getText().trim()) == ifastestflightTime) {
					pricelistI = By.xpath("(//div[@autom='priceLabel'])["+(i+1)+"]");
					String actprice = driver.findElement(pricelistI).getText().toString().trim();
					String splitprice = actprice.replaceAll(",", "");

					if(Integer.parseInt(splitprice) == iCheapestFlight) {
						By booknow = By.xpath("(//button[@autom='booknow'])["+(i+1)+"]");
						WebElement ele1 = driver.findElement(booknow);
						((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele1);
						ele1.click();
						Thread.sleep(5000);
						System.out.println("selected the cheapest and fastest flight");
						break;
					}

				}

			}


		}


		driver.close();

	}

	public int convertintominutes(String Time) {

		String[] Timesplit = Time.split(" ");
		String sTime1 = Timesplit[0].replaceAll("h", "");
		int ihourtominutes = Integer.parseInt(sTime1) * 60;
		String sTime2 = Timesplit[1].replaceAll("m", "");
		int iminutesonly =	Integer.parseInt(sTime2);

		int iTotaltime = ihourtominutes + iminutesonly;

		return iTotaltime;

	}


	public HashMap<String, String> testdata() throws IOException {

		String value ="";
		HashMap<String, String> fvalue = null;
		System.out.println(System.getProperty("user.dir")+"\\src\\datatables\\testdata.xlsx");

		FileInputStream finput = new FileInputStream(System.getProperty("user.dir")+"\\src\\datatables\\testdata.xlsx");


		XSSFWorkbook wb = new XSSFWorkbook(finput);

		XSSFSheet sheet = wb.getSheetAt(0);

		int irowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(0).getPhysicalNumberOfCells();

		for(int i=1; i<= irowcount;i++) {
			fvalue = new HashMap<String, String>();


			for(int j=0;j< columncount;j++) {

				XSSFCell cell = sheet.getRow(i).getCell(j);
				if(cell == null) {

					value = "";

				}else {

					value = cell.toString();
				}

				if(j ==0 ) {
					fvalue.put("Origin", value);
				}else {
					fvalue.put("Arrival", value);
				}

			}


		}	
		return fvalue;

	}

	public String TmrwDate() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		String strDate = formatter.format(cal.getTime());
		return strDate;


	}
	public boolean NumofFastestTrains(int iTime, List<Integer> l) {		
		boolean bResult = true;
		int icount = 0;		
		for(int k=0;k<(int) l.size();k++) {
			if(iTime==l.get(k)) {
				icount++;
			}
		}
		if(icount>1) {
			bResult = false;			
		}
		return bResult;		
	}


}
