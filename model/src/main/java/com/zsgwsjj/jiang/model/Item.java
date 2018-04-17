package com.zsgwsjj.jiang.model;

import java.util.Arrays;

/**
 * @author : jiang
 * @time : 2018/4/4 16:59
 */
public class Item {

    private String title;
    private String url;
    private String[] links;
    private String[] pwds;
    private String linksAndPwdsStr;
    private String publishTime;
    private String authorityLevel;
    private String partition;
    private String auther;
    private String replyNum;
    private String viewNum;
    private String lastReplyName;
    private String lastReplyTime;
    private String lastReplyUrl;
    private String firstPageReply;
    private boolean isNeedReply;
    private int searchLinkTimes;

    public String getTitle() {
        return title;
    }

    public Item setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Item setUrl(String url) {
        this.url = url;
        return this;
    }

    public String[] getLinks() {
        return links;
    }

    public Item setLinks(String[] links) {
        this.links = links;
        return this;
    }

    public String[] getPwds() {
        return pwds;
    }

    public Item setPwds(String[] pwds) {
        this.pwds = pwds;
        return this;
    }

    public String getLinksAndPwdsStr() {
        return linksAndPwdsStr;
    }

    public Item setLinksAndPwdsStr(String linksAndPwdsStr) {
        if (linksAndPwdsStr == null || linksAndPwdsStr.equals("")) {
            links = new String[]{};
            pwds = new String[]{};
        } else {
            String[] split = linksAndPwdsStr.split("#;#");
            links = split[0].split(";");
            pwds = split[1].split(";");
        }
        this.linksAndPwdsStr = linksAndPwdsStr;
        return this;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public Item setPublishTime(String publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public String getAuthorityLevel() {
        return authorityLevel;
    }

    public Item setAuthorityLevel(String authorityLevel) {
        this.authorityLevel = authorityLevel;
        return this;
    }

    public String getPartition() {
        return partition;
    }

    public Item setPartition(String partition) {
        this.partition = partition;
        return this;
    }

    public String getAuther() {
        return auther;
    }

    public Item setAuther(String auther) {
        this.auther = auther;
        return this;
    }

    public String getReplyNum() {
        return replyNum;
    }

    public Item setReplyNum(String replyNum) {
        this.replyNum = replyNum;
        return this;
    }

    public String getViewNum() {
        return viewNum;
    }

    public Item setViewNum(String viewNum) {
        this.viewNum = viewNum;
        return this;
    }

    public String getLastReplyName() {
        return lastReplyName;
    }

    public Item setLastReplyName(String lastReplyName) {
        this.lastReplyName = lastReplyName;
        return this;
    }

    public String getLastReplyTime() {
        return lastReplyTime;
    }

    public Item setLastReplyTime(String lastReplyTime) {
        this.lastReplyTime = lastReplyTime;
        return this;
    }

    public String getLastReplyUrl() {
        return lastReplyUrl;
    }

    public Item setLastReplyUrl(String lastReplyUrl) {
        this.lastReplyUrl = lastReplyUrl;
        return this;
    }

    public String getFirstPageReply() {
        return firstPageReply;
    }

    public Item setFirstPageReply(String firstPageReply) {
        this.firstPageReply = firstPageReply;
        return this;
    }

    public boolean isNeedReply() {
        return isNeedReply;
    }

    public Item setNeedReply(boolean needReply) {
        isNeedReply = needReply;
        return this;
    }

    public int getSearchLinkTimes() {
        return searchLinkTimes;
    }

    public Item setSearchLinkTimes(int searchLinkTimes) {
        this.searchLinkTimes = searchLinkTimes;
        return this;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", links=" + Arrays.toString(links) +
                ", pwds=" + Arrays.toString(pwds) +
                ", linksAndPwdsStr='" + linksAndPwdsStr + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", authorityLevel='" + authorityLevel + '\'' +
                ", partition='" + partition + '\'' +
                ", auther='" + auther + '\'' +
                ", replyNum='" + replyNum + '\'' +
                ", viewNum='" + viewNum + '\'' +
                ", lastReplyName='" + lastReplyName + '\'' +
                ", lastReplyTime='" + lastReplyTime + '\'' +
                ", lastReplyUrl='" + lastReplyUrl + '\'' +
                ", firstPageReply='" + firstPageReply + '\'' +
                ", isNeedReply=" + isNeedReply +
                ", searchLinkTimes=" + searchLinkTimes +
                '}';
    }
}
