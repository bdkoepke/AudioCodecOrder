package pw.swordfish.util;

public final class Arrays {
    public static <T> String toString(T[] self, Function<T, String> f) {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (int i = 0; i < (self.length - 1); i++)
            builder.append(f.apply(self[i]))
                   .append(",");
        builder.append("}");
        return builder.toString();
    }
    public static <T> String toString(T[] self) {
        return toString(self, new Function<T, String>() {
            @Override
            public String apply(T o) {
                return o.toString();
            }
        });
    }
}
