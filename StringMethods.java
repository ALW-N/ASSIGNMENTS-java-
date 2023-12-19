public class StringMethods {
    String str;
    String str1;

    public StringMethods() {
        this.str = "We realizes that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative. The alternative mentioned here is the Tata Nano, which soon after came as the world’s cheapest car on retail at a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a recent post by Humans of Bombay which formed the basis of his decision to come up with a car like Tata Nano.";
        this.str1 = "The paragraph is %s";
    }

    public static void main(String[] args) {

        // Java String Methods
        StringMethods sm = new StringMethods();
        // System.out.println(sm.str.charAt(9));
        // System.out.println(sm.str.compareTo("We realizes that while our workers were thriving"));
        // System.out.println(sm.str.concat("null"));
        // System.out.println(sm.str.contains("the surrounding villages were still suffering."));
        // System.out.println(sm.str.endsWith("thriving"));
        // System.out.println(sm.str.equals("the surrounding"));
        // System.out.println(sm.str.equalsIgnoreCase(sm.str));
        // System.out.println(String.format(sm.str1, sm.str));
        // System.out.println(sm.str.getBytes());
        // char[] destArray = new char[50];
        // sm.str.getChars(12, 25, destArray, 0);
        // System.out.println(destArray);
        // System.out.println("Bombay");
        System.out.println(sm.str.intern());
        // System.out.println(sm.str.isEmpty());
        // String result = String.join("-", sm.str1, sm.str);
        // System.out.println(result);
        // System.out.println(sm.str.lastIndexOf("Bombay"));
        // System.out.println(sm.str.replace("We", "I"));
        // System.out.println(sm.str.length());
        // String replaceString = sm.str.replaceAll("Bombay", "Hubli");
        // System.out.println(replaceString);
        // String[] arrOfStr = sm.str.split(".", 2);

        // for (String a : arrOfStr)
        //     System.out.println(a);
        // System.out.println(sm.str.startsWith("We"));
        // System.out.println(sm.str.substring(10));
        // char[] charArr = sm.str.toCharArray();
        // System.out.println(charArr);
        // System.out.println(sm.str.toLowerCase());
        // System.out.println(sm.str.toUpperCase());
        // System.out.println("trim");
        // System.out.println(sm.str.trim());
        // String s6 = String.valueOf(30);
        // System.out.println(10 + s6);

    }
}