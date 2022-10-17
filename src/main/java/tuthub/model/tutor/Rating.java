package tuthub.model.tutor;

import static java.util.Objects.requireNonNull;
import static tuthub.commons.util.AppUtil.checkArgument;

/**
 * Represents the rating that a Tutor has.
 * Guarantees: immutable; is valid as declared in {@link #isValidRating(String)}
 */
public class Rating {

    public static final String MESSAGE_CONSTRAINTS = "Rating should only contain positive decimal values"
            + "including zero with no spaces in between, and it should not be blank";

    public static final Double MAX_RATING = 5.0;
    public static final Double MIN_RATING = 0.0;

    public final String value;

    /**
     * Constructs a {@code Rating}
     *
     * @param rating Number of teaching nominations Tutor has.
     */
    public Rating(String rating) {
        requireNonNull(rating);
        checkArgument(isValidRating(rating), MESSAGE_CONSTRAINTS);
        value = rating;
    }

    /**
     * Returns true if a given string is a valid Rating.
     */
    public static boolean isValidRating(String test) {
        return isInRange(test);
    }

    /**
     * Returns true if a given string is between minimum and maximum rating.
     */
    public static boolean isInRange(String test) {
        return Double.parseDouble(test) <= MAX_RATING && Double.parseDouble(test) >= MIN_RATING;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Rating // instanceof handles null
                && value.equals(((Rating) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
