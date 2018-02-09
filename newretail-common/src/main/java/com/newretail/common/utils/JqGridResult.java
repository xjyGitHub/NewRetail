package com.newretail.common.utils;
import java.util.List;

public class JqGridResult<T> {

    private int totalCount;
    private int currentCount;
    private int currentPage;
    private int limitCount;
    private int totalPage;
    private String sortField;
    private String sortOrder;
    private List<T> data;
    public void setTotalCount(int totalCount) {
         this.totalCount = totalCount;
     }
     public int getTotalCount() {
         return totalCount;
     }

    public void setCurrentCount(int currentCount) {
         this.currentCount = currentCount;
     }
     public int getCurrentCount() {
         return currentCount;
     }

    public void setCurrentPage(int currentPage) {
         this.currentPage = currentPage;
     }
     public int getCurrentPage() {
         return currentPage;
     }

    public void setLimitCount(int limitCount) {
         this.limitCount = limitCount;
     }
     public int getLimitCount() {
         return limitCount;
     }

    public void setTotalPage(int totalPage) {
         this.totalPage = totalPage;
     }
     public int getTotalPage() {
         return totalPage;
     }

    public void setSortField(String sortField) {
         this.sortField = sortField;
     }
     public String getSortField() {
         return sortField;
     }

    public void setSortOrder(String sortOrder) {
         this.sortOrder = sortOrder;
     }
     public String getSortOrder() {
         return sortOrder;
     }

    public void setData(List<T> data) {
         this.data = data;
     }
     public List<T> getData() {
         return data;
     }

}