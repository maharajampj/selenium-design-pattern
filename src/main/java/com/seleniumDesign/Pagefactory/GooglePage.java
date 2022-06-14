package com.seleniumDesign.Pagefactory;

public abstract class GooglePage {
    public abstract  void launchSite();
    public abstract void search(String Keyword);
    public abstract String getResultCount();
}
