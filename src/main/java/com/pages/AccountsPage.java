package com.pages;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AccountsPage {
	private WebDriver driver;
	
	private By accountsSections = By.xpath("//div[@class='row addresses-lists']//a");
	private By storeinfo = By.xpath("//section[@id='block_contact_infos']//div//ul//li");
	private By storeinfoHeader = By.xpath("//section[@id='block_contact_infos']//div//h4");
	
	public AccountsPage(WebDriver driver){
		this.driver = driver;
	}
	public String getAccountsPageTitle(){
		return driver.getTitle();
	}
	public int getAccSectionsCount(){
		return driver.findElements(accountsSections).size();
	}
    public List<String> getAccountSections(){
	    List<String> accList = new ArrayList<>();
	    List<WebElement> accSections =  driver.findElements(accountsSections);
	    for(WebElement e:accSections){
		String text = e.getText();
		accList.add(text);
	    }
	    return accList;
   } 
    public List<String> clickAccountSections(){
    	List<String> sectionsPageTitle = new ArrayList<>();
    	List<WebElement> secs = driver.findElements(accountsSections);
    	try {
    	for(int i=0;i<secs.size();i++) {
    		secs.get(i).click();
    		String title = driver.getTitle();
    		sectionsPageTitle.add(title);    		
    		driver.navigate().back();
    		secs = driver.findElements(accountsSections);
    	}
    	}
    	catch(Exception e) {
    		System.out.println("unexpected exception");
    		e.printStackTrace();
    	}
    	return sectionsPageTitle;
    }
    public List<String> getStoreInfo() {
    	List<String> storeinformation = new ArrayList<>();
    	List<WebElement> istoreInfo = driver.findElements(storeinfo);
    	for(int i=0;i<istoreInfo.size();i++) {
    		String text = istoreInfo.get(i).getText();
    		storeinformation.add(text);
    	}
    	return storeinformation;
    }
    public String getStoreInfoHeader() {
    	String header = driver.findElement(storeinfoHeader).getText();
    	return header;
    }
}
