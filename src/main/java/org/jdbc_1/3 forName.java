package org.jdbc_1;

class forName {
    public static void main(String[] args) throws Exception {
        Pqr obj = new Pqr();

        Class.forName("org.jdbc_1.Xyz");

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
