package javaCore2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook {

    private Map<String, List<String>> addressBook = new HashMap<>();

    public AddressBook() {
    }

    public void addRecord(String family, String phoneNumber) {
        if (addressBook != null && addressBook.containsKey(family)) {
            List<String> list = addressBook.get(family);
            list.add(phoneNumber);
            return;
        }
        List<String> list = new ArrayList<>();
        list.add(phoneNumber);
        addressBook.put(family, list);
    }

    public void findPhoneNumber(String family) {
        if (!addressBook.containsKey(family)) {
            System.out.println("В справочнике нет информации по запросу " + family);
            return;
        }
        List<String> list = addressBook.get(family);
        for (String phoneNumber : list) {
            System.out.println(family + " : " + phoneNumber);
        }
    }


}
