package academy.elqoo.java8.stream;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Collects Characters from a string to a String
 */
public class CharacterToStringCollector implements Collector<Character, StringBuilder, String> {
    @Override
    public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
    }

    @Override
    public BiConsumer<StringBuilder, Character> accumulator() {
        return (a, b)-> a.append(b);
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (a,b)->a.append(b.substring(0));    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return (sb)->sb.substring(0);
    }

    @Override
    public Set<Characteristics> characteristics() {
        Set<Characteristics> characteristicses = new HashSet<>();
        characteristicses.add(Characteristics.UNORDERED);
        return characteristicses;
    }
}
