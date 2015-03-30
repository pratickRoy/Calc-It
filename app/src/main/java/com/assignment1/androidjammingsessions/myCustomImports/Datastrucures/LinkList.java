package com.assignment1.androidjammingsessions.myCustomImports.Datastrucures;

/**
 * Created by 1405321 on 2/13/2015.
 */
public class LinkList
{
    protected String data;
    protected LinkList link;
    protected LinkList()
    {
        link = null;
        data = null;
    }
    protected LinkList(String d,LinkList n)
    {
        data = d;
        link = n;
    }
    protected void setLink(LinkList n)
    {
        link = n;
    }
    protected void setData(String d)
    {
        data = d;
    }
    protected LinkList getLink()
    {
        return link;
    }
    protected String getData()
    {
        return data;
    }
}