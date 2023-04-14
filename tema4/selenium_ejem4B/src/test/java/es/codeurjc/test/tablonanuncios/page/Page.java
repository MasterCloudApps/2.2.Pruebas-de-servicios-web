package es.codeurjc.test.tablonanuncios.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String baseUrl;
	 
    public Page(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        PageFactory.initElements(driver, this);
    }
    
    public Page(Page page) {
    	this(page.driver, page.baseUrl);
    }
    
    protected void get(String path) {
    	
    	if(!path.startsWith("http") && baseUrl != null) {
    		path = baseUrl + path;
    	} 
    	
        driver.get(path);
    }
}