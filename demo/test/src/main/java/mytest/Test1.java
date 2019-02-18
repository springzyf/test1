package mytest;

import observation.House;
import observation.HouseBuyer;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test1 {

    @Test
    public void test1() {
        Map<String, String> map = new HashMap();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.forEach((k, v) -> {
            if ("a".equals(k)) {
                System.out.println(v);
            }
        });
    }

    @Test
    public void test2() {
        String[] s = {"a", "b", "c"};
        List<String> list = Arrays.asList(s);
//        list.forEach(System.out::println);
        list.stream().filter(a -> a.equals("a")).forEach(System.out::println);
    }

    @Test
    public void test3() {
        House house = new House(10000);
        HouseBuyer b1 = new HouseBuyer("老王");
        HouseBuyer b2 = new HouseBuyer("老李");
        HouseBuyer b3 = new HouseBuyer("小航");
        house.addObserver(b1);
        house.addObserver(b2);
        house.addObserver(b3);
        house.setPrice(10001);
    }

    @Test
    public void test4() {
        String format = MessageFormat.format("成功了{0}，失败了{1}", 5, 2);
        System.out.println(format);
    }

    @Test
    public void test5() {
        String s = "12.126";
        System.out.println(new BigDecimal(s).setScale(2, BigDecimal.ROUND_HALF_UP));

    }

    @Test
    public void test6() {
        Integer[] s = {1, 2, 3};
        for (Integer integer : s) {
            if (integer == 1) {
                continue;
            }
            System.out.println(integer);
        }
    }

    @Test
    public void test7() {
        Person p1 = new Person(1, "A");
        Person p2 = new Person(2, "B");
        Person p3 = new Person(3, "C");
        Person p4 = new Person(3, "D");
        Person p5 = new Person(5, null);
        Person p6 = new Person(5, null);
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        Map<PersonTempVO,List<Person>> data = list.stream().collect(Collectors.groupingBy(c -> {
            PersonTempVO vo = new PersonTempVO();
            if(c.getName() !=null){
                vo.setAge(c.getAge());
            }else
            {
                vo.setAge(0);
            }
            return vo;
        }));
        for (List<Person> value : data.values()) {
            System.out.println(Arrays.toString(value.toArray()));
        }
    }

    @Test
    public void test8(){
        Boolean b= null;
        if(b){
            System.out.println(b);
        }
    }

    @Test
    public void test9(){
        System.out.println(BigDecimal.valueOf(123,2));

    }
    public static void main(String[] args){
        String orgFileName = "abc ";
        Pattern p = Pattern.compile("\\s|\t|\r|\n");
        Matcher m = p.matcher(orgFileName);
        orgFileName = m.replaceAll("_");
        System.out.println(orgFileName);
    }
}
