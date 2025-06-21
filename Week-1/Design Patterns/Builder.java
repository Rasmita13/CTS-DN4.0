class Builder {
    private String name;
    private int age;

    private Builder(UserBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public void display() {
        System.out.println("User: " + name + ", Age: " + age);
    }

    static class UserBuilder {
        private String name;
        private int age;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder build() {
            return new Builder(this);
        }
    }

    public static void main(String[] args) {
        Builder user = new Builder.UserBuilder()
                .setName("Rashmita")
                .setAge(20)
                .build();
        user.display();
    }
}
