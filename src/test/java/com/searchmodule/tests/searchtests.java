package com.searchmodule.tests;

import com.searchmodule.pages.searchvideos;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class searchtests extends BaseTest {


    @Test
    @Parameters({"keyword"})
    public void callsearch(String keyword){
        searchvideos searchVideos = new searchvideos(driver);
        searchVideos.gotosearchpage();
        searchVideos.searchtext(keyword);
        searchVideos.gotovideos();
        int searchcnt = searchVideos.getcnt();
        Assert.assertTrue(searchcnt>0);

    }



}
