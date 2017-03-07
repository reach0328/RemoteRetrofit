package com.android.jh.remoteretorofit.Domain;

public class Data
{
    private SearchParkingInfo SearchParkingInfo;

    public SearchParkingInfo getSearchParkingInfo ()
    {
        return SearchParkingInfo;
    }

    public void setSearchParkingInfo (SearchParkingInfo SearchParkingInfo)
    {
        this.SearchParkingInfo = SearchParkingInfo;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [SearchParkingInfo = "+SearchParkingInfo+"]";
    }
}