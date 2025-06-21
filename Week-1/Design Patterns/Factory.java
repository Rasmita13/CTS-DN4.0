interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

class Factory {
    public static Animal createAnimal(String type) {
        if ("dog".equals(type)) {
            return new Dog();
        } else if ("cat".equals(type)) {
            return new Cat();
        }
        return null;
    }

    public static void main(String[] args) {
        Animal a1 = Factory.createAnimal("dog");
        a1.makeSound();

        Animal a2 = Factory.createAnimal("cat");
        a2.makeSound();  
    }
}
