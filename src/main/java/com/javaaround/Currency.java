package com.javaaround;
public enum Currency {
  USD("$","United Amerial"),EURO("€","England"),SWISSFRANK("₣","Swizerland"),TAKA("৳","Bangladesh");
  private String icon;
  private String country; 
  Currency(String icon, String country){
    this.icon = icon; 
    this.country = country; 
  }

  public String getIcon(){
  	return icon;
  }
  public String getCountry(){
  	return country;
  }
}