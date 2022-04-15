package store;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static constants.Constants.*;

public abstract class ParticularProduct implements Product {

    private long particularProductId;
    private int percentageDiscount;
    private BigDecimal price;
    private String tradeMark;
    private List<String> materials;

    public ParticularProduct() {

        materials = new ArrayList<>();
    }

    public ParticularProduct(long particularProductId, BigDecimal price, int percentageDiscount,
                             String tradeMark, ArrayList<String> materials) {

        this.particularProductId = particularProductId;
        this.price = price;
        this.percentageDiscount = percentageDiscount;
        this.tradeMark = tradeMark;
        this.materials = materials;
    }

    public long getParticularProductId() {

        return particularProductId;
    }

    public void setParticularProductId(long particularProductId) {

        this.particularProductId = particularProductId;
    }

    public int getPercentageDiscount() {

        return percentageDiscount;
    }

    public void setPercentageDiscount(int percentageDiscount) {

        this.percentageDiscount = percentageDiscount;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    public String getTradeMark() {

        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {

        this.tradeMark = tradeMark;
    }

    public void setMaterials(ArrayList<String> materials) {

        this.materials = materials;
    }

    public void addMaterial(String material) {

        materials.add(material);
    }

    public void deleteElementMaterials(String element) {

       materials.remove(element);
    }

    @Override
    public List<String> getMaterials() {

        return materials;
    }

    @Override
    public BigDecimal calculateCost() {

        if (price.compareTo(new BigDecimal(ZERO)) > ZERO && percentageDiscount > ZERO) {

            return price.subtract(price.multiply(new BigDecimal(percentageDiscount))
                    .divide(new BigDecimal(HUNDRED_PERCENT), ROUNDING_UP_CALCULATIONS, RoundingMode.HALF_UP))
                    .setScale(ROUNDING_UP_RESULTS, RoundingMode.HALF_UP);
        } else if (price.compareTo(new BigDecimal(ZERO)) > ZERO) {

            return price;
        } else {

            return new BigDecimal(ZERO);
        }
    }

    @Override
    public void sortingMaterials() {

        Collections.sort(materials);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticularProduct)) return false;
        ParticularProduct that = (ParticularProduct) o;
        return particularProductId == that.particularProductId &&
                percentageDiscount == that.percentageDiscount &&
                Objects.equals(price, that.price) &&
                Objects.equals(tradeMark, that.tradeMark) &&
                Objects.equals(materials, that.materials);
    }

    @Override
    public int hashCode() {

        return Objects.hash(particularProductId, percentageDiscount, price, tradeMark, materials);
    }

    @Override
    public String toString() {
        return "ElementClothes{" +
                "particularProductId=" + particularProductId +
                ", percentageDiscount=" + percentageDiscount +
                ", price=" + price +
                ", tradeMark='" + tradeMark + '\'' +
                ", materials=" + materials +
                '}';
    }
}
