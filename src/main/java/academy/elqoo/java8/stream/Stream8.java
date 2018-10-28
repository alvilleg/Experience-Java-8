package academy.elqoo.java8.stream;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Stream8 {

    public static List<Integer> returnSquareRoot(List<Integer> numbers){
        return numbers.stream().map((x -> (int) Math.sqrt(x))).collect(Collectors.toList());
    }

    public static List<Integer> getAgeFromUsers(List<User> user){
        return user.stream().map((u->u.getAge())).collect(Collectors.toList());

    }

    public static List<Integer> getDistinctAges(List<User> users){
        return users.stream().map(u->u.getAge()).distinct().collect(Collectors.toList());
    }

    public static List<User> getLimitedUserList(List<User> users, int limit){
        return users.stream().limit(limit).collect(Collectors.toList());
    }

    public static Integer countUsersOlderThen25(List<User> users){
        return (int)users.stream().filter(u->u.getAge()>25).count() ;
    }

    public static List<String> mapToUpperCase(List<String> strings){
        return strings.stream().map((s -> s.toUpperCase())).collect(Collectors.toList());
    }

    public static Integer sum(List<Integer> integers){
        return integers.stream().reduce(0,(x,y)->x+y);
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip){
        return integers.stream().skip(toSkip).collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names){
        return names.stream().map(( n-> n.split(" ")[0])).collect(Collectors.toList());
    }

    public static List<String> getDistinctLetters(List<String> names){
        return names.stream().map((n -> Arrays.asList(n.split("")))).flatMap((l -> l.stream())).distinct().collect(Collectors.toList());
    }


    public static String separateNamesByComma(List<User> users){
        return users.stream().map((u->u.getName())).collect(Collectors.joining(", "));
    }

    public static double getAverageAge(List<User> users){
        return users.stream().map((u->u.getAge())).collect(Collectors.averagingDouble((i->i)));
    }

    public static Integer getMaxAge(List<User> users){
        return users.stream().map((u -> u.getAge())).max(Integer::compare).orElse(0);
    }

    public static Integer getMinAge(List<User> users) {
        return users.stream().map((u -> u.getAge())).min(Integer::compare).orElse(0);
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users){
        return users.stream().collect(Collectors.partitioningBy((User::isMale)));
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users){
        return users.stream().collect(Collectors.groupingBy((User::getAge)));
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(
                        User::isMale,
                        Collectors.groupingBy(User::getAge)));
    }

    public static Map<Boolean, Long> countGender(List<User> users){
        return users.stream().collect(Collectors.groupingBy(User::isMale, Collectors.counting()));
    }

    public static boolean anyMatch(List<User> users, int age){
        return users.stream().anyMatch(u -> u.getAge() == age);
    }

    public static boolean noneMatch(List<User> users, int age){
        return users.stream().noneMatch(u -> u.getAge() == age);
    }

    public static Optional<User> findAny(List<User> users, String name){
        return users.stream().filter(u -> u.getName().equals(name)).findAny();
    }

    public static List<User> sortByAge(List<User> users){
        return users.stream().sorted((u, o) -> u.getAge().compareTo(o.getAge())).collect(Collectors.toList());
    }

    public static Stream<Integer> getBoxedStream(IntStream stream){
        return stream.boxed();
    }

    public static List<Integer> generateFirst10PrimeNumbers(){


        return IntStream.rangeClosed(2,100).filter(Stream8::isPrime).limit(10).boxed().collect(Collectors.toList());

    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number % i == 0);
    }

    public static List<Integer> generate10RandomNumbers(){
        Random random = new Random();
        return  random.ints(10).boxed().collect(Collectors.toList());
    }

    public static User findOldest(List<User> users){
        return users.stream().reduce((a,b) ->  a.getAge()>b.getAge()?a:b ).orElse(null);
    }

    public static int sumAge(List<User> users){
        return users.stream().collect(Collectors.summingInt((u)->u.getAge()));
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users){
        return users.stream().collect(Collectors.summarizingInt((u)->u.getAge()));
    }


    public static void main(String a[]){
        List<String> names = asList("Homer Simpson", "Marge Simpson", "Bart Simpson", "Kent Brockman");
        List<User> input = asList(
                new User("Homer"),
                new User("Maggie"),
                new User("Bart"));
        String result = Stream8.separateNamesByComma(input);
        System.out.println(result);
    }
}
