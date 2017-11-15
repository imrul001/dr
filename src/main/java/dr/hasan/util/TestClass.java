package dr.hasan.util;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] a){
        Menu menu1 = new Menu(); // fund transfer

        Menu subMenu1 = new Menu(); // transfer

        Menu subMenu2 = new Menu(); //eftn

        List<Menu> menus3 = new ArrayList<Menu>();
        subMenu2.setId(3);
        subMenu2.setName("eftn");
        menus3.add(null);
        subMenu2.setSubMenu(menus3);

        List<Menu> menus2 = new ArrayList<Menu>();
        subMenu1.setId(1);
        subMenu1.setName("transfer");
        menus2.add(subMenu2);
        subMenu1.setSubMenu(menus2);

        List<Menu> menus1 = new ArrayList<Menu>();
        menu1.setId(1);
        menu1.setName("fund_transfer");
        menus1.add(subMenu1);
        menu1.setSubMenu(menus1);

        System.out.println("result is "+search(menu1.getSubMenu(), "transfer"));


    }

    public static boolean search(List<Menu> menus, String str){
        if(menus.get(0) == null){
            return false;
        }
        if(menus.get(0).getName().equals(str)){
            return true;
        }else{
            return search(menus.get(0).getSubMenu(), str);
        }
    }
}
