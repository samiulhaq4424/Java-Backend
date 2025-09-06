package org.jdbc_1;

class forName {
    public static void main(String[] args) throws Exception {
        // Creating an object of Pqr
        // 👉 This will first load the Pqr class (triggering its static block once),
        // and then create an instance (triggering its instance block).
        Pqr obj = new Pqr();

        // 👉 If you want to execute only the static block of a class
        // without creating an object, use Class.forName()
        // Needs fully qualified class name (with package)
        Class.forName("org.jdbc_1.Xyz");

        // 👉 If you want to both load the class (static block)
        // and also create an object (instance block), use newInstance()
        Class.forName("org.jdbc_1.Abc").newInstance();
    }
}

class Pqr {
    // 👉 This block is executed only once when the class is loaded.
    static {
        System.out.println("in static block of Pqr");
    }

    // 👉 This block is executed every time an object is created.
    {
        System.out.println("in instance block of Pqr");
    }
}

class Xyz {
    // 👉 Only has a static block.
    // Will run when the class is loaded (Class.forName).
    static {
        System.out.println("in static block of Xyz");
    }
}

class Abc {
    // 👉 Only has an instance block.
    // Will run only when an object is created (via newInstance).
    {
        System.out.println("in instance block of Abc");
    }
}
