### Example application to show a bug using **Spring Data JDBC** with **PGpoint** postgres JDBC type. 

The main test is on **src/test/java/com/example/demo/DemoApplicationTests.java**

The problem occurs when **save** or **findById** methods of the CrudRepository are called on an entity that has a property of the type in **org.postgresql.geometric** (for example **PGpoint**). This types are used to map postgres geometric data types: [https://www.postgresql.org/docs/9.4/datatype-geometric.html](https://www.postgresql.org/docs/9.4/datatype-geometric.html).  A similar problem happens with  any of the PostGIS JDBC types.

The error seems to be due to spring treating the property as if it were an aggregate that it is referencing another entity instead of a data type describing a column data type. For example, an entity with the following properties:

    @Table("example")
    public class Example {
        @Id
        private int id;
        private String info;
        private PGpoint singlePoint;

        public int getId() {return id;}
        public void setId(int id) {this.id = id;}
        public String getInfo() {return info;}
        public void setInfo(String info) {this.info = info;}
        public PGpoint getSinglePoint() { return singlePoint;}
        public void setSinglePoint(PGpoint singlePoint) {this.singlePoint = singlePoint;}
    }

when save is called on an instance of this class, the following error happens:
INSERT INTO "p_gpoint" ("example", "is_null", "type", "value", "x", "y") VALUES (?, ?, ?, ?, ?, ?)] for task [PreparedStatementCallback