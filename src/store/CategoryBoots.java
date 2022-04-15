package store;

import java.util.Objects;

public class CategoryBoots extends Category {

    private long categoryId;

    public CategoryBoots() {

        super();
    }

    public CategoryBoots(long categoryId, String categoryName) {

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
        if (!(o instanceof CategoryBoots)) return false;
        if (!super.equals(o)) return false;
        CategoryBoots that = (CategoryBoots) o;
        return categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), categoryId);
    }

    @Override
    public String toString() {
        return "CategoryBoots{" +
                "categoryId=" + categoryId +
                ", categoryName='" + getCategoryName() + '\'' +
                '}';
    }
}
