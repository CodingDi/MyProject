// "static void main" must be defined in a public class.
public class FindFruitCombs {
    public static void main(String[] args) {
        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList8 = { { "apple", "banana"}};
        String[] shoppingCart8 = {"apple", "apple", "banana"};
        String[][] codeList9 = {{"anything", "anything"}, {"banana", "anything", "oranage"}};
        String[] shoppingCart9 = {"apple", "apple", "banana", "apple", "apple", "oranage", "oranage", "grape"};

        System.out.println(isWinner(codeList1, shoppingCart1));
        System.out.println(isWinner(codeList2, shoppingCart2));
        System.out.println(isWinner(codeList3, shoppingCart3));
        System.out.println(isWinner(codeList4, shoppingCart4));
        System.out.println(isWinner(codeList5, shoppingCart5));
        System.out.println(isWinner(codeList6, shoppingCart6));
        System.out.println(isWinner(codeList7, shoppingCart7));
        System.out.println(isWinner(codeList8, shoppingCart8));
        System.out.println(isWinner(codeList9, shoppingCart9));

    }

    /*
    O(MN) solution where M is the average number of items in each code group,
    N is the number of items in the shopping cart.
    The idea is to consider each item in the shopping cart
    as the start of the current code group we are processing.
    If the current cart item did not match with the current code group,
    then move to the next cart item and try to match that with the current code group.
    Return true if you can match all code groups before hitting end of the cart.
    * */

    public static boolean isWinner(String[][] codeList, String[] shoppingCart) {
        int group = 0;
        int cartStart = 0;
        while(group < codeList.length && cartStart < shoppingCart.length) {
            int i = cartStart;

            //find the start of shopping cart so that it equals the start of codeList
            if(codeList[group][0].equals(shoppingCart[i]) || codeList[group][0].equals("anything")) {
                //potential match : begin of code group
                i++;//move the cart index pointer
                int j;
                for(j = 1; j < codeList[group].length; j++) {
                    String codeStr = codeList[group][j];
                    String cartStr = shoppingCart[i];

                    if(!codeStr.equals("anything") && !codeStr.equals(cartStr)) {
                        break;
                    } else {
                        i++;
                    }
                }

                if(j == codeList[group].length) {
                    cartStart = i;
                    group++;//one of the codeList is matched
                } else {
                    cartStart++;//if not matched, we move the shopping cart pointer to the begin
                }
            } else {
                //if current shopping cart is not a match, we move the shopping cart pointer
                cartStart++;
            }
        }

        //check if all codeList group is matched
        return group == codeList.length;
    }
}