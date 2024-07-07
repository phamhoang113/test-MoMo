package main.service;

import main.dto.BillDto;

import java.lang.reflect.Array;

public class UtilService {
    public static <T> T[] addElement(T[] arrayInput, T newElement, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, arrayInput.length + 1);

        System.arraycopy(arrayInput, 0, array, 0, arrayInput.length);

        array[arrayInput.length] = newElement;

        return array;
    }

    public static BillDto[] removeBillById(BillDto[] arrayInput, long id) {
        int count = arrayInput.length-1;
        BillDto[] newArray = new BillDto[count];
        int index = 0;
        for (BillDto element : arrayInput) {
            if (element.getId() != id) {
                newArray[index++] = element;
            }
        }
        return newArray;
    }
}
