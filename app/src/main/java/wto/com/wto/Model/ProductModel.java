package wto.com.wto.Model;

/**
 * Created by Bilardo on 9/8/2017.
 */

public class ProductModel {

    private String id;
    private String name;
    private String imageArr;
    private String detail;
    private String urlShare;
    private String categoryId;
    private String postDate;
    private String endDate;
    private String rating;
    private String keyword;
    private String userId;
    private String type;
    private String categoryName;
    private String insertDate;
    private String status;
    private String storeId;
    private String price;
    private String discount;
    private String storeName;

    public ProductModel()
    {
        setId("");
        setName("");
        setImageArr("");
        setDetail("");
        setUrlShare("");
        setCategoryId("");
        setPostDate("");
        setEndDate("");
        setRating("");
        setKeyword("");
        setUserId("");
        setType("");
        setCategoryName("");
        setInsertDate("");
        setStatus("");
        setStoreId("");
        setPrice("");
        setDiscount("");
        setStoreName("");
    }

    public ProductModel(String id, String name, String imageArr, String detail, String urlShare, String categoryId, String postDate,
                        String endDate, String rating, String keyword, String userId, String type, String categoryName, String insertDate,
                        String status, String storeId, String price, String discount, String storeName)
    {
        setId(id);
        setName(name);
        setImageArr(imageArr);
        setDetail(detail);
        setUrlShare(urlShare);
        setCategoryId(categoryId);
        setPostDate(postDate);
        setEndDate(endDate);
        setRating(rating);
        setKeyword(keyword);
        setUserId(userId);
        setType(type);
        setCategoryName(categoryName);
        setInsertDate(insertDate);
        setStatus(status);
        setStoreId(storeId);
        setPrice(price);
        setDiscount(discount);
        setStoreName(storeName);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setImageArr(String imageArr)
    {
        this.imageArr = imageArr;
    }

    public String getImageArr()
    {
        return imageArr;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setUrlShare(String urlShare)
    {
        this.urlShare = urlShare;
    }

    public String getUrlShare()
    {
        return  urlShare;
    }

    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    public void setPostDate(String postDate)
    {
        this.postDate = postDate;
    }

    public String getPostDate()
    {
        return postDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

}
