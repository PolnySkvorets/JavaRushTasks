package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements  Cloneable, Serializable {
    Entry<String> root;
    Entry<String> lastEntry;
    ArrayList<Entry<String>> innerList = new ArrayList<Entry<String>>();
    //конструктор множества, создание корня
    public CustomTree(){
        this.root = new Entry<String>("0");

        this.root.parent =null;
        this.root.lineNumber = 0;
        innerList.add(0, root);

    }


    //метод добавления нового элемента
    @Override
    public boolean add( String element){

        // создаем объект класса Entry с параметром element
        lastEntry = new Entry<String>(element);

        //перед добавлением новогоэлемента проверяем наличие корня дерева
        if(root.equals(null)){

            //передаем ссылку на новый объект
            root = lastEntry;

            //проверяем возможность добавлять новые ветви
            root.isAvailableToAddChildren();

            //добавляем корень на первую позицию в множество
            innerList.add(0, root);
            root.lineNumber = 0;

        }
        else{

            // необходимо добавить перебор элементов дерева, у которых уже заняты ветви
            for(Entry<String> currentEntry : innerList ) {
                if( currentEntry.isAvailableToAddChildren()) {


                    //добавляем новый элемент слева, если левое направление свободно
                    if(currentEntry.availableToAddLeftChildren) {


                            //добавляем новый элемент в общий внутренний список
                            innerList.add((currentEntry.lineNumber * 2) + 1,lastEntry);

                            // связываем родительский узел с новым узлом
                            currentEntry.leftChild = lastEntry;
                            lastEntry.parent = currentEntry;

                            //добавляем линейный номер в новый элемент
                            lastEntry.lineNumber = (currentEntry.lineNumber * 2) + 1;



                            // указываем на возможность добавления  новых узлов на дереве у нового элемента

                        currentEntry.availableToAddLeftChildren = false;
                            return true;
                    }
                    //добавляем новый элемент справа
                    else{

                        // связываем родительский узел с новым узлом
                        currentEntry.rightChild = lastEntry;
                        lastEntry.parent = currentEntry;

                        //добавляем линейный номер в новый элемент
                        lastEntry.lineNumber = (currentEntry.lineNumber * 2) + 2;

                        //добавляем новый элемент в общий внутренний список
                        innerList.add((currentEntry.lineNumber * 2) + 2, lastEntry);

                        // указываем на возможность добавления  новых узлов на дереве у нового элемента
                        currentEntry.checkChildren();
                        return true;
                    }
                }
            }
       }
        return false;
    }


    public String getParent(String name) {
        // перебираем элементы нашего множества
        for(Entry<String> currentEntry : innerList ) {

            //проверяем - есть ли среди них тот, имя которого совпадает с искомым
            if( currentEntry.elementName.equals(name)) {
                //возвращаем имя родительского узла
                return currentEntry.parent.elementName;
            }}

            //если родительского узла нет - null
        return null;

    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();

    }

    @Override
    public int size() {
        int size = 0;
        for(Entry<String> currentEntry : innerList ) {
            if( !currentEntry.equals(null)) {
                size++;
            }}
        return size - 1;
    }



    @Override
    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }



    @Override
    public String remove(int index){
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c){
        throw new UnsupportedOperationException();
    }


     static class Entry<T> implements Serializable {
        public String elementName;
        public int lineNumber;
        public boolean availableToAddLeftChildren, availableToAddRightChildren;
        public Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName){
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;

        }
        public void checkChildren(){
            if (!(leftChild.equals(null))){
                this.availableToAddLeftChildren = false;
            }
            if(!(rightChild.equals(null))){
                this.availableToAddRightChildren = false;
            }
        }
        public boolean isAvailableToAddChildren(){
            return (availableToAddLeftChildren|availableToAddRightChildren);
        }

    }

}
