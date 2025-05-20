package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return title + " - " + category + " : " + cost + "$";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Media)) return false;

        Media other = (Media) obj;

        try {
            return this.title != null && this.title.equals(other.title)
                && Float.compare(this.cost, other.cost) == 0;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public int compareTo(Media other) {
        if (other == null) {
            throw new NullPointerException("Compared media is null");
        }

        int titleCompare = this.title.compareToIgnoreCase(other.title);
        if (titleCompare != 0) {
            return titleCompare;
        }

        return Float.compare(this.cost, other.cost);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (title == null ? 0 : title.hashCode());
        result = 31 * result + Float.hashCode(cost);
        return result;
    }
}