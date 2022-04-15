package store;

import java.util.Objects;

public class CategoryClothes extends Category {

    private long categoryId;

    public CategoryClothes() {

        super();
    }

    public CategoryClothes(long categoryId, String categoryName) {

        super(categoryName);
        this.categoryId = categoryId;
    }

    public long getCategoryId() {

        return categoryId;
    }

    public void setCategoryId(long categoryId) {

        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryClothes)) return false;
        if (!super.equals(o)) return false;
        CategoryClothes that = (CategoryClothes) o;
        return categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), categoryId);
    }

    @Override
    public String toString() {
        return "CategoryClothes{" +
                "categoryId=" + categoryId +
                ", categoryName='" + getCategoryName() + '\'' +
                '}';
    }
}
